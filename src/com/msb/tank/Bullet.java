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
    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("bulletSpeed"));//子弹速度
    public static int WIDTH = ResourceMgr.bulletU.getWidth(), HEIGHT = ResourceMgr.bulletU.getHeight();//子弹大小
    private  boolean living = true;//子弹状态
    private Group group = Group.BAD;//子弹队伍区分
    Rectangle rect = new Rectangle();
    TankFrame tf = null;
    public Bullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;

        tf.bullets.add(this);
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
        rect.x = this.x;
        rect.y = this.y;
        if (x < 0 || y < 0 || x > TankFrame.GAME_WIDTH || y > TankFrame.GAME_HEIGHT) living = false;//设置边界 判断子弹是否超出边界
    }

    public void collideWith(Tank tank) {//碰撞检测
        if (this.group == tank.getGroup()) return;//判断子弹与坦克的阵营
        //碰撞检测
        if (rect.intersects(tank.rect)){
            tank.die();
            this.die();
            //在坦克中心爆炸
            int ex = tank.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
            int ey = tank.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
            tf.explodes.add(new Explode(ex,ey,tf));
        }
    }

    private void die() {//子弹死亡
        this.living = false;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
