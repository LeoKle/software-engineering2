package teaching.swe.streaming.integration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teaching.swe.streaming.LoginRequest;
import teaching.swe.streaming.LoginResponse;
import teaching.swe.streaming.StreamingApplication;
import teaching.swe.streaming.fraud.FraudDetectionMock;
import teaching.swe.streaming.fraud.IFraudDetection;
import teaching.swe.streaming.recommender.IRecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystem;

public class StreamingApplicationAndRecommenderSystemIntegrationTest {

    private StreamingApplication streamingApplication;
    private LoginRequest request;

    @BeforeEach
    public void setUp() {
        IRecommenderSystem rs = new RecommenderSystem();
        IFraudDetection fd = new FraudDetectionMock();
        streamingApplication = new StreamingApplication(rs, fd);

        request = new LoginRequest();
        request.setLocation("DE");
        request.setUserName("Test User");
        request.setPassword("Test PWD");
    }

    @Test
    public void testLoginAndRecommend() {
        LoginResponse response = streamingApplication.login(request);

        assertTrue(response.isSuccessful());
        assertEquals(Arrays.asList("Movie 1", "Movie 3"), response.getRecommendations());
    }

    @AfterEach
    public void tearDown() {
        streamingApplication = null;
        request = null;
    }

}
