/*
 * 
 */
package pl.ftims.zaawJava.LogicTest;

import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import pl.ftims.zaawJava.Entities.*;
import pl.ftims.zaawJava.DAO.*;
import pl.ftims.zaawJava.View.*;
/**
 * Controller zajmuje sie operacjami na zbiorze danych
 */
public class Controller {

	/** Przechowuje listy obiektow typow Klient,Rower,Wypozyczenie,Zdarzenie */
	private ListWrapper lists = new ListWrapper();

	/** Sciezka do pliku bazy danych */
	private String path = new File("Database.mdb").getAbsolutePath();

	/** Obiekt bazy danych */
	private Database db;

	/** Obiekt okna glownego */
	private MainWindow mw;

	/** Zwraca liste klientow z wrappera */
	public ArrayList<Client> getClients() {
		return lists.getKlienci();
	}

	public void setClients(ArrayList<Client> klienci) {
		lists.setKlienci(klienci);
	}

	/** Zwraca liste rowerow z wrappera */
	public ArrayList<Bicycles> getBicycles() {
		return lists.getBicycles();
	}

	public void setBicycles(ArrayList<Bicycles> rowery) {
		lists.setBicycles(rowery);
	}

	/** Zwraca liste wypozyczen z wrappera */
	public ArrayList<Rent> getRent() {
		return lists.getRents();
	}

	public void setRent(ArrayList<Rent> wypozyczenia) {
		lists.setRents(wypozyczenia);
	}

	/** Zwraca liste zdarzen z wrappera */
	public ArrayList<Zdarzenie> getEvents() {
		return lists.getEvents();
	}

	public void setEvents(ArrayList<Zdarzenie> zdarzenia) {
		lists.setEvents(zdarzenia);
	}

	/**
	 * Tworzy nowy kontroler
	 * 
	 * @param d
	 *            baza danych
	 * @param w
	 *            okno glowne
	 */
	public Controller(Database d, MainWindow w) {
		this.db = d;
		this.mw = w;
		mw.button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mw.textField_1.getText().equals("")
						|| mw.textField_2.getText().equals("")
						|| mw.textField_3.getText().equals("")
						|| mw.textField_4.getText().equals("")
						|| mw.textField_5.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Pola nie moga byc puste!", "Blad",
							JOptionPane.ERROR_MESSAGE);

				} else {
					addClient();
					mw.comboBox.removeAllItems();
					loadComboBoxItems(lists.getKlienci(), mw.comboBox);
				}
			}
		});

		mw.button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveClients(lists.getKlienci(), path);
				update(db);
				mw.comboBox.removeAllItems();
				loadComboBoxItems(lists.getKlienci(), mw.comboBox);
			}
		});

		// mw.button_2.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		//
		// int selected = mw.comboBox.getSelectedIndex();
		// int temp = selected;
		// listy.removeItem(listy.getKlienci(), selected);
		// JOptionPane.showMessageDialog(null, "Usunieto z pozycji "
		// + (selected), "Operacja zakonczona",
		// JOptionPane.INFORMATION_MESSAGE);
		// selected = temp;
		// mw.comboBox.removeAllItems();
		// loadComboBoxItems(listy.getKlienci(), mw.comboBox);
		// }
		// });
