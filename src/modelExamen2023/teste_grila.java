package modelExamen2023;

import java.util.Arrays;

interface interfata{
        static int x=0;
        public void met();
    }
    abstract class implementaere implements interfata{
        static int x=1;
        @Override
        abstract public void met();
    }



    abstract class C { public static  int a=1;
        abstract void met();
    }
//    class D extends C{public static  int a =100;}
    public class teste_grila {
//        public static void main(String[] args) {
////            C ob1 = new C();
////            C ob2 = new C();
////            ob1.a++;
////            System.out.println(++ob2.a);
//            C c=new D();
//            System.out.println(c.a);
//
//
//
//            String  s="aaee";
//            String e ="ee";
//            int x= s.length()-s.replace(e,"").length();
//            System.out.println(s.replace("[a]+","e"));
//
//        }
//static void modificare(int v[],char b) {
//    v[0] = 100;
//    v = new int[10];
//    v[1] = 1000;
//    v[1]=b;
//}
//        public static void main(String[] args) {
//            int v[] = {1, 2, 3, 4, 5};char b='0';
//            modificare(v,b);
//            System.out.println(Arrays.toString(v));
//            System.out.println(b);
//        }
    }

