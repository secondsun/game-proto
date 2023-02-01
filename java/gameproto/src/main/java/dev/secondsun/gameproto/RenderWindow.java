package dev.secondsun.gameproto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import dev.secondsun.gameproto.structs.Camera;
import dev.secondsun.gameproto.structs.Polygon;

public class RenderWindow extends JPanel {

    public BufferedImage render(Polygon[] polys, Camera camera) throws IOException{
        return null;
    }

    @Override
    public void paint(Graphics g) {
        int width = getWidth();
        int height = getHeight();
        var color = Color.RED;
        try {
            super.paint(g);
            g.setColor(color);
            g.fillRect(0, 0, width, height);
            Thread.sleep(1000/60);
            repaint();
        } catch (InterruptedException e) {
        }      
    }
}
