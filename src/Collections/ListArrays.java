package Collections;

import java.util.ArrayList;
import java.util.List;

/**
 * exista si Vector de la List -> sincronizare pt threads
 *
 * Stack extinde Vector
 */
public class ListArrays {
    public static void main(String[] args) {
////cand avem nevoie de accesare cel mai mult

        List<Integer> lista1 = new ArrayList<>();
        lista1.add(0, 1); // adaugă 1 pe poziția 0
        lista1.add(1, 2); // adaugă 2 pe pozția 1
        System.out.println(lista1); // [1, 2]
        List<Integer> lista2 = new ArrayList<Integer>();
        lista2.add(1); // adaugă 1 la sfârșitul listei
        lista2.add(2); // adaugă 2 la sfârșitul listei
        lista2.add(3); // adaugă 3 la sfârșitul listei
        System.out.println(lista2); // [1, 2, 3]
        // adaugă elementele din lista2 începând cu poziția 1
        lista1.addAll(1, lista2);
        System.out.println(lista1); // [1, 1, 2, 3, 2]
        // șterge elementul de pe poziția 1
        lista1.remove(1);
        System.out.println(lista1); // [1, 2, 3, 2]
        // afișează elementul aflat pe poziția 3
        System.out.println(lista1.get(3)); // 2
        // înlocuiește valoarea aflată pe poziția 1 cu valoarea 5
        lista1.set(1, 5);
        System.out.println(lista1); // [1, 5, 3, 2]


//• Accesarea unui element se realizează cu complexitatea 𝒪(1).
//• Adăugarea unui element la sfârșitul listei prin metoda add(T elem)se realizează cu complexitatea 𝒪(1) dacă nu este depășită capacitatea listei sau cu complexitatea 𝒪(𝑛) în caz contrar.
//• Adăugarea unui element pe o anumită poziție prin metoda add(E element, int index)se realizează cu complexitatea 𝒪(𝑛).
//• Căutarea sau ștergerea unui element se realizează cu complexitatea 𝒪(𝑛).


    }
}
