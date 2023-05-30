package ExamenIunie2022;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**

 III.
 Informaţiile despre concertele organizate de compania MusicForStudents în anul curent
 sunt păstrate în mai multe fişiere text. Fiecare linie dintr-un astfel de fişier conţine
 informaţii referitoare la un concert, respectiv denumire, localitate, pretBilet și numarLocuri,
 despărţite între ele prin câte o virgulă. Scrieţi o clasă Java care să calculeze, pe baza
 informaţiilor dintr-un fişier de tipul indicat anterior, numărul concertelor la care prețul
 biletului nu depăşeşte o valoare maximă dată, folosind un fir de executare dedicat.
 Scrieți un program care, utilizând clasa definită anterior, citeşte de la tastatură o valoare
 reală pmax, după care afişează numărul total al concertelor având preţurile biletelor cel mult
 egale cu pmax, pe baza informaţiilor din fişierele text concerte_1.txt şi concerte_2.txt.
 */


class CalculeazaNumarConcert extends Thread{

    private String numeFisier;
    private float pmax;
    private int nr;

    CalculeazaNumarConcert(String numeFisier,float pmax)
    {
        this.numeFisier=numeFisier;
        this.pmax=pmax;
        this.nr=0;
    }

    public String getNumeFisier() {
        return numeFisier;
    }

    public void setNumeFisier(String numeFisier) {
        this.numeFisier = numeFisier;
    }

    public float getPmax() {
        return pmax;
    }

    public void setPmax(float pmax) {
        this.pmax = pmax;
    }

    public int getNr() {
        return nr;
    }

    public void setNr(int nr) {
        this.nr = nr;
    }

    @Override
    public void run() {
        try{
            Scanner in= new Scanner(new File(numeFisier));

            while(in.hasNextLine())
            {
                String concert=in.nextLine();
                String []infoConcert=concert.split("[,]+");
//                denumire, localitate, pretBilet și numarLocuri,
                float pret = Float.parseFloat(infoConcert[2]);
                if (pret<=pmax)
                    nr++;
            }
            in.close();
        }
        catch (FileNotFoundException e)
        {
            System.out.println(e);
        }
    }


}
public class Ex3Iunie2022 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        System.out.println("Valoarea lui Pmax:");
        float nr=in.nextFloat();

        CalculeazaNumarConcert c1=new CalculeazaNumarConcert("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\ExamenIunie2022\\concerte1",nr);
        CalculeazaNumarConcert c2=new CalculeazaNumarConcert("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\ExamenIunie2022\\concerte2",nr);
        CalculeazaNumarConcert c3=new CalculeazaNumarConcert("C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\ExamenIunie2022\\concerte3",nr);

        c1.start();
        c2.start();
        c3.start();

        try{
            c1.join();
            c2.join();
            c3.join();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }
        int t=c1.getNr() + c2.getNr() + c3.getNr();
        System.out.println(t);
    }
}
