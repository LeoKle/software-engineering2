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
        if (level < 0 || level > 100) {
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
        final boolean isFraud = fd.isFraud(request);
        final boolean authSuccessful = lm.checkAuth(request.getUserName(), request.getPassword());

        final boolean validRequest = authSuccessful && !isFraud;
        LoginResponse response = new LoginResponse();
        response.setSuccessful(validRequest);

        if (!validRequest)
            return response;

        List<String> recommendations = rs.recommend(request);
        response.setRecommendations(recommendations);

        return response;
    }

}
