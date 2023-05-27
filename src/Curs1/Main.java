package Curs1;

public class Main {
    public static void main(String[] args)
    {

        Persoana p1 = new Persoana();
        System.out.println(p1);
        System.out.println();
        Persoana p2 = new Persoana("Popescu Ion");
        System.out.println(p2);
        System.out.println();
        Persoana p3 = new Persoana("Ionescu Dana", 25);
        System.out.println(p3);
        System.out.println();
        System.out.println("-------------------------");



        A ob = new B(); //polimorfism
        System.out.println("Data membră non-statică = " + ob.dată_membră_non_statică);
        System.out.println("Data membră statică = " + ob.dată_membră_statică);
        ob.metoda1();
        ob.metoda2();

        System.out.println("-------------------------");
//declarăm un tablou cu elemente de tipul superclasei Angajat,
//comună subclaselor Paznic și Economist
        Angajat t[] = new Angajat[4];
//folosind upcasting-ul, atribuim elementelor tabloului referințe
//spre instanțe ale celor două subclase (Paznic și Economist)
        t[0] = new Paznic("Popa Ion", 2500, 40, 0.25);
        t[1] = new Economist("Mihai Ana", 3700, 55, 4);
        t[2] = new Economist("Popescu Maria", 3000, 47, 2);
        t[3] = new Paznic("Ionescu Mihai", 2100, 35, 0.20);
//afișăm informațiile despre fiecare angajat
        for(int i = 0; i < t.length; i++)
        {
            System.out.println("Angajat " + (i+1) + ":");
            System.out.println("\tNume: " + t[i].nume);
//datorită polimorfismului, pentru fiecare angajat
//se va apela metoda calculeazaVenit() din subclasa corespunzătoare
            System.out.println("\tVenit: " + t[i].calculeazaVenit());
//pentru a putea apela metodele proprii fiecărei subclase,
//utilizăm downcasting-ul
            if(t[i] instanceof Paznic)
            {
                Paznic aux = (Paznic)t[i];
                aux.afiseazaSporPaznic();
            }
            else
            if(t[i] instanceof Economist)
            {
                Economist aux = (Economist)t[i];
                aux.afiseazaSporEconomist();
            }
            System.out.println();
        }

    }
}
