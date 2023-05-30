package ExamenIunie2022;

/**

 Se consideră definită complet o clasă Firmă care permite memorarea următoarelor informații
 despre o firmă: denumire (şir de caractere), anul înființării (număr natural) şi profitul
 mediu anual (număr real). Definiți complet o clasă singleton denumită Locomotiva care să
 permită memorarea următoarelor informații despre o locomotivă: firma producătoare (de tip Firmă),
 anul fabricației (număr natural) şi numărul de kilometri parcurşi (număr real).

 */
class Firma {
    private String denumire;
    private int anulInfiintarii;
    private double profitMediuAnual;

    public Firma(String denumire, int anulInfiintarii, double profitMediuAnual) {
        this.denumire = denumire;
        this.anulInfiintarii = anulInfiintarii;
        this.profitMediuAnual = profitMediuAnual;
    }

    public String getDenumire() {
        return denumire;
    }

    public void setDenumire(String denumire) {
        this.denumire = denumire;
    }

    public int getAnulInfiintarii() {
        return anulInfiintarii;
    }

    public void setAnulInfiintarii(int anulInfiintarii) {
        this.anulInfiintarii = anulInfiintarii;
    }

    public double getProfitMediuAnual() {
        return profitMediuAnual;
    }

    public void setProfitMediuAnual(double profitMediuAnual) {
        this.profitMediuAnual = profitMediuAnual;
    }

    @Override
    public String toString() {
        return "Firmă{" +
                "denumire='" + denumire + '\'' +
                ", anulInfiintarii=" + anulInfiintarii +
                ", profitMediuAnual=" + profitMediuAnual +
                '}';
    }
}




class Locomotiva
{
    private static Locomotiva locomotiva ;
    private Firma firmaProducatoare;
    private int anFabricatie;
    private double nrKilometri;
    private Locomotiva(){}

    public void setLocomotiva(Locomotiva locomotiva) {
        this.locomotiva = locomotiva;
    }

    public Firma getFirmaProducatoare() {
        return firmaProducatoare;
    }

    public void setFirmaProducatoare(Firma firmaProducatoare) {
        this.firmaProducatoare = firmaProducatoare;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public double getNrKilometri() {
        return nrKilometri;
    }

    public void setNrKilometri(double nrKilometri) {
        this.nrKilometri = nrKilometri;
    }

    public Locomotiva getLocomotiva()
    {
        if(locomotiva==null)
        {
            locomotiva=new Locomotiva();
        }
        return locomotiva;
    }

}
public class Ex4Iunie2022
{
    public static void main(String[] args) {

    }

}
