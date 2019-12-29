package ex5;


public class cliniqueMedecin extends Thread {

    public static void main(String args[]) {
        cliniqueMedecin cliniqueM = new cliniqueMedecin();
        cliniqueM.start(); // Que la simulation commence
    }
    public void run() {
        Medecin doc = new Medecin();
        doc.start(); // la consultation a commencé
        int i = 0;
        long rnd = (long) ((3000 * Math.random()));
        while (true) {
            i++;
            Patient aPatient = new Patient(i);
            aPatient.start();
            try {
                sleep(rnd); //rnd est une valeur aléatoire entre 2 et 4 seondes
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
