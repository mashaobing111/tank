package com.msb.tank.cor;

import com.msb.tank.*;

/**
 * @author: msb
 * @date: 2022/11/4 - 11 - 04 - 16:17
 * @description: com.msb.tank.cor
 * @version: 1.0
 */
public class BulletWallCollider implements Collider {
    @Override
    public boolean collide(GameObject o1, GameObject o2) {
        if (o1 instanceof Bullet && o2 instanceof Wall){
            Bullet b = (Bullet)o1;
            Wall w = (Wall)o2;
            //碰撞检测
            if (b.rect.intersects(w.rect)){
                b.die();
                return true;
            }
        }else if(o1 instanceof  Wall && o2 instanceof  Bullet) {
            return collide(o2, o1);
        }
        return true;
    }
}
