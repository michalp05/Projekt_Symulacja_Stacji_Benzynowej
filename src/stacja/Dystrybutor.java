package stacja;

import java.util.Random;

/**
 * Klasa reprezentująca dystrybutor paliwa.
 */
public class Dystrybutor {
    private String typPaliwa;
    private double cenaZaLitr;
    private boolean sprawny;

    /**
     * Tworzy nowy dystrybutor.
     * @param typPaliwa typ paliwa
     * @param cenaZaLitr cena za litr paliwa
     */
    public Dystrybutor(String typPaliwa, double cenaZaLitr) {
        this.typPaliwa = typPaliwa;
        this.cenaZaLitr = cenaZaLitr;
        this.sprawny = true;
    }

    /**
     * Sprawdza, czy dystrybutor jest sprawny (losowa awaria).
     * @return true jeśli sprawny, false jeśli niesprawny (awaria)
     */
    public boolean czySprawny() {
        // Zdarzenie losowe polegające na losowej awarii dystrybutora z prawdopodobieństwem 5%
        if (new Random().nextInt(100) < 5) {
            this.sprawny = false;
        }
        return sprawny;
    }

    /**
     * Zwraca cenę za litr paliwa.
     * @return cena za litr
     */
    public double getCenaZaLitr() {
        return cenaZaLitr;
    }

    /**
     * Zwraca typ paliwa.
     * @return typ paliwa
     */
    public String getTypPaliwa() {
        return typPaliwa;
    }
}