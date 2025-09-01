import java.sql.Connection;
import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int id,choice;
        String name,address,email,phoneNumber;

        PhoneBook phoneBook=new PhoneBook(5);
        System.out.println("------------------------------Phonebook Management System ----------------------------------");

        Scanner scanner=new Scanner(System.in);
        do{
            System.out.println("--------------------------------------------------------------------------");
            System.out.println("1. Add Contact");
            System.out.println("2. Delete Contact");
            System.out.println("3. View All Contacts");
            System.out.println("4. Update Contacts");
            System.out.println("5. Sort Contacts by Name");
            System.out.println("6. Search Contact by Name");
            System.out.println("7. Search Contact by Phone Number");
            System.out.println("8.Display Favorites");
            System.out.println("9. Exit");
            System.out.println("Enter an option from menu: ");
            choice=scanner.nextInt();
            switch (choice){
                case 1:
                {
                    while (true) {
                        try {
                            System.out.println("Enter Contact ID: (numeric)");
                            id = scanner.nextInt();
                            scanner.nextLine(); // Consume newline left by nextInt()
                            break; // Break out of the loop if valid input is given
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input! Please enter a numeric value for the Contact ID.");
                            scanner.nextLine(); // Clear invalid input
                        }
                    }


                    System.out.println("Enter Contact Name: ");
                    name=scanner.nextLine();
                    System.out.println("Enter Address: ");
                    address=scanner.nextLine();
                    System.out.println("Enter Email Address: ");
                    email=scanner.nextLine();
                    System.out.println("Enter Phone Number: ");
                    phoneNumber=scanner.nextLine();
                    System.out.println("Is this contact a favorite? (true/false): ");
                    String isFavorite = scanner.nextLine();
                    Contacts contacts=new Contacts(id,name,phoneNumber,address,email,isFavorite);
                    phoneBook.insert(contacts);
                    break;
                }
                case 2:
                {
                    System.out.println("Enter id you want to Delete");
                    id=scanner.nextInt();
                    phoneBook.delete(id);
                    break;
                }
                case 3:
                {
                    System.out.println("---------------------------------------------- PHONEBOOK -----------------------------------------");
                    phoneBook.display();
                    System.out.println("--------------------------------------------------------------------------------------------");
                    break;
                }
                case 5:
                    phoneBook.sortContactsByName();
                    break;
                case 6:{
                    System.out.println("Enter name to search: ");
                    scanner.nextLine(); // Consume newline
                    name = scanner.nextLine();
                    phoneBook.searchByName(name);
                    break;}
                case 7:{
                    System.out.println("Enter phone number to search: ");
                    scanner.nextLine(); // Consume newline
                    phoneNumber = scanner.nextLine();
                    phoneBook.searchByPhoneNumber(phoneNumber);
                    break;}
                case 4: {
                    System.out.print("Enter Contact ID to update: ");
                    id = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    System.out.print("Enter new Name (or press Enter to skip): ");
                    name = scanner.nextLine();
                    System.out.print("Enter new Phone Number (or press Enter to skip): ");
                    phoneNumber = scanner.nextLine();
                    System.out.print("Enter new Address (or press Enter to skip): ");
                    address = scanner.nextLine();
                    System.out.print("Enter new Email Address (or press Enter to skip): ");
                    email = scanner.nextLine();

                    phoneBook.updateContact(id,
                            name.isEmpty() ? null : name,
                            phoneNumber.isEmpty() ? null : phoneNumber,
                            address.isEmpty() ? null : address,
                            email.isEmpty() ? null : email);
                    break;
                }
                case 8:{
                    phoneBook.displayFavorites();break;
                }
                case 9:
                {
                    System.out.println("Exiting. Good Bye");
                    break;
                }
                default:{
                    System.out.println("Invalid choice. Enter Again");
                    break;
                }
            }
        }while (choice!=9);




    }
}