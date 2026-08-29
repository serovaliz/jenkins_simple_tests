package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class NegativeTests {
    @Test
    public void testNegative() {
        assertFalse(true);
    }
    @Test
    public void testNegative1() {
        assertFalse(true);
    }
    @Test
    public void testNegative2() {
        assertFalse(true);
    }
    @Test
    public void testNegative3() {
        assertFalse(true);
    }
    @Test
    public void testNegative4() {
        assertFalse(true);
    }

    @Test
    @Disabled("Не нужен?")
    public void testDisabled() {
        assertFalse(false);
    }
}
