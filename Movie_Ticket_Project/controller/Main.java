package controller;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import user.IStaff;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Cinema cinema = new Cinema("CADT Cinema", "Phnom Penh");
        cinema.seedStaff();
        // cinema.demoPolymorphism();

        int choice = -1;

        do {

            if (cinema.getLoggedInStaff() == null) {

                printMainMenu();

                System.out.print("Choose: ");
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter number.");
                    sc.nextLine();
                    continue;
                }
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
                        System.exit(0);

                    default:
                        System.out.println("Invalid choice.");
                }

            } else {

                IStaff staff = cinema.getLoggedInStaff();

                Map<Integer, String> actions = new LinkedHashMap<>();
                int option = 1;

                System.out.println("\n=== STAFF MENU ===");
                System.out.println("Logged in: " + staff);

                if (staff.can(Cinema.CREATE_MOVIE)) actions.put(option++, "CREATE_MOVIE");
                if (staff.can(Cinema.UPDATE_MOVIE)) actions.put(option++, "UPDATE_MOVIE");
                if (staff.can(Cinema.DELETE_MOVIE)) actions.put(option++, "DELETE_MOVIE");
                if (staff.can(Cinema.PRINT_MOVIES)) actions.put(option++, "CHECK_MOVIES");
                if (staff.can(Cinema.DISPLAY_MOVIE)) actions.put(option++, "DISPLAY_MOVIE");
                if (staff.can(Cinema.CREATE_CUSTOMER)) actions.put(option++, "CREATE_CUSTOMER");
                if (staff.can(Cinema.SELL_TICKET)) actions.put(option++, "SELL_TICKET");
                if (staff.can(Cinema.CHECK_TICKET)) actions.put(option++, "CHECK_TICKET");
                if (staff.can(Cinema.CANCEL_TICKET)) actions.put(option++, "CANCEL_TICKET");
                if (staff.can(Cinema.HANDLE_TICKET_ISSUE)) actions.put(option++, "HANDLE_TICKET_ISSUE");
                if (staff.can(Cinema.HANDLE_SYSTEM)) actions.put(option++, "HANDLE_SYSTEM");
                if (staff.can(Cinema.CREATE_STAFF)) actions.put(option++, "CREATE_STAFF");
                if (staff.can(Cinema.MANAGE_STAFF)) actions.put(option++, "MANAGE_STAFF");

                actions.put(option++, "LOGOUT");
                actions.put(option++, "EXIT");



                //print menu

                for (Map.Entry<Integer, String> entry : actions.entrySet()) {
                    System.out.println(entry.getKey() + ") " + entry.getValue());
                }
                System.out.print("Choose: ");
                try {
                    choice = sc.nextInt();
                } catch (Exception e) {
                    System.out.println("Invalid input. Enter number.");
                    sc.nextLine();
                    continue;
                }
                sc.nextLine();
                String action = actions.get(choice);
                if (action == null){
                    System.out.println("Invalid chice");
                    continue;
                }

                switch (action) {

                    case "CREATE_MOVIE": {
                        System.out.print("Movie ID: ");
                        String id = sc.nextLine();

                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Duration (Minutes): ");
                        int duration = Integer.parseInt(sc.nextLine());

                        System.out.print("Release Date (YY-MM-DD): ");
                        String date = sc.nextLine();

                        System.out.print("Genre: ");
                        String genre = sc.nextLine();

                        cinema.createMovie(id, title, duration, date, genre);
                        break;
                    }

                    case "UPDATE_MOVIE": {
                        System.out.print("Movie ID: ");
                        String id = sc.nextLine();

                        System.out.print("New Title: ");
                        String title = sc.nextLine();

                        cinema.updateMovie(id, title);
                        break;
                    }

                    case "DELETE_MOVIE": {
                        System.out.print("Movie ID: ");
                        String id = sc.nextLine();

                        cinema.deleteMovie(id);
                        break;
                    }

                    case "CHECK_MOVIES":
                        cinema.printMovies();
                        break;

                    case "DISPLAY_MOVIE": {
                        System.out.print("Movie ID: ");
                        String id = sc.nextLine();

                        cinema.displayMovie(id);
                        break;
                    }

                     case "CREATE_CUSTOMER": {
                        System.out.print("Name: ");
                        String name = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        cinema.createCustomer(name, email);
                        break;
                    }

                    case "SELL_TICKET": {
                        System.out.print("Ticket ID: ");
                        String tId = sc.nextLine();

                        System.out.print("Movie ID: ");
                        String mId = sc.nextLine();

                        System.out.print("Customer Name: ");
                        String name = sc.nextLine();

                        cinema.sellTicket(tId, mId, name);
                        break;
                    }

                    case "CHECK_TICKET":
                        cinema.checkTicket();
                        break;

                    case "CANCEL_TICKET": {
                        System.out.print("Ticket ID: ");
                        String id = sc.nextLine();

                        cinema.cancelTicket(id);
                        break;
                    }

                    case "HANDLE_TICKET_ISSUE": {
                        System.out.print("Ticket ID: ");
                        String id = sc.nextLine();

                        System.out.print("Issue: ");
                        String issue = sc.nextLine();

                        cinema.handleTicketIssue(id, issue);
                        break;
                    }

                    case "CREATE_STAFF": {
                        System.out.print("ID: ");
                        String id = sc.nextLine();

                        System.out.print("Username: ");
                        String username = sc.nextLine();

                        System.out.print("Fullname: ");
                        String fullname = sc.nextLine();

                        System.out.print("Password: ");
                        String password = sc.nextLine();

                        System.out.print("Email: ");
                        String email = sc.nextLine();

                        System.out.print("Phone: ");
                        String phone = sc.nextLine();

                        System.out.print("Position: ");
                        String position = sc.nextLine();

                        cinema.createStaff(id, username, fullname, password, email, phone, position);
                        break;
                    }
                    case "MANAGE_STAFF":
                        cinema.manageStaff();
                        break;

                    case "LOGOUT":
                        cinema.staffLogout();
                        break;

                    case "EXIT":
                        System.out.println("Goodbye!");
                        System.exit(0);
                }

                System.out.println(cinema.getLastMessage());
            }

        } while (true);
    }

    // =========================
    // MENUS
    // =========================
    private static void printMainMenu() {
        System.out.println("\n=== MAIN MENU (Not Logged In) ===");
        System.out.println("1) Staff Login");
        System.out.println("2) Check Movies");
        System.out.println("0) Exit");
    }
}