package envelope;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class ControllerTest {


    @ParameterizedTest
    @ValueSource(strings = {"df", ".", "/ ", "56 ", " *"})
    void doContinueFail(String input) {
        assertFalse(input.equalsIgnoreCase("y") || input.equalsIgnoreCase("yes"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"y", "Y", "yes", "Yes", "yEs", "YES", "YEs", " yES", "  y   "})
    void doContinue(String input) {
        assertTrue(input.trim().equalsIgnoreCase("y") || input.trim().equalsIgnoreCase("yes"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"df", ".", "/ ", " "})
    void checkSideInputByNotNumbers(String input) throws NumberFormatException {
        Assertions.assertThrows(NumberFormatException.class, () -> {
            Double.parseDouble(input);
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"-8", "0", "-5.2"})
    void checkSideInputByNumbers(String input) {
        boolean actual = Double.parseDouble(input) > 0;
        assertFalse(actual);
    }

}