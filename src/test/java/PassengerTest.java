import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    Passenger passenger;

    @Before
    public void setUp(){
        passenger = new Passenger("Andy", 3);
    }

    @Test
    public void canGetPassengerName() {
        assertEquals("Andy", passenger.getName());
    }

    @Test
    public void canGetNumberOfBags() {
        assertEquals(3, passenger.getBags());
    }
}
