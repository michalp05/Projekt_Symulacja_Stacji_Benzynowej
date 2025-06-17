package pojazdy;

import java.util.List;

/**
 * Klasa reprezentująca samochód osobowy.
 */
public class SamochodOsobowy extends Pojazd {
    private String typPaliwa;

    private static final List<String> DOZWOLONE_PALIWA = List.of("Benzyna", "Diesel", "LPG");

    /**
     * Tworzy samochód osobowy.
     *
     * @param nrRejestracyjny numer rejestracyjny
     * @param typPaliwa typ paliwa
     */
    public SamochodOsobowy(String nrRejestracyjny, String typPaliwa) {
        super(nrRejestracyjny, 50, 50 * (0.1 + Math.random() * 0.4));

        if (!DOZWOLONE_PALIWA.contains(typPaliwa)) {
            throw new IllegalArgumentException("Nieprawidłowy typ paliwa dla samochodu osobowego.");
        }

        this.typPaliwa = typPaliwa;
    }

    /**
     * Zwraca typ paliwa samochodu osobowego.
     *
     * @return typ paliwa
     */
    @Override
    public String getTypPaliwa() {
        return this.typPaliwa;
    }
}