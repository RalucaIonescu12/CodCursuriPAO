package Threads;
/**
class FirDeExecutareRunnable implements Runnable {
    @Override
    public void run() {
//        secvența de cod asociată firului de executare
    }

    public static void main(String[] args) {
        FirDeExecutareRunnable f = new FirDeExecutareRunnable(); // firul nu pornește automat!
        Thread t = new Thread(f);
        t.start(); //trebuie apelată metoda start() care va invoca metoda run()!
    }
}*/

class FirDeExecutare extends Thread
{
    char c;
    public FirDeExecutare(char c)
    {
        this.c = c;
    }
    @Override
    public void run()
    {
        for(int i = 0; i < 100; i++)
            System.out.print(c + " ");
    }

    public static void main(String[] args)
    {
        FirDeExecutare fir_1 = new FirDeExecutare('1');
        FirDeExecutare fir_2 = new FirDeExecutare('2');
        fir_1.start();
        fir_2.start();
        for(int i = 0; i < 100; i++)
            System.out.print("0 ");
        System.out.println();
    }
    /**
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0
     * 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2
     * 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
     * 2 2 2 2 2 2 2 2 2 2 2 2 1 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 2 2 2
     * 2 2 2 2 2 2 1 1 1 1 1 1 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2 2 2 2 2 2
     * 2 2 2 2 2 2 2 1 1 1 1 1 1 1 1 1 1 0 0 0 0 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 2
     * 2 2 2 2 2 2 2 2 2 2 2 2 2 2 2
     *
     * Practic, în acest program sunt executate concurent 3 fire (fir_1, fir_2 și firul principal -
     * cel asociat metodei main()), pe care planificatorul le execută într-un mod aleatoriu, astfel:
     * fiecare fir este executat o perioadă de timp, după care el este suspendat și se trece la executarea
     * altui fir, până când toate cele 3 fire își vor încheia executarea. În exemplul de mai sus, se observă
     * faptul că deși firul principal se termină primul (ultimele 4 cifre de 0 sunt afișate pe penultimul rând),
     * executarea programului se încheie doar după ce se termină de executat și celelalte două fire (care afișează
     * cifrele 1 și 2).
     */
}
