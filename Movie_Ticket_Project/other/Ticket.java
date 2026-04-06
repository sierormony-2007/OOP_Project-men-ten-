package other;

public class Ticket {

    private static int ticketIDCounter = 1; // start from 1 (better)

    private int ticketId;
    private Showtime showtime;
    private Customer customer;
    private double price;
    private String ticketType;

    // =========================
    // CONSTRUCTOR
    // =========================
    public Ticket(Showtime showtime, Customer customer, double price, String ticketType) {
        this.ticketId = ticketIDCounter++; // auto ID
        this.showtime = showtime;
        this.customer = customer;
        this.price = price;
        this.ticketType = ticketType;
    }

    // =========================
    // GETTERS
    // =========================
    public int getTicketId() {
        return ticketId;
    }

    public Showtime getShowtime() {
        return showtime;
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

    // =========================
    // SETTERS (SAFE)
    // =========================
    public void setShowtime(Showtime showtime) {
        if (showtime != null)
            this.showtime = showtime;
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

    // =========================
    // toString()
    // =========================
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