package pl.pp;

public class mojaOsmaAplikacja {
    public static void main(String[] args) {
        Person person1 = new Person("Test", "Testowy", 25);
        person1.hiToAll();
        person1.growOld(10);
        person1.hiToAll();
        person1.setForename("ZmienionyTest");
        person1.hiToAll();
        String personName = person1.getForename();
        int personAge = person1.getAge();
        System.out.println("Pobrane imię to " + personName + " z wiekiem = " + personAge);

        Circle circle1 = new Circle(1.2);
        circle1.getInfo();
        circle1.setRadius(2.6);
        circle1.getInfo();

        Konto mojeKonto = new Konto("1234567890", 1000.0, "Jan Kowalski", "jan.kowalski@email.com", "123456789");
        mojeKonto.wyplata(900.0);
        mojeKonto.wplata(250.0);
        mojeKonto.wyplata(50.0);
    }
}

class Person {
    private String forename;
    private String surname;
    private int age;

    public Person() {}

    public Person(String forename, String surname, int age) {
        this.forename = forename;
        this.surname = surname;
        this.age = age;
    }

    public void hiToAll(){
        System.out.println("Nazywam się " + forename + " " + surname + ". Mam " + age + " lat.");
    }

    public int growOld(int age){
        this.age += age;
        return age;
    }

    public String getForename(){
        return forename;
    }

    public void setForename(String forename){
        this.forename = forename;
    }

    public String getSurname(){
        return surname;
    }

    public void setSurname(String surname){
        this.surname = surname;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }
}

class Circle {
    private double radius;

    public Circle() {}

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double circumference() {
        return 2 * Math.PI * radius;
    }

    public void getInfo() {
        System.out.println("Circle with radius = " + radius + ", area = " + area() + " and circumference = " + circumference());
    }
}

class Konto {
    private String numerKonta;
    private double saldo;
    private String wlasciciel;
    private String email;
    private String telefon;

    public Konto() {}

    public Konto(String numerKonta, double saldo, String wlasciciel, String email, String telefon) {
        this.numerKonta = numerKonta;
        this.saldo = saldo;
        this.wlasciciel = wlasciciel;
        this.email = email;
        this.telefon = telefon;
    }

    public String getNumerKonta() {
        return numerKonta;
    }

    public double getSaldo() {
        return saldo;
    }

    public String getWlasciciel() {
        return wlasciciel;
    }

    public String getEmail() {
        return email;
    }

    public String getTelefon() {
        return telefon;
    }

    public void setNumerKonta(String numerKonta) {
        this.numerKonta = numerKonta;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public void setWlasciciel(String wlasciciel) {
        this.wlasciciel = wlasciciel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTelefon(String telefon) {
        this.telefon = telefon;
    }

    public void wplata(double kwota) {
        if (kwota > 0) {
            saldo += kwota;
            System.out.println("Wpłata PLN " + kwota + " została wykonana. Nowe saldo PLN " + saldo);
        } else {
            System.out.println("Kwota musi być większa niż 0.");
        }
    }

    public void wyplata(double kwota) {
        if (kwota > 0 && kwota <= saldo) {
            saldo -= kwota;
            System.out.println("Pobrano PLN " + kwota + " z konta. Pozostałe saldo = PLN " + saldo);
        } else if (kwota > saldo) {
            System.out.println("Brak wystarczających środków. Dostępne saldo = PLN " + saldo);
        } else {
            System.out.println("Kwota musi być większa niż 0.");
        }
    }
}
