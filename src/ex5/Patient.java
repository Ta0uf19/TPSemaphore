package ex5;

import java.util.concurrent.Semaphore;

public class Patient extends Thread {

    private int iD;
    private Semaphore sem_waiting_room;
    private Semaphore sem_doctor_processing;

    public Patient(int iD, Semaphore sem_waiting_room, Semaphore sem_doctor_processing) {
        super();
        this.iD = iD;
        this.sem_waiting_room = sem_waiting_room;
        this.sem_doctor_processing = sem_doctor_processing;
    }



    public void run() {
        //verifier si il y a une place si ui continue sinon return
        //attendre appel du medecin


        System.out.println("\n>>Patient "+ iD+" entre to the hospital" );
        try
        {

            if(sem_waiting_room.availablePermits()==0) {
                System.err.println("<<No place... Patient "+iD+" left the hospital (sem_waiting_room.availablePermits()==0)\n");
                return;
            }

            sem_waiting_room.acquire();
            System.out.println(iD + " is in the waiting room (after sem_waiting_room.acquire();)");


            System.out.println(iD + " is waiting for his turn (before sem_doctor_processing.acquire();)");
            sem_doctor_processing.acquire();
            System.out.println(iD + " is called by doctor (after sem_doctor_processing.acquire();)");
            System.out.println(iD + " is no more in the waiting room (sem_waiting_room.release();)");
            sem_waiting_room.release();
            enExamen();
            System.out.println(iD + " is no more with the doctor (sem_doctor_processing.release();)");
            sem_doctor_processing.release();
            System.out.println("<<Patient "+ iD+" leave the hospital" );


        } catch (InterruptedException exc) {
            System.out.println(exc);
        }

        // Release the permit. 


    }



    public void enExamen() {
        System.out.println(">>>"+iD + " healing (enExamen())");

        for (int i = 0; i < 8; i++) {
            try {
                sleep(250);
            } catch (InterruptedException e) {

            }
        }
        System.out.println("<<<"+iD + " finished healing (enExamen())");


    }
}
