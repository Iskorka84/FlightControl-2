package flight;

public class FlightControl {

    final static int MAX_AIRPORT_CLIENTS = 11;

    public Plane[] planes;
    public String[] passengerNames = new String[MAX_AIRPORT_CLIENTS];
    public int[] passengerSeats = new int[MAX_AIRPORT_CLIENTS];
    public String[] passengerFlights = new String[MAX_AIRPORT_CLIENTS];

    public FlightControl(Plane[] airportPlanes) {
        planes = airportPlanes;
    }

    public Plane getPlaneByFlightId(String flightId) {
        for (int i = 0; i < planes.length; i++) {
            if (planes[i].flightID.equals(flightId)) {
                return planes[i];
            }
        }
        return null;
    }

       public void setPlaneDestination(String flightID, String destination) {
        Plane plane = getPlaneByFlightId(flightID);
        plane.setFlightDestination(destination);
    }

    public String getPlaneDestination(String flightID) {
        Plane plane = getPlaneByFlightId(flightID);
        String destination = plane.getFlightDestination();
        return destination;
    }

    public void boardingNewPassenger(int passengerID) {
        String passengerName = passengerNames[passengerID];
        int passengerSeat = passengerSeats[passengerID];
        String flightID = passengerFlights[passengerID];

        Plane plane = getPlaneByFlightId(flightID);
        plane.boardingPassenger(passengerName, passengerSeat);
    }

    public void boardingPassengerOnAlternativePlane (int passengerID) {
        String passengerName = passengerNames[passengerID];
        String flightID = passengerFlights[passengerID];

        String destination = getPlaneDestination(flightID);
        Plane alternativePlane = getAnotherPlaneWithSameDestination(flightID, destination);
        if (alternativePlane != null) {
            alternativePlane.offerFreeSeat(passengerName);
        }
    }

    public void registerPassenger(int passengerID, String passengerName, int passengerSeat, String flightID) {
        passengerNames[passengerID] = passengerName;
        passengerSeats[passengerID] = passengerSeat;
        passengerFlights[passengerID] = flightID;
    }

    public Plane getAnotherPlaneWithSameDestination(String flightID, String destination) {
        for (int i = 0; i < planes.length; i++) {
            if (!planes[i].flightID.equals(flightID) && planes[i].flightDestination.equals(destination)) {
                return planes[i];
            }
        }
        return null;
    }

}
