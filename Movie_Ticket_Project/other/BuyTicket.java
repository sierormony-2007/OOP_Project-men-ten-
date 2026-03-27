package other;

public class BuyTicket {

    private int ticketCount;
    // private int maxTickets;
    private Customer customer;
    private static final double NORMAL_PRICE = 12;
    private static final double VIP_PRICE = 20;
    

    // public BuyTicket(){
    //    this(50);
    // }
    // public BuyTicket(int maxTickets){
    //      this.maxTickets = maxTickets;
    //     this.ticketCount = 0;
    // }  


    // public boolean bookTicket(int numberOfTickets) {
    //     if (ticketCount + numberOfTickets <= maxTickets) {
    //         ticketCount += numberOfTickets;
    //         return true;
    //     } else {
    //         return false;
    //     }
    // }

    public double calculateTotalPrice(double  normalTickets, double  vipTickets) {
        return (normalTickets * NORMAL_PRICE) + (vipTickets * VIP_PRICE);
    }

    
    public int getTicketCount() {
        return ticketCount;
    }

    // public int getMaxTickets() {
    //     return maxTickets;
    // }

    public double getNormalPrice() {
        return NORMAL_PRICE;
    }

    public double getVipPrice() {
        return VIP_PRICE;
    }

    // public static void main(String[] args) {

    //     BuyTicket buy = new BuyTicket();

    //     int normalTickets = 3;
    //     int vipTickets = 2;

    //     if (buy.bookTicket(normalTickets + vipTickets)) {
    //         double totalPrice = buy.calculateTotalPrice(normalTickets, vipTickets);
    //         System.out.println("Tickets booked successfully!");
    //         System.out.println("Total Price: $" + totalPrice);
    //     } else {
    //         System.out.println("Not enough seats available.");
    //     }
    // }


}



