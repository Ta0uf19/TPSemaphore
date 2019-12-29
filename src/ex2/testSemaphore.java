package ex2;

public class testSemaphore {


    public static void main(String args[]) throws InterruptedException {

        monSemaphore semaphoreA = new monSemaphore(1);
        monSemaphore semaphoreB = new monSemaphore(0);
        monSemaphore semaphoreC = new monSemaphore(0);

       for(int i = 0; i < 5; i++){

           new ThreadA(semaphoreA, semaphoreB).start();
           new ThreadB(semaphoreB, semaphoreC).start();
           new ThreadC(semaphoreC, semaphoreA).start();
       }
   }

}
