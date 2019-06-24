import java.util.Scanner;

public class BankTeller {

  // small Bank initially holds four accounts.
  private static Bank bank = new Bank(4);

  public static void main(String[] args) {
    char command;
    int acct = 0;
    Scanner input = new Scanner(System.in);
    printMenu();
    do {
      // ask a user to choose a command
      System.out.println("\nPlease enter a command or type ?");
      command = input.nextLine().toLowerCase().charAt(0);

      switch (command) {
        case 'a': // add an Account
          System.out.print("Enter account holder name: ");
          String name = input.nextLine();
          BankAccount a = new BankAccount(name);
          if (bank.add(a)) System.out.print("\nBank Account successfully added.\n");
          else System.out.print("Bank Account not added. No duplicates please.\n");
          break;
        case 'b': // remove a BankAccount
          System.out.print("\nEnter account number: ");
          acct = Integer.parseInt(input.nextLine());
          if (bank.remove(bank.find(acct)))
            System.out.print("\nBank Account successfully removed.\n");
          else System.out.print("Bank Account not found. Cannot remove.\n");
          break;
        case 'c': // display the BankAccounts
          System.out.println(bank.toString());
          break;
        case 'd': // count the BankAccounts
          System.out.println("\nThere are " + bank.getCount() + " BankAccounts in the bank");
          break;
        case 'e': // sort the BankAccounts
          bank.sort();
          System.out.println("Accounts sorted.");
          break;
        case 'f': // update an account
          System.out.print("\nEnter account number: ");
          acct = Integer.parseInt(input.nextLine());
          BankAccount b = bank.find(acct);
          if (b == null) {
            System.out.print("Bank Account not found. Cannot update.\n");
            break;
          }

          int action = -1;
          while (action < 1 || action > 2) {
            System.out.print("\nEnter 1 for deposit or 2 for withdraw:");
            action = Integer.parseInt(input.nextLine());
          }
          System.out.println("Enter amount:");
          double amt = Double.parseDouble(input.nextLine());
          boolean result;
          if (action == 1) result = b.deposit(amt);
          else result = b.withdraw(amt);
          if (result) System.out.println("Transaction successful");
          else System.out.println("Transaction invalid");
          break;
        case '?':
          printMenu();
          break;
        case 'q':
          System.out.println("GOOD BYE!");
          break;
        default:
          System.out.println("Invalid Input");

      }

    } while (command != 'q');

    input.close();
  }



  // this method prints out the menu to a user
  // we put it here to keep the main method clean.
  public static void printMenu() {
    System.out.print("\nBank Teller Options\n" + "-----------------------------------\n"
        + "a: add an account to the bank\n" + "b: remove an account from the bank\n"
        + "c: display the accounts in the bank\n" + "d: count the accounts in the bank\n"
        + "e: sort the accounts in the bank\n" + "f: update an account in the bank\n"
        + "?: display the menu again\n" + "q: quit this program\n\n");

  } // end of the printMenu method



}