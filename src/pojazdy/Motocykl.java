package pojazdy;

/**
 * Klasa reprezentująca motocykl.
 */
public class Motocykl extends Pojazd {
    /**
     * Tworzy pojazd- motocykl.
     * @param nrRejestracyjny numer rejestracyjny
     */
    public Motocykl(String nrRejestracyjny) {
        super(nrRejestracyjny, 15, 15 * (0.1 + Math.random() * 0.4));
    }

    /**
     * Zwraca typ paliwa motocykla.
     * @return typ paliwa ("Benzyna")
     */
    @Override
    public String getTypPaliwa() {
        return "Benzyna";
    }
}