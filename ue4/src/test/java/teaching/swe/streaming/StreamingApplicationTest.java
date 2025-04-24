package teaching.swe.streaming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import teaching.swe.streaming.fraud.FraudDetectionMock;
import teaching.swe.streaming.fraud.IFraudDetection;
import teaching.swe.streaming.recommender.IRecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystem;
import teaching.swe.streaming.recommender.RecommenderSystemMock;

public class StreamingApplicationTest {

    @Test
    public void testSetVolumeWithinRange() {
        int newVolume = 20;

        StreamingApplication sa = new StreamingApplication();

        int result = sa.setVolume(newVolume);

        Assertions.assertEquals(newVolume, result);
        Assertions.assertTrue(result > -1);
        Assertions.assertEquals(newVolume, sa.getVolume());

        newVolume = 90;

        result = sa.setVolume(newVolume);

        Assertions.assertEquals(newVolume, result);
    }

    @Test
    public void testSetVolumeOutsideRange() {
        int newVolume = -5;
        StreamingApplication sa = new StreamingApplication();
        int oldVolume = sa.getVolume();

        int result = sa.setVolume(newVolume);

        Assertions.assertEquals(-1, result);
        Assertions.assertTrue(result == -1);
        Assertions.assertEquals(oldVolume, sa.getVolume());

        newVolume = 110;

        result = sa.setVolume(newVolume);

        Assertions.assertEquals(-1, result);
    }

    @Test
    public void testSetVolumeEdgeCases() {
        int minVolume = 0;
        int maxVolume = 100;
        StreamingApplication sa = new StreamingApplication();

        // test allowed edges (test min and max volume)
        Assertions.assertEquals(minVolume, sa.setVolume(minVolume));
        Assertions.assertEquals(minVolume, sa.getVolume());
        Assertions.assertEquals(maxVolume, sa.setVolume(maxVolume));
        Assertions.assertEquals(maxVolume, sa.getVolume());

        // reset volume
        sa.setVolume(50);

        // test not allowed edges
        Assertions.assertEquals(-1, sa.setVolume(-1));
        Assertions.assertEquals(50, sa.getVolume());
        Assertions.assertEquals(-1, sa.setVolume(101));
        Assertions.assertEquals(50, sa.getVolume());
    }

    @Test
    public void testLogin() {
        IRecommenderSystem rs = new RecommenderSystemMock();
        IFraudDetection fd = new FraudDetectionMock();
        ILoginManager lm = new LoginManagerMock(true);
        StreamingApplication sa = new StreamingApplication(rs, fd, lm);

        LoginRequest request = new LoginRequest();
        request.setLocation("DE");
        request.setUserName("Test User");
        request.setPassword("Test PWD");

        LoginResponse response = sa.login(request);

        assertTrue(response.isSuccessful());
        assertEquals(Arrays.asList("Dummy Movie A"), response.getRecommendations());
    }
}
