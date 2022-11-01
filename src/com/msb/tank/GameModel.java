package com.msb.tank;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 15:18
 * @description: com.msb.tank
 * @version: 1.0
 */
public class GameModel {
    //创建我方坦克
    Tank myTank = new Tank(200,890,Dir.UP,Group.GOOD,this);
    //创建子弹集合
    java.util.List<Bullet> bullets = new ArrayList<>();
    //创建敌方坦克集合
    java.util.List<Tank> tanks = new ArrayList<>();
    //创建坦克爆炸集合
    List<Explode> explodes = new ArrayList<>();
    public GameModel() {
        //获取配置文件敌方坦克数量
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //创建敌方坦克：
        for (int i = 0; i < initTankCount; i++) {
            for (int j = 0; j < 1; j++) {
                tanks.add(new Tank(50 + i *100, 200 + j * 70, Dir.DOWN, Group.BAD, this));
            }

        }
    }

    public void paint(Graphics g) {
        Color c = g.getColor();//获取子弹的数量
        g.setColor(Color.white);
        g.drawString("子弹的数量：" + bullets.size(),10,50);
        g.drawString("敌人的数量：" + tanks.size(),10,70);
        g.drawString("爆炸的数量：" + explodes.size(),10,90);
        g.setColor(c);

        myTank.paint(g);//绘制坦克
        for (int i = 0; i <bullets.size() ; i++) {
            bullets.get(i).paint(g);//绘制子弹
        }
        //绘制敌方坦克
        for (int i = 0; i < tanks.size(); i++) {
            tanks.get(i).paint(g);
        }
        //绘制爆炸
        for (int i = 0; i < explodes.size(); i++) {
            explodes.get(i).paint(g);
        }
        //碰撞检测
        for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));

            }

        }
        /*   for(Iterator<Bullet> it = bullets.iterator();it.hasNext();){
            Bullet b = it.next();
            if(!b.live) it.remove();
        }*/
    }
    public Tank getMainTank(){
        return myTank;
    }
}
