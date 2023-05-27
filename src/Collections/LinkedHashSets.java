package Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class LinkedHashSets {
    public static void main(String[] args) throws FileNotFoundException
    {
        Scanner in = new Scanner(new File("numere.txt"));
        HashSet<Integer> nrdist = new HashSet();
        while (in.hasNextLine()) {
            String linie = in.nextLine();
            String[] numere = linie.split("[ ,.;:?!]+");
            for (String nr : numere)
                nrdist.add(Integer.parseInt(nr));
        }
        System.out.println("Valorile distincte din fisier: ");
        for (int x : nrdist)
            System.out.print(x + " ");
        in.close();
//        După executarea programului de mai sus, se vor afișa valorile distincte
//        din fișierul text, într-o ordine oarecare. Dacă în locul clasei HashSet
//        vom utiliza clasa LinkedHashSet, atunci valorile distincte vor fi afișate
//        în ordinea inserării, adică în ordinea în care ele apar în fișierul text.
    }
}