//		mw.button_5.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//
//				int selected = mw.comboBox_1.getSelectedIndex();
//				int temp = selected;
//				db.usunRower(listy.getRowery().get(selected), path);
//				listy.removeItem(listy.getRowery(), selected);
//				JOptionPane.showMessageDialog(null, "Usunieto z pozycji "
//						+ (selected), "Operacja zakonczona",
//						JOptionPane.INFORMATION_MESSAGE);
//				selected = temp;
//				mw.comboBox_1.removeAllItems();
//				loadComboBoxItems(listy.getRowery(), mw.comboBox_1);
//			}
//		});
		mw.button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveBicycles(lists.getBicycles(), path);
				update(db);
				mw.comboBox_1.removeAllItems();
				loadComboBoxItems(lists.getBicycles(), mw.comboBox_1);
			}
		});
		mw.button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mw.textField_6.getText().equals("")
						|| mw.textField_7.getText().equals("")
						|| mw.textField_8.getText().equals("")
						|| mw.comboBox_2.getSelectedIndex() < 0
						|| mw.textField_10.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Pola nie moga byc puste!", "Blad",
							JOptionPane.ERROR_MESSAGE);

				} else {
					addBicycle();
					mw.comboBox_1.removeAllItems();
					loadComboBoxItems(lists.getBicycles(), mw.comboBox_1);
				}
			}
		});
		// mw.button_8.addActionListener(new ActionListener() {
		// public void actionPerformed(ActionEvent arg0) {
		//
		// int selected = mw.comboBox_3.getSelectedIndex();
		// int temp = selected;
		// listy.removeItem(listy.getWypozyczenia(), selected);
		// JOptionPane.showMessageDialog(null, "Usunieto z pozycji "
		// + (selected), "Operacja zakonczona",
		// JOptionPane.INFORMATION_MESSAGE);
		// selected = temp;
		// mw.comboBox_3.removeAllItems();
		// loadComboBoxItems(listy.getWypozyczenia(), mw.comboBox_3);
		// }
		// });

		mw.button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveRents(lists.getRents(), path);
				update(db);
				mw.comboBox_3.removeAllItems();
				loadComboBoxItems(lists.getRents(), mw.comboBox_3);
			}
		});

		mw.button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mw.textField_9.getText().equals("")
						|| mw.textField_11.getText().equals("")
						|| mw.textField_12.getText().equals("")
						|| mw.textField_13.getText().equals("")
						|| mw.textField_14.getText().equals("")
						|| mw.textField_15.getText().equals("")
						|| mw.textField_16.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Pola nie moga byc puste!", "Blad",
							JOptionPane.ERROR_MESSAGE);

				} else {
					addRent();
					mw.comboBox_3.removeAllItems();
					loadComboBoxItems(lists.getRents(), mw.comboBox_3);
				}
			}
		});
		mw.button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (mw.textField_17.getText().equals("")
						|| mw.textField_19.getText().equals("")
						|| mw.textField_20.getText().equals("")) {
					JOptionPane.showMessageDialog(null,
							"Pola nie moga byc puste!", "Blad",
							JOptionPane.ERROR_MESSAGE);

				} else {
					
					addEvent();
					mw.comboBox_4.removeAllItems();
					loadComboBoxItems(lists.getEvents(), mw.comboBox_4);
				}
			}
		});
		mw.button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				db.saveEvents(lists.getEvents(), path);
				update(db);
				mw.comboBox_4.removeAllItems();
				loadComboBoxItems(lists.getEvents(), mw.comboBox_4);
			}
		});
		mw.button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int selected = mw.comboBox_4.getSelectedIndex();
				int temp = selected;
				db.deleteEvents(lists.getEvents().get(selected), path);
				lists.removeItem(lists.getEvents(), selected);
				JOptionPane.showMessageDialog(null, "Usunieto z pozycji "
						+ (selected), "Operacja zakonczona",
						JOptionPane.INFORMATION_MESSAGE);
				selected = temp;
				mw.comboBox_4.removeAllItems();
				loadComboBoxItems(lists.getEvents(), mw.comboBox_4);
			}
		});
		mw.mntmWczytajBazeDanych.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int returnVal = mw.files.showOpenDialog(null);
				if (returnVal == JFileChooser.APPROVE_OPTION) {
					path = mw.files.getSelectedFile().getAbsolutePath();
					db.initDatabase(path);
					loadData(db);

				}
			}
		});
		mw.comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selected = mw.comboBox.getSelectedIndex();
					updateClientsView(selected);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					updateClientsView(0);
				}
			}
		});
		mw.comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selected = mw.comboBox_1.getSelectedIndex();
					updateBicyclesView(selected);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					updateBicyclesView(0);
				}
			}
		});
		mw.comboBox_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selected = mw.comboBox_3.getSelectedIndex();
					updateRentsView(selected);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					updateRentsView(0);
				}
			}
		});
		mw.comboBox_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					int selected = mw.comboBox_4.getSelectedIndex();
					updateEventsView(selected);
				} catch (java.lang.ArrayIndexOutOfBoundsException e) {
					updateEventsView(0);
				}
			}
		});
		mw.mntmZapiszDoXml.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				final XmlChooser newxml = new XmlChooser();
				newxml.btnOk.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent arg0) {
						if (newxml.chckbxKlienci.isSelected() == false
								&& newxml.chckbxRowery.isSelected() == false
								&& newxml.chckbxWypozyczenia.isSelected() == false
								&& newxml.chckbxZdarzenia.isSelected() == false) {
							JOptionPane.showMessageDialog(null,
									"Musisz wybrac przynajmniej jedno pole",
									"Blad!", JOptionPane.ERROR_MESSAGE);
						} else {

							if (newxml.chckbxKlienci.isSelected() == true) {
								try {
									XmlSerializer serializer = new XmlSerializer();
									serializer.serializeToXML("Klienci.xml",
											lists.getKlienci());
									JOptionPane
											.showMessageDialog(
													null,
													"Zapisano pomyslnie do Klienci.xml!",
													"Zakonczono",
													JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null,
											e.toString(), "Blad!",
											JOptionPane.ERROR_MESSAGE);
								}
							}
							if (newxml.chckbxRowery.isSelected() == true) {
								try {
									XmlSerializer serializer = new XmlSerializer();
									serializer.serializeToXML("Rowery.xml",
											lists.getBicycles());
									JOptionPane
											.showMessageDialog(
													null,
													"Zapisano pomyslnie do Rowery.xml!",
													"Zakonczono",
													JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null,
											e.toString(), "Blad!",
											JOptionPane.ERROR_MESSAGE);
								}
							}
							if (newxml.chckbxWypozyczenia.isSelected() == true) {
								try {
									XmlSerializer serializer = new XmlSerializer();
									serializer.serializeToXML(
											"Wypozyczenia.xml",
											lists.getRents());
									JOptionPane
											.showMessageDialog(
													null,
													"Zapisano pomyslnie do Wypozyczenia.xml!",
													"Zakonczono",
													JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null,
											e.toString(), "Blad!",
											JOptionPane.ERROR_MESSAGE);
								}
							}
							if (newxml.chckbxZdarzenia.isSelected() == true) {
								try {
									XmlSerializer serializer = new XmlSerializer();
									serializer.serializeToXML("Zdarzenia.xml",
											lists.getEvents());
									JOptionPane
											.showMessageDialog(
													null,
													"Zapisano pomyslnie do Zdarzenia.xml!",
													"Zakonczono",
													JOptionPane.INFORMATION_MESSAGE);
								} catch (Exception e) {
									JOptionPane.showMessageDialog(null,
											e.toString(), "Blad!",
											JOptionPane.ERROR_MESSAGE);
								}
							}
						}

					}
				});
			}
		});
		mw.button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selected = mw.comboBox_4.getSelectedIndex();
				lists.getEvents().get(selected)
						.setTytul(mw.textField_17.getText());
				lists.getEvents().get(selected)
						.setData(mw.textField_18.getText());
				lists.getEvents().get(selected)
						.setOpis(mw.textField_19.getText());
				lists.getEvents()
						.get(selected)
						.setWartosc(
								Double.parseDouble(mw.textField_20.getText()));
			}
		});
		mw.mntmMetal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIManager
							.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(mw);
			}
		});
		mw.mntmNimbus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIManager
							.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(mw);
			}
		});
		mw.mntmCd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(mw);
			}
		});
		mw.mntmWindows.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(mw);
			}
		});
		mw.mntmWindowsClassic.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					UIManager
							.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsClassicLookAndFeel");
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InstantiationException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(mw);
			}
		});

		mw.mntmWczytajZXml.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				JFileChooser deserializer = new JFileChooser();
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
						"Pliki XML", "xml");
				deserializer.setFileFilter(filter);
				int returnVal = deserializer.showOpenDialog(null);

				if (returnVal == JFileChooser.APPROVE_OPTION) {
					String filename = deserializer.getSelectedFile().getName();
					XmlSerializer serializer = new XmlSerializer();
					if (filename.equals("Klienci.xml")) {
						ArrayList<Client> temp = new ArrayList<Client>();
						try {
							temp = (ArrayList<Client>) serializer
									.deserializeFromXML("Klienci.xml");
							lists.clearList(lists.getKlienci());
							for (Client tmp : temp) {
								lists.addItem(lists.getKlienci(), tmp);
								;
							}
							updateClientsView(0);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.toString(),
									"Blad!", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (filename.equals("Rowery.xml")) {
						ArrayList<Bicycles> temp = new ArrayList<Bicycles>();
						try {
							temp = (ArrayList<Bicycles>) serializer
									.deserializeFromXML("Rowery.xml");
							lists.clearList(lists.getBicycles());
							for (Bicycles tmp : temp) {
								lists.addItem(lists.getBicycles(), tmp);
								;
							}
							updateBicyclesView(0);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.toString(),
									"Blad!", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (filename.equals("Wypozyczenia.xml")) {
						ArrayList<Rent> temp = new ArrayList<Rent>();
						try {
							temp = (ArrayList<Rent>) serializer
									.deserializeFromXML("Wypozyczenia.xml");
							lists.clearList(lists.getRents());
							for (Rent tmp : temp) {
								lists.addItem(lists.getRents(), tmp);
								;
							}
							updateRentsView(0);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.toString(),
									"Blad!", JOptionPane.ERROR_MESSAGE);
						}

					}
					if (filename.equals("Zdarzenia.xml")) {
						ArrayList<Zdarzenie> temp = new ArrayList<Zdarzenie>();
						try {
							temp = (ArrayList<Zdarzenie>) serializer
									.deserializeFromXML("Zdarzenia.xml");
							lists.clearList(lists.getEvents());
							for (Zdarzenie tmp : temp) {
								lists.addItem(lists.getEvents(), tmp);
								;
							}
							updateEventsView(0);
						} catch (Exception e) {
							JOptionPane.showMessageDialog(null, e.toString(),
									"Blad!", JOptionPane.ERROR_MESSAGE);
						}

					}

				}
			}
		});
		mw.mntmGenerujRaport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ReportGenerator report = new ReportGenerator();
				report.generatePaymentsReport(lists.getEvents(),
						lists.getRents());
			}
		});

		mw.mntmGenerujRaport2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Date from = new Date();
				Date to = new Date();

				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				try {
					from = format.parse(JOptionPane.showInputDialog(mw,
							"Podaj date poczatkowa w formacie yyyy-MM-dd"));
					to = format.parse(JOptionPane.showInputDialog(mw,
							"Podaj date koncowa w formacie yyyy-MM-dd"));
				} catch (ParseException e) {
					e.printStackTrace();
				}

				ReportGenerator report = new ReportGenerator();
				report.generatePaymentsReport(lists.getEvents(),
						lists.getRents(), from, to);
			}
		});

		mw.mntmGenerujRaportRoweru.addActionListener(new ActionListener() {
			int selected = 0;

			public void actionPerformed(ActionEvent arg0) {

				final RowerReport rreport = new RowerReport();
				loadComboBoxItems(lists.getBicycles(), rreport.comboBox);
				rreport.comboBox.addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						selected = rreport.comboBox.getSelectedIndex();
					}

				});
				rreport.btnOk.addActionListener(new ActionListener() {

					
					public void actionPerformed(ActionEvent arg0) {

						ReportGenerator report = new ReportGenerator();
						report.generateStats(lists.getRents(),
								lists.getBicycles(), selected);
					}

				});
			}
		});
	}

	/**
	 * Wczytuje dane z bazy danych do list zlokalizowanych w ListWrapper
	 * 
	 * @param db
	 *            baza danych
	 */
	public void loadData(Database db) {
		mw.comboBox.removeAllItems();
		mw.comboBox_1.removeAllItems();
		mw.comboBox_3.removeAllItems();
		mw.comboBox_4.removeAllItems();
		try {
			lists.setKlienci(new ArrayList<Client>(db.readClients(path)));
			lists.setBicycles(new ArrayList<Bicycles>(db.readBicycles(path)));
			lists.setRents(new ArrayList<Rent>(db
					.readRents(path)));
			lists.setEvents(new ArrayList<Zdarzenie>(db
					.readEvents(path)));
			initialUpdate();
			loadComboBoxItems(lists.getKlienci(), mw.comboBox);
			loadComboBoxItems(lists.getBicycles(), mw.comboBox_1);
			loadComboBoxItems(lists.getRents(), mw.comboBox_3);
			loadComboBoxItems(lists.getEvents(), mw.comboBox_4);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}

	}

	/*
	 * 
	 * 
	 */
	public void update(Database db) {
		try {
			lists.setKlienci(new ArrayList<Client>(db.readClients(path)));
			lists.setBicycles(new ArrayList<Bicycles>(db.readBicycles(path)));
			lists.setRents(new ArrayList<Rent>(db
					.readRents(path)));
			lists.setEvents(new ArrayList<Zdarzenie>(db
					.readEvents(path)));
			initialUpdate();
			loadComboBoxItems(lists.getKlienci(), mw.comboBox);
			loadComboBoxItems(lists.getBicycles(), mw.comboBox_1);
			loadComboBoxItems(lists.getRents(), mw.comboBox_3);
			loadComboBoxItems(lists.getEvents(), mw.comboBox_4);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.toString(), "Blad!",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	/**
	 * Wczytuje dane do pol okna glownego po uruchomieniu aplikacji
	 */
	public void initialUpdate() {
		mw.textField_1.setText(lists.getKlienci().get(0).getFirstName());
		mw.textField_2.setText(lists.getKlienci().get(0).getLastName());
		mw.textField_3.setText(lists.getKlienci().get(0).getAdress());
		mw.textField_4.setText(lists.getKlienci().get(0).getPESEL().toString());
		mw.textField_5.setText(lists.getKlienci().get(0).getComments());

		mw.textField_6.setText(lists.getBicycles().get(0).getModel());
		mw.textField_7.setText(lists.getBicycles().get(0).getSerialNumber());
		mw.textField_8.setText(lists.getBicycles().get(0).getMileAge()
				.toString());
		mw.textField_10.setText(lists.getBicycles().get(0).getComments());
		if (lists.getBicycles().get(0).getAvailable() == true) {
			mw.comboBox_2.setSelectedIndex(0);
		} else
			mw.comboBox_2.setSelectedIndex(1);

		mw.textField_9.setText(lists.getKlienci()
				.get(lists.getRents().get(0).getClient()).getFirstName()
				+ " "
				+ lists.getKlienci()
						.get(lists.getRents().get(0).getClient())
						.getLastName());
		mw.textField_11.setText(lists.getBicycles()
				.get(lists.getRents().get(0).getClient()).getModel());
		mw.textField_12.setText(lists.getRents().get(0).getStartDate());
		mw.textField_13.setText(lists.getRents().get(0).getStopDate());
		mw.textField_14.setText(lists.getRents().get(0).getComments());
		mw.textField_15.setText(lists.getRents().get(0).getValue()
				.toString());
		mw.textField_16.setText(lists.getRents().get(0).getPrice()
				.toString());

		mw.textField_17.setText(lists.getEvents().get(0).getTytul());
		mw.textField_18.setText(lists.getEvents().get(0).getData());
		mw.textField_20.setText(lists.getEvents().get(0).getWartosc()
				.toString());
		mw.textField_19.setText(lists.getEvents().get(0).getOpis());
	}

	/**
	 * Dodaje klienta do ArrayListy Klienci we wrapperze
	 */
	public void addClient() {
		ListWrapper.addItem(
				lists.getKlienci(),
				(new Client(null, mw.textField_1.getText(), mw.textField_2
						.getText(), mw.textField_3.getText(), Integer
						.parseInt(mw.textField_4.getText()), mw.textField_5
						.getText())));
		JOptionPane.showMessageDialog(null, "Dodano na pozycji "
				+ (lists.getKlienci().size() - 1), "Operacja zakonczona",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Dodaje rower do ArrayListy Rowery we wrapperze
	 */
	public void addBicycle() {
		ListWrapper
				.addItem(
						lists.getBicycles(),
						(new Bicycles(null, mw.textField_6.getText(),
								mw.textField_7.getText(), Integer
										.parseInt(mw.textField_8.getText()),
								checkComboBox(mw.comboBox_2), mw.textField_10
										.getText())));
		JOptionPane.showMessageDialog(null, "Dodano na pozycji "
				+ (lists.getBicycles().size() - 1), "Operacja zakonczona",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Dodaje wypozyczenie do ArrayListy Wypozyczenia we wrapperze
	 */
	public void addRent() {
		ListWrapper.addItem(
				lists.getRents(),
				(new Rent(null, Integer.parseInt(mw.textField_9
						.getText()),
						Integer.parseInt(mw.textField_11.getText()),
						mw.textField_12.getText(), mw.textField_13.getText(),
						Double.parseDouble(mw.textField_15.getText()), Double
								.parseDouble(mw.textField_16.getText()),
						mw.textField_14.getText())));
		JOptionPane.showMessageDialog(null, "Dodano na pozycji "
				+ (lists.getRents().size() - 1), "Operacja zakonczona",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Dodaje zdarzenie do ArrayListy Zdarzenia we wrapperze
	 */
	public void addEvent() {
		ListWrapper.addItem(
				lists.getEvents(),
				(new Zdarzenie(null, mw.textField_17.getText(), Double
						.parseDouble(mw.textField_20.getText()),
						mw.textField_19.getText())));
		JOptionPane.showMessageDialog(null, "Dodano na pozycji "
				+ (lists.getEvents().size() - 1), "Operacja zakonczona",
				JOptionPane.INFORMATION_MESSAGE);
	}

	/**
	 * Wczytuje do ComboBox kolejne ID elementow znajdujacych sie w ArrayLiscie.
	 * 
	 * @param <T>
	 *            typ ComboBox
	 * @param array
	 *            ArrayList z ktorej pobiera dane
	 * @param cbox
	 *            ComboBox w ktorym dodaje elementy
	 */
	public <T> void loadComboBoxItems(ArrayList<T> array, JComboBox<String> cbox) {
		int size = array.size();
		for (Integer i = 0; i < size; i++) {
			cbox.addItem(i.toString());
		}
	}

	/**
	 * Sprawdza czy rower jest dostepny czy nie
	 * 
	 * @param cbox
	 *            ComboBox w ktorym wybieram czy rower jest dostepny
	 */
	public boolean checkComboBox(JComboBox<String> cbox) {
		if (cbox.getSelectedIndex() == 0) {
			return true;
		}
		return false;
	}

	/**
	 * Odswieza stan zakladki Klienci
	 * 
	 * @param selected
	 *            wybrana pozycja JComboBox
	 */
	public void updateClientsView(int selected) {
		mw.textField_1.setText(lists.getKlienci().get(selected).getFirstName());
		mw.textField_2.setText(lists.getKlienci().get(selected).getLastName());
		mw.textField_3.setText(lists.getKlienci().get(selected).getAdress());
		mw.textField_4.setText(lists.getKlienci().get(selected).getPESEL()
				.toString());
		mw.textField_5.setText(lists.getKlienci().get(selected).getComments());
	}

	/**
	 * Odswieza stan zakladki wydarzenia
	 * 
	 * @param selected
	 *            wybrana pozycja JComboBox
	 */
	public void updateBicyclesView(int selected) {
		mw.textField_6.setText(lists.getBicycles().get(selected).getModel());
		mw.textField_7.setText(lists.getBicycles().get(selected).getSerialNumber());
		mw.textField_8.setText(lists.getBicycles().get(selected).getMileAge()
				.toString());
		mw.comboBox_2.setSelectedIndex(lists.getBicycles().get(selected)
				.getAvailableIndex());
		mw.textField_10.setText(lists.getBicycles().get(selected).getComments());
	}

	/**
	 * Odswieza stan zakladki wydarzenia
	 * 
	 * @param selected
	 *            wybrana pozycja JComboBox
	 */
	public void updateRentsView(int selected) {
		mw.textField_9.setText(lists.getRents().get(selected)
				.getClient().toString());
		mw.textField_11.setText(lists.getRents().get(selected)
				.getBicycle().toString());
		mw.textField_12.setText(lists.getRents().get(selected)
				.getStartDate().toString());
		mw.textField_13.setText(lists.getRents().get(selected)
				.getStopDate());
		mw.textField_15.setText(lists.getRents().get(selected)
				.getPrice().toString());
		mw.textField_16.setText(lists.getRents().get(selected)
				.getValue().toString());
		mw.textField_14.setText(lists.getRents().get(selected)
				.getComments());
	}

	/**
	 * Odswieza stan zakladki wydarzenia
	 * 
	 * @param selected
	 *            wybrana pozycja JComboBox
	 */
	public void updateEventsView(int selected) {
		mw.textField_17.setText(lists.getEvents().get(selected).getTytul());
		mw.textField_18.setText(lists.getEvents().get(selected).getData());
		mw.textField_20.setText(lists.getEvents().get(selected).getWartosc()
				.toString());
		mw.textField_19.setText(lists.getEvents().get(selected).getOpis());
	}
}
