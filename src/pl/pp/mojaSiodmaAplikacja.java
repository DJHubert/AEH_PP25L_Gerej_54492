package pl.pp;

public class mojaSiodmaAplikacja {

    public static void main(String[] args) {
        Person person1 = new Person();
        person1.setName("Mateusz");
        person1.setSurname("Karmazyn");
        person1.setAddress("Kraków");
        person1.setBirthYear(2000);
        person1.growOld(24);
        person1.hiToAll();

        Person person2 = new Person("Anna", "Nowak", 30);
        person2.setAddress("Warszawa");
        person2.setBirthYear(1995);
        person2.hiToAll();

        person1.growOld(10);
        person2.growOld(5);

        person1.beYounger();
        person2.beYounger();

        person1.hiToAll();
        person2.hiToAll();
    }
}

class Person {
    private String forename;
    private String surname;
    private int age;
    private String address;
    private int birthYear;

    public Person() {
    }

    public Person(String initForename, String initSurname, int initAge) {
        forename = initForename;
        surname = initSurname;
        age = initAge;
    }

    public void setName(String nameToSet) {
        forename = nameToSet;
    }

    public void setSurname(String surnameToSet) {
        surname = surnameToSet;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int growOld(int years) {
        age += years;
        return age;
    }

    public int beYounger() {
        age -= 1;
        return age;
    }

    public void hiToAll() {
        System.out.println("Nazywam się " + forename + " " + surname +
                ". Mam " + age + " lat. Mieszkam w: " + address +
                ", urodziłem/am się w roku: " + birthYear);
    }

    public String getName() {
        return forename;
    }
}



