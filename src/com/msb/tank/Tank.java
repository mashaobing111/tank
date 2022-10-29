package com.msb.tank;

import java.awt.*;
import java.util.Random;

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
    //坦克的大小
    public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    //坦克的移动状态
    private boolean moving = false;
    //创建随机数对象
    private Random random = new Random();
    //坦克生存状态
    private boolean living = true;
    private Group group = Group.BAD;
    //引用TankFrame
    private TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;
    }

    public void paint(Graphics g) {
        if(!living) {
            tf.tanks.remove(this);
        }
        //根据方向换出坦克：
        switch (dir) {
            case UP:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankU : ResourceMgr.badTankU, x, y, null);//三元运算判断输出好坏坦克
                break;
            case DOWN:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankD : ResourceMgr.badTankD, x, y, null);
                break;
            case LEFT:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankL : ResourceMgr.badTankL, x, y, null);
                break;
            case RIGHT:
                g.drawImage(this.group ==Group.GOOD ? ResourceMgr.goodTankR : ResourceMgr.badTankR, x, y, null);
                break;
            default:
                break;
        }
        move();

    }
    //移动方法
    private void move(){
        //如果移动状态为false 则跳出
        if (this.group == Group.GOOD){
            if (!moving) return;
        }else if (moving) return;

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
        if (this.group == Group.BAD && random.nextInt(100) > 97 ){
            this.fire();
        }
        if (this.group == Group.BAD && random.nextInt(100) >95)
            randomDir();

        boundsCheck();
    }
    private void boundsCheck(){
        if (this.x < 2) this.x = 2;
        if (this.x > TankFrame.GAME_WIDTH - WIDTH - 3) this.x = TankFrame.GAME_WIDTH -WIDTH - 3;
        if (this.y < 30) this.y = 30;
        if (this.y > TankFrame.GAME_HEIGHT - HEIGHT - 3) this.y = TankFrame.GAME_HEIGHT -HEIGHT - 3;
    }
    private void randomDir(){

        this.dir = Dir.values()[random.nextInt(4)];
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    //坦克开火打出子弹
    public void fire() {
        int bx = this.x + WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.y + HEIGHT /2 - Bullet.HEIGHT / 2;
        tf.bullets.add(new Bullet(bx, by, this.dir,this.group, this.tf));
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void die() {
        this.living = false;

    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
