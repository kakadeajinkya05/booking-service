package com.aj.bookingservice;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import org.hamcrest.core.Is;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@DirtiesContext
public class BookingServiceApplicationTests {

	private static final String GET_BOOKINGS = "/booking";

	@Autowired
	private TestRestTemplate testRestTemplate;

	@Test
	public void getAllSavedBookings() {

		ResponseEntity<List> responseEntity = testRestTemplate.exchange(GET_BOOKINGS,
				HttpMethod.GET, null, List.class);

		assertThat(responseEntity.getStatusCode(), Is.is(HttpStatus.OK));
		assertNotNull(responseEntity.getBody());
	}

}
