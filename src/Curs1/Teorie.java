package Curs1;

public class Teorie{

    /**
     * Limbaj compilat  de Java compiler si poate fi compilat
     *      pe orice platforma care are Java Virtual Machine
     *      (=> platform independent language)
     *      JVM interpreteaza bytecodeul si il executa pe host platform
     *      JVM modern=> combinatie intre interpretare si JIT(Just in time compilation)
     *      compilator JIT=> transforma bytecode-ul in cod masina specific
     *      procesorului respectiv
     *
     * -THREAD SAFE!
     *
     * - JRE(Java runtime environment)= Core classes + JVM + Runtime Libraries
     * - JDK(Java Development Kit) = JRE + Development Tools
     */

    /**
     * ->Upcasting corect pt ca se realizeaza implicit
     * Angajat a = new Economist();
     * Angajat b = new Inginer();
     * <p>
     * ->Downcating corect pt ca se face explicit:
     * Inginer p = null;
     * <p>
     * ////se verifică în prealabil dacă se poate efectua downcasting-ul respectiv,
     * if(b instanceof Inginer)
     * p = (Inginer)b;
     * <p>
     * ->autoboxing :
     * boolean->Boolean
     * ->unboxing:
     * Boolean->boolean
     * <p>
     * Integer a = 2 (boxing)
     * int s = 5 + a
     * <p>
     * --din char in int:
     * cu cast: int i=(int)'1';
     * sau: int i = Integer.parseInt("123")
     * sau: int i = Character.getNumericValue('1')
     */
    public static class Animal {
        String nume;

        public Animal() {
            nume = "Animal";

        }
    }

    public static class Dog extends Animal {
        public Dog() {
            nume = "dog";
        }
    }

    public static void main(String[] args) {
        Animal a = new Animal();
        Animal d = new Dog();

        System.out.println(a instanceof Animal);
        System.out.println(a instanceof Dog);
    }
}
