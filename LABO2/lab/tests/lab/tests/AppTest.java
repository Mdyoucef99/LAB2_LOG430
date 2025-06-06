package lab.tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AppTest {

    @Test
    public void test1() {
        int a = 0;
        int b = 1;
        int c = a + b;
        assertEquals(1, c);
    }

    @Test
    public void test2() {
        int a = 1;
        int b = 1;
        int c = a + b;
        assertEquals(2, c);
    }
}
