package stacja;

import pojazdy.*;
        import java.util.*;

/**
 * Klasa reprezentująca stację benzynową.
 * Zarządza kolejką pojazdów i stanowiskami tankowania.
 */
public class StacjaBenzynowa {
    private Queue<Pojazd> kolejka = new LinkedList<>();
    private List<Stanowisko> stanowiska = new ArrayList<>();

    /**
     * Dodaje pojazd do kolejki.
     * @param pojazd pojazd do dodania
     */
    public void dodajPojazd(Pojazd pojazd) {
        kolejka.offer(pojazd);
    }

    /**
     * Dodaje stanowisko do stacji.
     * @param stanowisko stanowisko do dodania
     */
    public void dodajStanowisko(Stanowisko stanowisko) {
        stanowiska.add(stanowisko);
    }

    /**
     * Rozpoczyna obsługę wszystkich pojazdów w kolejce.
     */
    public void rozpocznijObsluge() {
        while (!kolejka.isEmpty()) {
            Pojazd pojazd = kolejka.poll();
            boolean obsluzony = false;

            for (Stanowisko s : stanowiska) {
                if (s.obsluzPojazd(pojazd)) {
                    obsluzony = true;
                    break;
                }
            }

            if (!obsluzony) {
                System.out.println("Pojazd " + pojazd.getNrRejestracyjny() + " nie został obsłużony.");
            }
        }
    }
}