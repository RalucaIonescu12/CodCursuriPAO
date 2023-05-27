package Curs1;

class B extends A {
    int dată_membră_non_statică = 2;
    static int dată_membră_statică = 2000;
    void metoda1() {
        System.out.println("Metoda non-statică 1 din clasa B!");
    }
    static void metoda2() {
        System.out.println("Metoda statică 2 din clasa B!");
    }
}