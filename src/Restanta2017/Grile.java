package Restanta2017;

import java.io.StringReader;

class C {
    public static void met() throws Exception {
        try
        {
            throw new Exception();
        }
        finally
        {
            System.out.print("M");
        }
    }
}



//grila 4

class F {
    static String x = "";

    public static void met_1() {
        x = x + "A";
    }

    public void met_2() {
        x = x + "B";
    }
}
    class E extends F
    {
        public static void met_1() {
            x = x + "C";
        }

        public void met_2() {
            x = x + "D";
        }
    }



class O {
    public O() {
        System.out.print ("A");
    }

    public void met () {
        System.out.print ("B");
    }
}

class S extends O {
    public S() {
        System.out.print ("C");
    }
    public void met () {
        System.out.print ("D");
    }
}

class X {

    public int a;
    public static int b;

    public X()
    {
        b++;b =b +a;
    }

    public void met() {
        a = a + b;
        a++;
    }
}
public class Grile {
    //    grila 2  MCTF
    public static void main(String[] args) {

        try {
            C.met();
        } catch (Exception e) {
            System.out.print("C");
        } finally {
            System.out.print("F");
        }
        System.out.println("T");

        ////grila3
        String s = "abracadabra";
        s.replace('r', 'R');
        int p = s.indexOf("R");
        int q= s.lastIndexOf("b");
        s = s.substring(0, q- p);
        System.out.println(s);
        System.out.println(s.length());


        ////grila4
        F ob= new E();
        ob.met_1();
        ob.met_2();
        System.out.println(ob.x); //AD




        ///grila 1 septembrie

        X ob1=new X();
        ob1.met();
        X ob2=new X();
        ob2.met();
        System.out.println(ob1.a+ob2.b);


//  grila2
        String s1 = "academician";
        int p1= s1.lastIndexOf("c");
        int q1 = s1.indexOf (s1.charAt (p1));
        s1 = s1.substring (q1, p1);
        System.out.println("grila2: "+s1);

        String sir="0123456781";
        System.out.println(sir.indexOf('1'));


        O ob3 = new S();
        ob3.met();

    }


}




