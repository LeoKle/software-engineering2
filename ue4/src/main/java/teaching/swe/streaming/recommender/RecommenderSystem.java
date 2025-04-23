package teaching.swe.streaming.recommender;

import java.util.Arrays;
import java.util.List;

import teaching.swe.streaming.LoginRequest;

public class RecommenderSystem implements IRecommenderSystem {

    // private final List<String> movies =
    //     Arrays.asList("Movie 1", "Movie 2", "Movie 3", "Movie 4", "Movie 5");

    public RecommenderSystem() {
        System.out.println("RS: Initialisierungen auf dem Produktivsystem durchführen...");
    }

    public List<String> recommend(LoginRequest request) {
        System.out.println("RS: Generierung von Empfehlungen auf Basis von KI-Algorithmen");
        System.out.println("RS: Für User '" + request.getUserName() + "' in " + request.getLocation());

        // Wähle zufällig einen Index für die Filme-Liste aus,
        // um verschiedene Empfehlungen zu simulieren
        // Random random = new Random();
        // int index1 = random.nextInt(movies.size());
        // int index2 = random.nextInt(movies.size());
        // System.out.println("I1: " + index1);
        // System.out.println("I1: " + index2);

        // return Arrays.asList(movies.get(index1), movies.get(index2));

        // Einfachheitshalber Empfehlungen "statisch" halten
        return Arrays.asList("Movie 1", "Movie 3");
    }
}
