package modelExamen2023;

class clasa1{
    public final void metoda(int x){}
    public final void metoda(char x){}

}
class clasa2 extends clasa1 {
//    public final void metoda(int a ){} eroare
}



class Fir implements Runnable{
    int x;
    public Fir(int x){
        this.x = x;
    }
    public void run(){
        for (int i = 0; i < 10; i++) System.out.print(x);
    }
//    public static void main(String args[]) throws InterruptedException{ Fir obj1 = new Fir(1);
//        Fir obj2 = new Fir(2);
//        Thread t1 = new Thread(obj1);
//        Thread t2 = new Thread(obj2);
//        t1.start();
//        t2.start();
//        t2.join();
//        System.out.print(3);
//    }
}

////Subiecte examen 2019
//grila3
class AAA{
    public void metoda(int x){System.out.println(x);}

}
class BBB extends  AAA{
    public void metoda(String a){System.out.println("aaaaa");}
}
///grila 5


class   Model1Grile {
    static String sir = "A";

    void AAAA() {
        try {

            sir = sir + "B";
            BBBB();
        } catch (
                Exception e) {
            sir = sir + "C";
        }
    }

    void BBBB() throws Exception {
        try {
            sir= sir +"D";
            CCCC();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            sir = sir + "E";
        }
    }

    void CCCC() throws Exception {
        throw new Exception();
    }

    public static void main(String[] args) {
        Model1Grile ob = new Model1Grile();
        ob.AAAA();
        System.out.println(sir); ///ABDEC
    }
}
//public class Model1Grile
//{
//    public static void main(String[] args) {

        ///grila 4
//        String s = "Ionel are mere si pereeee!!!"; String c = "e";
//
//        int x = s.length() - s.replace(c, "").length();
//        System.out.println(x);

//        AAA aaa=new BBB();
//        aaa.metoda('a');
//
//    }
//}
