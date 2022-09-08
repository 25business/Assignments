public class Person {
    String ime;
    String prezime;
    String grad;
    public Person(String ime, String prezime, String grad) {
        this.ime = ime;
        this.prezime = prezime;
        this.grad = grad;
    }
    String getInfo() { return ime + " " + prezime + " " + grad; }
}
