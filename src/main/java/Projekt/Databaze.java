package Projekt;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;

public class Databaze {


    //seznam pojištěných zákazníků
    private ArrayList<Zakaznik> zakaznici;

    //konstruktor třídy databáze
    public Databaze() {
        zakaznici = new ArrayList<>();
    }

    //metoda pro přidání pojištěného do databáze
    public void pridejZakaznika(Zakaznik novyZakaznik) {
        zakaznici.add(novyZakaznik);
    }

    //metoda pro vypsání pojištěného
    public void vypisZakazniky() {
        for (Zakaznik zakaznik : zakaznici) {
            System.out.println(zakaznik.toString());
        }
    }

    //metoda pro nalezení pojištěného
    public ArrayList<Zakaznik> vyhledatZakaznikaPodleJmenaAPrijmeni(String jmeno, String prijmeni) {
        //seznam nalezených pojištěných
        ArrayList<Zakaznik> nalezeniZakaznici = new ArrayList<>();

        //procházení seznamu zakaznici
        for (Zakaznik zakaznik : zakaznici) {
            //porovnání jména a příjmení
            if (zakaznik.getJmeno().equalsIgnoreCase(jmeno) && zakaznik.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                //přidání nalezeného pojištěného do seznamu nalezeniZakaznici
                nalezeniZakaznici.add(zakaznik);
            }
        }

        // Vrácení seznamu nalezených pojištěných
        return nalezeniZakaznici;
    }


    //metoda pro odstranění pojištěného
    public boolean vymazatZakaznika(String jmeno, String prijmeni) {
        //procházení seznamu zakaznici
        Iterator<Zakaznik> iterator = zakaznici.iterator();
        while (iterator.hasNext()) {
            Zakaznik zakaznik = iterator.next();
            //porovnání jména a příjmení
            if (zakaznik.getJmeno().equalsIgnoreCase(jmeno) && zakaznik.getPrijmeni().equalsIgnoreCase(prijmeni)) {
                //odstranění zákazníka ze seznamu pomocí iterator.remove()
                iterator.remove();
                return true; //opustí cyklus, jakmile je zákazník nalezen a vymazán
            }
        }
        //pokud zákazník nebyl nalezen
        return false;
    }
}
