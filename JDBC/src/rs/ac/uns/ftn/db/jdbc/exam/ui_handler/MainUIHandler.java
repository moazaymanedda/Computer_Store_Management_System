package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.ArtikalOcenaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupacStatistikaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.KupovineAnalizaDTO;
import rs.ac.uns.ftn.db.jdbc.exam.dto.UtisakDTO;
import rs.ac.uns.ftn.db.jdbc.exam.service.ArtikalService;
import rs.ac.uns.ftn.db.jdbc.exam.service.KupacService;
import rs.ac.uns.ftn.db.jdbc.exam.service.KupovinaService;

public class MainUIHandler {

    private static final ArtikalService artikalService = new ArtikalService();
    private static final KupacService kupacService = new KupacService();
    private static final KupovinaService kupovinaService = new KupovinaService();
    public static Scanner sc = new Scanner(System.in);

    public void handleMainMenu() {
        String answer;
        do {
            System.out.println("\nOdaberite opciju za rad sa prodavnicom:");
            System.out.println("1 - (Jednostavan upit)Prikaz statistiku kupovine kupca");
            System.out.println("2 - (Dodatna)Prikaz prosečnih ocena po tipu artikla");
            System.out.println("3 - (1.Kompleksan upit)Detaljna analiza kupovina");
            System.out.println("4 - (2.Kompleksan upit)Analiza artikala");
            System.out.println("5 - (Transakcija)Nova kupovina sa utiskom");
            System.out.println("X - Izlazak iz programa");

            answer = MainUIHandler.sc.nextLine();

            switch (answer) {
                case "1":
                	prikaziStatistikuKupaca();
                    break;
                case "2":
                	prikaziProsecneOcene();;
                    break;
                case "3":
                    prikaziKupovineAnalizu();
                    break;
                case "4":
                    prikaziArtikleAnalizu();
                    break;
                case "5":
                    kreirajNovuKupovinu();
                    break;
                case "X":
                case "x":
                    System.out.println("Izlazak iz programa...");
                    break;
                default:
                    System.out.println("Nepoznata opcija, pokušajte ponovo.");
                    break;
            }
        } while (!answer.equalsIgnoreCase("X"));
    }
    
    private void prikaziStatistikuKupaca() {
        System.out.println("\nPrikaz statistike kupaca:");
        System.out.println(KupacStatistikaDTO.getFormattedHeader());

        try {
            for (KupacStatistikaDTO statistika : kupacService.getStatistikaKupaca()) {
                System.out.println(statistika);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void prikaziProsecneOcene() {
        System.out.println("\nPrikaz prosečnih ocena po tipu artikla:");
        System.out.println(ArtikalOcenaDTO.getFormattedHeader());

        try {
            for (ArtikalOcenaDTO ocena : artikalService.getProsecneOcenePoTipu()) {
                System.out.println(ocena);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void prikaziKupovineAnalizu() {
        System.out.println("\nPrikaz detaljne analize kupovina:");
        System.out.println(KupovineAnalizaDTO.getFormattedHeader());

        try {
            for (KupovineAnalizaDTO analiza : kupovinaService.getKupovineAnaliza()) {
                System.out.println(analiza);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void prikaziArtikleAnalizu() {
        System.out.println("\nPrikaz analize artikala:");
        System.out.println(ArtikalAnalizaDTO.getFormattedHeader());

        try {
            for (ArtikalAnalizaDTO analiza : artikalService.getArtikliAnaliza()) {
                System.out.println(analiza);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private void kreirajNovuKupovinu() {
        System.out.println("\nUnos nove kupovine sa utiskom:");

        System.out.print("Unesite ID kupca: ");
        int idKupca = Integer.parseInt(MainUIHandler.sc.nextLine());

        System.out.print("Unesite ID-eve artikala (razdvojene zarezima): ");
        String artikliInput = MainUIHandler.sc.nextLine();
        List<Integer> artikliIds = new ArrayList<>();
        for (String id : artikliInput.split(",")) {
            artikliIds.add(Integer.parseInt(id.trim()));
        }

        System.out.print("Unesite način plaćanja: ");
        String nacinPlacanja = MainUIHandler.sc.nextLine();

        System.out.print("Unesite ocenu (1-5): ");
        double ocena = Double.parseDouble(MainUIHandler.sc.nextLine());

        System.out.print("Unesite komentar: ");
        String komentar = MainUIHandler.sc.nextLine();

        UtisakDTO utisak = new UtisakDTO(0, ocena, komentar, null, idKupca);

        try {
            kupovinaService.kreirajKupovinuSaRacunomIUtiskom(idKupca, artikliIds, nacinPlacanja, utisak);
            System.out.println("Kupovina je uspešno kreirana.");
        } catch (SQLException e) {
            System.out.println("Došlo je do greške prilikom kreiranja kupovine: " + e.getMessage());
        }
    }
}
