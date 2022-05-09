package it.start2impact.testProgettoS2I.service;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.opencsv.bean.CsvToBeanBuilder;

import it.start2impact.testProgettoS2I.beanVerifiers.CorsoVerifier;
import it.start2impact.testProgettoS2I.beanVerifiers.PrenotazioneVerifier;
import it.start2impact.testProgettoS2I.beanVerifiers.UtenteVerifier;
import it.start2impact.testProgettoS2I.model.Corso;
import it.start2impact.testProgettoS2I.model.Prenotazione;
import it.start2impact.testProgettoS2I.model.Utente;

@Service
public class CsvService {

	private List<Corso> corsi;
	private List<Utente> utenti;
	private List<Prenotazione> prenotazioni;

	public CsvService() throws IllegalStateException, FileNotFoundException {
		corsi = this.fetchCorsiFromCsv();
		utenti = this.fetchUtentiFromCsv();
		prenotazioni = this.fetchPrenotazioniFromCsv();
	}

	public List<Utente> fetchUtentiFromCsv() throws IllegalStateException, FileNotFoundException {
		InputStream input = CsvService.class.getResourceAsStream("/utenti.csv");
		List<Utente> utenti = new CsvToBeanBuilder<Utente>(new InputStreamReader(input)).withSeparator(';')
				.withSkipLines(1).withVerifier(new UtenteVerifier()).withType(Utente.class).build().parse();
		return utenti;
	}

	public List<Prenotazione> fetchPrenotazioniFromCsv() throws IllegalStateException, FileNotFoundException {
		InputStream input = CsvService.class.getResourceAsStream("/prenotazioni.csv");
		List<Prenotazione> prenotazioni = new CsvToBeanBuilder<Prenotazione>(new InputStreamReader(input))
				.withSeparator(';').withSkipLines(1).withVerifier(new PrenotazioneVerifier())
				.withType(Prenotazione.class).build().parse();
		return prenotazioni;
	}

	public List<Corso> fetchCorsiFromCsv() throws IllegalStateException, FileNotFoundException {
		InputStream input = CsvService.class.getResourceAsStream("/corsi.csv");
		List<Corso> corsi = new CsvToBeanBuilder<Corso>(new InputStreamReader(input)).withSeparator(';')
				.withSkipLines(1).withVerifier(new CorsoVerifier()).withType(Corso.class).build().parse();
		return corsi;
	}

	public List<Corso> getCorsi() {
		return corsi;
	}

	public Corso getCorsoById(Integer id) {
		for (Corso corso : this.getCorsi()) {
			if (corso.getId().equals(id)) {
				return corso;
			}
		}
		return null;
	}

	public List<Corso> getCorsiDisponibili() {
		List<Corso> corsiDisponibili = new ArrayList<Corso>();
		for (Corso corso : this.getCorsi()) {
			if (corso.getDisponibile().equalsIgnoreCase("si")) {
				corsiDisponibili.add(corso);
			}
		}
		return corsiDisponibili;
	}

	public void setCorsi(List<Corso> corsi) {
		this.corsi = corsi;
	}

	public List<Utente> getUtenti() {
		return utenti;
	}

	public void setUtenti(List<Utente> utenti) {
		this.utenti = utenti;
	}

	public List<Utente> addUtente(Utente nuovoUtente) {
		this.utenti.add(nuovoUtente);
		return this.getUtenti();
	}

	public List<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public List<Prenotazione> getPrenotazioniByUtente(Integer idUtente) {
		List<Prenotazione> prenotazioniUtenteSelezionato = new ArrayList<Prenotazione>();
		for (Prenotazione p : this.getPrenotazioni()) {
			if (p.getIdUtente().equals(idUtente)) {
				prenotazioniUtenteSelezionato.add(p);
			}
		}
		return prenotazioniUtenteSelezionato;
	}

	public void setPrenotazioni(List<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}

	public List<Prenotazione> addPrenotazione(Prenotazione nuovaPrenotazione) {
		this.prenotazioni.add(nuovaPrenotazione);
		return this.getPrenotazioni();
	}
}
