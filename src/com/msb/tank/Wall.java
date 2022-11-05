package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/11/4 - 11 - 04 - 16:06
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Wall extends GameObject {
    int w, h;
    public  Rectangle rect;

    public Wall(int x, int y, int w, int h) {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;

        this.rect = new Rectangle(x, y, w, h);
    }

    @Override
    public void paint(Graphics g) {
        Color c = g.getColor();
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x, y, w, h);
        g.setColor(c);
    }
    @Override
    public int getWidth() {
        return w;
    }

    @Override
    public int getHeight() {
        return h;
    }
}
