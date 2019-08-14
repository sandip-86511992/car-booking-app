package com.isobar.carbooking.services.booking;

import java.util.List;

public interface BookingService {

    BookingSuccessResponse book(BookingRequest bookingRequest);
    List<BookingResponse> getAll();
    List<BookingResponse> getByStatus(String status);
    BookingResponse updateStatus(String id, StatusUpdateRequest statusUpdateRequest);
}
