package Projekt;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


public class EvidencePojisteni {

    //vytvoření instance Scanner pro načítání uživatelského vstupu z konzole
    private Scanner scanner = new Scanner(System.in);

    //konstruktor EvidencePojisteni
    public EvidencePojisteni() {
        databaze = new Databaze();
    }

    //instance Databaze pro správu zákazníků
    private Databaze databaze;

    //pojištěný - jedná se o proměnnou, která bude sloužit pro vyhledaného zákazníka
    private Zakaznik zakaznik;

    //metoda pro zobrazení úvodní obrazovky s možnostmi pro uživatele
    public void vypisUvodniObrazovku() {
        System.out.println("-------------------------------------------");
        System.out.println("Evidence pojištěných");
        System.out.println("-------------------------------------------");
        System.out.println();
        System.out.println("Vyberte si akci:");
        System.out.println("1 - Přidat nového pojištěného");
        System.out.println("2 - Vypsat všechny pojištěné");
        System.out.println("3 - Vyhledat pojištěného");
        System.out.println("4 - Vymazat pojištěného");
        System.out.println("5 - Konec");
    }

    //metoda pro výpis všech pojištěných
    public void vypisZakazniky() {
        databaze.vypisZakazniky();
    }

    //metoda pro přidání pojištěného
    public void pridejZakaznika() {
        System.out.println("Zadejte jméno pojištěného: ");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte přijmení pojištěného: ");
        String prijmeni = scanner.nextLine();
        System.out.println("Zadejte telefonní čislo pojištěného: ");

        String telCisloString = scanner.nextLine();
        String telCisloBezMezer = telCisloString.replaceAll("\\s+", "");
        String telCislo = telCisloBezMezer;

        System.out.println("Zadejte věk pojištěného: ");
        int vek = Integer.parseInt(scanner.nextLine());
        Zakaznik novyZakaznik = new Zakaznik(jmeno, prijmeni, telCislo, vek);
        databaze.pridejZakaznika(novyZakaznik);

        System.out.println();
        System.out.println("Pojištěný úspěšně přidán do databáze.");
    }

    //metoda pro nalezení pojištěného podle jména a příjmení
    public Zakaznik najdiZakaznika() {
        System.out.println("Zadejte jméno pojištěný:");
        String jmeno = scanner.nextLine();
        System.out.println("Zadejte příjmení pojištěného:");
        String prijmeni = scanner.nextLine();

        ArrayList<Zakaznik> nalezeniZakaznici = databaze.vyhledatZakaznikaPodleJmenaAPrijmeni(jmeno, prijmeni);

        if (!nalezeniZakaznici.isEmpty()) {
            System.out.println("Nalezeni pojištěný:");
            for (Zakaznik zakaznik : nalezeniZakaznici) {
                System.out.println(zakaznik);
            }
        } else {
            System.out.println("Pojištěný se jménem " + jmeno + " a příjmením " + prijmeni + " nebyl nalezen.");
        }
        if (nalezeniZakaznici.isEmpty()) {
            //pokud je seznam prázdný, vrátí se null
            zakaznik = null;
        } else {
            //pokud seznam není prázdný, vrátí se první prvek seznamu
            zakaznik = nalezeniZakaznici.get(0);
        }

        //vrátí výsledného pojištěného
        return zakaznik;
    }

    //metoda pro vymazání pojištěného podle jména a příjmení
    public void vymazZakaznika() {
        System.out.println("Zadejte jméno pojištěného, kterého chcete vymazat: ");
        String vymazJmeno = scanner.nextLine();

        System.out.println("Zadejte příjmení pojištěného, kterého chcete vymazat: ");
        String vymazPrijmeni = scanner.nextLine();

        boolean vymazano = databaze.vymazatZakaznika(vymazJmeno, vymazPrijmeni);
        if (vymazano) {
            System.out.println("Pojištěný byl úspěšně vymazán.");
        } else {
            System.out.println("Pojištěný s tímto jménem a příjmením nebyl nalezen.");
        }
    }

}


