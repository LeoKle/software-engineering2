package teaching.swe.streaming.recommender;

import java.util.List;

import teaching.swe.streaming.LoginRequest;

public interface IRecommenderSystem {
    public List<String> recommend(LoginRequest request);
}
