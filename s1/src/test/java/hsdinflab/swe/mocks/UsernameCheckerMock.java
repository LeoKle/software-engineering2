package hsdinflab.swe.mocks;

import hsdinflab.swe.UsernameChecker;

public class UsernameCheckerMock extends UsernameChecker {
    private boolean returnValue = true;

    public boolean isValid(String username) {
        return this.returnValue;
    }

    public void setReturnValue(boolean returnValue) {
        this.returnValue = returnValue;
    }
}
