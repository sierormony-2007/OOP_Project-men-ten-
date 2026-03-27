package user;

public class OperatorStaff extends Staff {
    private String department; // "sound", "projection"

    public OperatorStaff(String staffId, String userName, String fullName,String password, String email, String phone, double salary, String department) {
        super(staffId, userName, fullName, password, email, phone, salary);
        this.department = department;
    }
     public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public boolean can(String action) {

        if (action.equals("HANDLE_SYSTEM") ||
            action.equals("DISPLAY_MOVIE") ||
            action.equals("CHECK_TICKET"))

            return true;
        return false;
    }
    @Override
    public boolean equals(Object obj){
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        OperatorStaff other = (OperatorStaff) obj;
        if(!super.equals(obj)){
            return false;
        }
        if (this.getSalary() != other.getSalary()) {
            return false;
        }
        return true;
    }
    @Override
    public String toString() {
        return super.toString() + "OperatorStaff{" +
                "salary=" + getSalary()+
                '}';
    }


}
