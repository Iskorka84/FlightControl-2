package flight;

public class Main {

    public static void main(String[] args) {

        Plane[] airportPlanes = new Plane[3];
        airportPlanes[0] = new Plane("PS7701", 4);
        airportPlanes[1] = new Plane("PS7702", 4);
        airportPlanes[2] = new Plane("PS7703", 3);

        FlightControl airport = new FlightControl(airportPlanes);
        airport.setPlaneDestination("PS7701", "London");
        airport.setPlaneDestination("PS7702", "Paris");
        airport.setPlaneDestination("PS7703", "London");

        createPassengers(airport);

        for (int i = 0; i < airport.passengerNames.length; i++) {
            airport.boardingNewPassenger(i);
            if (!Plane.freeSeat) {
                airport.boardingPassengerOnAlternativePlane(i);
            }
        }

    }

    public static void createPassengers (FlightControl airport) {
        airport.registerPassenger(0, "Alain Delon", 0, "PS7701");
        airport.registerPassenger(1, "Tom Cruise", 1, "PS7701");
        airport.registerPassenger(2, "Elvis Presley", 2, "PS7701");
        airport.registerPassenger(3, "Nicole Kidman", 3, "PS7701");

        airport.registerPassenger(4, "David Beckham", 0, "PS7702");
        airport.registerPassenger(5, "Leo Messi", 1, "PS7702");
        airport.registerPassenger(6, "Diego Maradona", 2, "PS7702");
        airport.registerPassenger(7, "Zinedine Zidane", 5, "PS7702");

        airport.registerPassenger(8, "Andrii Shevchenko", 0, "PS7703");
        airport.registerPassenger(9, "Boris Johnson", 1, "PS7703");
        airport.registerPassenger(10, "Mister X", 3, "PS7701");
    }
}
