package it.start2impact.testProgettoS2I.utils;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import it.start2impact.testProgettoS2I.exception.NumberOutOfRangeException;
import it.start2impact.testProgettoS2I.service.CsvService;

/**
 * Utilities for managing simple tasks like receiving a number or a string from
 * input. Every method has a while loop till the input inserted passes all the
 * controls.
 */

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

	public static String getPath(Scanner input, String label) {
		do {
			String path = getString(input, label);
			try {
				File folder = new File(path);
				if (folder.exists()) {
					return path;
				} else {
					System.out.println("Il percorso non esiste!");
				}
			} catch (Exception e) {
				System.out.println("Errore nella digitazione del percorso!");
			}
		} while (true);
	}
}
