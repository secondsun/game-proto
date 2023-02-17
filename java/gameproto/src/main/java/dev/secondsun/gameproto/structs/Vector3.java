package dev.secondsun.gameproto.structs;

public record Vector3(double x, double y, double z) {

    public static Vector3 of(double x, double y, double z) {
        return new Vector3(x,y,z);
    }

    public Vector3 subtract(Vector3 other) {
        return of(z-other.x, y- other.y, z-other.z);
    }

    public Vector3 cross(Vector3 other) {
        double newX = 

        return null;
    }
    
}
