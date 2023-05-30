package modelExamen2023;

class A {
    int x;
    public A() { System.out.println("Constructor A ");
            init(0);
       }
    protected void init(int x) { this.x = x; System.out.println("Init A cu x=" +this.x);}
}
class B extends A {
    public B() { System.out.println("Constructor B ");init (super.x + 1); }
    public void init(int x) { this.x = x + 1;System.out.println("Init B cu x=" +this.x); }

}

///grila2
class Drink {
    public static void make() {
        System.out.println("Making drink");
    }
}
class Tea extends Drink {
    public static void make() {
        System.out.println("Making tea");
    }
}

//grila 3
class BasicInit {
    private int x;
    private boolean flag;
    protected String s;
    protected int[] li;

    private Integer i;
    private Float f;

    @Override
    public String toString() {
        return x + " " + flag + " " + s+ " " + i+ " " + f+ " " + li;
    }
}

///grila 9
class Test {
    //grila 9
//    public static void main(String[] args) {
//        System.out.println(breakingStuff());
//    }
public static int breakingStuff()
{
        try
        {
                try
                {
                     throw new Exception();
                }
                catch (Exception e)
                {
                    System.out.println("exceptia 1");
                     return 1;
                }
                finally
                {
                    System.out.println("finally 1");
                    return 2;
                }
        }
        catch (Exception e)
        {
            System.out.println("exceptia 2");
             return 3;

        }
        finally
        {
            System.out.println("finally 2");
            return 4;
        }
        }
}


///grila 16
class AA {
    private int x = 5;
    private void hidden()
    {
        System.out.println("Hidden AA "+x);
    }
    public void show_hidden() {
        hidden();
    }
}
class BB extends AA {
    public int x = 10;

    public void hidden()
    {
        System.out.println("Hidden BB "+x);
        System.out.println(x);
    }
}
public class Model2Grile {
    public static void main(String[] args) {
        BB b = new BB();
        b.show_hidden();
    }
}

//public class Model2Grile
//{

//    public static void main(String[] args) {
//        A a = new B();
//        System.out.println(a.x);
//    }

    //grila2
//    public static void main(String []args) {
//        Drink tea = new Tea();
//        tea.make();
//    }

    //grila3
//    public static void main(String[] args) {
//        BasicInit basicInit = new BasicInit();
//        System.out.println(basicInit);
//    }

//    //grila12
//    public static void main(String[] args) {
//        String s = 0+1+"ONE"
//                +3+2+"TWO"+"THREE"
//                +5+4+"FOUR"+"FIVE"+5;
//        String c=0+1+2+"!"+2+3+"!";
//        System.out.println(s);
//
//        System.out.println(c);
//    }


//}
