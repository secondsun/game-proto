package dev.secondsun.gameproto;

import javax.swing.JFrame;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        var frame = new JFrame("Game Demo");
        frame.setSize(640, 480);
        frame.add(new RenderWindow());
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }
}
