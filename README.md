# BankApp
This is OOP app that enables managing user accounts and performing various operations on those accounts, such as balance check or money transfers via terminal.
## Usage
- `git clone https://github.com/Rezmii/bank-app.git`

- `java -cp bin bankapp.Main`
## Class Descriptions

1. `Main`: A class containing the `main` method, which is the entry point to the program.

2. `User`: A class representing a user. It contains methods for logging in, creating a new user, and managing transactions.

3. `Przelew`: A class inheriting from `Transakcja`, representing a transfer transaction.

4. `Blik`: A class inheriting from `Transakcja`, representing a Blik transaction.

5. `Transakcja`: An abstract class representing a financial transaction. It contains methods for processing transactions.
## Sample Input and Output
### An example of logging in:
![image](https://github.com/Rezmii/bank-app/assets/151035243/187a9d1f-ce79-4e8a-b626-cba5dd81ec67)

You can log in using an existing User object or create a new account.

![image](https://github.com/Rezmii/bank-app/assets/151035243/df0d3334-98d8-4ec6-969d-c3f1888c1749)

After logging in, the main menu with available options is displayed.

### An example of money transfer:
![image](https://github.com/Rezmii/bank-app/assets/151035243/c831adc0-b7f3-4aac-8a39-c98c6bc99552)

After selecting the transfer option, you can choose the type of transfer. In this case, BLIK has been selected. 

![image](https://github.com/Rezmii/bank-app/assets/151035243/e3b015aa-1fff-4f30-97aa-225b233470ee)

BLIK requires entering the recipient's phone number and inputting a randomly generated code.

When everything is entered correctly, the transfer is executed, and the account balances of the users are updated accordingly.


