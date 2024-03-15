package bankapp;

import java.util.Scanner;

public class Blik extends Transakcja implements Info{
	private String nrTel;
	private int kodBlik;
	
	public Blik(String typ, double kwota, String nrTel, User odbiorca, User nadawca) {
		super(typ,kwota, odbiorca, nadawca);
		this.setnrTel(nrTel);
	}

	public String getKod() {
		return nrTel;
	}

	public void setnrTel(String nrTel) {
		this.nrTel = nrTel;
	}
	

	public boolean generujKodBlik() {
		int kod = (int)(Math.random()*9000)+1000;
		this.kodBlik = kod;
		System.out.println("Wprowadz kod BLIK: " + kod + " aby potwierdzic transakcje.");
		Scanner scanner = new Scanner(System.in);
		int kodWprowadzony = scanner.nextInt();
		
		if(kodWprowadzony==kod) {
		System.out.println("Prawidlowy kod.");
		return true;
		} else {
		System.out.println("Kod BLIK nieprawidlowy. Transakcja anulowana.");
		return false;
		}
		}

	@Override
	public void wyswietl() {
		//generujKodBlik();
		System.out.println("Numer telefonu odbiorcy: " + nrTel);
	}
	
}
