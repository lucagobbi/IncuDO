package it.start2impact.testProgettoS2I.model;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class Utente {

	@CsvBindByPosition(position = 0)
	private Integer id;
	@CsvBindByPosition(position = 1)
	private String nome;
	@CsvBindByPosition(position = 2)
	private String cognome;
	@CsvBindByPosition(position = 3)
	@CsvDate(value = "dd/MM/yyyy")
	private Date dataDiNascita;
	@CsvBindByPosition(position = 4)
	private String indirizzo;
	@CsvBindByPosition(position = 5)
	private String documentoId;

	public Utente() {

	}

	public Utente(Integer id, String nome, String cognome, Date dataDiNascita, String indirizzo, String documentoId) {
		super();
		this.id = id;
		this.nome = nome;
		this.cognome = cognome;
		this.dataDiNascita = dataDiNascita;
		this.indirizzo = indirizzo;
		this.documentoId = documentoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public Date getDataDiNascita() {
		return dataDiNascita;
	}

	public void setDataDiNascita(Date dataDiNascita) {
		this.dataDiNascita = dataDiNascita;
	}

	public String getIndirizzo() {
		return indirizzo;
	}

	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}

	public String getDocumentoId() {
		return documentoId;
	}

	public void setDocumentoId(String documentoId) {
		this.documentoId = documentoId;
	}

	@Override
	public String toString() {
		return "ID=" + id + "\tNome=" + nome + "\tCognome=" + cognome + "\tData di nascita=" + dataDiNascita
				+ "\tIndirizzo=" + indirizzo + "\tDocumento ID=" + documentoId;
	}

}
