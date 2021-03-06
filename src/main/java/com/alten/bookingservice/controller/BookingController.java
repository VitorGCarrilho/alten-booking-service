package com.alten.bookingservice.controller;

import com.alten.bookingservice.dto.request.BookingRequestDTO;
import com.alten.bookingservice.dto.response.BookingResponseDTO;
import com.alten.bookingservice.dto.response.CreateBookingResponseDTO;
import com.alten.bookingservice.service.BookingService;
import com.alten.bookingservice.service.CancelBookService;
import com.alten.bookingservice.service.GetBookingService;
import com.alten.bookingservice.service.UpdateBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
@RequestMapping("/api/v1/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @Autowired
    private CancelBookService cancelBookService;

    @Autowired
    private UpdateBookService updateBookService;

    @Autowired
    private GetBookingService getBookingService;

    @GetMapping("/{id}")
    public ResponseEntity<BookingResponseDTO> getBooking(@PathVariable String id) {
        var dto = getBookingService.getBooking(id);
        return ResponseEntity.ok(dto);
    }

    @PostMapping
    public ResponseEntity<CreateBookingResponseDTO> createBooking(@Valid @RequestBody BookingRequestDTO bookingRequestDTO){
        var response = bookingService.createBookingEvent(bookingRequestDTO);
        return ResponseEntity.accepted().body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity cancelBook(@PathVariable String id) {
        cancelBookService.cancelBookEvent(id);
        return ResponseEntity.accepted().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity updateBook(@PathVariable String id, @Valid @RequestBody BookingRequestDTO bookingRequestDTO) {
        updateBookService.updateBookEvent(id, bookingRequestDTO);
        return ResponseEntity.accepted().build();
    }

}
