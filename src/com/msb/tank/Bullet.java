package com.msb.tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:57
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Bullet {
    private int x, y;//子弹位置
    private Dir dir;//子弹方向
    private static final int SPEED = 15;//子弹速度
    public static int WIDTH = ResourceMgr.bulletU.getWidth(), HEIGHT = ResourceMgr.bulletU.getHeight();//子弹大小
    private  boolean living = true;//子弹状态
    TankFrame tf = null;
    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if (!living){//子弹消亡就移除
            tf.bullets.remove(this);
        }

        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x ,y,null);
                break;
            case DOWN:
                g.drawImage(ResourceMgr.bulletD,x,y,null);
                break;
            case LEFT:
                g.drawImage(ResourceMgr.bulletL,x,y,null);
                break;
            case RIGHT:
                g.drawImage(ResourceMgr.bulletR,x,y,null);
                break;
            default:
                break;
        }


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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;//设置边界 判断子弹是否超出边界
    }

    public void collideWith(Tank tank) {
        Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
        Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
        if (rect1.intersects(rect2)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.living = false;
    }
}
