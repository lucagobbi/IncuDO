package it.start2impact.testProgettoS2I.model;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class Prenotazione {

	@CsvBindByPosition(position = 0)
	private Integer id;
	@CsvBindByPosition(position = 1)
	private Integer idAttivita;
	@CsvBindByPosition(position = 2)
	private Integer idUtente;
	@CsvBindByPosition(position = 3)
	@CsvDate(value = "dd/MM/yyyy")
	private Date dataInizio;
	@CsvBindByPosition(position = 4)
	@CsvDate(value = "dd/MM/yyyy")
	private Date dataFine;

	public Prenotazione() {

	}

	public Prenotazione(Integer id, Integer idAttivita, Integer idUtente, Date dataInizio, Date dataFine) {
		super();
		this.id = id;
		this.idAttivita = idAttivita;
		this.idUtente = idUtente;
		this.dataInizio = dataInizio;
		this.dataFine = dataFine;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdAttivita() {
		return idAttivita;
	}

	public void setIdAttivita(Integer idAttivita) {
		this.idAttivita = idAttivita;
	}

	public Integer getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Integer idUtente) {
		this.idUtente = idUtente;
	}

	public Date getDataInizio() {
		return dataInizio;
	}

	public void setDataInizio(Date dataInizio) {
		this.dataInizio = dataInizio;
	}

	public Date getDataFine() {
		return dataFine;
	}

	public void setDataFine(Date dataFine) {
		this.dataFine = dataFine;
	}

	@Override
	public String toString() {
		return "ID=" + id + "\tID attività=" + idAttivita + "\tID Utente=" + idUtente + "\tData inizio=" + dataInizio
				+ "\tData fine=" + dataFine;
	}

}
