package bankapp;

import java.util.Scanner;
import java.util.ArrayList;



public class Main
{
    public static void main( String[] args) {
        boolean znak = true;
        boolean znak1 = true;
         
         User.userList = new ArrayList<User>();
         
         User u1 = new User("login", "haslo", 6700.0, "Pawel", "Mielnik","11111","22222");
         User u2 = new User("jkowalski01", "jan123", 6700.0, "Jan", "Kowalski","258376299","2315321252");
         User u3 = new User("anowak37", "nowak137", 2137.0, "Adam", "Nowak","724532532","6432525212");
         User u4 = new User("J0pekxd", "j0pek", 2.0, "Kamil", "Jopek","660321258","6793624687");
        
        
         Scanner x = new Scanner(System.in);
         do {
         System.out.println("Wybierz opcje:");
         System.out.println("1. Zaloguj sie");
         System.out.println("2. Stworz nowe konto");
         System.out.println("3. Zakoncz program");

         int opcja = x.nextInt();
         x.nextLine();
         if(opcja==1) {
        	 znak1 = true;  
        	 System.out.println("Podaj dane:");
        	 Scanner keyboard = new Scanner(System.in);
         
        	 do {  
             String user = keyboard.nextLine();
             String pass = keyboard.nextLine();
             
             User logged = User.login(user, pass);
                         
            if (logged != null) {
                znak = true;
                System.out.println("\nPrawidlowe dane, zostales zalogowany\n");
                for (int i = 0; i <= 1; ++i) {
                    i = 0;
                     Scanner scanner = new Scanner(System.in);
                    System.out.println("\nWitaj, " + logged);
                    System.out.println("1.Wyswietl saldo");
                    System.out.println("2.Przelew pieniedzy");
                    System.out.println("3.Historia twoich transakcji");
                    System.out.println("4.Zapisz wyciag do pliku");
                    System.out.println("5.Wyloguj sie");
                     String polecenie = scanner.nextLine();
                     
                    switch (polecenie) {
                        case "1": {
                            System.out.println("\nTwoje saldo wynosi: " + logged.saldo + "zl\n");
                            continue;
                        }
                        case "2": {
                        	Scanner sc = new Scanner(System.in);
                            System.out.println("Wybierz typ transakcji");
                            System.out.println("1.Przelew");
                            System.out.println("2.Blik");
                            System.out.println("3.Powrot");
                            int typ = sc.nextInt();
                            sc.nextLine();
                            if(typ==1) {
                            User.wyswietlListe();
                            System.out.println("\nPodaj numer konta");
                            String numerKonta=sc.nextLine();
                            User odbiorca = User.nrKonta(numerKonta);
                            System.out.println("Podaj tytul przelewu");
                            String tytul=sc.nextLine();
                            System.out.println("Podaj kwote");
                            double kwota=sc.nextDouble();
                            sc.nextLine();
                            
                            if(logged != odbiorca) { 
                            Przelew transakcja = new Przelew("Przelew", kwota, numerKonta, tytul, odbiorca, logged);
                            logged.dodajTransakcje(transakcja);
                            Transakcja.wyslijKwote(odbiorca,logged, kwota,transakcja);
                            }
                            else {
                            	System.out.println("Nie mozesz wykonac transakcji do siebie samego.");
                            }
                            }
                            else if(typ==2) {
                            	User.wyswietlListe();
                                System.out.println("\nPodaj numer telefonu");
                                String tel=sc.nextLine();
                                User odbiorca = User.nrTel(tel);
                                System.out.println("Podaj kwote");
                                double kwota=sc.nextDouble();
                                sc.nextLine();
                                
                                if(logged != odbiorca) {
                                Blik transakcja = new Blik("Blik", kwota, tel, odbiorca, logged);
                                logged.dodajTransakcje(transakcja);
                                Transakcja.wyslijKwote(odbiorca,logged,kwota,transakcja);
                                }
                                else {
                                	System.out.println("Nie mozesz wykonac transakcji do siebie samego.");
                                }
                            }
                            else if(typ==3) {
                            	System.out.println("");
                            }
                            else
                            	 System.out.println("Nie ma takiej opcji");
                            
                            continue;
                        }
                        case "3": {
                        	logged.odczytajTransakcje();
                            continue;
                        }
                        case "4": {
                        	logged.zapiszTransakcje();
                            continue;
                        }
                        case "5": {
                            ++i;
                            System.out.println("\nWylogowano cie");
                            znak = false;
                            continue;
                        }
                        default:
                            break;
                    }
                    System.out.println("Nie ma takiej opcji");
                }
            }
            else{
            	System.out.println("Bledne dane logowania");
            }
        } while (znak);
      }
         else if(opcja==2) {
        	 znak1 = true;
        	 User nowyUzytkownik = new User();
        	 nowyUzytkownik.utworzUzytkownika();
         }
         else if(opcja==3) {
        	 znak1 = false;
        	 System.out.println("Do widzenia!");
         }
         else
         System.out.println("Wybrano nieprawidlowe opcje. Sprobuj ponownie.");
         
    }while(znak1);
    }
}
