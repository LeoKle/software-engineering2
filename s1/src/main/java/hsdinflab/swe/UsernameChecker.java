package hsdinflab.swe;

public class UsernameChecker {

    public boolean isValid(String username) {
        // -----------------------------------------------------------------//
        // Initialisiert den Checker (z. B. Vorbereitung interner Ressourcen)
        // Hinweis: Dieser Teil kann für die User Stories und Testfallanalyse ignoriert werden.
        System.out.println("Initialisiere UsernameChecker...");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            return false;
        }   
        // -----------------------------------------------------------------//

        if (username == null || username.isBlank()) {
            return false;
        }

        int length = username.length();
        if (length < 4 || length > 15) {
            return false;
        }

        for (int i = 0; i < length; i++) {
            char c = username.charAt(i);
            if (!isValidChar(c)) {
                return false;
            }
        }

        return true;
    }

    private boolean isValidChar(char c) {
        return Character.isLetterOrDigit(c) || c == '_'; // allows any unicode letter or digit, and underscore
    }
}
