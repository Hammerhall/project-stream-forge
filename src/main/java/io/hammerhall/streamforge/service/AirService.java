package io.hammerhall.streamforge.service;

import io.hammerhall.streamforge.domain.air.Airplane;
import io.hammerhall.streamforge.domain.air.Airport;
import io.hammerhall.streamforge.domain.air.BoardingPass;
import io.hammerhall.streamforge.domain.air.Booking;
import io.hammerhall.streamforge.domain.air.Flight;
import io.hammerhall.streamforge.domain.air.Route;
import io.hammerhall.streamforge.domain.air.Seat;
import io.hammerhall.streamforge.domain.air.Segment;
import io.hammerhall.streamforge.domain.air.Ticket;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * Данные «Авиаперевозки». Малые таблицы — коллекциями, большие — потоками: каждый вызов
 * {@code stream…()} читает файл заново.
 */
public interface AirService {

    Collection<Airport> findAllAirports();

    Collection<Airplane> findAllAirplanes();

    Collection<Seat> findAllSeats();

    Collection<Route> findAllRoutes();

    Collection<Flight> findAllFlights();

    Stream<Booking> streamBookings();

    Stream<Ticket> streamTickets();

    Stream<Segment> streamSegments();

    Stream<BoardingPass> streamBoardingPasses();
}
