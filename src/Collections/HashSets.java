package Collections;

import java.util.HashSet;

public class HashSets {
    public static void main(String[] args) {
//• metoda hashCode trebuie să returneze aceeași valoare în timpul rulării unei aplicații,
// indiferent de câte ori este apelată, dacă starea obiectului nu s-a modificat, dar nu
// trebuie să furnizeze aceeași valoare în cazul unor rulări diferite;

//• două obiecte egale din punct de vedere al metodei equals trebuie să fie egale și
// din punct de vedere al metodei hashCode, deci trebuie să aibă și hash code-uri egale;

//• nu trebuie neapărat ca două obiecte diferite din punct de vedere al conținutului să
// aibă hash-code-uri diferite, dar, dacă acest lucru este posibil, se vor obține performanțe
// mai bune pentru operațiile asociate unei tabele de dispersie

        HashSet<Persoana> lp = new HashSet<>();
        Persoana p1 = new Persoana("Popescu Ion", 23);
        Persoana p2 = new Persoana("Popescu Ion", 23);
        lp.add(p1);
        lp.add(p2);
        System.out.println(lp.size());
//        În urma rulării secvenței de cod de mai sus, se va afișa valoarea 2,
//        deoarece ambele obiecte p1 și p2 vor fi inserate în HashSet-ul lp! Evident,
//        problema se rezolvă implementând corect metodele equals și hashCode în clasa Persoana.
    }
}
