package dev.secondsun.gameproto.structs;

public record Vector3(double x, double y, double z) {

    public static Vector3 of(double x, double y, double z) {
        return new Vector3(x,y,z);
    }

    public Vector3 subtract(Vector3 other) {
        return of(x-other.x, y- other.y, z-other.z);
    }

    public Vector3 cross(Vector3 other) {
        

        return Vector3.of(
            this.y*other.z - this.z*other.y, 
            this.z*other.x - this.x * other.z, 
            this.x*other.y - this.y*other.x
            );
    }

    public Vector3 negate() {
        return of(-x,-y,-z);
    }

    public double length() {
        return Math.sqrt(x*x+y*y+z*z);
    }
    
}
