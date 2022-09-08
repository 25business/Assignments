public class Product {
    String naziv;
    int bar_kod;
    double osnovna_cena;
    double porez;

    private static final double uvecanjePoreza = 1.2;

    public Product(String naziv, int bar_kod, double osnovna_cena, double in_porez) {
        this.naziv = naziv;
        this.bar_kod = bar_kod;
        this.osnovna_cena = osnovna_cena;
        this.porez = in_porez;
    }

    public double cenaSaPorezom() {
        return osnovna_cena * uvecanjePoreza;
    }

    public String getNaziv() { return naziv; }
    public void setNaziv(String naziv) { this.naziv = naziv; }

    public int getBar_kod() { return bar_kod; }
    public void setBar_kod(int bar_kod) { this.bar_kod = bar_kod; }

    public double getOsnovna_cena() { return osnovna_cena; }
    public void setOsnovna_cena(double osnovna_cena) { this.osnovna_cena = osnovna_cena; }

    public double getPorez() { return porez; }
    public void setPorez(double porez) { this.porez = porez; }

    public String toString() {
        return String.format("""
                        Naziv: %s
                        Bar Kod: %d
                        Osnovna cena: %.2f
                        Porez: %.2f 
                        """, naziv, bar_kod, osnovna_cena, cenaSaPorezom());
    }
}