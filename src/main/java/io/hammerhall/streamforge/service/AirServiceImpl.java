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
import io.hammerhall.streamforge.repository.AirRepository;
import java.util.Collection;
import java.util.stream.Stream;

public class AirServiceImpl implements AirService {

    private final AirRepository airRepository;

    public AirServiceImpl(AirRepository airRepository) {
        this.airRepository = airRepository;
    }

    @Override
    public Collection<Airport> findAllAirports() {
        return airRepository.airports();
    }

    @Override
    public Collection<Airplane> findAllAirplanes() {
        return airRepository.airplanes();
    }

    @Override
    public Collection<Seat> findAllSeats() {
        return airRepository.seats();
    }

    @Override
    public Collection<Route> findAllRoutes() {
        return airRepository.routes();
    }

    @Override
    public Collection<Flight> findAllFlights() {
        return airRepository.flights();
    }

    @Override
    public Stream<Booking> streamBookings() {
        return airRepository.bookings();
    }

    @Override
    public Stream<Ticket> streamTickets() {
        return airRepository.tickets();
    }

    @Override
    public Stream<Segment> streamSegments() {
        return airRepository.segments();
    }

    @Override
    public Stream<BoardingPass> streamBoardingPasses() {
        return airRepository.boardingPasses();
    }
}
