package bankapp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class User
{
    String login;
    private String password;
    double saldo;
    String imie;
    String nazwisko;
    String nrTelefonu;
    String nrKonta;
    static List<User> userList;
    static List<Transakcja> transakcje;
    
    
    public User(String login,String password,double saldo,String imie,String nazwisko, String nrTelefonu, String nrKonta) {
        this.login = login;
        this.password = password;
        this.saldo = saldo;
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.nrTelefonu = nrTelefonu;
        this.nrKonta = nrKonta;
        userList.add(this);
        this.transakcje = new ArrayList<Transakcja>();
    }

    public User() {
	}



	static public void wyswietlListe() {
    	for(int i=0; i<userList.size();i++)
        System.out.println(userList.get(i).login + "- nrKonta: " + userList.get(i).nrKonta + " nrTelefonu: " + userList.get(i).nrTelefonu);
    }
    
    static public User login(String login, String password) {
    	

        for(int i=0; i<userList.size();i++)
        {
       	 	if (login.equals(User.userList.get(i).login) && password.equals(User.userList.get(i).password)) {
	       		 return userList.get(i);
       	 	}
        }	
            return null;
    	
    }

    
    static public User nrTel(String tel) {
        
        for(int i=0; i<userList.size();i++)
        {
       	 
       	 	if (tel.equals(User.userList.get(i).nrTelefonu)){
	       		 return userList.get(i);
       	 	}
        }	
        
        return null;
    	
    }
    
    static public User nrKonta(String numerKonta) {
        
        for(int i=0; i<userList.size();i++)
        {
       	 
       	 	if (numerKonta.equals(User.userList.get(i).nrKonta)){
	       		 return userList.get(i);
       	 	}
        }	
        
        return null;
    	
    }
    
    public void dodajTransakcje(Transakcja transakcja) {
        transakcje.add(transakcja);
    }
    
    public void zapiszTransakcje() {
    	if(transakcje.isEmpty())
    	{
    		System.out.println("Nie wykonano zadnych transakcji, ktore mozna by zapisac.");
    	}
    	else {
        try {
            FileWriter fw = new FileWriter("transakcje_"+this.login + ".txt");
            for(Transakcja t : transakcje) {
            	fw.write("\n-----------------------------------------------------------------\n");
                fw.write(t.toString() + "\n");
                fw.write("-----------------------------------------------------------------");
            }
            fw.close();
            System.out.println("Transakcje zapisano do pliku transakcje_" + this.login + ".txt");
        } catch (IOException e) {
        	System.out.println("Plik nie zostal znaleziony");
            e.printStackTrace();
        }
    	}
    }
    
    public void odczytajTransakcje() {
    	System.out.println("Historia twoich transakcji:");
    	String filename = "transakcje_"+ this.login +".txt";
        try {
            Scanner scan = new Scanner(new File(filename));
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                System.out.println(line);
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Plik nie zostal znaleziony");
            e.printStackTrace();
        }
    }
    
    public void utworzUzytkownika() {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Podaj login:");
    	String login = sc.nextLine();
    	for (User u : User.userList) {
            if (u.login.equals(login)) {
                System.out.println("Podany login jest juz zajety. Prosze podaj inny login.");
                return;
            }
        }
    	System.out.println("Podaj haslo:");
    	String haslo = sc.nextLine();
    	System.out.println("Podaj saldo poczatkowe:");
    	double saldo = sc.nextDouble();
    	sc.nextLine();
    	System.out.println("Podaj imie:");
    	String imie = sc.nextLine();
    	System.out.println("Podaj nazwisko:");
    	String nazwisko = sc.nextLine();
    	System.out.println("Podaj numer konta:");
    	String numerKonta = sc.nextLine();
    	System.out.println("Podaj numer telefonu:");
    	String numerTelefonu = sc.nextLine();
    	User nowyUzytkownik = new User(login, haslo, saldo, imie, nazwisko,  numerTelefonu, numerKonta);
    	System.out.println("Konto zostalo utworzone!");
    	}
        
    @Override
    public String toString() {
        return this.imie + " " + this.nazwisko;
    }
    
}