package ExamenIunie2022;
import java.util.*;
import java.util.stream.Collectors;

class Concert {
    private String denumire;
    private String localitate;
    private double pretBilet;
    private int numarLocuri;

    public Concert(String denumire, String localitate, double pretBilet, int numarLocuri) {
        this.denumire = denumire;
        this.localitate = localitate;
        this.pretBilet = pretBilet;
        this.numarLocuri = numarLocuri;
    }

    // Setters and getters

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public String getLocalitate() {
        return localitate;
    }

    public void setLocalitate(String localitate) {
        this.localitate = localitate;
    }

    public double getPretBilet() {
        return pretBilet;
    }

    public void setPretBilet(double pretBilet) {
        this.pretBilet = pretBilet;
    }

    public int getNumarLocuri() {
        return numarLocuri;
    }

    public void setNumarLocuri(int numarLocuri) {
        this.numarLocuri = numarLocuri;
    }

    // Override toString(), equals(), and hashCode() methods

    @Override
    public String toString() {
        return "Concert{" +
                "denumire='" + denumire + '\'' +
                ", localitate='" + localitate + '\'' +
                ", pretBilet=" + pretBilet +
                ", numarLocuri=" + numarLocuri +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Concert concert = (Concert) o;

        if (Double.compare(concert.pretBilet, pretBilet) != 0) return false;
        if (numarLocuri != concert.numarLocuri) return false;
        if (!denumire.equals(concert.denumire)) return false;
        return localitate.equals(concert.localitate);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = denumire.hashCode();
        result = 31 * result + localitate.hashCode();
        temp = Double.doubleToLongBits(pretBilet);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + numarLocuri;
        return result;
    }
}

/**
II.
Se consideră definită o clasă Concert având datele membre denumire, localitate, pretBilet şi numarLocuri. Clasa este utilizată pentru a memora informații despre concertele organizate de compania MusicForStudents în anul 2022. Datele membre denumire şi localitate sunt de tip String, numarLocuri este de tip int şi pretBilet este de tip double. Clasa încapsulează constructori, metode de tip set/get pentru toate datele membre, precum şi metodele toString(), equals () şi hashCode().
Creaţi o listă care să conţină cel puţin 3 obiecte de tip Concert şi, folosind stream-uri bazate pe lista creată şi lambda expresii, rezolvați următoarele cerințe:

afişați lista concertelor din localitatea Bucureşti, în ordinea descrescătoare a prețurilor biletelor;

afişați în ordine alfabetică localităţile distincte în care se vor desfăşura concerte;

 creați o colecţie care să conţină concertele pentru care numărul de locuri este mai mare decât 500;

 afişați, pentru fiecare localitate, lista concertelor care se vor desfăşura în acest an.
*/
public class Ex2Model2022 {
    public static void main(String[] args) {


        List<Concert> concerts = new ArrayList<>();
        concerts.add(new Concert("Concert1", "Bucuresti", 50.0, 1000));
        concerts.add(new Concert("Concert2", "Timisoara", 80.0, 700));
        concerts.add(new Concert("Concert3", "Cluj-Napoca", 70.0, 1200));
        concerts.add(new Concert("Concert4", "Iasi", 60.0, 900));
        concerts.add(new Concert("Concert5", "Bucuresti", 90.0, 1500));
        concerts.add(new Concert("Concert6", "Constanta", 65.0, 800));

        System.out.println("Afişați lista concertelor din localitatea Bucureşti,\n" +
                " în ordinea descrescătoare a prețurilor biletelor;");

        concerts.stream().filter(c -> c.getLocalitate().equals("Bucuresti")).sorted(Comparator.comparing(Concert::getPretBilet).reversed()).forEach(System.out::println);

        System.out.println();
        System.out.println("afişați în ordine alfabetică localităţile distincte în care se vor desfăşura concerte");

        concerts.stream().map(Concert::getLocalitate).distinct().sorted().forEach(System.out::println);


        System.out.println();
        System.out.println("creați o colecţie care să conţină concertele pentru \n" +
                " care numărul de locuri este mai mare decât 500;");

        List<Concert> colectie = concerts.stream().filter(a -> a.getNumarLocuri() > 500).collect(Collectors.toList());
        colectie.stream().forEach(System.out::println);

        System.out.println();
        System.out.println(" afişați, pentru fiecare localitate, lista concertelor care se vor desfăşura în acest an.");


        concerts.stream().collect(Collectors.groupingBy(Concert::getLocalitate))
                .forEach((localitate, concertList) ->
                {
                    System.out.println("Localitate: " + localitate);
                    concertList.forEach(System.out::println);
                    System.out.println();
                });



//alte funtii din Collectors
        Optional<Concert> minTicketPriceConcert = concerts.stream().filter(x->x.getLocalitate().equals("a"))
                .collect(Collectors.minBy(Comparator.comparingDouble(Concert::getPretBilet)));
        System.out.println("Concert with the minimum ticket price: " + minTicketPriceConcert.orElse(null));



        DoubleSummaryStatistics statistics = concerts.stream()
                .collect(Collectors.summarizingDouble(Concert::getPretBilet));
        System.out.println("Ticket price statistics: " + statistics);


        ///Comparator
        Comparator<Concert> customComparator = Comparator.comparing((Concert concert) -> {
            // Custom logic to determine the comparison value
            if (concert.getNumarLocuri() > 500) {
                return -1; // concert has more seats, so it comes before
            } else if (concert.getNumarLocuri() < 500) {
                return 1; // concert has fewer seats, so it comes after
            } else {
                // concert has the same number of seats, compare based on ticket price
                return Double.compare(concert.getPretBilet(), 500.0); // 500.0 is the reference ticket price
            }
        });

    }
}
