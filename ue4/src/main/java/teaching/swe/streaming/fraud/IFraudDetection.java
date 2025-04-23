package teaching.swe.streaming.fraud;

import teaching.swe.streaming.LoginRequest;

public interface IFraudDetection {
    
    public boolean isFraud(LoginRequest request);
}
