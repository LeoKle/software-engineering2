package teaching.swe.streaming.fraud;

import java.util.Arrays;
import java.util.List;

import teaching.swe.streaming.LoginRequest;

public class FraudDetection implements IFraudDetection {

    private List<String> allowedCountries = Arrays.asList("DE", "EN", "FR");

    public FraudDetection() {
        System.out.println("FD: Initialisierungen auf dem Produktivsystem durchführen...");
    }

    public boolean isFraud(LoginRequest request) {
        System.out.print("FD: Fraud Check für User '" + request.getUserName() + "' in " + request.getLocation());

        return allowedCountries.contains(request.getLocation());
    }

}
