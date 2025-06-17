package pojazdy;

/**
 * Klasa abstrakcyjna reprezentująca pojazd.
 */
public abstract class Pojazd {
    protected String nrRejestracyjny;
    protected double iloscPaliwa;
    protected double pojemnoscZbiornika;

    /**
     * Tworzy pojazd.
     * @param nrRejestracyjny numer rejestracyjny
     * @param pojemnoscZbiornika pojemność zbiornika paliwa
     * @param iloscPaliwa ilość paliwa w zbiorniku
     */
    public Pojazd(String nrRejestracyjny, double pojemnoscZbiornika, double iloscPaliwa) {
        this.nrRejestracyjny = nrRejestracyjny;
        this.pojemnoscZbiornika = pojemnoscZbiornika;
        this.iloscPaliwa = iloscPaliwa;
    }

    /**
     * Zwraca typ paliwa pojazdu.
     * @return typ paliwa
     */
    public abstract String getTypPaliwa();

    /**
     * Tankuje pojazd do pełna.
     * @return ilość zatankowanego paliwa
     */
    public double tankuj() {
        double doZatankowania = pojemnoscZbiornika - iloscPaliwa;
        return doZatankowania;
    }

    /**
     * Zwraca numer rejestracyjny pojazdu.
     * @return numer rejestracyjny
     */
    public String getNrRejestracyjny() {
        return nrRejestracyjny;
    }
}
