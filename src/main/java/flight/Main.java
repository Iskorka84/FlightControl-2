package flight;

public class Main {

    public static void main(String[] args) {

        FlightControl boarding = new FlightControl();

        Plane airbus = new Plane("airbus", 4);
        Plane boeing = new Plane("boeing", 4);
        Plane privateJet = new Plane("privateJet", 3);

        Plane[] planes = {airbus, boeing, privateJet};

        String[] firstAirbusPassengers = {"Alain Delon", "Tom Cruise", null, "Elvis Presley"};
        String[] firstBoeingPassengers = {"David Beckham", "Leo Messi", null, null};
        String[] firstPrivateJetPassengers = {"Joe Biden", null, null};
        String[][] firstPlanePassengers = {firstAirbusPassengers, firstBoeingPassengers, firstPrivateJetPassengers};

        boarding.boardingNewPassengers(planes, firstPlanePassengers);

        String[] secondAirbusPassengers = {null, "Nicole Kidman", "Elvis Presley", null};
        String[] secondBoeingPassengers = {null, "Diego Maradona", "Zinedine Zidane", "Andrii Shevchenko"};
        String[] secondPrivateJetPassengers = {"Boris Johnson", null, "Mister X"};
        String[][] secondPlanePassengers = {secondAirbusPassengers, secondBoeingPassengers, secondPrivateJetPassengers};

        boarding.boardingNewPassengers(planes, secondPlanePassengers);


    }
}
