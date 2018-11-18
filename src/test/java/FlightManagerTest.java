import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightManagerTest {
    
    Passenger passenger1;
    Passenger passenger2;
    Plane plane;
    Flight flight;
    FlightManager flightManager;
    
    @Before
    public void setUp(){
        passenger1 = new Passenger("Andy", 3);
        passenger2 = new Passenger("Bob", 2);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "EJ345", Destination.EDI, DepartureAirport.LDNGAT, "0945");
        flightManager = new FlightManager();
    }

    @Test
    public void canGetBaggageWeight() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(50, flight.getBaggageWeight());
    }

    @Test
    public void canGetRemainingWeight() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        assertEquals(200, flight.getRemaingWeight());
    }

    @Test
    public void canGetBaggageWeightPerPassenger() {

        assertEquals(125, flight.getAllowedBaggagePerPerson());
    }
}
