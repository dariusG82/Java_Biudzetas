package com.cao.dariusg;

public class IslaiduIrasas extends Irasas{

    private IslaiduKategorija islaiduKategorija;
    private AtsiskaitymoBudas atsiskaitymoBudas;

    public IslaiduIrasas() {
        super();
        this.islaiduKategorija = null;
        this.atsiskaitymoBudas = null;
    }

    @Override
    public String toString() {
        String stars = "***********************\n";
        String value = "Islaidu suma: " + getSuma() +
                " Eur, Islaidu data: " + getData().toString() +
                ", Islaidu Kategorija: " + getIslaiduKategorija() +
                ", Atsiskaitymo budas: " + getAtsiskaitymoBudas() +
                ", Papildoma informacija apie operacija: " + getPapildomaInfo() +
                '\n';
        return stars + value + stars;
    }

    public IslaiduKategorija getIslaiduKategorija() {
        return islaiduKategorija;
    }

    public void setIslaiduKategorija(IslaiduKategorija islaiduKategorija) {
        this.islaiduKategorija = islaiduKategorija;
    }

    public AtsiskaitymoBudas getAtsiskaitymoBudas() {
        return atsiskaitymoBudas;
    }

    public void setAtsiskaitymoBudas(AtsiskaitymoBudas atsiskaitymoBudas) {
        this.atsiskaitymoBudas = atsiskaitymoBudas;
    }
}
