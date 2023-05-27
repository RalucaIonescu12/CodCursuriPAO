package Serializare;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Deserializare_listă_ciculară {
    //    Pentru a restaura lista circulară salvată/serializată în fișierul binar
    //    lista.ser, vom citi/deserializa din fișier doar primul său nod (obiectul prim),
    //    iar restul nodurilor listei vor fi restaurate/deserializate automat, deoarece
    //    ele formează graful de dependențe asociat obiectului prim (evident,
    //    clasa Nod trebuie să fie vizibilă):

    public static void main(String[] args) {
        try (ObjectInputStream fin = new ObjectInputStream(new FileInputStream("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Serializare\\lista.ser"))) {
            Nod prim = (Nod) fin.readObject();
            System.out.println("Lista deserializata:");
            Nod aux = prim;
            do {
                System.out.print(aux.data + " ");
                aux = aux.next;
            } while (aux != prim);

            System.out.println();

        }
        catch (Exception ex)
        {
            System.out.println("Excepție: " + ex);
        }
        //    În exemplul prezentat, graful de dependențe asociat obiectului
        //    prim este unul ciclic, deoarece lista este circulară (deci există o referință
        //    indirectă a obiectului prim către el însuși), dar mecanismul de serializare
        //    gestionează fără probleme o astfel de situație complicată!

    }
}
