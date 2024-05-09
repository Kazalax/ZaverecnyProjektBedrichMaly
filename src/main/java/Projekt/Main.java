package Projekt;

import javax.xml.crypto.Data;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //vytvoření instance Scanner pro načítání uživatelského vstupu z konzole
        Scanner scanner = new Scanner(System.in);

        //vytvoření instance EvidencePojisteni pro správu databáze pojištěných osob
        EvidencePojisteni evidence = new EvidencePojisteni();

        //zobrazí úvodní obrazovku
        evidence.vypisUvodniObrazovku();

        //hlavní smyčka programu pro zpracování uživatelských voleb
        String volba = "";
        while (!volba.equals("5")) {
            //přečtení uživatelské volby z konzole
            volba = scanner.nextLine();
            System.out.println();
            //reakce na volbu
            switch (volba) {
                //přidá pojištěného
                case "1":
                    evidence.pridejZakaznika();
                    break;

                //vypíše všechny pojištěné
                case "2":
                    evidence.vypisZakazniky();
                    break;

                //najde pojištěného
                case "3":
                    evidence.najdiZakaznika();
                    break;

                //vymaže pojištěného
                case "4":
                    evidence.vymazZakaznika();
                    break;

                //konec
                case "5":
                    evidence.vymazZakaznika();
                    break;

                //případ pro neplatnou volbu
                default:
                    System.out.println("Neplatná volba, stiskněte libovolnou klávesu a opakujte volbu.");
                    break;
            }
            //pokud volba není "5", vyzve uživatele k pokračování po stisknutí Enteru
            if (!volba.equals("5")) {
                System.out.println("Stiskněte Enter pro pokračování...");
                scanner.nextLine(); // Čekání na stisknutí Enteru
                evidence.vypisUvodniObrazovku(); // Znovu zobrazí úvodní obrazovku
            }
        }

        // Zavření scanneru na konci programu
        scanner.close();
    }

}

