package Collections;

import java.util.LinkedList;

public class LinkedLists {
    public static void main(String[] args)
    {

        ////cand avem nevoie de mult inserari stergeri

        LinkedList<String> lista = new LinkedList<>();
        // adăugarea unor elemente în listă
        lista.add("A");
        lista.add("B");
        lista.addLast("C");
        lista.addFirst("D");
        lista.add(2, "E");
        lista.add("F");
        lista.add("G");
        System.out.println(lista); // [D, A, E, B, C, F, G]

        // ștergerea unor elemente din listă
        lista.remove("B");
        lista.remove(3);
        lista.removeFirst();
        lista.removeLast();
        System.out.println(lista); // [A, E, F]

        // căutarea unui element în listă
        boolean rezultat = lista.contains("E");
        System.out.println(rezultat); // true

        // operații de accesare a unui element
        Object element = lista.get(2);
        System.out.println(element); // F
        lista.set(2, "Y");
        System.out.println(lista); // [A, E, Y]

//• Accesarea unui element se realizează cu complexitatea 𝒪(𝑛).
//• Adăugarea unui element la sfârșitul listei, folosind metoda add(E elem), se realizează cu complexitatea 𝒪(1).
//• Adăugarea unui element pe poziția index, folosind metoda add(E elem, int index), se realizează cu o complexitate egală cu 𝒪(𝑛).
//• Căutarea unui element se realizează cu o complexitate egală cu 𝒪(𝑛).
//• Ștergerea unui element se realizează cu o complexitate egală cu 𝒪(𝑛).
    }
}
