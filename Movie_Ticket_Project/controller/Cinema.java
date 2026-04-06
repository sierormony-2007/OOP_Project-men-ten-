package controller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import other.Customer;
import other.Movie;
import other.Showtime;
import other.Ticket;
import user.CashierStaff;
import user.IStaff;
import user.Manager;
import user.OperatorStaff;
import user.Staff;

public class Cinema {

    // =========================
    // ACTION CONSTANTS
    // =========================

    // Movie actions

    public static final String CREATE_MOVIE = "CREATE_MOVIE";
    public static final String UPDATE_MOVIE = "UPDATE_MOVIE";
    public static final String DELETE_MOVIE = "DELETE_MOVIE";
    public static final String PRINT_MOVIES = "CHECK_MOVIES";
    public static final String DISPLAY_MOVIE = "DISPLAY_MOVIE";
    public static final String CREATE_CUSTOMER = "CREATE_CUSTOMER";
    public static final String CREATE_SHOWTIME = "CREATE_SHOWTIME";
    public static final String CHECK_SHOWTIME = "CHECK_SHOWTIME";
    // Ticket actons
    public static final String SELL_TICKET = "SELL_TICKET";
    public static final String CHECK_TICKET = "CHECK_TICKET";
    public static final String CANCEL_TICKET = "CANCEL_TICKET";

    // manager
    public static final String CREATE_STAFF = "CREATE_STAFF";
    public static final String MANAGE_STAFF = "MANAGE_STAFF";

    // BASIC INFO

    private String cinemaName;
    private String address;

    // DATA STORAGE (ArrayLists)

    private ArrayList<Staff> staffs = new ArrayList<>();
    private ArrayList<Movie> movies = new ArrayList<>();
    private ArrayList<Customer> customers = new ArrayList<>();
    private ArrayList<Showtime> showtimes = new ArrayList<>();
    private ArrayList<Ticket> tickets = new ArrayList<>();

    // LOGIN
    private int ticketCounter = 1;

    private IStaff loggedInStaff = null;

    // FEEDBACK MESSAGE

    private String lastMessage = "";

    // CONSTRUCTOR
    // =========================
    public Cinema(String cinemaName, String address) {
        setCinemaName(cinemaName);
        setAddress(address);

        lastMessage = "Cinema created. Default admin: admin / 1234";
    }

    @Override
    public String toString() {
        return "Cinema [cinemaName=" + cinemaName + ", address=" + address + ", staffs=" + staffs + ", customers="
                + customers + ", showTimes=" + showtimes + ",Ticket=" + tickets + ", loggedInStaff=" + loggedInStaff
                + ", lastMessage=" + lastMessage + "]";
    }
    // getters / setters

    public String getCinemaName() {
        return cinemaName;
    }

    public void setCinemaName(String cinemaName) {
        if (isBlank(cinemaName))
            this.cinemaName = "cinema";
        else
            this.cinemaName = cinemaName.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (isBlank(address)) {
            this.address = "UNKNOWN";
        } else {
            this.address = address.trim();
        }
    }

    public boolean isStafffLoggedIn() {
        return loggedInStaff != null;
    }

    public IStaff getLoggedInStaff() {
        return loggedInStaff;
    }

    public void setLastMessage(String lmsg) {
        lastMessage = lmsg;
    }

    public String getLastMessage() {
        return lastMessage;
    }

    // Test code

    public void seedStaff() {

        Staff m1 = new Manager("m00", "manager", "SIE RORMONY", "1234", "nii18102007@gmail.com",
                "0886477296", 5000.0, "70");
        // Manager manager = new Manager(managerStaff, "70");
        staffs.add(m1);

        Staff s1 = new Staff("m00", "manager_01", "SIE RORMONY", "sierormony_18102007", "nii18102007@gmail.com",
                "0886477296", 5000.0) {
            @Override
            public boolean can(String action) {
                return true;
            }

            @Override
            public String toString() {
                return super.toString() + "this one is manager";
            }

        };
    }

    // Anonymous_class
    // public void showActiveStaffsAnonymous() {

    // Staff.StaffFilter activeFilter = new Staff.StaffFilter() {
    // public boolean filter(Staff staff) {
    // return staff.isActive();
    // }
    // };

    // for (Staff s : staffs) {
    // if (activeFilter.filter(s)) {
    // System.out.println(s);
    // }
    // }
    // }
    // lamda expression
    public void showActiveStaffs() {
        Staff.StaffFilter activeFilter = (staff) -> staff.isActive();

        for (Staff s : staffs) {
            if (activeFilter.filter(s)) {
                System.out.println(s);
            }
        }
    }

    // public void demoPolymorphism() {

