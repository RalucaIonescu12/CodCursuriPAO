package Curs1;

public class ClasaAfișareȘir implements InterfațaAfișareȘir {
    //@Override -> nu se poate utiliza adnotarea deoarece metoda este statică și nu se preia din interfață
    public static boolean esteȘirVid(String str) {
        System.out.println("Metoda esteȘirVid din clasă!");
        return str.length() == 0;
    }
}
