package com.isobar.carbooking.services.booking;

import com.isobar.carbooking.dao.booking.BookingEntity;
import com.isobar.carbooking.dao.booking.BookingRepository;
import com.isobar.carbooking.dao.booking.BookingStatus;
import com.isobar.carbooking.dao.driver.DriverEntity;
import com.isobar.carbooking.dao.driver.DriverRepository;
import com.isobar.carbooking.exceptions.ErrorCodes;
import com.isobar.carbooking.exceptions.FailFastValidation;
import com.isobar.carbooking.exceptions.ValidationException;
import org.apache.commons.lang3.EnumUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingServiceImpl implements BookingService {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    DriverRepository driverRepository;

    DozerBeanMapper mapper = new DozerBeanMapper();

    @Override
    public BookingSuccessResponse book(BookingRequest bookingRequest) {
        BookingSuccessResponse newBookingResponse = new BookingSuccessResponse();
        try {
            Date startTimeStamp = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(bookingRequest.getDate().concat(" ").concat(bookingRequest.getStartTime()));
            Date endTimeStamp = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss").parse(bookingRequest.getDate().concat(" ").concat(bookingRequest.getEndTime()));
            DriverEntity driverEntity = driverRepository.findById(bookingRequest.getDriverId()).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_DRIVER_ID));
            List<BookingEntity> bookingEntities = new ArrayList<>();
            bookingRepository.findAll().forEach(bookingEntity -> bookingEntities.add(bookingEntity));
            List<Long> activeDrivers = bookingEntities.stream().filter(bookingEntity -> bookingEntity.getDriverId() == bookingRequest.getDriverId() &&
                    !bookingEntity.getStatus().equals(BookingStatus.CANCELLED) &&
                    ( (startTimeStamp.compareTo(bookingEntity.getStartTime()) >= 0 && startTimeStamp.compareTo(bookingEntity.getEndTime()) <=0)
                    || (endTimeStamp.compareTo(bookingEntity.getStartTime()) >=0 && endTimeStamp.compareTo(bookingEntity.getEndTime()) <=0))
            ).mapToLong(bookingEntity -> bookingEntity.getDriverId()).distinct().boxed().collect(Collectors.toList());
            FailFastValidation.testAndThrowValidationException(list -> list.size() > 0, activeDrivers, ErrorCodes.DRIVER_NOT_AVAILABLE);
            BookingEntity bookingEntity = new BookingEntity();
            bookingEntity.setDriverId(driverEntity.getId());
            bookingEntity.setCarId(driverEntity.getCarId());
            bookingEntity.setStartTime(startTimeStamp);
            bookingEntity.setEndTime(endTimeStamp);
            bookingEntity.setStatus(BookingStatus.CONFIRMED);
            bookingRepository.save(bookingEntity);
            newBookingResponse.setSuccess(true);
        } catch (ParseException e) {
            throw new ValidationException(ErrorCodes.INVALID_DATE_FORMAT);
        }
        return newBookingResponse;
    }

    @Override
    public List<BookingResponse> getAll() {
        List<BookingResponse> bookingResponses = new ArrayList<>();
        bookingRepository.findAll().forEach(bookingEntity1 -> bookingResponses.add(mapper.map(bookingEntity1, BookingResponse.class)));
        return bookingResponses;
    }

    @Override
    public List<BookingResponse> getByStatus(String status) {
        FailFastValidation.testAndThrowValidationException(s -> !EnumUtils.isValidEnum(BookingStatus.class, s.toUpperCase()), status, ErrorCodes.INVAILD_STATUS);
        List<BookingResponse> bookingResponses = new ArrayList<>();
        bookingRepository.findAll().forEach(bookingEntity1 -> bookingResponses.add(mapper.map(bookingEntity1, BookingResponse.class)));
        List<BookingResponse> responses = bookingResponses.stream().filter(bookingResponse -> bookingResponse.getStatus().equals(BookingStatus.valueOf(status.toUpperCase()))).collect(Collectors.toList());
        return responses;
    }

    @Override
    public BookingResponse updateStatus(String id, StatusUpdateRequest statusUpdateRequest) {
        FailFastValidation.testAndThrowValidationException(FailFastValidation.isNull, id, ErrorCodes.INVALID_BOOKING_ID);
        FailFastValidation.testAndThrowValidationException(s -> !EnumUtils.isValidEnum(BookingStatus.class, s.toUpperCase()), statusUpdateRequest.getStatus(), ErrorCodes.INVAILD_STATUS);
        BookingEntity bookingEntity = bookingRepository.findById(Long.parseLong(id)).orElseThrow(() -> new ValidationException(ErrorCodes.INVALID_BOOKING_ID));
        bookingEntity.setStatus(BookingStatus.valueOf(statusUpdateRequest.getStatus().toUpperCase()));
        bookingEntity = bookingRepository.save(bookingEntity);
        return mapper.map(bookingEntity, BookingResponse.class);
    }
}