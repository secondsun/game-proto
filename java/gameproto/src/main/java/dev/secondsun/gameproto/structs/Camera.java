package dev.secondsun.gameproto.structs;

public record Camera(Vector3 lookAt, Vector3 posiiton, Vector3 up) {

    public Matrix4 lookAtMatrix() {
        Vector3 zaxis = normalize(lookAt.subtract(posiiton));    
        Vector3 xaxis = normalize(zaxis.cross(up));
        Vector3 yaxis = xaxis.cross(zaxis);
      
        zaxis = zaxis.negate();
      
        Matrix4 viewMatrix = new Matrix4(
          Vector4.of(xaxis.x(), xaxis.y(), xaxis.z(), -dot(xaxis, posiiton)),
          Vector4.of(yaxis.x(), yaxis.y(), yaxis.z(), -dot(yaxis, posiiton)),
          Vector4.of(zaxis.x(), zaxis.y(), zaxis.z(), -dot(zaxis, posiiton)),
          Vector4.of(0, 0, 0, 1)
        );
      
        return viewMatrix;
    }
    
}
