package it.start2impact.testProgettoS2I.beanVerifiers;

import com.opencsv.bean.BeanVerifier;
import com.opencsv.exceptions.CsvConstraintViolationException;

import it.start2impact.testProgettoS2I.model.Corso;

public class CorsoVerifier implements BeanVerifier<Corso> {

	@Override
	public boolean verifyBean(Corso corso) throws CsvConstraintViolationException {
		if (corso.getData() == null || corso.getDescrizione() == null || corso.getDisponibile() == null
				|| corso.getDurata() == null || corso.getId() == null || corso.getLuogo() == null
				|| corso.getNome() == null || corso.getNome().isEmpty()) {
			return false;
		}
		return true;
	}

}
