package com.maistasinamus.pjazz;

public class NewEntry {
    private String pavadinimas;
    private String padazas;
    private String dydis;
    private String mesa;
    private double kaina;
    private int id;

    //Reikalingas naujo iraso kurimui
    public NewEntry(String pavadinimas,String padazas,String dydis,String mesa,double kaina) {
        this.pavadinimas=pavadinimas;
        this.padazas=padazas;
        this.dydis=dydis;
        this.mesa=mesa;
        this.kaina=kaina;
    }

    //Darbas su duomenu bazes irasu
    public NewEntry(int id, String pavadinimas, String padazas, String dydis, String mesa, double kaina) {
        this.pavadinimas = pavadinimas;
        this.padazas = padazas;
        this.dydis = dydis;
        this.mesa = mesa;
        this.kaina = kaina;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getPadazas() {
        return padazas;
    }

    public void setPadazas(String padazas) {
        this.padazas = padazas;
    }

    public String getDydis() {
        return dydis;
    }

    public void setDydis(String dydis) {
        this.dydis = dydis;
    }

    public String getMesa() {
        return mesa;
    }

    public void setMesa(String mesa) {
        this.mesa = mesa;
    }

    public Double getKaina() {
        return kaina;
    }

    public void setKaina(Double kaina) {
        this.kaina = kaina;
    }
}
