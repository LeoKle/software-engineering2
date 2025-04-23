package teaching.swe.streaming;

public class LoginRequest {

    private String userName;
    
    private String password;
    
    private String location;

    public LoginRequest() {
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserName() {
        return userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public String getPassword() {
        return password;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }

}
