package dev.secondsun.gameproto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.secondsun.gameproto.util.Math;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void pass() {
        Assertions.fail("Pick up reading https://www.geertarien.com/blog/2017/07/30/breakdown-of-the-lookAt-function-in-OpenGL/");
    }

    @Test
    public void fixedPointSquareRoot88() {
    // var q = Math.sqrt88((short) 0x0400);
    // assertEquals(0x0200, q);
    
    // q = Math.sqrt88((short) 0x1000);
    // assertEquals(0x0400, q);

    var q = Math.sqrt88((short) 0x6E40);//110.25
    assertEquals(0x0A80, q);//10.5

    q = Math.sqrt88((short) 0x48cf);
    assertEquals(0x0888, q);

}

@Test
public void testTo88() {
    assertEquals(0x0100, Math.to88Fixedpoint(1));
    
    assertEquals(0x0A80, Math.to88Fixedpoint(10.5));
    
    assertEquals(0x6E40, Math.to88Fixedpoint(110.25));
    assertEquals(0x7D1f, Math.to88Fixedpoint(125.123));
    assertEquals(0x48cf, Math.to88Fixedpoint(72.81));

}

}