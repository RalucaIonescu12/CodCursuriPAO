package Collections;

import java.util.Arrays;
import java.util.Comparator;

public class lambdas {

    ///lambda expresii
    public static void main(String[] args) {


        ///clasa anonima
        Persoana tp[]= new Persoana[2];
        Persoana tp2[]= new Persoana[2];
        Persoana p2=new Persoana();
        Persoana p1=new Persoana();
        Arrays.sort(tp, new Comparator(){
            public int compare(Object p1 , Object p2)
            {
                return ((Persoana)p1).getNume().
                        compareTo(((Persoana)p2).getNume());
            }
        });

        Arrays.sort(tp2, (Object p3, Object p4) -> ((Persoana)p3).getNume().
                compareTo(((Persoana)p4).getNume()));
        Arrays.sort(tp2, (p3, p4) -> ((Persoana)p1).getNume().
                compareTo(((Persoana)p2).getNume()));
        Arrays.sort(tp2, (p3, p4) -> p1.getNume().compareTo(p2.getNume()));


        /**
         * Consumer<Persoana[]> sortare = tablou -> Arrays.sort(tablou,
         *                                              (p1, p2) -> p1.getVarsta() - p2.getVarsta());
         * Consumer<Persoana[]> afisare = tablou -> {
         *                                          for (Persoana aux : tablou)
         *                                          System.out.println(aux);
         *                                          };
         * sortare.andThen(afisare).accept(tp);
         *
         *
         *
         *
         * Function<Persoana , Double> marire = pers -> pers.getSalariu() * 1.2;
         * for(Persoana crt:tp)
         *         System.out.println(crt.getNume() + " " + marire.apply(crt));
         *
         *
         *
         *
         *         Function<Integer,Integer> f = x -> x*x;
         * Function<Integer,Integer> g = x -> 2*x;
         * System.out.println("f ∘ g = " + f.compose(g).apply(2)); //va afișa 16
         * System.out.println("f ∘ g = " + g.andThen(f).apply(2)); //va afișa 16
         * System.out.println("g ∘ f = " + g.compose(f).apply(2)); //va afișa 8
         * System.out.println("g ∘ f = " + f.andThen(g).apply(2)); //va afișa 8
         *
         *
         * Supplier<Persoana> furnizor = () -> new Persoana("",0,0.0);
         * Persoana p = furnizor.get();
         */

    }
}
