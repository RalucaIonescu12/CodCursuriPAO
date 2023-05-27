package Curs1;

class A {
    int dată_membră_non_statică = 1;
    static int dată_membră_statică = 1000;

    void metoda1() {
        System.out.println("Metoda non-statică 1 din clasa A!");
    }

    static void metoda2() {
        System.out.println("Metoda statică 2 din clasa A!");
    }
}
