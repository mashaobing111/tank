package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:01
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Tank {
    //坦克的初始位置
    private int x, y;
    //坦克的初始方向
    private Dir dir = Dir.DOWN;
    //坦克的速度
    private static final int SPEED = 10;

    //坦克的移动状态
    private boolean moving = false;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir) {
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public void paint(Graphics g) {
        Color c = g.getColor();//获取老的颜色
        g.setColor(Color.yellow);//设置颜色
        //创建一个填充矩形
        g.fillRect(x,y,50,50);
        //根据坦克的方向移动
        g.setColor(c);
        move();

    }
    //移动方法
    private void move(){
        //如果移动状态为false 则跳出
        if (!moving) return;
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

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }
}
