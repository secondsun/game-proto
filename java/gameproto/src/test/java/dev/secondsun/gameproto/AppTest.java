package dev.secondsun.gameproto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.secondsun.gameproto.structs.Camera;
import dev.secondsun.gameproto.structs.Matrix4;
import dev.secondsun.gameproto.structs.Vector3;
import dev.secondsun.gameproto.util.Math;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void pass() {
        //Assertions.fail("Pick up reading https://www.geertarien.com/blog/2017/07/30/breakdown-of-the-lookAt-function-in-OpenGL/");
    }


@Test
public void testGsuLookAt() {
    var camera = new Camera(Vector3.of(0.0,0.0,0.0), Vector3.of(-1.5,0.0,-1.5), Vector3.of(0.0,1.0,0.0));
    Matrix4 matrix = camera.lookAtMatrix();
    assertEquals(0.7071067811865476, matrix.a().x());
    assertEquals(1.0000000000000002, matrix.b().y());
    assertEquals(-0.7071067811865476, matrix.a().z());
    assertEquals(0.7071067811865476, matrix.c().x());
    assertEquals(0.7071067811865476, matrix.c().z());


    camera = new Camera(Vector3.of(0.0,0.0,0.0), Vector3.of(-1.0,0.0,-1.5), Vector3.of(0.0,1.0,0.0));
    matrix = camera.lookAtMatrix();
    assertEquals(0.8320502943378437, matrix.a().x());
    assertEquals(1.0, matrix.b().y());
    assertEquals(-0.5547001962252291, matrix.a().z());
    assertEquals(0.5547001962252291, matrix.c().x());
    assertEquals(0.8320502943378437, matrix.c().z());

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
    q = Math.sqrt88((short) 0x400);
    assertEquals(0x200, q);
}

@Test
public void testTo88() {
    assertEquals(0x0100, Math.to88Fixedpoint(1));
    
    assertEquals(0x0A80, Math.to88Fixedpoint(10.5));
    
    assertEquals(0x6E40, Math.to88Fixedpoint(110.25));
    assertEquals(0x7D1f, Math.to88Fixedpoint(125.123));
    assertEquals(0x48cf, Math.to88Fixedpoint(72.81));

}

@Test
public void testReciprocol() {
    assertEquals(0x02, Math.reciprocol( 128));
    assertEquals(0x03, Math.reciprocol( 80));
    assertEquals(0x4, Math.reciprocol((short) 64));
    assertEquals(0x10, Math.reciprocol((short) 16));
    assertEquals(0x20, Math.reciprocol((short) 8));
    
}

}