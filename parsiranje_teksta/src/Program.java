public class Program {
    public static void main(String[] args) {

        String text = "John.Davidson/Belgrade.Michael.Barton/Krakow.Ivan.Perkinson/Moscow";
        Person[] ljudi = new Person[3];
        int ljudiCounter = 0;
        String[] textData = text.split("[./]");
        for (int i = 0; i < textData.length; i+= 3) {
            Person person = new Person(textData[i], textData[i+1], textData[i+2]);
            ljudi[ljudiCounter] = person;
            ljudiCounter++;
        }
        for (Person person : ljudi) {
            System.out.println(person.getInfo());
        }
    }
}