package other;

public class Ticket {

    public static int getTicketIDCounter() {
        return ticketIDCounter;
    }
    private Showtime showtime;
    private int ticketId;
    private Movie movie;
    private Customer customer;
    private double price;
    private String ticketType;
    private static int ticketIDCounter = 0;

    public Ticket(Showtime showtime,  Customer customer, double price, String ticketType) {
        this.showtime = showtime;
        this.ticketId = ticketId;
        this.customer = customer;
        this.price = price;
        this.ticketType = ticketType;
        this.ticketId=ticketIDCounter++;
    }


    public int getTicketId() {
        return ticketId;
    }

    public Movie getMovie() {
        return movie;
    }
    
    public Showtime getShowtime() {
        return showtime;
    }

    public void setShowtime(Showtime showtime) {
        this.showtime = showtime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getPrice() {
        return price;
    }

    public String getTicketType() {
        return ticketType;
    }
    public void setMovie(Movie movie) {
        if (movie != null)
            this.movie = movie;
    }

    public void setCustomer(Customer customer) {
        if (customer != null)
            this.customer = customer;
    }

    public void setPrice(double price) {
        if (price >= 0)
            this.price = price;
    }

    public void setTicketType(String ticketType) {
        if (ticketType != null && !ticketType.isEmpty())
            this.ticketType = ticketType;
    }
        public static int getNextTicketId(){
        ticketIDCounter++;
        return ticketIDCounter;
    }



    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ticketId +
                ", Movie=" + showtime.getMovie().getTitle() +
                ", Time=" + showtime.getTime() +
                ", Date=" + showtime.getDate() +
                ", Hall=" + showtime.getHallNumber() +
                ", Customer=" + customer.getName() +
                ", Price=" + price +
                ", Type='" + ticketType + '\'' +
                '}';
    }

}