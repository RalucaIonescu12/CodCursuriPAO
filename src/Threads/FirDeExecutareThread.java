package Threads;

class FirDeExecutareThread extends Thread {
    @Override
    public void run() {
//        secvența de cod asociată firului de executare
    }

    public static void main(String[] args) {
        FirDeExecutareThread f = new FirDeExecutareThread(); // firul nu pornește automat!
        f.start(); //trebuie apelată metoda start() care va invoca metoda run()!
    }
}
