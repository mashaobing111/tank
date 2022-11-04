package com.msb.tank.cor;

import com.msb.tank.GameObject;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 17:50
 * @description: com.msb.tank.cor
 * @version: 1.0
 */
public interface Collider {
    boolean collide(GameObject o1, GameObject o2);
}
