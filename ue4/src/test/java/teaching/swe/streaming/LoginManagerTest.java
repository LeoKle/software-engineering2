package teaching.swe.streaming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginManagerTest {
    @Test
    public void testCheckAuthTrue() {
        LoginManager lm = new LoginManager();

        Assertions.assertTrue(lm.checkAuth("User1", "PasswortA"));
        Assertions.assertTrue(lm.checkAuth("User2", "PasswortB"));
        Assertions.assertTrue(lm.checkAuth("User3", "PasswortC"));
        Assertions.assertTrue(lm.checkAuth("User4", "PasswortC"));
    }

    @Test
    public void testCheckAuthFalse() {
        LoginManager lm = new LoginManager();

        Assertions.assertFalse(lm.checkAuth("User", "PasswortA"));
        Assertions.assertFalse(lm.checkAuth("User2", "PasswortD"));
        Assertions.assertFalse(lm.checkAuth("", "PasswortC"));
        Assertions.assertFalse(lm.checkAuth("\t\n#124124", "PasswortC"));
    }

    @Test
    public void testCheckAuthNull() {
        LoginManager lm = new LoginManager();

        Assertions.assertFalse(lm.checkAuth(null, null));
    }
}
