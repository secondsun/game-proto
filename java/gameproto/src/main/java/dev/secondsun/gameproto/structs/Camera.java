package dev.secondsun.gameproto.structs;

import dev.secondsun.gameproto.util.Math;

public record Camera(Vector3 eye, Vector3 lookAt, Vector3 up) {

    /**
     * @return
     */
    public Matrix4 lookAtMatrix() {
        Vector3 zaxis = Math.normalize(lookAt.subtract(eye));    
        Vector3 xaxis = Math.normalize(zaxis.cross(up));
        Vector3 yaxis = xaxis.cross(zaxis);
      
        zaxis = zaxis.negate();
      
        Matrix4 viewMatrix = new Matrix4(
          Vector4.of(xaxis.x(), xaxis.y(), xaxis.z(), -Math.dot(xaxis, eye)),
          Vector4.of(yaxis.x(), yaxis.y(), yaxis.z(), -Math.dot(yaxis, eye)),
          Vector4.of(zaxis.x(), zaxis.y(), zaxis.z(), -Math.dot(zaxis, eye)),
          Vector4.of(0, 0, 0, 1)
        );
      
        return viewMatrix;
    }
    
}
