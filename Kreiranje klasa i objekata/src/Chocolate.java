public class Chocolate extends Product {

    double tezina;

    public Chocolate(String naziv, int bar_kod, double osnovna_cena, double in_porez, double tezina) {
        super(naziv, bar_kod, osnovna_cena, in_porez);
        this.tezina = tezina;
    }

    public double getTezina() { return tezina; }
    public void setTezina(double values) { tezina = values; }

    public String toString() {
        return super.toString() +
                String.format("""
                        Tezina: %f
                        """, tezina);
    }
}
