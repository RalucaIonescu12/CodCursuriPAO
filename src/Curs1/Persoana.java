package Curs1;

public class Persoana {
        String nume;
        int varsta, ID;
        static int nrPersoane;
        static String nationalitate;
        public Persoana() {
            this.nume = "XYZ";
            this.varsta = 20;
            System.out.println("Constructorul cu 0 parametri");
        }
        public Persoana(String nume) {
            this.nume = nume;
            this.varsta = 20;
            System.out.println("Constructorul cu 1 parametru");
        }
        public Persoana(String nume, int varsta) {
            this.nume = nume;
            this.varsta = varsta;
            System.out.println("Constructorul cu 2 parametri");
        }
        //bloc nestatic de initializare
        {
            this.ID = ++nrPersoane;
            System.out.println("Bloc nestatic de initializare");
        }
        //bloc static de initializare
        static
        {
            System.out.println("Bloc static de initializare\n");
            nationalitate = "română";
            nrPersoane = 0;
        }
        @Override
        public String toString() {
            return "nume='" + nume + ", varsta=" + varsta + ", ID=" + ID;
        }
    }
