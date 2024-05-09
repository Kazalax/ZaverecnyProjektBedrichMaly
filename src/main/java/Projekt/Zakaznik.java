package Projekt;

public class Zakaznik {
    //jmeno pojištěného
    private String jmeno;

    //prijmeni pojištěného
    private String prijmeni;

    //telefonní číslo pojištěného
    private String telCislo;

    //věk pojištěného
    private int vek;


    //konstruktor pro nového pojištěného
    public Zakaznik(String jmeno, String prijmeni, String telCislo, int vek) {
        this.jmeno = jmeno;
        this.prijmeni = prijmeni;
        this.telCislo = telCislo;
        this.vek = vek;
    }

    @Override
    public String toString() {
        return jmeno + " " + prijmeni + " " + vek + " " + telCislo;
    }

    //gettery vracejí jmeno, prijmeni, vek a telefonni cislo
    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public int getVek() {
        return vek;
    }
    public String getTelCislo() {
        return telCislo;
    }

    //settry nastavují jmeno, prijmeni, vek a telefonni cislo
    public void setJmeno(String jmeno) {
        this.jmeno = jmeno;
    }

    public void setPrijmeni(String prijmeni) {
        this.prijmeni = prijmeni;
    }

    public void setTelCislo(String telCislo) {
        this.telCislo = telCislo;
    }

    public void setVek(int vek) {
        this.vek = vek;
    }
}