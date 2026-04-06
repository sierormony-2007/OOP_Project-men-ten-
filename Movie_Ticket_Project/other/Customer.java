package other;

public class Customer {

    private int customerId;
    private String name;
    private String phoneNumber;
    private boolean member;   // improved naming

    private static int totalCustomers = 0;

    // =========================
    // CONSTRUCTORS
    // =========================
    public Customer(String name, String phoneNumber, boolean member) {
        this.customerId = ++totalCustomers; // auto increment
        this.name = isBlank(name) ? "Unknown" : name.trim();
        this.phoneNumber = isBlank(phoneNumber) ? "Unknown" : phoneNumber.trim();
        this.member = member;
    }

    public Customer() {
        this("Unknown", "Unknown", false);
    }

    // =========================
    // GETTERS / SETTERS
    // =========================
    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (!isBlank(name)) {
            this.name = name.trim();
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (!isBlank(phoneNumber) && phoneNumber.trim().length() >= 9) {
            this.phoneNumber = phoneNumber.trim();
        }
    }

    public boolean isMember() {
        return member;
    }

    public void setMember(boolean member) {
        this.member = member;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    // =========================
    // BUSINESS LOGIC (VERY IMPORTANT 🔥)
    // =========================

    // Apply discount if member
    public double applyDiscount(double price) {
        if (member) {
            return price * 0.9; // 10% discount
        }
        return price;
    }

    public String getMembershipType() {
        return member ? "Member" : "Regular";
    }

    public boolean hasValidPhone() {
        return phoneNumber != null && phoneNumber.length() >= 9;
    }

    // =========================
    // HELPER METHOD
    // =========================
    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    // =========================
    // toString()
    // =========================
    @Override
    public String toString() {
        return "Customer ID: " + customerId +
               " | Name: " + name +
               " | Phone: " + phoneNumber +
               " | Type: " + getMembershipType();
    }
}