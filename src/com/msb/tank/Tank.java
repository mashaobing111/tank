package com.msb.tank;

import com.msb.tank.observer.TankFireEvent;
import com.msb.tank.observer.TankFireHandler;
import com.msb.tank.observer.TankFireObserver;
import com.msb.tank.strategy.FireStrategy;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 * @author: msb
 * @date: 2022/10/24 - 10 - 24 - 17:01
 * @description: com.msb.tank
 * @version: 1.0
 */
public class Tank extends GameObject{
    //坦克的初始位置
    public int oldX, oldY;
    //坦克的初始方向
    public Dir dir = Dir.DOWN;
    //坦克的速度
    private static final int SPEED = Integer.parseInt((String)PropertyMgr.get("tankSpeed"));
    //坦克的大小
    public static int WIDTH = ResourceMgr.goodTankU.getWidth(), HEIGHT = ResourceMgr.goodTankU.getHeight();
    //坦克的移动状态
    private boolean moving = true;
    //创建随机数对象
    private Random random = new Random();
    //坦克生存状态
    private boolean living = true;
    //默认坦克阵营
    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();

    /*transient*/ FireStrategy fs;

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public Tank(int x, int y, Dir dir, Group group) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;

        rect.x = this.x;
        rect.y = this.y;
        rect.width = WIDTH;
        rect.height = HEIGHT;
        if (this.group == Group.GOOD) {
            String goodFSName = (String)PropertyMgr.get("goodFs");

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
        GameModel.getInstance().add(this);

    }

    public void paint(Graphics g) {
        if(!living) {
            GameModel.getInstance().remove(this);
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

        //记录坦克移动之前的位置
        oldX = x;
        oldY = y;
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
        fs.fire(this);
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

    public Rectangle getRect() {
        return rect;
    }

    //坦克相撞后回到上一次的位置
    public void back(){
        x = oldX;
        y = oldY;
    }
    @Override
    public int getWidth() {
        return WIDTH;
    }

    @Override
    public int getHeight() {
        return HEIGHT;
    }

    private List<TankFireObserver> fireObservers = Arrays.asList(new TankFireHandler());
    private void handleFireKey(){
        TankFireEvent event = new TankFireEvent(this);
        for (TankFireObserver o : fireObservers){
            o.actionOnFire(event);
        }
    }
}
