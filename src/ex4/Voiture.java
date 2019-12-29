package ex4;

public class Voiture extends Thread {
    private VPark parking;
    public Voiture (VPark parking)
    {
        this.parking = parking;
    }
    public void run() {
        try {
            parking.arriver();
            Thread.sleep((long)(500 * Math.random()));
            parking.partir();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}