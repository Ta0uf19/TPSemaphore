package ex4;

import java.util.concurrent.Semaphore;

public class VPark {
    int placeOcuppes = 0;

    private Semaphore sem;

    public VPark(int capacite) {
        sem = new Semaphore(capacite);
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

    public void arriver() throws InterruptedException {
        if(this.sem.availablePermits() == 0)
        {
            System.err.println("Parking refusé! attendre..");
        }
        this.sem.acquire();
        this.placeOcuppes++;
        System.out.println("Une voiture est entrée, il y a " + this.placeOcuppes + " places occupées");

    }
    public void partir()
    {
        this.placeOcuppes--;
        this.sem.release();
        System.out.println("Une voiture est sorti, il reste " + this.placeOcuppes + " places occupées");
    }
}
