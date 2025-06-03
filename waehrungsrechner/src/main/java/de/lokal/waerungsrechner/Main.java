package de.lokal.waerungsrechner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Sc = new Scanner(System.in); // erstellt einen Scanner namens Sc

        // definition der festen Wechselkurse
        Double USD_Kurs = 1.14;
        Double BAHT_Kurs = 37.13;

        // "Begrueße den User + zeigt verfügbare Waehrungen"
        System.out.println("Einfacher Währungsrechner");
        System.out.println("Verfügbare Währungen = EUR,BAHT,USD");

        // Fragt User nach Quellwaehrung
        System.out.println("Bitte die Quellwährung eingeben!(EUR,BAHT,USD) ");
        String quellWaehrungInput = Sc.nextLine().toUpperCase(); // ermöglicht das lesen der Eingabe + Groß schreiben

        // Fragt User nach Zielwaehrung
        System.out.println("Bitte die Zielwährung eingeben!(EUR,BAHT,USD)");
        String ZielWaehrungInput = Sc.nextLine().toUpperCase();

        // Fragt User nach Betrag
        System.out.println("Bitte den Betrag in " + quellWaehrungInput + " eingeben!");
        Double BetragInput = Sc.nextDouble();

        // Umrechnungslogik von Waehrung in EUR
        Double EURBetrag = 0.0;
        Double Endbetrag = 0.0;
        boolean eingabegueltig = true;

        if (quellWaehrungInput.equals("EUR")) {
            EURBetrag = BetragInput;
        } else if (quellWaehrungInput.equals("USD")) {
            EURBetrag = BetragInput / USD_Kurs;
        } else if (quellWaehrungInput.equals("BAHT")) {
            EURBetrag = BetragInput / BAHT_Kurs;
        } else {
            System.out.println("Fehler: Ungültige Quellwährung ' " + quellWaehrungInput + " ' ");
            eingabegueltig = false;
        }

        // Umrechnungslogik von EUR in Waehrung
        if (eingabegueltig) {
            if (ZielWaehrungInput.equals("EUR")) {
                Endbetrag = EURBetrag;
            } else if (ZielWaehrungInput.equals("USD")) {
                Endbetrag = EURBetrag * USD_Kurs;
            } else if (ZielWaehrungInput.equals("BAHT")) {
                Endbetrag = EURBetrag * BAHT_Kurs;
            } else {
                System.out.println("Fehler: Ungültige Zielwaehrung ' " + ZielWaehrungInput + " ' ");
                eingabegueltig = false;

            }

        }
        // Ergebnisausgabe falls gültig
        if (eingabegueltig) {
            System.out.println(Endbetrag + ZielWaehrungInput);

        }

        Sc.close(); // schließt den Scanner wieder um Ressourcen zu sparen
    }
}