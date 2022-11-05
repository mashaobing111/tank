package com.msb.tank.cor;


import com.msb.tank.Bullet;
import com.msb.tank.GameObject;
import com.msb.tank.Tank;
import com.msb.tank.Wall;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 17:52
 * @description: com.msb.tank.cor
 * @version: 1.0
 */
public class TankWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Tank && o2 instanceof Wall) {
            Tank t = (Tank) o1;
            Wall w = (Wall) o2;
            if (t.getRect().intersects(w.rect)) {
                t.back();

            } else if (o1 instanceof Wall && o2 instanceof Tank) {
                return collide(o2, o1);
            }
        }
        return true;
    }
}
