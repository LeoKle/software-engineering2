package teaching.swe.streaming.fraud;

import teaching.swe.streaming.LoginRequest;

public class FraudDetectionMock implements  IFraudDetection {

    public FraudDetectionMock() {
        System.out.println("FD-MOCK: wird instanziiert...");
    }

    @Override
    public boolean isFraud(LoginRequest request) {
        System.out.print("FD-MOCK: Fraud Check für User '" + request.getUserName() + "' in " + request.getLocation());
        return (!"DE".equals(request.getLocation()));
    }
    
}
