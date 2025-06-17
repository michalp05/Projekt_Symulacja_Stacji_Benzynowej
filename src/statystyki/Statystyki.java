package statystyki;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Klasa przechowująca i obsługująca statystyki stacji benzynowej.
 */
public class Statystyki {
    private static int liczbaKlientow = 0;
    private static double sumaPaliwa = 0;
    private static double przychod = 0;

    /**
     * Dodaje klienta (właściciela pojazdu) do statystyk.
     */
    public static void dodajKlienta() {
        liczbaKlientow++;
    }

    /**
     * Dodaje ilość zatankowanego paliwa.
     * @param litry liczba litrów
     */
    public static void dodajPaliwo(double litry) {
        sumaPaliwa += litry;
    }

    /**
     * Dodaje przychód do statystyk.
     * @param kwota kwota do dodania
     */
    public static void dodajPrzychod(double kwota) {
        przychod += kwota;
    }

    /**
     * Wyświetla statystyki w terminalu.
     */
    public static void wyswietl() {
        System.out.println("===> STATYSTYKI <===");
        System.out.println("Liczba klientów: " + liczbaKlientow);
        System.out.println("Zatankowane paliwo: " + sumaPaliwa + " L");
        System.out.println("Lączny przychód: " + przychod + " PLN");
    }

    /**
     * Zapisuje statystyki do pliku.
     * @param Plik nazwa pliku
     */
    public static void zapiszDoPliku(String Plik) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(Plik))) {
            writer.println("===> STATYSTYKI <===");
            writer.println("Liczba klientów: " + liczbaKlientow);
            writer.println("Zatankowane paliwo: " + sumaPaliwa + " L");
            writer.println("Lączny przychód: " + przychod + " PLN");
            System.out.println("Statystyki zapisano do pliku: " + Plik);
        } catch (IOException e) {
            System.err.println("Błąd zapisu statystyk do pliku: " + e.getMessage());
        }
    }
}