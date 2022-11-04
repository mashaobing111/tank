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
public class TankTankCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Tank){
            Tank t1 = (Tank)o1;
            Tank t2 = (Tank)o2;
            if (t1.getRect().intersects(t2.getRect())){
                t1.stop();
                t2.stop();
            }
        }
        return true;
    }
}
