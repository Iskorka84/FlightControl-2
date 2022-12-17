package flight;

public class FlightControl {

    public void boardingNewPassengers (Plane[] allPlanes, String[][] passengerList) {
        for (int i = 0; i < allPlanes.length; i++) {
               allPlanes[i].setNewPassengers(allPlanes, allPlanes[i], passengerList[i]);
        }
    }
}