    // // String[] actions = {
    // // CREATE_MOVIE;
    // // CREATE_CUSTOMER;
    // // SELL_TICKET;
    // // DELETE_MOVIE;
    // // CANCEL_TICKET;
    // // CHECK_TICKET;
    // // UPDATE_MOVIE;
    // // CHECK_MOVIES;
    // // DISPLAY_MOVIE;
    // // HANDLE_SYSTEM;
    // // HANDLE_TICKET_ISSUE;
    // // CREATE_STAFF;
    // // MANAGE_STAFF;
    // // };

    // for (IStaff staff : staffs) {

    // // for(String action : actions){

    // // System.out.println(
    // // action + " -> " + staff.can(action)
    // // );

    // // }

    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> CREATE_MOVIE --> " +
    // staff.can(CREATE_MOVIE));
    // System.out.println(
    // "\nStaff: " + staff.getUsername() + " --> CREATE_CUSTOMER --> " +
    // staff.can(CREATE_CUSTOMER));
    // System.out.println("\nStaff: " + staff.getUsername() + " --> SELL_TICKET -->
    // " + staff.can(SELL_TICKET));
    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> DELETE_MOVIE --> " +
    // staff.can(DELETE_MOVIE));
    // System.out.println(
    // "\nStaff: " + staff.getUsername() + " --> CANCEL_TICKET --> " +
    // staff.can(CANCEL_TICKET));
    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> CHECK_TICKET --> " +
    // staff.can(CHECK_TICKET));
    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> UPDATE_MOVIE --> " +
    // staff.can(UPDATE_MOVIE));
    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> CHECK_MOVIE --> " +
    // staff.can(PRINT_MOVIES));
    // System.out.println(
    // "\nStaff: " + staff.getUsername() + " --> DISPLAY_MOVIE --> " +
    // staff.can(DISPLAY_MOVIE));
    // System.out.println(
    // "\nStaff: " + staff.getUsername() + " --> HANDLE_SYSTEM --> " +
    // staff.can(HANDLE_SYSTEM));
    // System.out.println("\nStaff: " + staff.getUsername() + " -->
    // HANDLE_TICKET_ISSUE --> "
    // + staff.can(HANDLE_TICKET_ISSUE));
    // System.out.println(
    // "\nStaff: " + staff.getUsername() + " --> CREATAE_STAFF --> " +
    // staff.can(CREATE_STAFF));
    // System.out
    // .println("\nStaff: " + staff.getUsername() + " --> MANAGE_STAFF --> " +
    // staff.can(MANAGE_STAFF));

    // }
    // }

    // =========================
    // LOGIN
    // =========================
    private boolean requireLogin() {
        if (loggedInStaff == null) {
            lastMessage = "Action denied. Please login first.";
            return false;
        }
        return true;
    }

    public void staffLogin(String username, String password) {

        if (isBlank(username) || isBlank(password)) {
            lastMessage = "Login failed: missing username or password.";
            return;
        }
        for (int i = 0; i < staffs.size(); i++) {
            Staff s = staffs.get(i);
            if (s.getUsername().equalsIgnoreCase(username.trim())) {
                if (!s.checkPassword(password)) {
                    setLastMessage("Login failed: password is wrong");
                    return;
                }

                loggedInStaff = s;
                setLastMessage("Login successful. Welcome " + s.getUsername() + " " + s.getFullName() + "!");
                return;
            }
        }

        setLastMessage("Login failed: username not found.");
    }

    public void staffLogout() {
        loggedInStaff = null;
        setLastMessage("Logged out successfully.");
    }

    // create staff

    public void createStaff(String staffId, String userName, String fullName, String password, String email,
            String phone, String position) {

        if (!requireLogin() || !requirePermission(CREATE_STAFF))
            return;

        if (isBlank(staffId) || isBlank(userName)) {
            setLastMessage("Cannot create staff: ID or UserName is empty");
            return;
        }

        Staff staff;

        if (position.equalsIgnoreCase("manager")) {
            staff = new Manager(staffId, userName, fullName, password, email, phone, 5000.0, "management");
        } else if (position.equalsIgnoreCase("cashier")) {
            staff = new CashierStaff(staffId, userName, fullName, password, email, phone, 150.0, "morning");
        } else if (position.equalsIgnoreCase("operator")) {
            staff = new OperatorStaff(staffId, userName, fullName, password, email, phone, 400.0, "Sound");
        } else {
            setLastMessage("Invalid position.");
            return;
        }

        // Add staff to the correct list
        staffs.add(staff);

        setLastMessage("Staff created successfully.");
    }

    public void manageStaff() {
        if (!requireLogin() || !requirePermission(MANAGE_STAFF))
            return;
        if (staffs.isEmpty()) {
            setLastMessage("No staff abailable.");
            return;
        }
        System.out.println("--- Staff List ---");
        for (Staff s : staffs) {
            System.out.println(s);
        }
        setLastMessage("Staff displayed successfully.");
    }

