package com.msb.tank.cor;

import com.msb.tank.GameObject;
import com.msb.tank.PropertyMgr;

import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: msb
 * @date: 2022/11/4 - 11 - 04 - 14:46
 * @description: com.msb.tank.cor
 * @version: 1.0
 */
public class ColliderChain implements Collider {
    private List<Collider> colliders = new LinkedList<>();

    public ColliderChain() {
        add(new BulletTankCollider());
        add(new BulletWallCollider());
        add(new TankTankCollider());
        add(new TankWallCollider());
    }

    public void add(Collider c){
        colliders.add(c);
    }

    public boolean collide(GameObject o1, GameObject o2) {
        for (int i = 0; i < colliders.size(); i++) {
            if (!colliders.get(i).collide(o1, o2)){
                return false;
            }
        }
        return true;
    }
}
