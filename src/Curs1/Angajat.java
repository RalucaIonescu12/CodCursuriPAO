package Curs1;

class Angajat {
    String nume;
    double salariu;
    int varsta;
    public Angajat(String nume, double salariu, int varsta) {
        this.nume = nume;
        this.salariu = salariu;
        this.varsta = varsta;
    }
    double calculeazaVenit() {
        return salariu;
    }
}