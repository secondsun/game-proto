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
        int t, root, bit, numb;
        numb = input;
        bit = 0x4000;
        root = 0;
        t = 0;
        while( bit > 0x4 )
        {
            t =  (0xFFFF) & (root + bit);
            if( numb >= t )
            {
                numb -= t;
                root = (0xFFFF) & (t + bit); // equivalent to root += 2*b
            }
            numb <<= 1;
            
            bit >>= 1;
        }
        root >>= 4;
        return (short)root;
    }

    public static short sqrt16(short input){
        return -1;
        //Use http://6502org.wikidot.com/software-math-sqrt
        // int t, root, bit, numb;
        // numb = input;
        // bit = 0x4000;
        // root = 0;
        // t = 0;
        // while( bit >=1  )
        // {
        //     t =  (0xFFFF) & (root + bit);
        //     if( numb >= t )
        //     {
        //         numb -= t;
        //         root = (0xFFFF) & (t + bit); // equivalent to root += 2*b
        //     }
        //     numb <<= 1;
            
        //     bit >>= 1;
        // }
        
        // return (short)root;
    }

    /**
     * Returns a 8.8 fixed point reciprocol of bottom.
     * IE 255 will return 0x00FF or 8 will return 0x0020
     * @param bottom
     * @return
     */
    public static int reciprocol(int divisor) {
        int dividend = 1;
        int quotient = 0;
        int remainder = dividend;

        for (int x = 0; x < 8; x++) {
            remainder = (remainder << 1);
            quotient =  (quotient<<1);
            if (divisor > remainder) {
            } else {
                quotient++;
                remainder -=divisor;
            }
        }


        return quotient;
    }


    public static short to88Fixedpoint(double in) {
        return (short)((int)(in * 256 ) &  0x0FFFF);
    }

}
