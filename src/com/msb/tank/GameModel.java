package com.msb.tank;

import com.msb.tank.cor.BulletTankCollider;
import com.msb.tank.cor.Collider;
import com.msb.tank.cor.ColliderChain;
import com.msb.tank.cor.TankTankCollider;

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

    //创建碰撞器链表
    ColliderChain chain = new ColliderChain();
/*
    //创建子弹集合
    java.util.List<Bullet> bullets = new ArrayList<>();
    //创建敌方坦克集合
    java.util.List<Tank> tanks = new ArrayList<>();
    //创建坦克爆炸集合
    List<Explode> explodes = new ArrayList<>();
    */
    //创建游戏物体对象
    private List<GameObject> objects = new ArrayList<>();

    //构造游戏模型
    public GameModel() {
        //获取配置文件敌方坦克数量
        int initTankCount = Integer.parseInt((String)PropertyMgr.get("initTankCount"));
        //创建敌方坦克：
        for (int i = 0; i < initTankCount; i++) {
            for (int j = 0; j < 1; j++) {
                add(new Tank(50 + i *100, 200 + j * 70, Dir.DOWN, Group.BAD, this));
            }

        }
    }

    public void add(GameObject go){
        this.objects.add(go);
    }
    public void remove(GameObject go){
        this.objects.remove(go);
    }

    public void paint(Graphics g) {
        Color c = g.getColor();//获取子弹的数量
        g.setColor(Color.white);
        /*g.drawString("子弹的数量：" + bullets.size(), 10, 50);
        g.drawString("敌人的数量：" + tanks.size(),10,70);
        g.drawString("爆炸的数量：" + explodes.size(),10,90);*/
        g.setColor(c);

        myTank.paint(g);//绘制所有物体
        for (int i = 0; i <objects.size() ; i++) {
            objects.get(i).paint(g);//
        }

        //互相碰撞：
        for (int i = 0; i < objects.size(); i++) {
            for (int j=i+1; j < objects.size() ; j++) {
                GameObject o1 = objects.get(i);
                GameObject o2 = objects.get(j);
                chain.collide(o1, o2);
            }
        }
        //碰撞检测
       /* for (int i = 0; i < bullets.size(); i++) {
            for (int j = 0; j < tanks.size(); j++) {
                bullets.get(i).collideWith(tanks.get(j));

            }

        }*/
        /*   for(Iterator<Bullet> it = bullets.iterator();it.hasNext();){
            Bullet b = it.next();
            if(!b.live) it.remove();
        }*/
    }
    public Tank getMainTank(){
        return myTank;
    }
}
