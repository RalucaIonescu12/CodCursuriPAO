package Externalizare;

import java.io.*;

public class Main {
    public static void main(String[] args) {
//        Considerăm un tablou s cu elemente de tip Student:

        Student s[] = new Student[5];
        Student.facultate = "Facultatea de Matematica si Informatica";
        s[0] = new Student();


//        Salvarea tabloului s într-un fișier binar studenti_extern.ser se poate realiza astfel:

        try(ObjectOutputStream fout = new ObjectOutputStream(new FileOutputStream("studenti_extern.ser")))
        {
            fout.writeObject(s);
        }
        catch (IOException ex)
        {
            System.out.println("Excepție: " + ex);
        }


//        Restaurarea tabloului s din fișierul binar studenti_extern.ser se poate realiza astfel:

        Student s2[];
        try(ObjectInputStream fin = new ObjectInputStream(new FileInputStream("studenti_extern.ser")))
        {
            s2= (Student [])fin.readObject();
        }
        catch (Exception ex)
        {
            System.out.println(ex);
        }

//        Un aspect pe care nu trebuie să-l pierdem din vedere în momentul utilizării
//        externalizării este faptul că se vor pierde toate facilitățile puse la dispoziție
//        de mecanismul de serializare (salvarea automată a informațiilor despre superclasele
//        clasei respective, salvarea automată a grafului de dependențe etc.), deci un
//        programator va trebui să le implementeze explicit!
    }
}
