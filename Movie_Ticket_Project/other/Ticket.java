package other;

public class Ticket {
    private Showtime showtime;
    private int ticketId;
    private Movie movie;
    private Customer customer;
    private double price;
    private String ticketType;
    private String issue = "";
    private static int ticketIDCounter = 0;

    public Ticket(Showtime showtime, int ticketId, Movie movie, Customer customer, double price, String ticketType) {
        this.showtime = showtime;
        this.ticketId = ticketId;
        this.movie = movie;
        this.customer = customer;
        this.price = price;
        this.ticketType = ticketType;
        ticketIDCounter++;
    }

    public int getTicketId() {
        return ticketId;
    }

    public Movie getMovie() {
        return movie;
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

    public String getIssue() {
        return issue;
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

    public void setIssue(String issue) {
        if (issue != null)
            this.issue = issue;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ID=" + ticketId +
                ", Movie=" + showtime.getMovie().getTitle() +
                ", Time=" + showtime.getTime() +
                ", Date=" + showtime.getDate() +
                ", Customer=" + customer.getName() +
                ", Price=" + price +
                ", Type='" + ticketType + '\'' +
                (issue.isEmpty() ? "" : ", Issue='" + issue + '\'') +
                '}';
    }
}