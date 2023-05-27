package Collections;

import java.util.Comparator;
import java.util.TreeSet;

public class TreeSets {
    public static void main(String[] args) {
        /**
        Intern, clasa TreeSet implementează o mulțime utilizând un arbore binar de tip
        Red-Black pentru a stoca elemente într-o anumită ordine,
        respectiv în ordinea lor naturală când se utilizează constructorul
        fără parametri ai clasei și clasa corespunzătoare obiectelor
        implementează interfața Comparable sau într-o ordine specificată în constructorul
        clasei printr-un argument de tip Comparator:
         */
        TreeSet t = new TreeSet();
        Comparator comp = null;
        TreeSet t2 = new TreeSet(comp);


//        Colecția TreeSet este utilă în aplicații care necesită stocarea unui număr
//        mare de obiecte sortate după un numit criteriu, regăsirea informației fiind rapidă.
    }
}
