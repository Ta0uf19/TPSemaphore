package ex2;

public class monSemaphore {

    private int val = 0;

    public monSemaphore(int val) {
        this.val = val;
    }
    // mettre en attente le processus jusqu'à que la ressources soit disponible
    public void P() {
        synchronized (this) {
            while (this.val == 0) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            this.val--;
        }
    }
    // acquire
    public void V() {
        synchronized(this) {
            this.val++;
            this.notify();
        }
    }

}
