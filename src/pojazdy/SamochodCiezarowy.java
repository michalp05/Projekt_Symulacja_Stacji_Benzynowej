package pojazdy;

/**
 * Klasa reprezentująca samochód ciężarowy.
 */
public class SamochodCiezarowy extends Pojazd {
    /**
     * Tworzy samochód ciężarowy.
     * @param nrRejestracyjny numer rejestracyjny
     */
    public SamochodCiezarowy(String nrRejestracyjny) {
        super(nrRejestracyjny, 400, 400 * (0.1 + Math.random() * 0.4));
    }

    /**
     * Zwraca typ paliwa samochodu ciężarowego.
     * @return typ paliwa ("Diesel")
     */
    @Override
    public String getTypPaliwa() {
        return "Diesel";
    }
}