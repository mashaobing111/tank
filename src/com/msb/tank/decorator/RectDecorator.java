package com.msb.tank.decorator;

import com.msb.tank.GameObject;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/11/5 - 11 - 05 - 16:08
 * @description: com.msb.tank.decorator
 * @version: 1.0
 */
public class RectDecorator extends GoDecorator {

    public RectDecorator(GameObject go) {
        super(go);
    }

    @Override
    public void paint(Graphics g) {
        this.x = go.x;
        this.y = go.y;
        go.paint(g);

        Color c = g.getColor();
        g.setColor(Color.yellow);
        g.drawRect(super.go.x, super.go.y, getWidth()+3, getHeight()+3);
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
