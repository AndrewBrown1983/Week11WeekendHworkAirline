import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {

    Passenger passenger1;
    Passenger passenger2;
    Passenger passenger3;
    Plane plane;
    Flight flight;

    @Before
    public void setUp() {
        passenger1 = new Passenger("Dave", 2);
        passenger2 = new Passenger("Andy", 3);
        passenger3 = new Passenger("Bob", 1);
        plane = new Plane(PlaneType.BOEING747);
        flight = new Flight(plane, "EJ345", Destination.EDI, DepartureAirport.LDNGAT, "0945");
    }

    @Test
    public void checkPassengerListisEmpty() {
        assertEquals(0, flight.getPassengerList());
    }

    @Test
    public void canAddPassenger() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getPassengerList());
    }

    @Test
    public void canGetAvailableSeats() {
        flight.addPassenger(passenger1);
        assertEquals(1, flight.getAvailableSeats());
    }

    @Test
    public void canBookPassengerOnFlight() {
        flight.bookPassenger(passenger1);
        assertEquals(1, flight.getPassengerList());
        assertEquals(true, flight.checkPassengerPresent(passenger1));
    }

    @Test
    public void willRejectPassengerIfAtCapacity() {
        flight.bookPassenger(passenger1);
        flight.bookPassenger(passenger2);
        flight.bookPassenger(passenger3);

        assertEquals(2, flight.getPassengerList());
        assertEquals(true, flight.checkPassengerPresent(passenger1));
        assertEquals(true, flight.checkPassengerPresent(passenger2));
        assertEquals(false, flight.checkPassengerPresent(passenger3));
    }

//    @Test
//    public void canGetBaggageWeight() {
//        flight.bookPassenger(passenger1);
//        flight.bookPassenger(passenger2);
//        assertEquals(50, flight.getBaggageWeight());
//}
}
