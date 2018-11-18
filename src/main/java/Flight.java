import java.util.ArrayList;

public class Flight {

    private ArrayList<Passenger> passengerList;
    private Plane plane;
    private String flightNumber;
    private Destination destination;
    private DepartureAirport departureAirport;
    private String departureTime;

    public Flight(Plane plane, String flightNumber, Destination destination, DepartureAirport departureAirport, String departureTime) {
        this.plane = plane;
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.departureAirport = departureAirport;
        this.departureTime = departureTime;
        this.passengerList = new ArrayList<Passenger>();
    }

    public Plane getPlane() {
        return plane;
    }

    public void setPlane(Plane plane) {
        this.plane = plane;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public DepartureAirport getDepartureAirport() {
        return departureAirport;
    }

    public void setDepartureAirport(DepartureAirport departureAirport) {
        this.departureAirport = departureAirport;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }

    public int getPassengerList(){
        return this.passengerList.size();
    }

    public void addPassenger(Passenger passenger) {
        this.passengerList.add(passenger);
    }

    public int getAvailableSeats() {
        int available = this.plane.getCapacity() - this.getPassengerList();
        return available;
    }

    public boolean checkPassengerPresent(Passenger passenger) {
        return this.passengerList.contains(passenger);
    }

    public void bookPassenger(Passenger passenger, Flight flight) {
        if (flight.getAvailableSeats() > 0){
            flight.addPassenger(passenger);
        }
    }
}


