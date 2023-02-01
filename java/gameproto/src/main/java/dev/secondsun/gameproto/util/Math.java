package dev.secondsun.gameproto.util;

import java.math.BigDecimal;

public final class Math {
    private Math() {}

    /**
     * Caluculate the 8.8 fixed point sqrt of input 
     * based on https://github.com/chmike/fpsqrt/blob/master/fpsqrt.c
     * @param input
     * @return
     */
    public static short sqrt88(short input){
        int t, q, b, r;
        r = input;
        b = 0x4000;
        q = 0;
        while( b > 0x4 )
        {
            t =  (0xFFFF) & (q + b);
            if( r >= t )
            {
                r -= t;
                q = (0xFFFF) & (t + b); // equivalent to q += 2*b
            }
            r <<= 1;
            b >>= 1;
        }
        q >>= 4;
        return (short)q;
    }

    public static short to88Fixedpoint(double in) {
        return (short)((int)(in * 256 ) &  0x0FFFF);
    }

}
