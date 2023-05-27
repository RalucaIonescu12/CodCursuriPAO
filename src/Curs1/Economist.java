package Curs1;

class Economist extends Angajat {
    //treapta profesională -> număr natural cuprins între 0 și 5
    int treapta_profesionala;
    //sporurile procentuale corespunzătoare treptelor profesionale
    static final double sporuri[] = {5, 10, 15, 20, 25, 30};
    public Economist(String nume, double salariu, int varsta, int
            treapta_profesionala) {
        super(nume, salariu, varsta);
        this.treapta_profesionala = treapta_profesionala;
    }
    @Override
    double calculeazaVenit() {
        return salariu + salariu * sporuri[treapta_profesionala] / 100;
    }
    void afiseazaSporEconomist() {
        double spor = salariu * sporuri[treapta_profesionala] / 100;
        System.out.println("\tSpor economist: " + spor);
    }
}