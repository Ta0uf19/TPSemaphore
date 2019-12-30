package ex5;


import java.util.concurrent.Semaphore;

public class cliniqueMedecin extends Thread {

    public static void main(String args[]) {
        cliniqueMedecin cliniqueM = new cliniqueMedecin();
        cliniqueM.start(); // Que la simulation commence
    }
    public void run() {

        Semaphore sem_waiting_room = new Semaphore(2);
        Semaphore sem_doctor_processing = new Semaphore(0);

        Medecin doc = new Medecin(sem_doctor_processing);
        doc.start(); // la consultation a commencé
        int i = 0;
        while (true) {
            long rnd = (long) (Math.random()*3 + 2) * 1000;
            //System.out.println(rnd);
            i++;
            Patient aPatient = new Patient(i, sem_waiting_room, sem_doctor_processing);
            aPatient.start();
            try {
                //rnd est une valeur aléatoire entre 2 et 4 seondes
                sleep(rnd);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
