package envelope;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EnvelopeTest {


    @Test
    void putTo_valid() {
        Envelope en1 = new Envelope(10, 20);
        Envelope en2 = new Envelope(5, 5);
        boolean actual = en2.putTo(en1);
        assertTrue(actual);
    }

    @Test
    void putTo_invalid() {
        Envelope en1 = new Envelope(5, 5);
        Envelope en2 = new Envelope(9, 9);
        boolean actual = en2.putTo(en1);
        assertFalse(actual);
    }

    @Test
    void putWithAngleIn_invalid() {
        Envelope en1 = new Envelope(5, 5);
        Envelope en2 = new Envelope(5.6, 0.2);
        boolean actual = en1.putWithAngleIn(en2);
        assertFalse(actual);
    }

    @Test
    void putWithAngleIn_valid() {
        Envelope en1 = new Envelope(5, 5);
        Envelope en2 = new Envelope(5.6, 0.2);
        boolean actual = en2.putWithAngleIn(en1);
        assertTrue(actual);
    }

}