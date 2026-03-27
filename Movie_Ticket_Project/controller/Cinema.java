package controller;
import java.util.ArrayList;
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

    //Movie actions

    

    public static final String CREATE_MOVIE = "CREATE_MOVIE";
    public static final String UPDATE_MOVIE = "UPDATE_MOVIE";
    public static final String DELETE_MOVIE = "DELETE_MOVIE";
    public static final String CHECK_MOVIES = "CHECK_MOVIES";
    public static final String DISPLAY_MOVIE = "DISPLAY_MOVIE";
    public static final String CREATE_CUSTOMER = "CREATE_CUSTOMER";
    //Ticket actons
    public static final String SELL_TICKET = "SELL_TICKET";
    public static final String CHECK_TICKET = "CHECK_TICKET";
    public static final String CANCEL_TICKET = "CANCEL_TICKET";
    public static final String HANDLE_TICKET_ISSUE = "HANDLE_TICKET_ISSUE";
    //System
    public static final String HANDLE_SYSTEM = "HANDLE_SYSTEM";
    
    //manager
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

    public String getCinemaName() {return cinemaName;}

    public void setCinemaName(String cinemaName) {
        if(isBlank(cinemaName)) this.cinemaName = "cinema";
        else this.cinemaName = cinemaName.trim();
    }

    public String getAddress() {return address;}

    public void setAddress(String address) {
        if(isBlank(address)) this.address = "UNKNOWN";
        this.address = address.trim();
    }
    public boolean isStafffLoggedIn(){return loggedInStaff != null;}

    public IStaff getLoggedInStaff() {return  loggedInStaff;}

    public void setLastMessage(String lmsg) {lastMessage = lmsg;}

    public String getLastMessage() {
        return lastMessage;
    }
    
    // Test code

public void seedStaff() {
    
    Staff m1 = new Manager("m00", "manager_01", "SIE RORMONY" , "sierormony_18102007", "nii18102007@gmail.com", "0886477296", 5000.0, "70");
    // Manager manager = new Manager(managerStaff, "70");
    staffs.add(m1);

    Staff CS1 = new CashierStaff("CS01", "cashier", "Cashier User","cashier_1234" ,"cashier@cinema.com", "111111", 150.0, "morning");
    // CashierStaff cashier = new CashierStaff(CS, "morning");
    staffs.add(CS1);

    Staff OS = new OperatorStaff("OS01", "operator", "Jasmin","operator_1234", "jasmin01@gmail.com", "099875630",400, "Sound");
    // OperatorStaff operatorstaff = new OperatorStaff(OS, "Sound");
    staffs.add(OS);


    Staff s1 = new Staff("m00", "manager_01", "SIE RORMONY" , "sierormony_18102007", "nii18102007@gmail.com", "0886477296", 5000.0) {
        @Override
        public boolean can(String action) {
            return true;
        }

        @Override
        public String toString() {
            return super.toString()+"this one is manager";
        }
        
    };
}

//Anonymous_class
// public void showActiveStaffsAnonymous() {

//     Staff.StaffFilter activeFilter = new Staff.StaffFilter() {
//         public boolean filter(Staff staff) {
//             return staff.isActive();
//         }
//     };

//     for (Staff s : staffs) {
//         if (activeFilter.filter(s)) {
//             System.out.println(s);
//         }
//     }
// }
//lamda expression
public void showActiveStaffs() {
    Staff.StaffFilter activeFilter = (staff) -> staff.isActive();

    for (Staff s : staffs) {
        if (activeFilter.filter(s)) {
            System.out.println(s);
        }
    }
}


