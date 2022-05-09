package it.start2impact.testProgettoS2I.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import it.start2impact.testProgettoS2I.exception.NumberOutOfRangeException;
import it.start2impact.testProgettoS2I.service.CsvService;

public class Utils {

	public static Boolean getChoice(Scanner input, String label) {
		do {
			System.out.println(label + " y/n");
			String choice = input.nextLine();
			if (choice.equalsIgnoreCase("y")) {
				return true;
			} else if (choice.equalsIgnoreCase("n")) {
				return false;
			}
		} while (true);
	}

	public static Integer getNum(Scanner input) {
		Integer num = null;

		do {
			try {
				num = Integer.parseInt(input.nextLine());
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Dovevi digitare un numero!");
			}
		} while (true);
	}

	public static Integer getNum(Scanner input, Integer start, Integer limit) {

		Integer num = null;

		do {
			try {
				num = Integer.parseInt(input.nextLine());
				checkRange(num, start, limit);
				return num;
			} catch (NumberFormatException e) {
				System.out.println("Dovevi digitare un numero!");
			} catch (NumberOutOfRangeException e) {
				System.out.println(e.getMessage());
			}
		} while (true);

	}

	private static void checkRange(Integer num, Integer start, Integer limit) throws NumberOutOfRangeException {
		if (num < start || num > limit) {
			throw new NumberOutOfRangeException(
					"\nErrore! Il numero inserito non è compreso tra " + start + " e " + limit + "\n", null);
		}
	}

	public static String getString(Scanner input, String label) {
		System.out.println(label);
		do {
			String string = input.nextLine();
			if (!string.isEmpty()) {
				return string;
			}
		} while (true);
	}

	public static Date getDate(Scanner input, String label) {
		System.out.println(label);
		do {
			String dateString = input.nextLine();
			try {
				Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dateString);
				return date;
			} catch (ParseException e) {
				System.out.println("Il formato della data non è valido, riprova!");
			}
		} while (true);
	}

	public static Integer getIdUtente(Scanner input, CsvService service, String label) {
		System.out.println(label);
		service.getUtenti().forEach(System.out::println);
		Integer idUtenteSelezionato = Utils.getNum(input, 1, service.getUtenti().size());
		return idUtenteSelezionato;
	}
}
