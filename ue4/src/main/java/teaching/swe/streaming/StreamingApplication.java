package teaching.swe.streaming;

import java.util.List;

import teaching.swe.streaming.fraud.FraudDetection;
import teaching.swe.streaming.fraud.IFraudDetection;
import teaching.swe.streaming.recommender.IRecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystem;

public class StreamingApplication {

    private String[][] userCredentials = {
        {"User1", "PasswortA"},
        {"User2", "PasswortB"},
        {"User3", "PasswortC"},
        {"User4", "PasswortC"}
    };
    
    private final IRecommenderSystem rs;
    private final IFraudDetection fd;

    private int volumeLevel = 50;

    public StreamingApplication() {
        this.rs = new RecommenderSystem();
        this.fd = new FraudDetection();
    }

    public StreamingApplication (IRecommenderSystem rs, IFraudDetection fd) {
        this.rs = rs;
        this.fd = fd;
    }

    public int setVolume(int level) {
        if (level <= 0 || level > 100) {
            return -1;
        } else {
            this.volumeLevel = level;
            return level;
        }
    }

    public int getVolume() {
        return this.volumeLevel;
    }

    public LoginResponse login(LoginRequest request) {
        boolean successful = !fd.isFraud(request); 
        List<String> recommendations = rs.recommend(request);

        LoginResponse response = new LoginResponse();
        response.setSuccessful(successful);
        response.setRecommendations(recommendations);

        return response;
    }

    /**
     * Gibt true zurück, wenn das User/Passwort-Paar in
     * userCredentials enthalten ist. Andernfalls wird false zurückgegeben.
     */
    private boolean checkAuth(String user, String password) {
        // TODO: implementieren. Dabei userCredentials verwenden.

        return true;
    }
}
