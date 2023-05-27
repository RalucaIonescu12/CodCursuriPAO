package Collections;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class HashMaps {
    public static void main(String[] args) throws FileNotFoundException {
        //h1 conține studenții anului I folosind perechi număr_matricol - student
        HashMap<String, Student> h1 = new HashMap<>();
        //h2 conține studenții anului II folosind perechi număr_matricol - student
        HashMap<String, Student> h2 = new HashMap<>();
        //m conține studenții din fiecare an folosind perechi an_studiu – studenti
        HashMap<Integer, HashMap<String, Student>> m = new HashMap();
        h1.put("11111", new Student("Ion Popescu", 141, new int[]{10, 9, 10, 7, 8}));
        h1.put("22222", new Student("Anca Pop", 142, new int[]{9, 10, 10, 8}));
        h2.put("12121", new Student("Ana Ionescu", 241, new int[]{8, 9, 10}));
        h2.put("12345", new Student("Radu Mihai" , 242 , new int[]{9, 10, 8}));
        m.put(1, h1);
        m.put(2, h2);
        for(Map.Entry<Integer, HashMap<String, Student>> hms : m.entrySet()) {
            System.out.println("An " + hms.getKey() + ": ");
            for(Map.Entry<String, Student> s : hms.getValue().entrySet())
                System.out.println(s);
        }


//        Pentru a calcula frecvența cuvintelor dintr-un fișier, vom folosi un HashMap
//        cu perechi de forma cuvânt – frecvență_cuvânt. Fiecare cuvânt din fișier va fi
//        căutat în HashMap și dacă nu există deja, va fi inserat cu frecvența 1, altfel i
//        se va actualiza frecvența mărită cu 1 (prin reinserare):

        Scanner in = new Scanner(new File("exemplu.txt"));
        HashMap<String, Integer> fcuv = new HashMap();
        while(in.hasNextLine()) {
            String linie = in.nextLine();
            String []cuvinte = linie.split("[ ,.;:?!]+");
            for(String cuvant : cuvinte)
                if(fcuv.containsKey(cuvant))
                    fcuv.put(cuvant, fcuv.get(cuvant) + 1);
                else
                    fcuv.put(cuvant, 1);
        }
        System.out.println("Frecventele cuvintelor din fisier: ");
        for(Map.Entry<String, Integer> aux : fcuv.entrySet())
            System.out.println(aux.getKey() + " -> " + aux.getValue());
        in.close();
    }



}
