package task3;

class Tranzactie {
    private Client client;
    private double suma;
    private String metodaPlata;

    public Tranzactie(Client client, double suma, String metodaPlata) {
        this.client = client;
        this.suma = suma;
        this.metodaPlata = metodaPlata;
    }

    public void executaTranzactie() {
        if (client.efectuarePlata(suma)) {
            System.out.println("Tranzactie realizata cu succes pentru " + client.getNume() +
                    ".Metoda de plata: " + metodaPlata + ".");
        } else {
            System.out.println("Eroare: Fonduri insuficiente pentru " + client.getNume() +
                    ".Metoda de plata: " + metodaPlata + ".");
        }
    }
}
