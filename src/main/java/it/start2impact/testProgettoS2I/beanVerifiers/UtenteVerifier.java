package it.start2impact.testProgettoS2I.beanVerifiers;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

import it.start2impact.testProgettoS2I.model.Utente;

public class UtenteVerifier implements BeanVerifier<Utente> {

	@Override
	public boolean verifyBean(Utente utente) throws CsvConstraintViolationException {
		if (utente.getCognome() == null || utente.getDataDiNascita() == null || utente.getDocumentoId() == null
				|| utente.getId() == null || utente.getIndirizzo() == null || utente.getNome() == null) {
			return false;
		}
		return true;
	}

}
