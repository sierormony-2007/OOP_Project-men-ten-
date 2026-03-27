package other;
public class Ticket {
    private int ticketId;
    private Movie movie;
    // private double priceSnapshot;
    private String ticketType;
    private double price;
    private String issue;
    private static int ticketIDCounter = 0;

    public Ticket(int ticketId, Movie movie, Customer customer, double price, String ticketType){
        this.ticketId = ticketId;
        this.movie = movie;
        // this.priceSnapshot = price;
        this.ticketType = ticketType;
        ticketIDCounter++;  
    }

    public int getTicketId() {

        return ticketId;
    }

    // public void setTicketId(int ticketId) {
    //     if (ticketId > 0){              
    //         this.ticketId = ticketId;
    //     } else {
    //         System.out.println("Invalid ticket ID. It must be a positive integer.");
    //     }
    // }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        if (movie != null){
            this.movie = movie;
        }
    }

    // public double getPriceSnapshot() {
    //     return priceSnapshot;
    // }

   

    public String getTicketType() {
        return ticketType;
    }

    public void setTicketType(String ticketType) {
        if (ticketType != null && !ticketType.isEmpty()){
            this.ticketType = ticketType;
        }
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
       if (price >= 0){
            this.price = price;
        }
    }
    
    public static int getTicketIDCounter() {
        return ticketIDCounter;
    }
    public String getIssue(){
        return issue;
    }
     public void setIssue(String issue) {
        this.issue = issue;
    }

    

}
