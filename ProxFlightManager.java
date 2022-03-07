package hw3;

import hw3.airline.Airline;
import hw3.airport.Airport;
import hw3.flight.Flight;
import hw3.flight.FlightFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public interface FlightManagerObject {
    void createFlight();
}

public class FlightManagerImpl implements FlightManager {

    public FlightManagerImpl() {
        getFlightByNumber();
    }

    @Override
    public void createFlight() {
        LOG.info("A flight is being created");
    }

    @Override
    public void getFlightByNumber(String flightNumber) {
        return flights.stream()
                .filter(flt -> flt.getFlightNumber().equals(flightNumber))
                .findFirst();
        LOG.info("Flight Number: " + flightNumber + " is being retrieved");
    }
}


public class ProxFlightManager extends FlightManager {
    private static FlightManagerObject object;
    private static List<Flight> flights;
    private ProxFlightManager() {
        flights = new ArrayList<Flight>();
    }

    @Override
    public void process() {
        if (object == null){
            object = new FlightManagerImpl();
        }
        object.createFlight();
    }
}
