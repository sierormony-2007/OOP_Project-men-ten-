package user;

public interface IStaff {

    String getId();
    String getUsername();
    String getFullName();
    boolean isActive();
    boolean checkPassword(String input);
    
    
    boolean can(String action);
}