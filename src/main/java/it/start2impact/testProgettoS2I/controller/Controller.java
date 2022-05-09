package it.start2impact.testProgettoS2I.controller;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import it.start2impact.testProgettoS2I.model.Corso;
import it.start2impact.testProgettoS2I.model.Prenotazione;
import it.start2impact.testProgettoS2I.model.Utente;
import it.start2impact.testProgettoS2I.service.CsvService;
import it.start2impact.testProgettoS2I.utils.Utils;

@Component
public class Controller {

	@Autowired
	CsvService service;

	public void getAllCorsi() {
		service.getCorsi().forEach(System.out::println);
	}

	public void prenotaCorso(Scanner input) {
		System.out.println("Hai selezionato Prenota un corso!\nDigita l'ID di uno dei corsi disponibili: ");
		List<Corso> corsiDisponibili = service.getCorsiDisponibili();
		corsiDisponibili.forEach(System.out::println);
		boolean available = false;
		Corso corsoSelezionato = null;
		do {
			Integer idAttivitaScelta = Utils.getNum(input);
			for (Corso corso : corsiDisponibili) {
				if (corso.getId().equals(idAttivitaScelta)) {
					System.out.println("Hai selezionato il corso: " + corso.getNome() + "\n");
					corso.setDisponibile("NO");
					corsoSelezionato = corso;
					available = true;
					break;
				}
			}
			if (!available) {
				System.out.println("Il corso selezionato non è disponibile! Riprova: ");
			}
		} while (!available);

		Integer idUtenteSelezionato = Utils.getIdUtente(input, service,
				"Digita l'ID dell'utente da iscrivere al corso: ");

		Prenotazione nuovaPrenotazione = new Prenotazione(service.getPrenotazioni().size() + 1,
				corsoSelezionato.getId(), idUtenteSelezionato, corsoSelezionato.getData(), corsoSelezionato.getData());

		service.addPrenotazione(nuovaPrenotazione);
		System.out.println(
				"Prenotazione confermata: " + "\nID Prenotazione: " + nuovaPrenotazione.getId() + "\nID Attività: "
						+ nuovaPrenotazione.getIdAttivita() + "\nID Utente: " + nuovaPrenotazione.getIdUtente());
	}

	public void cancellaPrenotazione(Scanner input) {
		System.out.println("Hai selezionato Cancella prenotazione!");
		Integer idUtenteSelezionato = Utils.getIdUtente(input, service,
				"Digita l'ID dell'utente la cui prenotazione desideri cancellare: ");
		List<Prenotazione> prenotazioniUtenteSelezionato = service.getPrenotazioniByUtente(idUtenteSelezionato);
		if (prenotazioniUtenteSelezionato.size() == 0) {
			System.out.println("L'utente selezionato non ha prenotazioni registrate!");
		} else {
			System.out.println("Queste sono le prenotazioni dell'utente con ID " + idUtenteSelezionato + ": ");
			prenotazioniUtenteSelezionato.forEach(System.out::println);
			System.out.println("Digita l'ID di una delle prenotazioni per cancellarla: ");
			Boolean available = false;
			do {
				Integer idPrenotazioneScelta = Utils.getNum(input);
				for (Prenotazione prenotazione : prenotazioniUtenteSelezionato) {
					if (prenotazione.getId().equals(idPrenotazioneScelta)) {
						System.out.println("Hai selezionato la prenotazione con ID: " + idPrenotazioneScelta + "\n");
						do {
							Boolean choice = Utils.getChoice(input,
									"Sei sicuro di voler cancellare questa prenotazione?");
							if (choice) {
								available = true;
								service.getPrenotazioni().remove(prenotazione);
								service.getCorsoById(prenotazione.getIdAttivita()).setDisponibile("SI");
								System.out.println("Cancellazione avvenuta con successo!");
								break;
							} else {
								available = true;
								break;
							}
						} while (true);
						break;
					}
				}
				if (!available) {
					System.out.println("La prenotazione non è tra quelle elencate! Riprova: ");
				}
			} while (!available);
		}
	}

	public void aggiungiUtente(Scanner input) {
		System.out.println(
				"Hai selezionato Aggiungi nuovo utente! \nCompila i seguenti campi per aggiungere un nuovo utente: ");
		String nome = Utils.getString(input, "Nome: ");
		String cognome = Utils.getString(input, "Cognome: ");
		String indirizzo = Utils.getString(input, "Indirizzo: ");
		Date dataDiNascita = Utils.getDate(input, "Data di nascita (dd/MM/yyyy): ");
		String documentoId = Utils.getString(input, "Documento ID: ");

		Utente nuovoUtente = new Utente(service.getUtenti().size() + 1, nome, cognome, dataDiNascita, indirizzo,
				documentoId);
		service.getUtenti().add(nuovoUtente);
		System.out.println("Inserimento nuovo utente avvenuto con successo!");
		System.out.println(nuovoUtente);
	}

	public void esportaCorsi() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		LocalDate currentDate = LocalDate.now();
		Writer writer = new FileWriter("src/main/resources/" + currentDate + ".csv");
		StatefulBeanToCsv beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
		beanToCsv.write(service.getCorsiDisponibili());
		System.out.println("Stampa CSV avvenuta con successo!");
		writer.close();
	}

}
