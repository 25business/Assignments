public class Program {
    public static void main(String[] args) {

        Product product = new Product("Brašno DANUBIUS meko T-400 1kg", 860130004, 73.99, 20);
        Wine wine = new Wine("Belo vino RUBIN Chardonnay 0,75l", 860007413, 489.99, 30, 0.75);
        Chocolate chocolate = new Chocolate("Čokolada MILKA Oreo sendvich 92g", 762221083, 139.99, 20, 92);

        System.out.printf("""
                Naziv: %s
                Bar-kod: %d
                Cena (Osnovna): %.2f
                Porez: %.0f %%
                Cena sa porezom: %.2f
                \n""", product.naziv, product.bar_kod, product.osnovna_cena, product.porez, product.cenaSaPorezom());

        System.out.printf("""
                Naziv: %s
                Bar-kod: %d
                Cena (Osnovna): %.2f
                Porez: %.0f %%
                Cena sa Porezom: %.2f
                Zapremina Boce: %.2f l
                \n""", wine.naziv, wine.bar_kod, wine.osnovna_cena, wine.porez, wine.cenaSaPorezom(), wine.zapremina_boce);
        System.out.printf("""
                Naziv: %s
                Bar-kod: %d
                Cena (Osnovna): %.2f
                Porez: %.0f %%
                Cena sa porezom: %.2f
                Tezina: %.0f g
                """, chocolate.naziv, chocolate.bar_kod, chocolate.osnovna_cena, chocolate.porez, chocolate.cenaSaPorezom(), chocolate.tezina);

    }
}
