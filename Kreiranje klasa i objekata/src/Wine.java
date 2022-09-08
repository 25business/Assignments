public class Wine extends Product {

    double zapremina_boce;

    public static final double uvecanjePorezaVina = 1.1;

    public Wine(String naziv, int bar_kod, double osnovna_cena, double in_porez, double zapremina_boce) {
        super(naziv, bar_kod, osnovna_cena, in_porez);
        this.zapremina_boce = zapremina_boce;
    }

    public double getZapremina_boce() { return zapremina_boce; }
    public void setZapremina_boce(double values) { zapremina_boce = values; }

    public String toString() {
        return super.toString() +
                String.format("""
                        Zapremina boce: %.2f
                        """, zapremina_boce);
    }
    public double cenaSaPorezom() {
        return super.cenaSaPorezom() * uvecanjePorezaVina;
    }

}
