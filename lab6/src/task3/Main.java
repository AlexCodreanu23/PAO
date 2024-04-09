package task3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Client> clienti = new ArrayList<>();
        clienti.add(new Client("Client 1", 100, "cash"));
        clienti.add(new Client("Client 2", 200, "transfer bancar"));
        clienti.add(new Client("Client 3", 150, "card"));
        clienti.add(new Client("Client 4", 250, "cash"));

        List<Tranzactie> tranzactii = new ArrayList<>();
        for (Client client : clienti) {
            String metodaPlata = (client.getMetodaPreferata() != null) ? client.getMetodaPreferata() : getRandomMetodaPlata();
            double suma = 50 + Math.random() * 150;
            Tranzactie tranzactie = new Tranzactie(client, suma, metodaPlata);
            tranzactii.add(tranzactie);
            tranzactie.executaTranzactie();
        }
    }
    private static String getRandomMetodaPlata() {
        String[] metodePlata = {"cash", "transfer bancar", "card"};
        int index = (int) (Math.random() * metodePlata.length);
        return metodePlata[index];
    }
}
