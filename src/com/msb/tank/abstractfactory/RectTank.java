package com.msb.tank.abstractfactory;

import com.msb.tank.*;

import java.awt.*;
import java.util.Random;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:01
 * @description: com.msb.tank
 * @version: 1.0
 */
public class RectTank extends BaseTank {
    //坦克的初始位置
    private int x, y;
    //坦克的初始方向
    private Dir dir = Dir.DOWN;
    //坦克的速度
    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("tankSpeed"));
    //坦克的大小
    public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    //坦克的移动状态
    private boolean moving = false;
    //创建随机数对象
    private Random random = new Random();
    //坦克生存状态
    private boolean living = true;
    //默认坦克阵营
    private Group group = Group.BAD;

    public Rectangle rect = new Rectangle();


    FireStrategy fs;

    //引用TankFrame
     TankFrame tf = null;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public RectTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        //判断我方坦克从四个方向打出子弹，敌方坦克从一个方向打出子弹
        if (this.group == Group.GOOD) {
            String goodFSName = (String)PropertyMgr.get("goodFs");//从config个获取value

            try {
                fs = (FireStrategy) Class.forName(goodFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }

        } else {
            String badFSName = (String)PropertyMgr.get("badFs");
            try {
                fs = (FireStrategy) Class.forName(badFSName).getDeclaredConstructor().newInstance();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    @Override
    public void paint(Graphics g) {
        if(!living) {
            tf.tanks.remove(this);
        }
        //根据方向换出坦克：
        Color c = g.getColor();
        g.setColor(group == Group.GOOD ? Color.red :Color.yellow);
        g.fillRect(x,y,50,50);
        g.setColor(c);
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

        rect.x = this.x;
        rect.y = this.y;
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
        //fs.fire(this);
        int bx = this.getX() + RectTank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = this.getY() + RectTank.HEIGHT /2 - Bullet.HEIGHT / 2;

        Dir[] dirs = Dir.values();
        for (Dir dir:dirs){
            tf.gf.createBullet(bx, by, dir ,getGroup(), tf);
        }
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
