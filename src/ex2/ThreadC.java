package ex2;

public class ThreadC extends Thread {

    private monSemaphore sem1;
    private monSemaphore sem2;

    public ThreadC(monSemaphore sem1, monSemaphore sem2) {
        this.sem1 = sem1;
        this.sem2 = sem2;
    }
    public void run() {
        this.sem1.P(); // wait for permissions to run
        System.out.print("C");
        this.sem2.V();
    }
}
