package ModelEAP2022;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
II.	Se consideră definită o clasă Automobil având datele membre marca, model, capacitate și pret.
 Clasa încapsulează metode de tip set/get pentru toate datele membre, precum și metodele toString(),
 equals() și hashCode(). Creați o lista  care să conțină cel puțin 3 obiecte de tip Automobil și,
 folosind stream-uri bazate pe lista creată și lambda expresii, rezolvați următoarele cerințe:

    •	afișați automobilele care costă cel puțin 5000€, în ordinea descrescătoare a prețurilor;

    •	afișați mărcile distincte de automobile;

    map
    •	creați o listă formată din automobilele care au capacitatea cilindrică cuprinsă între 2000 și 3000 cm3;
    collect()
    •	afișați pentru fiecare marcă modelele existente. - >groupBY (marca), mappare (modele)
*/

class Automobil {
    private String marca;
    private String model;
    private int capacitate;
    private double pret;

    public Automobil(String marca, String model, int capacitate, double pret) {
        this.marca = marca;
        this.model = model;
        this.capacitate = capacitate;
        this.pret = pret;
    }

    // Setters and getters for the member variables

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getCapacitate() {
        return capacitate;
    }

    public void setCapacitate(int capacitate) {
        this.capacitate = capacitate;
    }

    public double getPret() {
        return pret;
    }

    public void setPret(double pret) {
        this.pret = pret;
    }

    // toString(), equals(), and hashCode() methods

    @Override
    public String toString() {
        return "Automobil{" +
                "marca='" + marca + '\'' +
                ", model='" + model + '\'' +
                ", capacitate=" + capacitate +
                ", pret=" + pret +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Automobil automobil = (Automobil) obj;
        return capacitate == automobil.capacitate &&
                Double.compare(automobil.pret, pret) == 0 &&
                marca.equals(automobil.marca) &&
                model.equals(automobil.model);
    }

    @Override
    public int hashCode() {
        int result = marca.hashCode();
        result = 31 * result + model.hashCode();
        result = 31 * result + capacitate;
        long temp = Double.doubleToLongBits(pret);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}

public class ExIIEAP2022 {
    public static void main(String[] args) {
        List<Automobil> automobiles = new ArrayList<>();
        automobiles.add(new Automobil("Audi", "A3", 2000, 25000.0));
        automobiles.add(new Automobil("BMW", "X5", 2500, 60000.0));
        automobiles.add(new Automobil("Mercedes", "C-Class", 4, 1000.0));



        System.out.println("---Afișați automobilele care costă cel puțin 5000€, în ordinea descrescătoare a prețurilor");
        System.out.println();
        automobiles.stream().filter(a->a.getPret()>=5000).sorted(Comparator.comparing(Automobil::getPret).reversed()).forEach(System.out::println);
        System.out.println();


        System.out.println("---afișați mărcile distincte de automobile;");
        System.out.println();
        automobiles.stream().map(Automobil::getMarca).distinct().forEach(System.out::println);
        System.out.println();

        System.out.println("---creați o listă formată din automobilele care au capacitatea cilindrică cuprinsă între 2000 și 3000 cm3;");
        System.out.println();
        List<Automobil> lista= automobiles.stream().filter(a->a.getCapacitate()>=2000 && a.getCapacitate()<=3000).collect(Collectors.toList());
        lista.forEach(System.out::println);
        System.out.println();

        System.out.println("---afișați pentru fiecare marcă modelele existente");
        System.out.println();
        automobiles.stream().collect(Collectors.groupingBy(Automobil::getMarca))
                .forEach((marca,marcaList)->{
                System.out.println("Marca:"+marca);
                marcaList.stream().map(Automobil::getModel).forEach(System.out::println);
                System.out.println();
                });

        System.out.println();


    }
}