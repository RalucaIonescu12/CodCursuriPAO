package Model2019;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.PrimitiveIterator;
import java.util.Scanner;

class Cuvinte extends Thread
{
    private int n;
    private String numeFisier;
    private HashSet<String> cuvN;
    Cuvinte(int n, String numeFisier,HashSet<String> cuvN)
    {
        this.n=n;
        this.numeFisier=numeFisier;
        this.cuvN=new HashSet<>();
    }
    @Override
    public void run(){
        try{
            Scanner in = new Scanner(new File(numeFisier));
            while(in.hasNextLine())
            {
                String []linie=in.nextLine().split("[ ,.?!;]+");
                for(String cuv : linie)
                    if (cuv.length()==n)
                    {
                        cuvN.add(cuv);
//                         System.out.println(cuvN);
                    }
            }

            in.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println(e);
        }
    }

    public HashSet<String> getCuvN() {
        return cuvN;
    }

    public void setCuvN(HashSet<String> cuvN) {
        this.cuvN = cuvN;
    }
}
public class ExII2019 {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        int n= in.nextInt();
        HashSet<String> h1=new HashSet<>();
        HashSet<String> h2=new HashSet<>();
        Cuvinte c1=new Cuvinte(n,"C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Model2019\\cuvinte1",h1);
        Cuvinte c2=new Cuvinte(n,"C:\\FACULTATE\\ANUL II\\An II sem 2\\PAO\\Cod-Curs3-PAO\\src\\Model2019\\cuvinte2",h2);
        c1.start();
        c2.start();
        try
        {
            c1.join();
            c2.join();
        }
        catch (InterruptedException e)
        {
            System.out.println(e);
        }

        h1=c1.getCuvN();
        h2=c2.getCuvN();
        h1.addAll(h2);

        h1.forEach(System.out::println);

    }
}
