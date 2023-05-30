package modelExamen2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.function.DoubleUnaryOperator;

/**
Scrieți o clasă Java care să calculeze de câte ori apare un cuvânt dat într-un
        fișier text, folosind un fir de executare. Scrieți un program care citește
        de la tastatură un cuvânt și, utilizând clasa definită anterior, afișează
        numărul total al aparițiilor cuvântului respectiv în fișierele text exemplu_1.txt,
        exemplu_2.txt și exemplu_3.txt. Cuvintele din fișierele text de intrare sunt despărțite
        între ele prin spații și semnele de punctuație uzuale.
 */

class NrAparitii extends Thread
{
    private int nr;
    private String numeFisier;
    private String cuvant;

    NrAparitii(String numeFisier,String cuvant){
        this.nr=0;
        this.cuvant=cuvant;
        this.numeFisier= numeFisier;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        try {
            Scanner in = new Scanner(new File(numeFisier));
            while(in.hasNextLine())
            {
                String linie=in.nextLine();
                System.out.println(linie);
                System.out.println("-----------");
                String []cuvinte= linie.split("[ .,\n]+");

                for (String cuv : cuvinte)
                    if (cuv.equals(cuvant))
                        nr++;
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println("eroare la fisier");
        }


    }
}

public class Ex3Model
{
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);

        System.out.println("Cuvantul cautat:    ");
        String cuv = in.next();

        NrAparitii f_1 = new NrAparitii("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\modelExamen2023\\cuvinte.in" , cuv);
        NrAparitii f_2 = new NrAparitii("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\modelExamen2023\\cuvinte2.in" , cuv);


        f_1.start();
        f_2.start();

        try
        {
            f_1.join();
            f_2.join();
        }
        catch (InterruptedException ex)
        {
            System.out.println("Eroare fire de executare!");
        }

        int t = f_1.getNr() + f_2.getNr();

        System.out.println("Cuvantul " + cuv + " apare de " + t + " ori in fisierele date!");
    }
}

//class k {
//    private int x = 5;
//    public void hidden() {
//        System.out.println(x);
//    }
//    public void show_hidden() {
//        hidden();
//    }
//}
//class l extends k {
//    private int x = 10;
//    public void hidden() {
//        System.out.println(x);
//    }
//}
//public class Ex3Model {
//    public static void main(String[] args) {
//        l b = new l();
//        b.show_hidden();
//    }
//}