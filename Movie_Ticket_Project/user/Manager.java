package user;


public class Manager extends Staff {
    String bonus;

   public Manager(String staffId, String userName, String fullName,String password, String email, String phone, double salary, String bonus) {

        super(staffId, userName, fullName, password, email, phone, salary);
        this.setBonus(bonus);
    }
    

    @Override
    public boolean can(String action) {

        return true;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Manager manager = (Manager) obj;
        return this.getId().equals(manager.getId());
    }

    public String getBonus() {
        return bonus;
    }

    public void setBonus(String bonus) {
        this.bonus = bonus;
    }
}

