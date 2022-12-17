package flight;

public class Plane {

    private String model;

    public int capacity;

    public String[] currentPassengers;

    public Plane (String modelName, int numberOfSeats) {

        model = modelName;
        capacity = numberOfSeats;
        currentPassengers = new String[capacity];
        for (int i = 0; i < capacity; i++) {
            currentPassengers[i] = null;
        }
    }

        public void setNewPassengers(Plane[] planes, Plane myPlane, String[] newPassengers) {
        System.out.println(myPlane.model + " :");
        searchDuplicatesInPlane(myPlane,newPassengers);
        for (int i = 0; i < newPassengers.length; i++) {
            if (myPlane.currentPassengers[i] == null) {
                myPlane.currentPassengers[i] = newPassengers[i];
                System.out.println((i+1) + " " + myPlane.currentPassengers[i]);
            }
            else if (myPlane.currentPassengers[i] != null && newPassengers[i] != null) {
                System.out.println((i+1) + " " + myPlane.currentPassengers[i] + "   " + newPassengers[i] + ", sorry, your seat is taken!");
                searchFreeSeat(planes, newPassengers[i]);
            }
            else if (myPlane.currentPassengers[i] != null && newPassengers[i] == null) {
                System.out.println((i+1) + " " + myPlane.currentPassengers[i]);
            }
        }
        System.out.println();
    }

    public void searchDuplicatesInPlane (Plane myPlane, String[] newPassengers) {
        for (int i = 0; i < newPassengers.length; i++) {
            for (int j = 0; j < newPassengers.length; j++) {
                if (myPlane.currentPassengers[i] != null && myPlane.currentPassengers[i].equals(newPassengers[j])) {
                    System.out.println("A passenger with name " + newPassengers[j] + " is already registered!");
                    newPassengers[j] = null;
                }
            }
        }
    }

    public void searchFreeSeat (Plane[] allPlanes, String somePassenger) {
        boolean freeSeat = false;
        for (int i = 0; i < allPlanes.length; i++) {
            for (int j = 0; j < allPlanes[i].currentPassengers.length; j++) {
                if (allPlanes[i].currentPassengers[j] == null) {
                    freeSeat = true;
                    allPlanes[i].currentPassengers[j] = somePassenger;
                    break;
                }
            }
            if (freeSeat) {
                break;
            }
        }
        if (!freeSeat) {
            System.out.println("There are no free seats any more!");
        }
    }


}
