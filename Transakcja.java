package bankapp;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;

public class Transakcja {
	private String typ;
	private double kwota;
	private User odbiorca, nadawca;
	Date data;
	
	
	public Transakcja(String typ, double kwota, User odbiorca, User nadawca) {
		this.setTyp(typ);
		this.setKwota(kwota);
		this.odbiorca = odbiorca;
		this.nadawca = nadawca;
		Date date = new Date();
		this.data=date;
		
	}
	
	public String toString() {
        return "Nadawca: " + nadawca + "\nOdbiorca: " + odbiorca +"\nTelefon: " + odbiorca.nrTelefonu +
        		"\nKwota: " + kwota + "z� na numer Konta: " + odbiorca.nrKonta + " wykonana poprzez: " + typ +"\nData: " + data;
    }
	

	
	public static void wybierzTyp(Transakcja transakcja) {
		if(transakcja instanceof Blik) {
			Blik blik = (Blik)transakcja;
				blik.wyswietl();
		} else if (transakcja instanceof Przelew) {
			Przelew przelew =(Przelew)transakcja;
				przelew.wyswietl();
		}
	}
	
	
	public static boolean wyslijKwote(User odbiorca, User nadawca, double kwota, Transakcja transakcja) {
		try {
	        if(kwota <= 0) {
	            throw new Exception("Kwota przelewu musi by� wi�ksza ni� 0");
	        }
	        else if(kwota > nadawca.saldo) {
	        throw new Exception("Nie masz wystarczaj�cych �rodk�w na koncie.");
	        }
	        else if(odbiorca == null) {
	        throw new Exception("Nie znaleziono takiego odbiorcy.");
	        }
	        else if(nadawca == odbiorca) {
		        throw new Exception("Nie mo�esz wykona� transakcji do siebie samego.");
		        }
	        
	        wybierzTyp(transakcja);
	        if(transakcja.typ=="Blik")
	        {
	        	if(((Blik) transakcja).generujKodBlik()) {
	        		 System.out.println("Transakcja przelewu BLIK zako�czona sukcesem");
	        		 przelew(odbiorca,nadawca,kwota,transakcja);
	        	}
	        	else {
	        		System.out.println("");
	        	}
	        }	
	        else if(transakcja.typ=="Przelew")
	        {
	        	przelew(odbiorca,nadawca,kwota,transakcja);
	        }
		return true;

	} catch (Exception e) {
		System.out.println(e.getMessage());
		return false;
		}
	}
	
	private static void przelew(User odbiorca, User nadawca, double kwota, Transakcja transakcja) {
		odbiorca.saldo=odbiorca.saldo+kwota;
		nadawca.saldo=nadawca.saldo-kwota;
		System.out.println("Wysylanie " + kwota + " z� na konto uzytkownika " + odbiorca.login +" za pomoc� transakcji typu " + transakcja.typ);
		System.out.println("Twoj stan konta obecnie wynosi: " + nadawca.saldo + "z�");
	}
	

	public double getKwota() {
		return kwota;
	}

	public void setKwota(double kwota) {
		this.kwota = kwota;
	}

	public String getTyp() {
		return typ;
	}

	public void setTyp(String typ) {
		this.typ = typ;
	}
}

