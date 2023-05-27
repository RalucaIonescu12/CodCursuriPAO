package Curs1;

class Paznic extends Angajat {
    double spor_noapte;
    public Paznic(String nume, double salariu, int varsta, double spor_noapte) {
        super(nume, salariu, varsta);
        this.spor_noapte = spor_noapte;
    }
    @Override
    double calculeazaVenit() {
        return salariu + salariu * spor_noapte;
    }
    void afiseazaSporPaznic() {
        double spor = salariu * spor_noapte;
        System.out.println("\tSpor paznic: " + spor);
    }
}
