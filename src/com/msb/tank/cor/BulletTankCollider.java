package com.msb.tank.cor;


import com.msb.tank.Bullet;
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
            if (b.collideWith(t)){
                return false;
            }
        }else if(o1 instanceof  Tank && o2 instanceof  Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
