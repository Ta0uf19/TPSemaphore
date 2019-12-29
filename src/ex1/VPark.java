package ex1;

public class VPark {
    private int capacite = 0;
    int placeOcuppes = 0;

    public VPark(int capacite) {
        this.capacite = capacite;
    }

    public static void main(String args[]) throws InterruptedException {
        VPark parking = new VPark(4);
        // créer 100 threads de voiture
        for(int i=0; i < 100; i++)
        {
            new Voiture(parking).start();
            Thread.sleep((long)(50 * Math.random()));
        }
    }

    synchronized public void arriver() throws InterruptedException {
        if((this.capacite - this.placeOcuppes) == 0)
        {
            System.err.println("Parking refusé! attendre..");
            this.wait();
        }

        this.placeOcuppes++;
        System.out.println("Une voiture est entrée, il y a " + this.placeOcuppes + " places occupées");

    }
    synchronized public void partir()
    {
        this.placeOcuppes--;
        this.notify();
        System.out.println("Une voiture est sorti, il reste " + this.placeOcuppes + " places occupées");
    }
}
