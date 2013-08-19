package MyCalculator;

import java.io.IOException;

/**
 * Main class for the project.
 * 
 * @author dennis.markmann
 * @since JDK.1.7.0_25
 * @version 1.0
 */

public final class Main { // NO_UCD

    private Main() {
        // Should prevent instantiation, throws an exception in case this still
        // is called somehow.
        throw new AssertionError("Instantiating utility class");
    }

    public static void main(final String[] args) throws IOException {
        new Controller().createGui();
    }
}
