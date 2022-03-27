package com.namudarbas;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biudzetas {
    private final List<PajamuIrasas> pajamos;
    private final List<IslaiduIrasas> islaidos;
    private final List<Irasas> visiIrasai = new ArrayList<>();
    private double pajamuSuma;
    private double islaiduSuma;

    public Biudzetas(){
        pajamos = new ArrayList<>();
        islaidos = new ArrayList<>();
        pajamuSuma = 0.0;
        islaiduSuma = 0.0;
    }

    public void pridetiPajamuIrasa(PajamuIrasas irasas){
        pajamos.add(irasas);
        visiIrasai.add(irasas);
        pajamuSuma += irasas.getSuma();
        System.out.println("Jusu ivestas pajamu irasas yra:");
        System.out.println(irasas);
    }

    public void pridetiIslaiduIrasa(IslaiduIrasas irasas){
        islaidos.add(irasas);
        visiIrasai.add(irasas);
        islaiduSuma += irasas.getSuma();
        System.out.println("Jusu ivestas islaidu irasas yra:");
        System.out.println(irasas);
    }

    public double getBalansas() {
        return getPajamuSuma() - getIslaiduSuma();
    }

    public void gautiBendrasPajamas(){
        double pajamuSuma = 0.0;
        for (PajamuIrasas irasas: pajamos) {
            System.out.println(irasas);
            pajamuSuma += irasas.getSuma();
        }
        System.out.printf("Bendra pajamu suma yra: %.02f\n", pajamuSuma);
    }

    public void gautiBendrasPajamas(LocalDate data){
        double pajamuSuma = 0.0;
        for (PajamuIrasas irasas: pajamos) {
            if(irasas.getData().equals(data)){
                System.out.println(irasas);
                pajamuSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra pajamu suma yra: %.02f\n", pajamuSuma);
    }

    public void gautiBendrasPajamas(PajamuKategorija kategorija){
        double pajamuSuma = 0.0;
        for (PajamuIrasas irasas: pajamos) {
            if(irasas.getPajamuKategorija() == kategorija){
                System.out.println(irasas);
                pajamuSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra pajamu suma yra: %.02f\n", pajamuSuma);
    }

    public void gautiBendrasPajamas(boolean pozymisIBanka){
        double pajamuSuma = 0.0;
        for (PajamuIrasas irasas: pajamos) {
            if(irasas.isPozymisArIBanka() == pozymisIBanka){
                System.out.println(irasas);
                pajamuSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra pajamu suma yra: %.02f\n", pajamuSuma);
    }

    public void gautiBendrasIslaidas(){
        double islaiduSuma = 0.0;
        for (IslaiduIrasas irasas: islaidos) {
            System.out.println(irasas);
            islaiduSuma += irasas.getSuma();
        }
        System.out.printf("Bendra islaidu suma yra: %.02f\n", islaiduSuma);
    }

    public void gautiBendrasIslaidas(LocalDate data){
        double islaiduSuma = 0.0;
        for (IslaiduIrasas irasas: islaidos) {
            if(irasas.getData().equals(data)){
                System.out.println(irasas);
                islaiduSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra islaidu suma yra: %.02f\n", islaiduSuma);
    }

    public void gautiBendrasIslaidas(IslaiduKategorija kategorija){
        double islaiduSuma = 0.0;
        for (IslaiduIrasas irasas: islaidos) {
            if(irasas.getIslaiduKategorija() == kategorija){
                islaiduSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra islaidu suma yra: %.02f\n", islaiduSuma);
    }

    public void gautiBendrasIslaidas(AtsiskaitymoBudas atsiskaitymoBudas){
        double islaiduSuma = 0.0;
        for (IslaiduIrasas irasas: islaidos) {
            if(irasas.getAtsiskaitymoBudas() == atsiskaitymoBudas){
                islaiduSuma += irasas.getSuma();
            }
        }
        System.out.printf("Bendra islaidu suma yra: %.02f\n", islaiduSuma);
    }

    public void gautiBalansa(){
        System.out.println("***********************");
        System.out.printf("Jusu balansas siuo metu yra %.2f Euru\n", getBalansas());
        System.out.println("***********************");
    }

    public void gautiBalansa(LocalDate balansoData){
        System.out.println("***********************");
        double balansas = 0.0;
        for (Irasas irasas : visiIrasai) {
            if(irasas.getData().isBefore(balansoData)){
                if(irasas instanceof PajamuIrasas){
                    balansas += irasas.getSuma();
                } else {
                    balansas -= irasas.getSuma();
                }
            }
        }
        System.out.println("Jusu balansas " + balansoData.toString() + " dienai yra " + balansas + " Eur");
        System.out.println("***********************");
    }

    public double getPajamuSuma() {
        return pajamuSuma;
    }

    public double getIslaiduSuma() {
        return islaiduSuma;
    }
}
