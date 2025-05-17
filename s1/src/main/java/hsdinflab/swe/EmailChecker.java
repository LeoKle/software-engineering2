package hsdinflab.swe;

public class EmailChecker {

    public boolean isValid(String email) {
        if (email == null || email.isBlank()) return false;

        int atIndex = email.indexOf('@');
        if (atIndex <= 0 || atIndex != email.lastIndexOf('@')) {
            return false;
        }

        String localPart = email.substring(0, atIndex);
        String domainPart = email.substring(atIndex + 1);

        if (localPart.isEmpty() || domainPart.isEmpty()) {
            return false;
        }

        int dotIndex = domainPart.indexOf('.');
        if (dotIndex <= 0 || dotIndex == domainPart.length() - 1) {
            return false;
        }

        return !email.contains(" ");
    }
}

