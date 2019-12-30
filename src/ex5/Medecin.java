package ex5;

import java.util.concurrent.Semaphore;

public class Medecin extends Thread {

    Semaphore sem_doctor_processing;

    public Medecin(Semaphore sem_doctor_processing) {
        this.sem_doctor_processing = sem_doctor_processing;
        this.sem_doctor_processing.release();
    }

    public void run() {
        while(true) {
            if(sem_doctor_processing.availablePermits() == 0)
                enConsultation();
            else {
                System.out.println("<<doctor sleeping>>");
                try {
                    sleep(500);
                } catch (InterruptedException e) {

                }
            }

        }
    }

    public void enConsultation() {
        System.out.println("<<doctor healing (enConsultation())>>");
        try {
            sleep(500);
        } catch (InterruptedException e) {
        }
    }
}
