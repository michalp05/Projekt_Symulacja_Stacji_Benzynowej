package stacja;

import pojazdy.Pojazd;
import statystyki.Statystyki;

/**
 * Klasa reprezentująca stanowisko tankowania na stacji benzynowej.
 */
public class Stanowisko {
    private Dystrybutor dystrybutor;

    /**
     * Tworzy stanowisko z przypisanym dystrybutorem.
     * @param dystrybutor dystrybutor paliwa
     */
    public Stanowisko(Dystrybutor dystrybutor) {
        this.dystrybutor = dystrybutor;
    }

    /**
     * Obsługuje pojazd na stanowisku.
     * @param pojazd pojazd do obsłużenia
     * @return true- jeśli pojazd został obsłużony, false- jeśli nie został obsłużony
     */
    public boolean obsluzPojazd(Pojazd pojazd) {
        if (!dystrybutor.czySprawny()) {
            System.out.println("Dystrybutor " + dystrybutor.getTypPaliwa() + " jest niesprawny!");
            return false;
        }

        if (!dystrybutor.getTypPaliwa().equals(pojazd.getTypPaliwa())) {
            System.out.println("Nieprawidłowy typ paliwa dla pojazdu " + pojazd.getNrRejestracyjny());
            return false;
        }

        double zatankowane = pojazd.tankuj();
        double koszt = zatankowane * dystrybutor.getCenaZaLitr();

        System.out.println("Pojazd " + pojazd.getNrRejestracyjny() + " zatankował " + zatankowane + "L za " + koszt + " PLN.");

        Statystyki.dodajPaliwo(zatankowane);
        Statystyki.dodajPrzychod(koszt);
        Statystyki.dodajKlienta();

        return true;
    }
}