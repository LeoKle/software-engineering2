package teaching.swe.streaming.recommender;

import java.util.Arrays;
import java.util.List;

import teaching.swe.streaming.LoginRequest;

public class RecommenderSystemMock implements IRecommenderSystem {

    public RecommenderSystemMock() {
        System.out.println("RS-MOCK: wird instanziiert...");
    }

    @Override
    public List<String> recommend(LoginRequest request) {
        System.out.println("RS-MOCK: Generierung von Empfehlungen auf Basis von KI-Algorithmen");
        System.out.println("Für User " + request.getUserName() + " in " + request.getLocation());
        
        return Arrays.asList("Dummy Movie A");
    }
    
}
