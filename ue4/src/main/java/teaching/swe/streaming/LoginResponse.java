package teaching.swe.streaming;

import java.util.ArrayList;
import java.util.List;

public class LoginResponse {
    private boolean successful;
    private List<String> recommendations = new ArrayList<>();

    public LoginResponse() {
    }

    public boolean isSuccessful() {
        return successful;
    }

    public void setSuccessful(boolean successful) {
        this.successful = successful;
    }

    public List<String> getRecommendations() {
        return recommendations;
    }

    public void setRecommendations(List<String> recommendations) {
        // Liste klonen
        this.recommendations = new ArrayList<>(recommendations);
    }

    

}
