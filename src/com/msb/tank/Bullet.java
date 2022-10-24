package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:57
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Bullet {
    private int x, y;
    private Dir dir;
    private static final int SPEED = 10;
    private static final int WIDTH = 10, HEIGHT = 10;
    public Bullet(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }
    public void paint(Graphics g){
        Color c = g.getColor();
        g.setColor(Color.red);
        g.fillOval(x,y,WIDTH,HEIGHT);
        g.setColor(c);

        move();
    }
    private void move(){
        switch (dir){
            case UP:
                y -= SPEED;
                break;
            case DOWN:
                y += SPEED;
                break;
            case LEFT:
                x -= SPEED;
                break;
            case RIGHT:
                x += SPEED;
                break;
            default:
                break;
        }
    }
}