    // CREATE MOVIE

    // =========================
    // CREATE MOVIE
    // =========================
    public void createMovie(String movieId, String title, int duration, String releaseDate, String genre) {

        if (!requireLogin())
            return;

        try {
            // Check Movie ID
            if (isBlank(movieId))
                throw new InvalidMovieException("Movie ID cannot be empty.");

            int id;
            try {
                id = Integer.parseInt(movieId.trim());
            } catch (NumberFormatException e) {
                throw new InvalidMovieException("Movie ID must be a number.");
            }

            if (findMovieById(movieId) != null) {
                throw new InvalidMovieException("Movie ID already exists.");
            }

            // Validate title
            if (isBlank(title))
                throw new InvalidMovieException("Movie title cannot be empty.");

            // duration
            try {
                if (duration < 90 || duration > 240) {
                    throw new InvalidMovieException("Duration must be between 90 and 240 minutes");
                }
            } catch (Exception e) {
                throw new InvalidMovieException("Invalid duration! Must be a number between 90 and 240.");
            }

            // Validate genre
            if (isBlank(genre))
                throw new InvalidMovieException("Movie genre cannot be empty.");

            // Validate release date format
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate date;
            try {
                date = LocalDate.parse(releaseDate, formatter);
                if (date.isBefore(LocalDate.now())) {
                    throw new InvalidMovieException("Release date cannot be in the past!");
                }
            } catch (Exception e) {
                throw new InvalidMovieException("Invalid release date! Use yyyy-MM-dd format.");
            }

            // Everything valid → create movie
            Movie tempMovie = new Movie(movieId, title, duration, releaseDate, genre);
            tempMovie.updateStatus();
            movies.add(tempMovie);
            lastMessage = "Movie created successfully.";
        } catch (Exception e) {
            // Catch-all for any unexpected exception
            lastMessage = "An unexpected error occurred: " + e.getMessage();
        }
    }

    // select genre from list of genre
    public String selectGenre(Scanner sc) {
        String[] genres = { "Action", "Comedy", "Romance", "Horror", "Sci-Fi", "etc." };

        System.out.println("Select Genre:");
        for (int i = 0; i < genres.length; i++) {
            System.out.println((i + 1) + ") " + genres[i]);
        }

        try {
            int choice = Integer.parseInt(sc.nextLine());

            if (choice < 1 || choice > genres.length) {
                System.out.println("Invalid genre choice!");
                return null;
            }

            return genres[choice - 1];

        } catch (NumberFormatException e) {
            System.out.println("Invalid input! Must be a number.");
            return null;
        }
    }

    // CHECK MOVIE
    public void checkMovies() {
        if (!requireLogin())
            return;

        if (movies.isEmpty()) {
            lastMessage = "No movies available.";
            return;
        }

        for (Movie m : movies) {
            System.out.println(m);
        }
    }

    // UPDATE MOVIE

    // public void updateMovie(String movieId, String newTitle) {

    // if (!requireLogin())
    // return;

    // Movie movie = findMovieById(movieId);

    // if (movie == null) {
    // lastMessage = "Movie not found.";
    // return;
    // }

    // if (!isBlank(newTitle)) {
    // movie.setTitle(newTitle);
    // }

    // lastMessage = "Movie updated successfully.";
    // }

    // DELETE MOVIE

    public void deleteMovie(String movieId) {

        if (!requireLogin())
            return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Movie not found.";
            return;
        }

