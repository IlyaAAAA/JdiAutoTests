package entities;

public class Person {
    public final String name;
    public final String surname;
    public final String city;
    public final String url;

    public Person(String name, String surname, String city, String url) {
        this.name = name;
        this.surname = surname;
        this.city = city;
        this.url = url;
    }
}
