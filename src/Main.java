import pojazdy.*;
import stacja.*;
import statystyki.Statystyki;
import java.util.Random;

/**
 * Główna klasa uruchamiająca symulację stacji benzynowej.
 * Tworzy stację, pojazdy oraz uruchamia obsługę i zapisuje statystyki.
 */
public class Main {
    /**
     * Metoda główna programu.
     * @param args argumenty wiersza poleceń
     */
    public static void main(String[] args) {
        StacjaBenzynowa stacja = new StacjaBenzynowa();

        // Dodajemy 3 rodzaje dystrybutorów, każdy odpowiada jednemu rodzajowi paliwa
        stacja.dodajStanowisko(new Stanowisko(new Dystrybutor("Benzyna", 5.86)));
        stacja.dodajStanowisko(new Stanowisko(new Dystrybutor("Diesel", 5.98)));
        stacja.dodajStanowisko(new Stanowisko(new Dystrybutor("LPG", 3.02)));

        String[] OznaczeniaRegionu = {"DKL", "PO", "DX", "KR", "WY"};
        String[] TypyPaliwa = {"Benzyna", "Diesel", "LPG"};
        Random random = new Random();

        //Losowa liczba pojazdów: od 5 do 10
        int liczbaPojazdow = random.nextInt(6) + 5;

        for (int i = 0; i < liczbaPojazdow; i++) {
            String rejestracja = OznaczeniaRegionu[random.nextInt(OznaczeniaRegionu.length)] + String.format("%05d", random.nextInt(100000));
            int typ = random.nextInt(3);
            //Pojazdy oznaczamy jako liczby w celu losowania typu pojazdu

            Pojazd pojazd;

            switch (typ) {
                case 0 -> {
                    String paliwo = TypyPaliwa[random.nextInt(TypyPaliwa.length)];
                    pojazd = new SamochodOsobowy(rejestracja, paliwo);
                }
                case 1 -> pojazd = new SamochodCiezarowy(rejestracja);
                default -> pojazd = new Motocykl(rejestracja);
            }

            System.out.println("Dodano: " + pojazd.getClass().getSimpleName() +
                    " | Rejestracja: " + pojazd.getNrRejestracyjny() +
                    " | Paliwo: " + pojazd.getTypPaliwa());

            stacja.dodajPojazd(pojazd);
        }

        System.out.println("===> Start symulacji <===");
        stacja.rozpocznijObsluge();

        Statystyki.wyswietl();
        Statystyki.zapiszDoPliku("Statystyki_projekt.txt");
    }
}