        movies.remove(movie);
        lastMessage = "Movie deleted successfully.";
    }

    // DISPLAY MOVIE
    public void displayMovie(String movieId) {
        try {
            if (movieId == null) {
                lastMessage = "Invalid Movie ID (null)";
                return;
            }

            for (Movie m : movies) {
                if (m.getMovieId().equals(movieId)) { // comparing Strings with equals
                    System.out.println(m);
                    lastMessage = "Movie displayed successfully.";
                    return;
                }
            }
            lastMessage = "Movie not found.";
        } catch (Exception e) {
            lastMessage = "An error occurred: " + e.getMessage();
        }
    }

    // SELL TICKET

    public void sellTicket(String movieId, String customerName, int quantity, String ticketType) {

        if (!requireLogin())
            return;

        try {
            // validate quantiy
            if (quantity <= 0) {
                lastMessage = "Quantity must be greater than 0.";
                return;
            }
            // Find showtime
            Showtime showtime = getShowtimeByMovieId(movieId);

            if (showtime == null) {
                lastMessage = "No showtime available.";
                return;
            }

            // Create customer
            Customer customer = new Customer(customerName, "", false);
            customers.add(customer);

            // Price logic
            double price;
            if (ticketType.equalsIgnoreCase("VIP")) {
                price = 20.0;
            } else {
                price = 12.0;
                ticketType = "Normal"; // default
            }
            // if memeber
            price = customer.applyDiscount(price);

            // Create multiple tickets
            for (int i = 0; i < quantity; i++) {
                Ticket t = new Ticket(showtime,  customer, price, ticketType);
                tickets.add(t);
            }

            lastMessage = quantity + " " + ticketType + " ticket(s) sold successfully!";

        } catch (Exception e) {
            lastMessage = "Error selling ticket: " + e.getMessage();
        }
    }

    // CREATE CUSTOMER
    public void createCustomer(String name, String email) {

        if (!requireLogin())
            return;

        if (isBlank(name)) {
            lastMessage = "Customer name cannot be empty.";
            return;
        }

        Customer c = new Customer(name, email, false);
        customers.add(c);

        lastMessage = "Customer created successfully.";
    }

    // PRINT METHODS

    public void printMovies() {
        System.out.println("\n--- Movies (" + movies.size() + ") ---");

        if (movies.isEmpty()) {
            lastMessage = "No movies available.";
            return;
        }

        for (Movie m : movies) {
            m.updateStatus();
            System.out.println(m);
        }

        lastMessage = "Movies displayed successfully.";
    }

    public void printTickets() {
        System.out.println("\n--- Tickets (" + tickets.size() + ") ---");
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }

    // CHECK TICKET
    public void checkTicket() {

        if (!requireLogin())
            return;

        if (tickets.isEmpty()) {
            lastMessage = "No tickets found.";

        } else {
            for (Ticket t : tickets) {
                System.out.println(t);
            }

            lastMessage = "Tickets displayed successfully.";
        }
    }

    // CANCEL TICKET
    public void cancelTicket(String ticketId) {

        if (!requireLogin())
            return;

        try {
            int id = Integer.parseInt(ticketId);

            for (int i = 0; i < tickets.size(); i++) {
                if (tickets.get(i).getTicketId() == id) {
                    tickets.remove(i);
                    lastMessage = "Ticket cancelled successfully.";
                    return;
                }
            }

            lastMessage = "Ticket not found.";

        } catch (NumberFormatException e) {
            lastMessage = "Invalid ticket ID";
        }
    }

    // CREATE SHOWTIME
    public void createShowtime(String movieId, String timeStr, String dateStr, int hallNumber) {
        Movie movie = findMovieById(movieId);
        if (movie == null) {
            System.out.println("Movie not found!");
            return;
        }

        String status = movie.getStatus();
        if (status.equals("Coming Soon")) {
            System.out.println("Cannot create showtime: Movie is not released yet.");
            return;
        } else if (status.equals("Not Released")) {
            System.out.println("Cannot create showtime: Movie release date has passed.");
            return;
        }

        // Validate time
        LocalTime time;
        try {
            time = LocalTime.parse(timeStr);
        } catch (Exception e) {
            System.out.println("Invalid time format. Use HH:mm");
            return;
        }

        // Validate date
        LocalDate date;
        try {
            date = LocalDate.parse(dateStr);
        } catch (Exception e) {
            System.out.println("Invalid date format. Use yyyy-MM-dd");
            return;
        }

        // Hall number check
        if (hallNumber <= 0) {
            System.out.println("Invalid hall number.");
            return;
        }

        Showtime showtime = new Showtime(time.toString(), date.toString(), hallNumber, movie);
        showtimes.add(showtime);
        System.out.println("Showtime created successfully for movie: " + movie.getTitle());
    }

    // CHECK SHOWTIME
    public void checkShowtime() {

        if (!requireLogin())
            return;

        if (showtimes.isEmpty()) {
            lastMessage = "No showtimes available.";
            return;
        }

        for (Showtime s : showtimes) {
            System.out.println(s);
        }

        lastMessage = "Showtimes displayed.";
    }
    // HELPER

    private Movie findMovieById(String movieId) {

        if (isBlank(movieId))
            return null;

        for (Movie m : movies) {
            if (m.getMovieId().equals(movieId.trim())) {
                return m;
            }
        }

        return null;
    }

    public Showtime getShowtimeByMovieId(String movieId) {
        if (movieId == null || movieId.isEmpty())
            return null;

        for (Showtime s : showtimes) {
            if (s.getMovie() != null && movieId.equals(s.getMovie().getMovieId())) {
                return s; // return the first matching showtime
            }
        }
        return null; // no showtime found
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    private boolean requirePermission(String action) {
        if (loggedInStaff == null) {
            setLastMessage("Please Logi first!!!");
            return false;
        }
        return true;
    }

    // =========================
    // GET MESSAGE
    // =========================

}