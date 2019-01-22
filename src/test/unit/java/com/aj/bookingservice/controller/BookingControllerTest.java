package com.aj.bookingservice.controller;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.aj.bookingservice.domain.Booking;
import com.aj.bookingservice.service.BookingService;
import java.util.Arrays;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(BookingController.class)
public class BookingControllerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private BookingService bookingService;

	@Test
	public void shouldReturnAllSavedBookings() throws Exception {
		Booking booking1 = Booking.builder().id(1).type("flight").build();
		Booking booking2 = Booking.builder().id(2).type("hotel").build();
		Booking booking3 = Booking.builder().id(3).type("car").build();

		when(bookingService.getAllSavedBookings())
				.thenReturn(Arrays.asList(booking1, booking2, booking3));

		this.mvc.perform(get("/booking")).andExpect(status().isOk())
				.andExpect(jsonPath("$", hasSize(3)))
				.andExpect(jsonPath("$[0].type", is(booking1.getType())))
				.andExpect(jsonPath("$[1].type", is(booking2.getType())))
				.andExpect(jsonPath("$[2].type", is(booking3.getType())));
	}

}
