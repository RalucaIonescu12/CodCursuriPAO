package Collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Iterators {
    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();
        lista.add("Ion");
        lista.add("Vasile");
        lista.addLast("Ana");
        lista.addFirst("Radu");
        lista.add(2, "Ioana");

        Iterator itr = lista.iterator();
        while(itr.hasNext())
            System.out.println(itr.next());

//        Orice colecție conține metode remove pentru ștergerea unui element având o anumită
//        poziție și/sau o anumită valoare. Totuși, în cazul în care o colecție este parcursă
//        fie "clasic", utilizând o instrucțiune de tip enhanced-for,
//        fie cu un iterator, aceste metode nu pot fi utilizate, așa cum vom vedea în următoarele două exemple:

/**
        Deși apelul metodei remove este formal corect, în momentul executării secvențelor de cod de
        mai jos apare excepția ConcurrentModificationException, deoarece operația de ștergere se realizează
        în timpul iterării colecției!
*/

        List<Integer> lista2 = new ArrayList<>();
        lista2.add(1);
        for(Integer item:lista2)
            if(item == 1)
                lista.remove(item);


        List<Integer> numere = new ArrayList<Integer>();
        numere.add(101);

        Iterator<Integer> itr2 = numere.iterator();
        while (itr2.hasNext())
        {
            Integer nr = itr2.next();
            if (nr % 2 == 0)
                numere.remove(nr);
        }

/**        O soluție sigură pentru a șterge un element dintr-o colecție presupune
 *         utilizarea metodei void remove() a unui iterator atașat unei colecții. Această
 *         metodă default este definită în interfața Iterator și permite ștergerea
 *         elementului curent (elementul referit de iterator):
*/
        Iterator<Integer> itr3 = numere.iterator();
        while (itr3.hasNext())
        {
            Integer number = itr3.next();
            if (number % 2 == 0)
                itr3.remove();
        }

    }
}
