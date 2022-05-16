package it.start2impact.testProgettoS2I.ui;

import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import it.start2impact.testProgettoS2I.controller.Controller;
import it.start2impact.testProgettoS2I.utils.Utils;

@SpringBootApplication(scanBasePackages = { "it.start2impact.testProgettoS2I.service",
		"it.start2impact.testProgettoS2I.controller" })
public class TestProgettoS2IApplication {

	public static void main(String[] args) {

		try (ConfigurableApplicationContext context = SpringApplication.run(TestProgettoS2IApplication.class, args);
				Scanner input = new Scanner(System.in)) {

			Controller controller = context.getBean("controller", Controller.class);

			System.out.println("\n\n\n         Benvenuto in IncuDO!          \n");
			System.out.println("\n        developed by Luca Gobbi           \n\n\n");

			Boolean intro = Utils.getChoice(input, "E' la tua prima volta con noi?");
			if (intro) {
				System.out.println(
						"IncuDO è una piattaforma di integrazione volta alla creazione di percorsi professionali per migranti."
								+ "\nL'obiettivo è di creare dei veri e propri corsi professionalizzanti, completamente gratuiti e volti alla preservazione di mestieri centenari."
								+ "\nAll'interno della piattaforma gli utenti potranno: visualizzare tutti i corsi presenti all'interno del sistema, prenotare un corso, "
								+ "\ndisdirne la prenotazione, aggiungere nuovi utenti ed esportare i dati relativi ai corsi per un utilizzo esterno.\n");
				System.out.println("Accedo al menù principale...");
			} else {
				System.out.println("Accedo al menù principale...");
			}

			do {
				System.out.println(
						"\nBenvenuto nel menù principale di IncuDO, seleziona un'opzione per continuare: \n1) Visualizza tutti i corsi \n2) Prenota un corso "
								+ "\n3) Cancella prenotazione \n4) Aggiungi nuovo utente \n5) Esporta file corsi \n0) Esci");

				Integer choice = Utils.getNum(input, 0, 5);
				if (choice == 0) {
					System.out.println("Grazie per aver utilizzato IncuDO! Arrivederci!");
					break;
				} else {
					switch (choice) {
					case 1:
						controller.getAllCorsi();
						break;
					case 2:
						controller.prenotaCorso(input);
						break;
					case 3:
						controller.cancellaPrenotazione(input);
						break;
					case 4:
						controller.aggiungiUtente(input);
						break;
					case 5:
						controller.esportaCorsi(input);
						break;
					default:
						break;
					}
				}

			} while (true);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
