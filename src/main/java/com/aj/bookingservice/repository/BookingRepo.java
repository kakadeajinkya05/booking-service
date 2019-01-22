package com.aj.bookingservice.repository;

import com.aj.bookingservice.domain.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface Booking repository.
 */
@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
