package com.msb.tank.cor;


import com.msb.tank.Bullet;
import com.msb.tank.Explode;
import com.msb.tank.GameObject;
import com.msb.tank.Tank;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 17:52
 * @description: com.msb.tank.cor
 * @version: 1.0
 */
public class BulletTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Tank){
            Bullet b = (Bullet)o1;
            Tank t = (Tank)o2;
            if (b.group == t.getGroup()) return false;//判断子弹与坦克的阵营
            //碰撞检测
            if (b.rect.intersects(t.rect)){
                t.die();
                b.die();
                //在坦克中心爆炸
                int ex = t.getX() + Tank.WIDTH / 2 - Explode.WIDTH / 2;
                int ey = t.getY() + Tank.HEIGHT / 2 - Explode.HEIGHT / 2;
               new Explode(ex,ey);
                return true;
            }
        }else if(o1 instanceof  Tank && o2 instanceof  Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
