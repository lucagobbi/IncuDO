package it.start2impact.testProgettoS2I.beanVerifiers;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

import it.start2impact.testProgettoS2I.model.Prenotazione;

public class PrenotazioneVerifier implements BeanVerifier<Prenotazione> {

	@Override
	public boolean verifyBean(Prenotazione prenotazione) throws CsvConstraintViolationException {
		if (prenotazione.getDataFine() == null || prenotazione.getDataInizio() == null || prenotazione.getId() == null
				|| prenotazione.getIdAttivita() == null || prenotazione.getIdUtente() == null) {
			return false;
		}
		return true;
	}

}
