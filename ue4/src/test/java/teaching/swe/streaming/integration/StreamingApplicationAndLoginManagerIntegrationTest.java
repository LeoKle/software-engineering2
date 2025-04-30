package teaching.swe.streaming.integration;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teaching.swe.streaming.ILoginManager;
import teaching.swe.streaming.LoginManager;
import teaching.swe.streaming.LoginRequest;
import teaching.swe.streaming.LoginResponse;
import teaching.swe.streaming.StreamingApplication;
import teaching.swe.streaming.fraud.FraudDetectionMock;
import teaching.swe.streaming.fraud.IFraudDetection;
import teaching.swe.streaming.recommender.IRecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystemMock;

public class StreamingApplicationAndLoginManagerIntegrationTest {

    private StreamingApplication streamingApplication;

    @BeforeEach
    public void setUp() {
        IRecommenderSystem rs = new RecommenderSystemMock();
        IFraudDetection fd = new FraudDetectionMock();
        ILoginManager lm = new LoginManager();
        streamingApplication = new StreamingApplication(rs, fd, lm);
    }

    @Test
    public void testLoginValid() {
        LoginRequest request = new LoginRequest();
        request.setLocation("DE");
        request.setUserName("User1");
        request.setPassword("PasswortA");
        LoginResponse response = streamingApplication.login(request);

        // response should be successful as User-Password combination is correct
        assertTrue(response.isSuccessful());
        // RecommenderSystemMock should create recommendations as the request is valid
        assertFalse(response.getRecommendations().isEmpty());
    }

    @Test
    public void testLoginInvalid() {
        LoginRequest request = new LoginRequest();
        request.setLocation("DE");
        request.setUserName("User1");
        request.setPassword("InvalidPassword");
        LoginResponse response = streamingApplication.login(request);

        // response should be unsuccessful as password is wrong
        assertFalse(response.isSuccessful());
        // recommendations should be empty as the request was invalid
        assertTrue(response.getRecommendations().isEmpty());
    }

    @AfterEach
    public void tearDown() {
        streamingApplication = null;
    }

}
