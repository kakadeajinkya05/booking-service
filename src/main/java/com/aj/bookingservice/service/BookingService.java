package com.aj.bookingservice.service;

import com.aj.bookingservice.domain.Booking;
import com.aj.bookingservice.repository.BookingRepo;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * The type Booking service.
 */
@Service
public class BookingService {

	private final BookingRepo bookingRepo;

	/**
	 * Instantiates a new Booking service.
	 * @param bookingRepo the booking repo
	 */
	public BookingService(BookingRepo bookingRepo) {
		this.bookingRepo = bookingRepo;
	}

	/**
	 * Gets all saved services.
	 * @return the all saved services
	 */
	public List<Booking> getAllSavedBookings() {
		Booking booking1 = Booking.builder().type("flight").build();
		Booking booking2 = Booking.builder().type("hotel").build();
		Booking booking3 = Booking.builder().type("car").build();
		bookingRepo.save(booking1);
		bookingRepo.save(booking2);
		bookingRepo.save(booking3);
		return bookingRepo.findAll();
	}

}
