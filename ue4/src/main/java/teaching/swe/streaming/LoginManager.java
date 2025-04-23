package teaching.swe.streaming;

public class LoginManager {
    private String[][] userCredentials = {
            { "User1", "PasswortA" },
            { "User2", "PasswortB" },
            { "User3", "PasswortC" },
            { "User4", "PasswortC" }
    };

    public boolean checkAuth(String user, String password) {
        for (String[] credentials : this.userCredentials) {
            final boolean isUser = credentials[0].equals(user);
            if (!isUser)
                continue;

            final boolean correctPassword = credentials[1].equals(password);
            return correctPassword;
        }

        return false;
    }
}
