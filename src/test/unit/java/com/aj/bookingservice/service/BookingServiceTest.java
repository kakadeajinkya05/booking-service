package com.aj.bookingservice.service;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.aj.bookingservice.domain.Booking;
import com.aj.bookingservice.repository.BookingRepo;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class BookingServiceTest {

	@Mock
	private BookingRepo bookingRepo;

	@InjectMocks
	private BookingService bookingService;

	@Test
	public void shouldSaveAllBookings() {
		when(bookingRepo.save(mock(Booking.class))).thenReturn(mock(Booking.class));
		when(bookingRepo.findAll()).thenReturn(mock(List.class));

		List<Booking> bookingList = bookingService.getAllSavedBookings();

		assertNotNull(bookingList);
	}

}
