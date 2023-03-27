package librarysystem_oto;

public class UserManager {
    private int UserID;
    private String UserName;
    private String UserLastName;
    private String UserPassword;
    
    
    public UserManager (int UserID, String UserName, String UserLastName, String UserPassword){
        this.UserID = UserID;
        this.UserName = UserName;
        this.UserLastName = UserLastName;
        this.UserPassword = UserPassword;
    }


    public int getUserID() {
        return UserID;
    }

    public void setUserID(int UserID) {
        this.UserID = UserID;
    }


    public String getUserName() {
        return UserName;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserLastName() {
        return UserLastName;
    }

    public void setUserLastName(String LastName) {
        this.UserLastName = LastName;
    }


    public String getUserPassword() {
        return UserPassword;
    }

    public void setUserPassword(String UserPassword) {
        this.UserPassword = UserPassword;
    }
    
    
    

}
