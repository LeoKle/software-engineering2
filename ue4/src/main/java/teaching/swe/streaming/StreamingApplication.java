package teaching.swe.streaming;

import java.util.List;

import teaching.swe.streaming.fraud.FraudDetection;
import teaching.swe.streaming.fraud.IFraudDetection;
import teaching.swe.streaming.recommender.IRecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystem;
import teaching.swe.streaming.ILoginManager;
import teaching.swe.streaming.LoginManager;

public class StreamingApplication {

    private final IRecommenderSystem rs;
    private final IFraudDetection fd;
    private final ILoginManager lm;

    private int volumeLevel = 50;

    public StreamingApplication() {
        this.rs = new RecommenderSystem();
        this.fd = new FraudDetection();
        this.lm = new LoginManager();
    }

    public StreamingApplication(IRecommenderSystem rs, IFraudDetection fd, ILoginManager lm) {
        this.rs = rs;
        this.fd = fd;
        this.lm = lm;
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

        this.lm.checkAuth(null, null);

        LoginResponse response = new LoginResponse();
        response.setSuccessful(successful);
        response.setRecommendations(recommendations);

        return response;
    }
}
