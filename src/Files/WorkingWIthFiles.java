package Files;

import java.io.*;

public class WorkingWIthFiles {
    public static void main(String[] args) throws IOException {
        FileReader fin = new FileReader("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Files\\exemplu.txt");
        ///sau
        File f = new File("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Files\\exemplu.txt");
        FileReader fin2 = new FileReader(f);




        try {
            FileWriter fout = new FileWriter("exemplu.txt");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        ///sau
         File f2 = new File("exemplu.txt");
        try {
            FileWriter fout2 = new FileWriter (f);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ///adaugare cu append  true->la final false->la inceput
        ///write


        ///
        FileReader fin3 = new FileReader("test.txt");
        FileWriter fout3 = new FileWriter("copie_caractere.txt", true);
        int c;
        while((c = fin.read()) != -1)
            fout3.write(c);




        /////Copierea directă a întregului conținut al
        // fișierului text test.txt în fișierul text copie_octeti.txt.

        FileInputStream fin4 = new FileInputStream("test.txt");
        FileOutputStream fout4 = new FileOutputStream("copie_octeti.txt");
        int dimFisier = fin4.available(); //metoda returnează numărul de octeți din fișier
        byte []buffer = new byte[dimFisier];
        fin4.read(buffer); //se citesc toți octeții din fișierul de intrare
        fout4.write(buffer); // se scriu toți octeții în fișierul de ieșire
    }
}

