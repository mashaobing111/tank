package com.msb.tank.observer;

import com.msb.tank.Tank;

import java.io.Serializable;

/**
 * @author: msb
 * @date: 2022/11/7 - 11 - 07 - 17:03
 * @description: com.msb.tank.observer
 * @version: 1.0
 */
public interface TankFireObserver extends Serializable {
    void actionOnFire(TankFireEvent e);
}
