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
    private static final int SPEED = 10;//子弹速度
    private static final int WIDTH = 10, HEIGHT = 10;//子弹大小
    private  boolean live = true;//子弹状态
    TankFrame tf = null;
    public Bullet(int x, int y, Dir dir,TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }
    public void paint(Graphics g){
        if (!live){//子弹消亡就移除
            tf.bullets.remove(this);
        }

        switch (dir){
            case UP:
                g.drawImage(ResourceMgr.bulletU,x,y,null);
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
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) live = false;//设置边界 判断子弹是否超出边界
    }
}
