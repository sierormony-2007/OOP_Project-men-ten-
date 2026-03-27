package user;

public abstract class Staff implements IStaff {
    private String staffId;
    private String userName;
    private String password;
    private String fullName;
    private String email;
    private String phone;
    private double salary;
    private boolean active;

@Override
public abstract boolean can(String action);

    public Staff(String staffId, String userName, String fullName,String password,  String email, String phone, double salary) {
        setStaffId(staffId);
        setUserName(userName);
        setFullName(fullName);
        setPassword(password);
        setEmail(email);
        setPhone(phone);
        setSalary(salary);
        this.active= true;

    }
    protected String getpassword() {
        return password;
    }

  @Override
    public boolean isActive() {
        return active;
    }
  @Override
    public String getId() {
        return staffId;
    }
    public String getUsername() {
        return userName;
    }
    public String getFullName() {
        return fullName;
    }
    public String getEmail() {
        return email;
    }
    public String getPhone() {
        return phone;
    }
    public double getSalary(){
        return salary;
    }
    public boolean checkPassword(String input) {
        return password != null && password.equals(input);
    }
    public void setStaffId(String staffId) {
        if (!isValidString(staffId)) this.staffId = "UNKNOWN";
        else this.staffId = staffId.trim();
    }
    public void setUserName(String userName) {
        if (!isValidString(userName)) this.userName = "UNKNOWN";
        else this.userName = userName.trim();
    }
    public void setFullName(String fullName) {
        if (!isValidString(fullName)) this.fullName = "UNKNOWN";
        else this.fullName = fullName.trim();
    }
    public void setPassword(String password) {
        String pw = (password == null) ? "" : password;
        // simple rule for teaching: >= 4 chars
        if (pw.length() < 4) this.password = "0000";
        else this.password = pw;
    }
    public void setEmail(String email) {
        if (email != null && !email.trim().isEmpty()) {
            this.email = email;
        } else {
            System.out.println("Invalid email. It cannot be null or empty.");
        }
    }

   public void setSalary(double salary) {
       if (salary < 0)
         this.salary = 0;
    else
        this.salary = salary;
}
    public void setPhone(String phone) {
        String p = (phone == null) ? "" : phone.trim();
        // simple validation: only digits, length 8–15
        if (!isDigit(p) || p.length() < 8 || p.length() > 15) this.phone = "00000000";
        else this.phone = p;
    }

    private boolean isValidString(String str) {
        return str != null && !str.trim().isEmpty();
    }
    private boolean isDigit(String str) {
        if (str == null || str.trim().isEmpty()) {
            return false;
        }
        for (char c : str.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        return "Staff{" +
        "StaffId='" + staffId + '\'' +
        ", UserName='" + userName + '\'' +
        ", FullName='" + fullName + '\'' +
        ", email='" + email + '\'' +
        ", Phone='" + phone + '\'' +
        ", salary=" + salary +
        '}';
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Staff other = (Staff) obj;
        return staffId.equals(other.staffId);
    }
    @FunctionalInterface
    public interface StaffFilter {
        boolean filter(Staff staff);
    
    }


}