public void demoPolymorphism(){

    // String[] actions = {
    //     CREATE_MOVIE;
    //     CREATE_CUSTOMER;
    //     SELL_TICKET;
    //     DELETE_MOVIE;
    //     CANCEL_TICKET;
    //     CHECK_TICKET;
    //     UPDATE_MOVIE;
    //     CHECK_MOVIES;
    //     DISPLAY_MOVIE;
    //     HANDLE_SYSTEM;
    //     HANDLE_TICKET_ISSUE;
    //     CREATE_STAFF;
    //     MANAGE_STAFF;
    // };
    

    for(IStaff staff : staffs){
        
        // for(String action : actions){

        //     System.out.println(
        //         action + " -> " + staff.can(action)
        //     );

        // }

        System.out.println("\nStaff: " + staff.getUsername() + " -->  CREATE_MOVIE  -->  " + staff.can(CREATE_MOVIE)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  CREATE_CUSTOMER  -->  " + staff.can(CREATE_CUSTOMER)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  SELL_TICKET  -->  " + staff.can(SELL_TICKET)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  DELETE_MOVIE  -->  " + staff.can(DELETE_MOVIE)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  CANCEL_TICKET  -->  " + staff.can(CANCEL_TICKET)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  CHECK_TICKET  -->  " + staff.can(CHECK_TICKET)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  UPDATE_MOVIE  -->  " + staff.can(UPDATE_MOVIE)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  CHECK_MOVIE  -->  " + staff.can(CHECK_MOVIES)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  DISPLAY_MOVIE  -->  " + staff.can(DISPLAY_MOVIE)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  HANDLE_SYSTEM  -->  " + staff.can(HANDLE_SYSTEM)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  HANDLE_TICKET_ISSUE  -->  " + staff.can(HANDLE_TICKET_ISSUE)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  CREATAE_STAFF  -->  " + staff.can(CREATE_STAFF)) ;
        System.out.println("\nStaff: " + staff.getUsername() + " -->  MANAGE_STAFF  -->  " + staff.can(MANAGE_STAFF)) ;

    }
}


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
        for(int i = 0; i<staffs.size(); i++){
            Staff s = staffs.get(i);
            if (s.getUsername().equalsIgnoreCase(username.trim())){
                if(!s.checkPassword(password)){
                    setLastMessage("Login failed: password is wrong");
                    return;
                }

                loggedInStaff = s;
                setLastMessage("Login successful. Welcome " + s.getUsername()); 
                return;
            }
        }

        setLastMessage("Login failed: username not found.");
    }

    public void staffLogout() {
        loggedInStaff = null;
        setLastMessage("Logged out successfully.");
    }

    //create staff

    public void createStaff (String staffId, String userName, String fullName, String password,String email, String phone, String position){
        if(!requireLogin() || !requirePermission(CREATE_STAFF)) return;
        if (isBlank(staffId) || isBlank(userName)){
            setLastMessage("Cannot crreate staff: ID or UserName is empty");
            return;
        }
    }
    public void manageStaff(){
        if(!requireLogin() || !requirePermission(MANAGE_STAFF)) return;
        if(staffs.isEmpty()){
            setLastMessage("No staff abailable.");
            return;
        }
        System.out.println("--- Staff List ---");
        for(Staff s : staffs){
            System.out.println(s);
        }
        setLastMessage("Staff displayed successfully.");
    }

    // CREATE MOVIE

    public void createMovie(String movieId, String title, int duration,String releaseDate, String genre) {

        if (!requireLogin()) return;

        if (isBlank(movieId)) {
    lastMessage = "Movie ID cannot be empty.";
    return;
    }

        movieId = movieId.trim();

        if (findMovieById(movieId) != null) {
            lastMessage = "Movie ID already exists.";
            return;
        }
        

        movies.add(new Movie(Integer.parseInt(movieId), title, (double) duration, releaseDate, genre));
        lastMessage = "Movie created successfully.";
        }
    //CHECK MOVIE
    public void checkMovies(){
    if(!requireLogin()) return;

    if(movies.isEmpty()){
        lastMessage = "No movies available.";
        return;
    }

    for(Movie m : movies){
        System.out.println(m);
    }

    lastMessage = "Movies displayed successfully.";
    }




    // UPDATE MOVIE

    public void updateMovie(String movieId, String newTitle) {

        if (!requireLogin()) return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Movie not found.";
            return;
        }

        if (!isBlank(newTitle)) {
            movie.setTitle(newTitle);
        }

        lastMessage = "Movie updated successfully.";
    }


    // DELETE MOVIE

    public void deleteMovie(String movieId) {

        if (!requireLogin()) return;

        Movie movie = findMovieById(movieId);

        if (movie == null) {
            lastMessage = "Movie not found.";
            return;
        }

        movies.remove(movie);
        lastMessage = "Movie deleted successfully.";
    }
   //DISPLAY MOVIE
   public void displayMovie(String movieId){

    if(!requireLogin()) return;

    Movie movie = findMovieById(movieId);

    if(movie == null){
        lastMessage = "Movie not found.";
        return;
    }

    System.out.println(movie);
    lastMessage = "Movie displayed successfully.";
}

    // SELL TICKET

    public void sellTicket(String ticketId, String movieId, String customerName) {

    if (!requireLogin()) return;

    Movie movie = findMovieById(movieId);

    if (movie == null) {
        lastMessage = "Cannot sell ticket. Movie not found.";
        return;
    }

    int id = Integer.parseInt(ticketId);
    Customer customer = new Customer(customerName, "", false);
    double price = 100.0;
    String ticketType = "Standard";

    Ticket t = new Ticket (id, movie, customer, price, ticketType);
    tickets.add(t);

    lastMessage = "Ticket sold successfully.";
}
    // CREATE CUSTOMER
    public void createCustomer(String name, String email){

    if(!requireLogin()) return;

    if(isBlank(name)){
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
        for (Movie m : movies) {
            System.out.println(m);
        }
    }

    public void printTickets() {
        System.out.println("\n--- Tickets (" + tickets.size() + ") ---");
        for (Ticket t : tickets) {
            System.out.println(t);
        }
    }
//CHECK TICKET
   public void checkTicket(){

    if(!requireLogin()) return;

    if(tickets.isEmpty()){
        lastMessage = "No tickets found.";
        return;
    }

    for(Ticket t : tickets){
        System.out.println(t);
    }

    lastMessage = "Tickets displayed successfully.";
}
// CANCEL TICKET
    public void cancelTicket(String ticketId){

    if(!requireLogin()) return;

    int id = Integer.parseInt(ticketId);

    for(Ticket t : tickets){
        if(t.getTicketId() == id){
            tickets.remove(t);
            lastMessage = "Ticket cancelled successfully.";
            return;
        }
    }

    lastMessage = "Ticket not found.";
}
//HANDLE TICKET ISSUE
    public void handleTicketIssue(String ticketId, String issue){

    if(!requireLogin()) return;

    int id = Integer.parseInt(ticketId);

    for(Ticket t : tickets){
        if(t.getTicketId() == id){
            t.setIssue(issue);
            lastMessage = "Ticket issue updated.";
            return;
        }
    }

    lastMessage = "Ticket not found.";
}
//CREATE SHOWTIME
public void createShowtime(String time, String date, int hall, String movieId){

    if(!requireLogin()) return;

    Movie movie = findMovieById(movieId);

    if(movie == null){
        lastMessage = "Movie not found.";
        return;
    }

    Showtime st = new Showtime(time, date, hall, movie);
    showtimes.add(st);

    lastMessage = "Showtime created successfully.";
}

//CHECK SHOWTIME
public void checkShowtime(){

    if(!requireLogin()) return;

    if(showtimes.isEmpty()){
        lastMessage = "No showtimes available.";
        return;
    }

    for(Showtime s : showtimes){
        System.out.println(s);
    }

    lastMessage = "Showtimes displayed.";
}
    // HELPER

    private Movie findMovieById(String movieId) {

        if (isBlank(movieId)) return null;

        for (Movie m : movies) {
            if (m.getMovieId() == Integer.parseInt(movieId.trim())) {
                return m;
            }
        }

        return null;
    }

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }
    private boolean requirePermission(String action){
        if(loggedInStaff == null){
            setLastMessage("Please Logi first!!!");
            return false;
        }
        return true;
    }

    // =========================
    // GET MESSAGE
    // =========================

}