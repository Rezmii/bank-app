package bankapp;

public class Przelew extends Transakcja implements Info{
	private String tytul;
	private String numerKonta;
	
	public Przelew(String typ, double kwota, String numerKonta, String tytul, User odbiorca, User nadawca) {
		super(typ, kwota, odbiorca, nadawca);
		this.setNumerKonta(numerKonta);
		this.setTytul(tytul);
		
		
	}
	public String getTytul() {
		return tytul;
	}
	public void setTytul(String tytul) {
		this.tytul = tytul;
	}
	
	public String getNumerKonta() {
		return numerKonta;
	}
	public void setNumerKonta(String numerKonta) {
		this.numerKonta = numerKonta;
	}
		
	@Override
	public void wyswietl() {
		System.out.println("Tytul przelewu: " + tytul);
		
	}
	
}
