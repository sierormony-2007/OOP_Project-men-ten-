package controller;

import java.util.Scanner;
import user.IStaff;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema("CADT Cinema", "Phnom Penh");
        cinema.seedStaff();
        cinema.demoPolymorphism();

        int choice;

        do {

            if (cinema.getLoggedInStaff() == null) {

                printMainMenu();

                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: { // Login
                        System.out.print("Username: ");
                        String username = sc.nextLine();

                        System.out.print("Password: ");
                        String password = sc.nextLine();

                        cinema.staffLogin(username, password);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 2: { // View Movies
                        cinema.printMovies();
                        break;
                    }

                    case 0:
                        System.out.println("Goodbye!");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } else {

                printStaffMenu(cinema);

                System.out.print("Choose: ");
                choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                    case 1: { // Create Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Duration: ");
                        int duration = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Release Date: ");
                        String releaseDate = sc.nextLine();

                        System.out.print("Genre: ");
                        String genre = sc.nextLine();

                        cinema.createMovie(movieId, title, duration, releaseDate, genre);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 2: { // Update Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("New Title: ");
                        String newTitle = sc.nextLine();

                        cinema.updateMovie(movieId, newTitle);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 3: { // Delete Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        cinema.deleteMovie(movieId);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 4: { // Check Movies
                        cinema.checkMovies();
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 5: { // Display Movie
                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        cinema.displayMovie(movieId);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 6: { // Create Customer
                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        cinema.createCustomer(name, email);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 7: { // Sell Ticket
                        System.out.print("Ticket ID: ");
                        String ticketId = sc.nextLine();

                        System.out.print("Movie ID: ");
                        String movieId = sc.nextLine();

                        System.out.print("Customer Name: ");
                        String customerName = sc.nextLine();

                        cinema.sellTicket(ticketId, movieId, customerName);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 8: { // Check Ticket
                        cinema.checkTicket();
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 9: { // Cancel Ticket
                        System.out.print("Ticket ID: ");
                        String ticketId = sc.nextLine();

                        cinema.cancelTicket(ticketId);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 10: { // Handle Ticket Issue
                        System.out.print("Ticket ID: ");
                        String ticketId = sc.nextLine();

                        System.out.print("Issue: ");
                        String issue = sc.nextLine();

                        cinema.handleTicketIssue(ticketId, issue);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 11: { // Handle System
                        System.out.println("System handled (demo action).");
                        break;
                    }

                    case 12: { // Create Staff
                        System.out.print("Staff ID: ");
                        String id = sc.nextLine();

                        System.out.print("Username: ");
                        String username = sc.nextLine();

                        System.out.print("Full Name: ");
                        String fullname = sc.nextLine();

                        System.out.print("Password: ");
                        String password = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Position (manager/cashier/operator): ");
                        String position = sc.nextLine();

                        cinema.createStaff(id, username, fullname, password, email, phone, position);
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 13: { // Manage Staff
                        cinema.manageStaff();
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 14: { // Logout
                        cinema.staffLogout();
                        System.out.println(cinema.getLastMessage());
                        break;
                    }

                    case 15: { // Exit
                        System.out.println("Goodbye!");
                        choice = 0;
                        break;
                    }

                    default:
                        System.out.println("Invalid choice.");
                }
            }

        } while (choice != 0);

        sc.close();
    }

    // =========================
    // MENUS
    // =========================
    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU (Not Logged In) ===");
        System.out.println("1) Staff Login");
        System.out.println("2) View Movies");
        System.out.println("0) Exit");
    }

    private static void printStaffMenu(Cinema cinema) {
        System.out.println("\n=== STAFF MENU (Logged In) ===");
        System.out.println("Logged in staff: " + cinema.getLoggedInStaff());
        IStaff staff = cinema.getLoggedInStaff();
        int option = 1;
        if (staff.can(Cinema.CREATE_MOVIE))
            System.out.println(option++ + ") Create Movie");

        if (staff.can(Cinema.UPDATE_MOVIE))
            System.out.println(option++ + ") Update Movie");

        if (staff.can(Cinema.DELETE_MOVIE))
            System.out.println(option++ + ") Delete Movie");

        if (staff.can(Cinema.CHECK_MOVIES))
            System.out.println(option++ + ") Check Movies");

        if (staff.can(Cinema.DISPLAY_MOVIE))
            System.out.println(option++ + ") Display Movie");

        if (staff.can(Cinema.CREATE_CUSTOMER))
            System.out.println(option++ + ") Create Customer");

        if (staff.can(Cinema.SELL_TICKET))
            System.out.println(option++ + ") Sell Ticket");

        if (staff.can(Cinema.CHECK_TICKET))
            System.out.println(option++ + ") Check Ticket");

        if (staff.can(Cinema.CANCEL_TICKET))
            System.out.println(option++ + ") Cancel Ticket");

        if (staff.can(Cinema.HANDLE_TICKET_ISSUE))
            System.out.println(option++ + ") Handle Ticket Issue");

        if (staff.can(Cinema.HANDLE_SYSTEM))
            System.out.println(option++ + ") Handle System");

        if (staff.can(Cinema.CREATE_STAFF))
            System.out.println(option++ + ") Create Staff");

        if (staff.can(Cinema.MANAGE_STAFF))
            System.out.println(option++ + ") Manage Staff");

        System.out.println(option++ + ") Logout");
        System.out.println(option + ") Exit");
    }
}