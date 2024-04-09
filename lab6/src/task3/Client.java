package task3;

public class Client {
    private String nume;
    private double fonduri;
    private String metodaPreferata;

    public Client(String nume, double fonduri, String metodaPreferata) {
        this.nume = nume;
        this.fonduri = fonduri;
        this.metodaPreferata = metodaPreferata;
    }

    public boolean efectuarePlata(double suma) {
        if (fonduri >= suma) {
            fonduri -= suma;
            return true;
        } else {
            return false;
        }
    }
    public String getNume() {
        return nume;
    }
    public String getMetodaPreferata() {
        return metodaPreferata;
    }
}
