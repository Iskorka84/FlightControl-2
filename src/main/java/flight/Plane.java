package flight;

public class Plane {

    public String flightID;
    public String flightDestination;
    public int capacity;
    public String[] currentPassengers;
    public static boolean freeSeat = true;

    public Plane (String flightNumber, int numberOfSeats) {
        flightID = flightNumber;
        capacity = numberOfSeats;
        currentPassengers = new String[capacity];
    }

    public void setFlightDestination(String destinationCity) {
        flightDestination = destinationCity;
    }
    public String getFlightDestination () {
        return flightDestination;
    }

        public void boardingPassenger(String name, int seatNumber) {
            if (seatNumber >= 0 && seatNumber < capacity && currentPassengers[seatNumber] == null) {
                System.out.println("Boarding complete for " + name + " on flight " + flightID + " to " + flightDestination);
                currentPassengers[seatNumber] = name;
                freeSeat = true;
            } else {
                System.out.println("Failed to find seat for passenger " + name);
                offerFreeSeat(name);
            }
        }


    public int getFreeSeat() {
        int newFreeSeat = -1;
        for (int i = 0; i < currentPassengers.length; i++) {
            if (currentPassengers[i] == null) {
                newFreeSeat = i;
            }
        }
        return newFreeSeat;
    }

    public void offerFreeSeat(String name) {
        int newFreeSeat = getFreeSeat();

        if (newFreeSeat >= 0 && newFreeSeat < currentPassengers.length) {
            System.out.println("Backup seat found for " + name + " on flight " + flightID + " to " + flightDestination);
            currentPassengers[newFreeSeat] = name;
            freeSeat = true;
        }
        else {
            System.out.println("There are no free seats for passenger " + name + " on flight " + flightID + " to " + flightDestination);
            freeSeat = false;
        }
    }

}

