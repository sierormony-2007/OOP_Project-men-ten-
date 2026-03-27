package other;
public class Customer {

    private int customerId;
    private String name;
    private String phoneNumber;
    private boolean isMember;

    private static int totalCustomers = 0;

    // =========================
    // CONSTRUCTORS
    // =========================
    public Customer(String name, String phoneNumber, boolean isMember) {
        this.customerId = ++totalCustomers;   // safer auto-increment
        this.name = isBlank(name) ? "Unknown" : name.trim();
        this.phoneNumber = isBlank(phoneNumber) ? "Unknown" : phoneNumber.trim();
        this.isMember = isMember;
    }

    public Customer() {
        this.customerId = ++totalCustomers;
        this.name = "Unknown";
        this.phoneNumber = "Unknown";
        this.isMember = false;
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

    public boolean isMember() {   // fixed method name
        return isMember;
    }

    public void setMember(boolean member) {
        this.isMember = member;
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }

    // =========================
    // HELPER METHODS
    // =========================

    private boolean isBlank(String s) {
        return s == null || s.trim().isEmpty();
    }

    public boolean hasValidPhone() {
        return phoneNumber != null && phoneNumber.length() >= 9;
    }

    public String getMembershipType() {
        return isMember ? "Member" : "Regular";
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