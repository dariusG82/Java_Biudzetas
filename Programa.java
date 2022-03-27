package com.cao.dariusg;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Programa {
    private final Scanner scanner = new Scanner(System.in);
    private final Biudzetas biudzetas;

    public Programa() {
        biudzetas = new Biudzetas();
    }

    public void startProgram() {
        System.out.println("Sveiki atvyke i biudzeto programa");
        int choice;
        do {
            System.out.println("Pasirinkinte norima atlikti operacija:");
            System.out.println("[1] - Ivesti pajamu irasa");
            System.out.println("[2] - Ivesti islaidu irasa");
            System.out.println("[3] - Pajamu ataskaitos");
            System.out.println("[4] - Islaidu ataskaitos");
            System.out.println("[5] - Balanso ataskaitos");
            System.out.println("[0] - Baigti darba");
//            boolean correctInput = false;
//            while (!correctInput){
//                String result = scanner.nextLine();
//                try {
//                    choice = Integer.parseInt(result);
//                    correctInput = true;
//                } catch (Exception e){
//                    correctInput = false;
//                    System.out.println("Klaidinga ivestis, bandykite dar karta");
//                }
//            }
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> sukurtiIrPridetiPajamuIrasa();
                case 2 -> sukurtiIrPridetiIslaiduIrasa();
                case 3 -> pajamuAtaskaitos();
                case 4 -> islaiduAtaskaitos();
                case 5 -> balansoAtaskaitos();
                default -> {
                    if (choice != 0) {
                        System.out.println("Bloga ivestis, bandykite dar karta");
                    }
                }
            }
        } while (choice != 0);
    }

    private void sukurtiIrPridetiPajamuIrasa() {
        PajamuIrasas pajamuIrasas = new PajamuIrasas();

        pajamuIrasas.setSuma(ivestiPajamasArbaIslaidas());
        pajamuIrasas.setData(patikrintiIrGautiIvestaData());
        pajamuIrasas.setPajamuKategorija(pasirinktiPajamuKategorija());
        pajamuIrasas.setPozymisArIBanka(sukurtiIrGautiBankoPozymi());
        pajamuIrasas.setPapildomaInfo(ivestiPapildomaInformacija());

        biudzetas.pridetiPajamuIrasa(pajamuIrasas);
    }

    private void sukurtiIrPridetiIslaiduIrasa() {
        IslaiduIrasas islaiduIrasas = new IslaiduIrasas();

        islaiduIrasas.setSuma(ivestiPajamasArbaIslaidas());
        islaiduIrasas.setData(patikrintiIrGautiIvestaData());
        islaiduIrasas.setIslaiduKategorija(pasirinktiIslaiduKategorija());
        islaiduIrasas.setAtsiskaitymoBudas(pasirinktiAtsiskaitymoBuda());
        islaiduIrasas.setPapildomaInfo(ivestiPapildomaInformacija());

        biudzetas.pridetiIslaiduIrasa(islaiduIrasas);
    }

    private void pajamuAtaskaitos() {
        System.out.println("PAJAMU ATASKAITOS");
        int choice;
        do {
            System.out.println("Pasirinkinte norima ataskaita:");
            System.out.println("[1] - Bendra pajamu ataskaita");
            System.out.println("[2] - Pajamu irasu ataskaita pagal data");
            System.out.println("[3] - Pajamu iradu ataskaita pagal pajamu kategorija");
            System.out.println("[4] - Pajamu irasu ataskaita pagal gavimo buda");
            System.out.println("[0] - Grizti atgal");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> biudzetas.gautiBendrasPajamas();
                case 2 -> biudzetas.gautiBendrasPajamas(patikrintiIrGautiIvestaData());
                case 3 -> biudzetas.gautiBendrasPajamas(pasirinktiPajamuKategorija());
                case 4 -> biudzetas.gautiBendrasPajamas(sukurtiIrGautiBankoPozymi());
                default -> {
                    if (choice != 0) {
                        System.out.println("Bloga ivestis, bandykite dar karta");
                    }
                }
            }
        } while (choice != 0);
    }

    private void islaiduAtaskaitos() {
        System.out.println("ISLAIDU ATASKAITOS");
        int choice;
        do {
            System.out.println("Pasirinkinte norima ataskaita:");
            System.out.println("[1] - Bendra islaidu ataskaita");
            System.out.println("[2] - Islaidu ataskaita pagal data");
            System.out.println("[3] - Islaidu ataskaita pagal islaidu kategorija");
            System.out.println("[4] - Islaidu ataskaita pagal atsiskaitymo buda");
            System.out.println("[0] - Grizti atgal");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> biudzetas.gautiBendrasIslaidas();
                case 2 -> biudzetas.gautiBendrasIslaidas(patikrintiIrGautiIvestaData());
                case 3 -> biudzetas.gautiBendrasIslaidas(pasirinktiIslaiduKategorija());
                case 4 -> biudzetas.gautiBendrasIslaidas(pasirinktiAtsiskaitymoBuda());
                default -> {
                    if (choice != 0) {
                        System.out.println("Bloga ivestis, bandykite dar karta");
                    }
                }
            }
        } while (choice != 0);
    }

    private void balansoAtaskaitos() {
        System.out.println("BALANSO ATASKAITOS");
        int choice;
        do {
            System.out.println("Pasirinkinte norima ataskaita:");
            System.out.println("[1] - Balansas siai dienai");
            System.out.println("[2] - Balansas nurodytai datai");
            System.out.println("[0] - Grizti atgal");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> biudzetas.gautiBalansa();
                case 2 -> biudzetas.gautiBalansa(patikrintiIrGautiIvestaData());
                default -> {
                    if (choice != 0) {
                        System.out.println("Bloga ivestis, bandykite dar karta");
                    }
                }
            }
        } while (choice != 0);
    }

    private double ivestiPajamasArbaIslaidas() {
        Scanner newScanner = new Scanner(System.in);
        double suma = 0.0;
        boolean success = false;
        do{
            System.out.print("Iveskite suma: ");
            String ivestis = newScanner.nextLine();
            try {
                suma = Double.parseDouble(ivestis);
                success = true;
            } catch (Exception e){
                success = false;
            }
        } while (!success);
        return suma;
    }

    private LocalDate patikrintiIrGautiIvestaData() {
        Scanner newScanner = new Scanner(System.in);
        boolean teisingaData;
        String naujaData;
        do {
            System.out.print("Iveskite data formatu YYYY-MM-DD: ");
            naujaData = newScanner.nextLine();
            teisingaData = arTeisingaiIvestaDiena(naujaData);
        } while (!teisingaData);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return LocalDate.parse(naujaData, formatter);
    }

    private boolean arTeisingaiIvestaDiena(String data) {
        if(data.length() < 1 || data.length() > 10){
            return false;
        }
        if(data.indexOf("-") != 4 && data.lastIndexOf("-") != 7){
            return false;
        }

        int metai;
        int menesis;
        int diena;

        try {
            metai = Integer.parseInt(data.substring(0, 4));
            menesis = Integer.parseInt(data.substring(5, 7));
            diena = Integer.parseInt(data.substring(8));
        } catch (Exception e){
            return false;
        }

        if (menesis < 0 || diena < 0) {
            return false;
        } else {
            switch (menesis) {
                case 1, 3, 5, 7, 8, 10, 12 -> {
                    return diena < 32;
                }
                case 2 -> {
                    return diena < 29;
                }
                case 4, 6, 9, 11 -> {
                    return diena < 31;
                }
                default -> {
                    return false;
                }
            }
        }
    }

    private PajamuKategorija pasirinktiPajamuKategorija() {
        int kategorijosNr;
        do {
            System.out.print("Pasirinkite pajamu kategorija: [1] - Darbo uzmokestis / [2] - Pardavimo pajamos / [3] - Papildomos pajamos: ");
            kategorijosNr = scanner.nextInt();
            switch (kategorijosNr){
                case 1 -> {
                    scanner.nextLine();
                    return PajamuKategorija.DARBO_UZMOKESTIS;
                }
                case 2 -> {
                    scanner.nextLine();
                    return PajamuKategorija.PARDAVIMO_PAJAMOS;
                }
                case 3 -> {
                    scanner.nextLine();
                    return PajamuKategorija.PAPILDOMOS_PAJAMOS;
                }
                default -> {
                    scanner.nextLine();
                    System.out.println("Neteisingas pasirinkimas, bandykite dar karta");
                }
            }
        } while (kategorijosNr > 3 || kategorijosNr < 1);
        scanner.nextLine();
        return null;
    }

    private IslaiduKategorija pasirinktiIslaiduKategorija() {
        int kategorijosNr;
        do {
            System.out.print("Pasirinkite islaidu kategorija: [1] - Maistas / [2] - Automobilis / [3] - Komunalins paslaugos / [4] Pramogos : ");
            kategorijosNr = scanner.nextInt();
            switch (kategorijosNr){
                case 1 -> {
                    scanner.nextLine();
                    return IslaiduKategorija.MAISTAS;
                }
                case 2 -> {
                    scanner.nextLine();
                    return IslaiduKategorija.AUTOMOBILIS;
                }
                case 3 -> {
                    scanner.nextLine();
                    return IslaiduKategorija.KOMUNALINES_PASLAUGOS;
                }
                case 4 -> {
                    scanner.nextLine();
                    return IslaiduKategorija.PRAMOGOS;
                }
                default -> System.out.println("Neteisingas pasirinkimas, bandykite dar karta.");
            }
        } while (kategorijosNr > 4 || kategorijosNr < 1);
        scanner.nextLine();
        return null;
    }

    private boolean sukurtiIrGautiBankoPozymi() {
        int choice;
        do {
            System.out.print("Ar pajamos gautos i banko saskaita: [1] - Taip / [2] - Ne: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    scanner.nextLine();
                }
                case 2 -> {
                    scanner.nextLine();
                }
                default -> System.out.println("Neteisingas pasirinkimas, bandykite dar karta");
            }
        } while (choice > 2 || choice < 1);

        if(choice == 1){
            return true;
        } else {
            return false;
        }
    }

    private AtsiskaitymoBudas pasirinktiAtsiskaitymoBuda() {
        int choice;
        do {
            System.out.print("Pasirinkine atsiskaitymo buda: [1] - Banko pavedimu / [2] - Banko kortele / [3] - Grynais pinigais: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1 -> {
                    scanner.nextLine();
                    return AtsiskaitymoBudas.BANKO_PAVEDIMAS;
                }
                case 2 -> {
                    scanner.nextLine();
                    return AtsiskaitymoBudas.BANKO_KORTELE;
                }
                case 3 -> {
                    scanner.nextLine();
                    return AtsiskaitymoBudas.GRYNAIS_PINIGAIS;
                }
                default -> System.out.println("Neteisingas pasirinkimas, bandykite dar karta");
            }
        } while (choice > 3 || choice < 1);
        scanner.nextLine();
        return null;
    }

    private String ivestiPapildomaInformacija() {
        System.out.println("Irasykite operacijos turini arba kita papildoma operacija");
        String operacijosTurinys = scanner.nextLine();
        return operacijosTurinys;
    }
}
