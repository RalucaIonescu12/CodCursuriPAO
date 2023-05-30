package ExamenIunie2022;

class A{
    public int x=1;
    public A(){x++;}
    public static void metodaA() { System.out.println("metodaA");}
}
class B extends A{
    public int x=1;
    public B(){x++;}
    public static void metodaA(){System.out.println("metodaB");}

}
class C extends B
{
    public C(){x++;}
}

public class Ex2
{
    public static void main(String[] args) {
        B b=new B();
        C c= new C();
        A ab = new B();
        System.out.println(b.x + " " + c.x);
        b.metodaA();
        c.metodaA();
        ab.metodaA();
    }
}

