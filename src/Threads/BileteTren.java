package Threads;
class Counter
{
    private long count;
    Counter() { count = 0; }
    public long getCount() { return count; }
    public void add() { count++; }
}
//    De asemenea, vom considera o clasă CounterThread care
//        incrementează de 10000 de ori un contor de tipul Counter,
//        utilizând un fir de executare dedicat:
class CounterThread extends Thread
{
    private Counter counter = null;
    public CounterThread(Counter counter)
    {
        this.counter = counter;
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
            counter.add();
    }
}

//    În continuare, vom considera o clasă CounterThread care incrementează
//de 10000 de ori un contor de tipul Counter, utilizând un fir de executare dedicat
class CounterThread2 extends Thread
{
    private Counter counter = null;
    public CounterThread2(Counter counter)
    {
        this.counter = counter;
    }
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
            counter.add();
    }
}
//Observați faptul că am apelat metoda join() pentru ambele fire de executare,
// astfel încât în firul principal al aplicației valoarea contorului să fie afișată
// doar după ce sunt încheiate executările ambelor fire! Rulând programul de mai multe
// ori, se va afișa, de obicei, o valoare strict mai mică decât valoarea 20000 pe
// care o anticipam. Acest lucru se întâmplă deoarece, în mai multe momente de timp,
// ambele fire vor încerca să incrementeze contorul comun (evident, fără a reuși),
// ceea ce va conduce la o valoare finală eronată a contorului.
// Pentru a rezolva această problemă, trebuie să realizăm incrementarea contorului
// (în metoda add() din clasa Counter) sub excludere reciprocă, respectiv în momentul
// în care un fir de executare incrementează contorul, celălalt fir să fie suspendat
// și abia după ce primul fir termină operația de incrementare a contorului să se reia
// executarea celui de-al doilea fir.
public class BileteTren {
    public static void main(String[] args) throws InterruptedException
    {
        Counter counter = new Counter();
        Thread thread_1 = new CounterThread(counter);
        Thread thread_2 = new CounterThread(counter);
        thread_1.start();
        thread_2.start();
        thread_1.join();
        thread_2.join();
        System.out.println("Counter: " + counter.getCount());
    }
}

//    Pentru asigurarea excluderii reciproce, putem să utilizăm cuvântul cheie synchronized în două moduri:
//        • la nivel de metodă, adăugând cuvântul cheie synchronized în antetul metodei add():

/**
 synchronized public void add()
        {
       count++;
        }
*/
//        • la nivel de bloc de instrucțiuni, adăugând cuvântul cheie synchronized doar pentru secțiunea critică:

/**
 * public void add()

    synchronized(this)
    {
        count++;
    }
 */