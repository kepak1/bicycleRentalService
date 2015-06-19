/*
 * 
 */
package pl.ftims.zaawJava.LogicTest;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import pl.ftims.zaawJava.Entities.*;

// TODO: Auto-generated Javadoc
/**
 * ReportGenerator zajmuje sie generowaniem raportow do pliku .txt
 */
public class ReportGenerator {

	/**
	 * Generuje zestawienie platnosci dla wydarzen i wypozyczen. Zawiera liste
	 * przechowujaca dane wartosci.
	 * 
	 * @param zd
	 *            lista wydarzen
	 * @param wyp
	 *            lista wypozyczen
	 */
	public void generatePaymentsReport(ArrayList<Zdarzenie> zd,
			ArrayList<Wypozyczenie> wyp) {
		ArrayList<Double> values = new ArrayList<Double>();
		for (Zdarzenie z : zd) {
			values.add(z.getWartosc());
		}
		for (Wypozyczenie w : wyp) {
			values.add(w.getWartosc());
		}
		try {
			PrintStream out = new PrintStream(new FileOutputStream(
					"Raport_Finansowy.txt"));
			out.println("\n--==RAPORT FINANSOWY==--\n");
			out.println("\nWszystkie zdarzenia\n");

			for (int i = 0; i < values.size(); i++) {
				out.println(values.get(i).toString());
			}
			out.println("\n--==Bilans==--\n");
			Integer plus = 0;
			Integer minus = 0;
			Double suma = 0.0;
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) < 0) {
					plus++;
				} else {
					minus++;
				}
			}
			for (int i = 0; i < values.size(); i++) {
				suma = suma + values.get(i);
			}
			out.println("\nPozycji z zyskiem: \n" + plus.toString());
			out.println("\nPozycji ze strata: \n" + minus.toString());
			out.println("\nRazem bilans: \n" + suma.toString() + "PLN");
			out.close();
			JOptionPane.showMessageDialog(null,
					"Zapisano do Raport_Finansowy.txt", "Zakonczono!",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Generate payments report.
	 *
	 * @param zd lista zdarzen z ktorej generujemy raport
	 * @param wyp lista wypozyczen z ktorej generujemy raport
	 * @param from data poczatkowa
	 * @param to data koncowa
	 */
	public void generatePaymentsReport(ArrayList<Zdarzenie> zd,
			ArrayList<Wypozyczenie> wyp, Date from, Date to) {
		ArrayList<Double> values = new ArrayList<Double>();
		Date tmp;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			for (Zdarzenie z : zd) {
				tmp = format.parse(z.getData());
				if (tmp.after(from) && tmp.before(to)) {
					values.add(z.getWartosc());
				}
			}
			for (Wypozyczenie w : wyp) {
				tmp = format.parse(w.getData_wyp());
				if (tmp.after(from) && tmp.before(to)) {
					values.add(w.getWartosc());
				}
			}
			PrintStream out = new PrintStream(new FileOutputStream(
					"Raport_Finansowy okres " + format.format(from) + " - " + format.format(to) + ".txt"));
			out.println("\n--==RAPORT FINANSOWY==--\n");
			out.println("\nWszystkie zdarzenia\n");

			for (int i = 0; i < values.size(); i++) {
				out.println(values.get(i).toString());
			}
			out.println("\n--==Bilans==--\n");
			Integer plus = 0;
			Integer minus = 0;
			Double suma = 0.0;
			for (int i = 0; i < values.size(); i++) {
				if (values.get(i) < 0) {
					plus++;
				} else {
					minus++;
				}
			}
			for (int i = 0; i < values.size(); i++) {
				suma = suma + values.get(i);
			}
			out.println("\nPozycji z zyskiem: \n" + plus.toString());
			out.println("\nPozycji ze strata: \n" + minus.toString());
			out.println("\nRazem bilans: \n" + suma.toString() + "PLN");
			out.close();
			JOptionPane.showMessageDialog(null,
					"Uko�czono Raport Finansowy", "Zakonczono!",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		} catch (ParseException e) {
			JOptionPane.showMessageDialog(null, e.toString(),
					"Blad podczas parsowania!", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
	}

	/**
	 * Generuje statystyki dla wybranego roweru
	 * 
	 * @param wyp
	 *            lista wypozyczen
	 * @param rowery
	 *            lista rowerow
	 * @param nr_roweru
	 *            numer wybranego roweru, dla ktorego chcemy utworzyc raport
	 */
	public void generateStats(ArrayList<Wypozyczenie> wyp,
			ArrayList<Bicycles> rowery, int nr_roweru) {
		try {
			PrintStream out = new PrintStream(new FileOutputStream(
					"Raport_Roweru_nr_" + nr_roweru + ".txt"));
			out.println("\n--==RAPORT FINANSOWY==--\n");
			out.println("\nDla roweru nr " + nr_roweru + "\n");
			Double suma = 0.0;
			for (Wypozyczenie w : wyp) {
				if (w.getRower() == nr_roweru) {
					suma = suma + w.getWartosc();
					out.println("\nWartosc wypozyczenia ");
					out.println(w.getWartosc().toString());
					out.println("RAZEM:" + suma.toString());
				}
				JOptionPane.showMessageDialog(null,
						"Zapisano do Raport_Roweru_nr_" + nr_roweru + ".txt",
						"Zakonczono!", JOptionPane.INFORMATION_MESSAGE);
				out.close();
			}

		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
