package dev.secondsun.gameproto.structs;

public record Vector4(double x, double y, double z, double w) {

    public static Vector4 of(double x, double y, double z, double w) {
        return new Vector4(x,y,z,w);
    }
    
}
