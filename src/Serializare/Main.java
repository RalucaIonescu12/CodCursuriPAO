package Serializare;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {


//se deschide un flux binar de ieșire utilizând clasa java.io.ObjectOutputStream:

        FileOutputStream file = new FileOutputStream("studenti.bin");
        ObjectOutputStream fout = new ObjectOutputStream(file);

//se salvează/scrie obiectul în fișier apelând metoda void writeObject(Object ob):

        Student s = new Student("Ion Popescu", 241, new int[]{10, 9, 10, 7, 8});
        fout.writeObject(s);

/////Deserializarea unui obiect se realizează astfel:

//se deschide un flux binar de intrare utilizând clasa java.io.ObjectInputStream:

        FileInputStream file2 = new FileInputStream("studenti.bin");
        ObjectInputStream fin2 = new ObjectInputStream(file2);

//se citește/restaurează obiectul din fișier apelând metoda Object readObject():
        Student s2 = (Student)fin2.readObject();
/**
NU se serializează datele membre statice și nici corpurile metodelor, ci doar antetele lor.

Explicit NU se serializează datele membre marcate prin modificatorul transient (de exemplu,
 s-ar putea să nu dorim salvarea anumitor informații confidențiale: salariul unei persoane,
 parola unui utilizator etc.).

Serializarea nu tine cont de specificatorii de acces, deci se vor serializa și datele/metodele private!

În momentul sterilizării unui obiect se va serializa întregul graf de dependențe asociat obiectului
 respectiv, adică obiectul respectiv și toate obiectele referite direct sau indirect de el.
  */
    }
}