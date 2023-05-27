package Collections;

import java.util.Comparator;
import java.util.TreeMap;

public class TreeMaps {
    public static void main(String[] args) {
        TreeMap<String, Integer> fcuv = new TreeMap(new cmpCuvinte());
//        Intern, implementarea clasei TreeMap utilizează un arbore binar de tip Red-Black
//        pentru a menține perechile cheie-valoare sortate fie în ordine naturală a cheilor,
//        dacă se utilizează constructorul fără parametri, fie în ordinea indusă de un comparator
//        transmis ca parametru al constructorului. Astfel, dacă în exemplul anterior
//        înlocuim obiectul de tip HashMap cu un obiect de tip TreeMap și utilizăm
//        tot constructorul fără argumente, cuvintele din fișier vor fi afișate în
//        ordine alfabetică. Dacă dorim să afișăm cuvintele în ordinea crescătoare a
//        lungimilor lor, iar în cazul unor cuvinte de lungimi egale în ordine alfabetică, definim comparatorul

    }
}
class cmpCuvinte implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
        if(s1.length() != s2.length())
            return s1.length() - s2.length();
        else
            return s1.compareTo(s2);
    }
}
