package com.msb.tank.decorator;

import com.msb.tank.GameObject;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/11/5 - 11 - 05 - 16:08
 * @description: com.msb.tank.decorator
 * @version: 1.0
 */
public class TailDecorator extends GoDecorator {

    public TailDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.white);
        g.drawLine(super.go.x, super.go.y, super.go.x+getWidth(), super.go.y+getHeight());
        g.setColor(c);
    }

    @Override
    public int getWidth() {
        return super.go.getWidth();
    }

    @Override
    public int getHeight() {
        return super.go.getHeight();
    }

}
