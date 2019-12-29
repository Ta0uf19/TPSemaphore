package ex2;

public class ThreadA extends Thread {

    private monSemaphore sem1;
    private monSemaphore sem2;

    public ThreadA(monSemaphore sem1, monSemaphore sem2) {
        this.sem1 = sem1;
        this.sem2 = sem2;
    }
    public void run() {
        this.sem1.P(); // relacher
        System.out.print("A");
        this.sem2.V(); // acquirer
    }
}
