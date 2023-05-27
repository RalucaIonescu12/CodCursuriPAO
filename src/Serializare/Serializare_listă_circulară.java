package Serializare;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class Serializare_listă_circulară {
    //    Folosind clasa Nod, vom construi o listă circulară, formată din
    //    numerele naturale cuprinse între 1 și 10, pe care apoi o vom salva/serializa
    //    în fișierul binar lista.ser, scriind în fișier doar primul său nod (obiectul prim) – restul
    //    nodurilor listei vor fi salvate/serializate automat, deoarece ele formează graful
    //    de dependențe asociat obiectului prim:

    public static void main(String[] args) {
        Nod prim = null, ultim = null;
        for (int i = 1; i <= 10; i++)
        {
            Nod aux = new Nod(i);
            if (prim == null) prim = ultim = aux;
            else {
                ultim.next = aux;
                ultim = aux;
                System.out.println(ultim.data);
            }
        }
        ultim.next = prim;
        System.out.println("Lista care va fi serializată:");
        Nod aux = prim;
        do {
            System.out.print(aux.data + " ");
            aux = aux.next;
        }
        while (aux != prim);
        try (ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Serializare\\lista.ser")))
        {
            fout.writeObject(prim);

        }
        catch (IOException ex)
        {
            System.out.println("Excepție: " + ex);
        }

    }
}
