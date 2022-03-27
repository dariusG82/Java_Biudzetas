package com.cao.dariusg;

import java.time.LocalDate;

public class Irasas {
    private double suma;
    private LocalDate irasoData;
    private String papildomaInfo;

    public Irasas() {
        this.suma = 0.0;
        this.irasoData = null;
        this.papildomaInfo = "";
    }

    public double getSuma() {
        return suma;
    }

    public void setSuma(double suma) {
        this.suma = suma;
    }

    public LocalDate getData(){
        return irasoData;
    }

    public void setData(LocalDate data) {
        this.irasoData = data;
    }

    public String getPapildomaInfo() {
        return papildomaInfo.length() < 1 ? "Informacijos nera" : papildomaInfo;
    }

    public void setPapildomaInfo(String papildomaInfo) {
        this.papildomaInfo = papildomaInfo;
    }
}
