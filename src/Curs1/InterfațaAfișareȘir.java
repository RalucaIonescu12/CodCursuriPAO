package Curs1;

public interface InterfațaAfișareȘir {
    default void afișeazăȘir(String str) {
        if (!esteȘirVid(str))
            System.out.println("Sirul: " + str);
        else
            System.out.println("Sirul este vid!");
    }
    static boolean esteȘirVid(String str) {
        System.out.println("Metoda esteȘirVid din interfață!");
        return str == null ? true : (str.equals("") ? true : false);
    }
}

