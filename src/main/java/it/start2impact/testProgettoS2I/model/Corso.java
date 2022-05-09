package it.start2impact.testProgettoS2I.model;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class Corso {

	@CsvBindByPosition(position = 0)
	private Integer id;
	@CsvBindByPosition(position = 1)
	private String nome;
	@CsvBindByPosition(position = 2)
	private String descrizione;
	@CsvBindByPosition(position = 3)
	@CsvDate(value = "dd/MM/yyyy")
	private Date data;
	@CsvBindByPosition(position = 4)
	private Integer durata;
	@CsvBindByPosition(position = 5)
	private String luogo;
	@CsvBindByPosition(position = 6)
	private String disponibile;

	public Corso() {

	}

	public Corso(Integer id, String nome, String descrizione, Date data, Integer durata, String luogo,
			String disponibile) {
		super();
		this.id = id;
		this.nome = nome;
		this.descrizione = descrizione;
		this.data = data;
		this.durata = durata;
		this.luogo = luogo;
		this.disponibile = disponibile;
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

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Integer getDurata() {
		return durata;
	}

	public void setDurata(Integer durata) {
		this.durata = durata;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public String getDisponibile() {
		return disponibile;
	}

	public void setDisponibile(String disponibile) {
		this.disponibile = disponibile;
	}

	@Override
	public String toString() {
		return "ID=" + id + "\tNome=" + nome + "\tDescrizione=" + descrizione + "\tData=" + data + "\tDurata=" + durata
				+ "\tLuogo=" + luogo + "\tDisponibile=" + disponibile;
	}

}
