package com.namudarbas;

public class PajamuIrasas extends Irasas {

    private PajamuKategorija pajamuKategorija;
    private boolean pozymisArIBanka;

    public PajamuIrasas(){
        super();
        this.pajamuKategorija = null;
        this.pozymisArIBanka = false;
    }

    @Override
    public String toString() {
        String stars = "***********************\n";
        String value = "Pajamu suma: " + getSuma() +
                "Eur, Pajamu gavimo data: " + getData().toString() +
                ", Pajamu Kategorija: " + getPajamuKategorija() +
                ", Pajamos gautos " + getPozymisIBanka() +
                ", Papildoma informacija: " + getPapildomaInfo() +
                "\n";
        return stars + value + stars;
    }

    public PajamuKategorija getPajamuKategorija() {
        return pajamuKategorija;
    }

    public void setPajamuKategorija(PajamuKategorija pajamuKategorija) {
        this.pajamuKategorija = pajamuKategorija;
    }

    public boolean isPozymisArIBanka() {
        return pozymisArIBanka;
    }

    public String getPozymisIBanka(){
        return pozymisArIBanka ? "i banko saskaita" : "grynais pinigais";
    }

    public void setPozymisArIBanka(boolean pozymisArIBanka) {
        this.pozymisArIBanka = pozymisArIBanka;
    }
}
