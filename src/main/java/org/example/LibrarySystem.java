package org.example;

import org.example.service.LibraryService;

import java.util.Scanner;

public class LibrarySystem {

    public static void main(String[] args) {
        LibraryService service = new LibraryService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Book");
            System.out.println("2. Register Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. Display Books");
            System.out.println("6. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Book ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    service.addBook(id, title, author);
                }
                case 2 -> {
                    System.out.print("Member ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Name: ");
                    String name = scanner.nextLine();
                    service.registerMember(id, name);
                }
                case 3 -> {
                    System.out.print("Book ID: ");
                    service.issueBook(scanner.nextLine());
                }
                case 4 -> {
                    System.out.print("Book ID: ");
                    service.returnBook(scanner.nextLine());
                }
                case 5 -> service.displayBooks();
                case 6 -> System.exit(0);
                default -> System.out.println("Invalid choice");
            }
        }
    }
}
