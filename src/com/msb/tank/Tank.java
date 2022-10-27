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
    private static final int SPEED = 5;
    //坦克的大小
    public static int WIDTH = ResourceMgr.tankU.getWidth(), HEIGHT = ResourceMgr.tankU.getHeight();
    //坦克的移动状态
    private boolean moving = false;
    //引用TankFrame
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public void paint(Graphics g) {
        //根据方向换出坦克：
        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.tankU, x, y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.tankD, x, y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.tankL, x, y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.tankR, x, y,null);
                break;
            default:
                break;
        }

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

    //坦克开火打出子弹
    public void fire() {
        int bx = this.x + ((WIDTH - Bullet.WIDTH)/2);
        int by = this.y + ((HEIGHT - Bullet.HEIGHT)/2);
        tf.bullets.add(new Bullet(bx, by, this.dir,this.tf));
    }
}
