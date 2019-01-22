package com.aj.bookingservice.controller;

import com.aj.bookingservice.domain.Booking;
import com.aj.bookingservice.service.BookingService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Booking controller.
 */
@RestController
public class BookingController {

	private final BookingService bookingService;

	/**
	 * Instantiates a new Booking controller.
	 * @param bookingService the booking service
	 */
	public BookingController(BookingService bookingService) {
		this.bookingService = bookingService;
	}

	/**
	 * Save booking response entity.
	 * @return the response entity
	 */
	@GetMapping("/booking")
	public ResponseEntity<List> saveBooking() {
		List<Booking> bookingList = bookingService.getAllSavedBookings();
		return ResponseEntity.ok(bookingList);
	}

}
