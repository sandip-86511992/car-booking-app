package com.isobar.carbooking.controllers;

import com.isobar.carbooking.services.booking.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.TimeZone;

@RestController
@RequestMapping("/booking")
public class BookingController extends BaseController{

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("Etc/UTC"));
    }

    @Autowired
    BookingServiceImpl bookingService;

    @RequestMapping(method = RequestMethod.POST)
    public BookingSuccessResponse book(@RequestBody BookingRequest bookingRequest) {
        return bookingService.book(bookingRequest);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<BookingResponse> getAll() {
        return bookingService.getAll();
    }

    @RequestMapping(value = "/by-status/{status}", method = RequestMethod.GET)
    public List<BookingResponse> getByStatus(@PathVariable String status) {
        return bookingService.getByStatus(status);
    }

    @RequestMapping(value = "update-status/{id}", method = RequestMethod.PATCH)
    public BookingResponse updateStatus(@PathVariable String id, @RequestBody StatusUpdateRequest statusUpdateRequest) {
        return bookingService.updateStatus(id, statusUpdateRequest);
    }
}
