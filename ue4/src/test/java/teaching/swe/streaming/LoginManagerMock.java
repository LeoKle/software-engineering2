package teaching.swe.streaming;

public class LoginManagerMock implements ILoginManager {
    private boolean returnValue;

    public LoginManagerMock(boolean returnValue) {
        this.returnValue = returnValue;
    }

    @Override
    public boolean checkAuth(String user, String password) {
        return returnValue;
    }
}
