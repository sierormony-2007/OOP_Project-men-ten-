package other;

public class BuyTicket {

    private int ticketCount;
    private Customer customer;

    private static final double NORMAL_PRICE = 12;
    private static final double VIP_PRICE = 20;

    // =========================
    // CONSTRUCTOR
    // =========================
    public BuyTicket(Customer customer) {
        this.customer = customer;
        this.ticketCount = 0;
    }

    // =========================
    // CORE LOGIC (IMPORTANT 🔥)
    // =========================
    public double calculateTotalPrice(int normalTickets, int vipTickets) {

        // Validation
        if (normalTickets < 0 || vipTickets < 0) {
            System.out.println("Invalid ticket quantity.");
            return 0;
        }

        this.ticketCount = normalTickets + vipTickets;

        double total = (normalTickets * NORMAL_PRICE) + (vipTickets * VIP_PRICE);

        // Apply discount if customer is member
        if (customer != null) {
            total = customer.applyDiscount(total);
        }

        return total;
    }

    // =========================
    // GETTERS
    // =========================
    public int getTicketCount() {
        return ticketCount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public double getNormalPrice() {
        return NORMAL_PRICE;
    }

    public double getVipPrice() {
        return VIP_PRICE;
    }

    // =========================
    // SETTER
    // =========================
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    // =========================
    // EXTRA METHOD (VERY GOOD 🔥)
    // =========================
    public void printSummary(int normalTickets, int vipTickets) {
        double total = calculateTotalPrice(normalTickets, vipTickets);

        System.out.println("Customer: " + (customer != null ? customer.getName() : "Unknown"));
        System.out.println("Normal Tickets: " + normalTickets);
        System.out.println("VIP Tickets: " + vipTickets);
        System.out.println("Total Tickets: " + ticketCount);
        System.out.println("Total Price: $" + total);
    }
}