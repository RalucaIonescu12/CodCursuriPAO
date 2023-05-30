package Model2019;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

class DiplomaLicenta {
    private String serie;
    private String absolvent;
    private int an;
    private String facultate;
    private String specializare;
    private double medie;

    public DiplomaLicenta(String serie, String absolvent, int an, String facultate, String specializare, double medie) {
        this.serie = serie;
        this.absolvent = absolvent;
        this.an = an;
        this.facultate = facultate;
        this.specializare = specializare;
        this.medie = medie;
    }

    // Metode de tip set/get pentru toate datele membre

    public String getSerie() {
        return serie;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }

    public String getAbsolvent() {
        return absolvent;
    }

    public void setAbsolvent(String absolvent) {
        this.absolvent = absolvent;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public String getFacultate() {
        return facultate;
    }

    public void setFacultate(String facultate) {
        this.facultate = facultate;
    }

    public String getSpecializare() {
        return specializare;
    }

    public void setSpecializare(String specializare) {
        this.specializare = specializare;
    }

    public double getMedie() {
        return medie;
    }

    public void setMedie(double medie) {
        this.medie = medie;
    }

    // Metodele toString(), equals() şi hashCode()

    @Override
    public String toString() {
        return "DiplomaLicenta{" +
                "serie='" + serie + '\'' +
                ", absolvent='" + absolvent + '\'' +
                ", an=" + an +
                ", facultate='" + facultate + '\'' +
                ", specializare='" + specializare + '\'' +
                ", medie=" + medie +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiplomaLicenta that = (DiplomaLicenta) o;
        return an == that.an &&
                Double.compare(that.medie, medie) == 0 &&
                Objects.equals(serie, that.serie) &&
                Objects.equals(absolvent, that.absolvent) &&
                Objects.equals(facultate, that.facultate) &&
                Objects.equals(specializare, that.specializare);
    }

    @Override
    public int hashCode() {
        return Objects.hash(serie, absolvent, an, facultate, specializare, medie);
    }
}

/**
 * Considerăm definită clasa DiplomăLicenţă cu datele membre serie, absolvent, an, facultate,
 * specializare și medie. Clasa încapsulează constructori, metode de tip set/get pentru toate
 * datele membre, precum şi metodele toString(), equals() şi hashCode(). Creați o listă care
 * să conțină cel puțin 3 obiecte de tip DiplomăLicenţă.
 *
 *
 * afişați diplomele eliberate între anii 2000 şi 2010, în ordinea descrescătoare a mediilor;
 *
 * afişați specializările distincte pentru care au fost eliberate diplome în Facultatea de
 * Informatică în anul 2018;
 *
 * creați o listă formată din numele absolvenților care au obținut media 10;
 *
 * afişați numărul diplomelor eliberate pentru specializarea Informatică.
 */


public class ExIII2019 {
    public static void main(String[] args)
    {
        List<DiplomaLicenta> listaDiplome = new ArrayList<>();

        DiplomaLicenta diploma1 = new DiplomaLicenta("A123", "John Doe", 2018, "Facultatea de Informatica", "Informatica", 9.5);
        DiplomaLicenta diploma2 = new DiplomaLicenta("B456", "Jane Smith", 2010, "Facultatea de Matematica", "Matematica", 9.0);
        DiplomaLicenta diploma3 = new DiplomaLicenta("C789", "Alice Johnson", 2008, "Facultatea de Informatica", "Informatica", 8.7);
        DiplomaLicenta diploma4 = new DiplomaLicenta("D123", "Mark Thompson", 2012, "Facultatea de Drept", "Drept", 8.9);
        DiplomaLicenta diploma5 = new DiplomaLicenta("E456", "Emily Johnson", 2015, "Facultatea de Medicina", "Medicina", 9.7);
        DiplomaLicenta diploma6 = new DiplomaLicenta("F789", "Michael Brown", 2018, "Facultatea de Informatica", "Matematica", 10);

        listaDiplome.add(diploma4);
        listaDiplome.add(diploma5);
        listaDiplome.add(diploma6);
        
        listaDiplome.add(diploma1);
        listaDiplome.add(diploma2);
        listaDiplome.add(diploma3);

        System.out.println(" afişați diplomele eliberate între anii 2000 şi 2010, în ordinea descrescătoare a mediilor;");

        listaDiplome.stream().filter(d->d.getAn()>=2000 && d.getAn()<=2010).sorted(Comparator.comparing(DiplomaLicenta::getMedie).reversed()).forEach(System.out::println);
        System.out.println();

        System.out.println("afişați specializările distincte pentru care au fost eliberate diplome în Facultatea de\n" +
                "  Informatică în anul 2018; ");

        listaDiplome.stream().filter(d->d.getFacultate().equals("Facultatea de Informatica") && d.getAn()==2018)
                        .map(DiplomaLicenta::getSpecializare).distinct().forEach(System.out::println);
        System.out.println();


        System.out.println("creați o listă formată din numele absolvenților care au obținut media 10;");

        List<String> lista = listaDiplome.stream().filter(d->d.getMedie()==10).map(DiplomaLicenta::getAbsolvent).collect(Collectors.toList());
        lista.stream().forEach(System.out::println);
        System.out.println();

        System.out.println("Afişați numărul diplomelor eliberate pentru specializarea Informatică.");

        System.out.println((Long) listaDiplome.stream().filter(d -> d.getSpecializare().equals("Informatica")).count());
        System.out.println();

    }
}

