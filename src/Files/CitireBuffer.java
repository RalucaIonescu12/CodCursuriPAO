package Files;


import java.io.*;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;
//Operațiile de citire/scriere la nivel de caracter/octet, specifice fluxurilor primitive,
// conduc la un număr mare de accesări ale fluxului respectiv (și, implicit, ale dispozitivului
// de memorie externă pe care este stocat fișierul asociat), ceea ce poate afecta eficiența
// din punct de vedere al timpului de executare. În scopul de a elimina acest neajuns,
// fluxurile de procesare la nivel de buffer introduc în procesele de scriere/citire o
// zonă auxiliară de memorie, astfel încât informația să fie accesată în blocuri de
// caractere/octeți având o dimensiune predefinită, ceea ce conduce la scăderea numărului
// de accesări ale fluxului respectiv.

// Dimensiunea implicită a buffer-ului utilizat este de 512 octeți.


//Exemplu: Fișierul date.in conține un text dispus pe mai multe linii.
// În fișierul date.out sunt afișate, pe fiecare linie, cuvintele sortate crescător lexicografic.
public class CitireBuffer {
    public static void main(String[] args) {
        try(BufferedReader fin = new BufferedReader(new FileReader("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Files\\date.in"));
            BufferedWriter fout = new BufferedWriter(new FileWriter("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Files\\date.out"));)
        {
            String linie;
            while((linie=fin.readLine())!=null)
            {
                String cuv[] = linie.split(" ");
                Arrays.sort(cuv);
                System.out.println(Arrays.toString(cuv));
                for(int i=0; i<cuv.length; i++)
                    fout.write(cuv[i] + " ");
                fout.write("\n");
            }
        }
        catch (FileNotFoundException ex) {
            System.out.println("Fisierul nu exista!");
        }
        catch(IOException ex) {
            System.out.println("Operatie de citire/scriere esuata!");
        }
    }
}
