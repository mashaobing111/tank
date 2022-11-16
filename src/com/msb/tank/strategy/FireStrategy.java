package com.msb.tank.strategy;

import com.msb.tank.Tank;

import java.io.Serializable;

/**
 * @author: msb
 * @date: 2022/10/30 - 10 - 30 - 15:23
 * @description: com.msb.tank
 * @version: 1.0
 */
public interface FireStrategy extends Serializable {
    void fire(Tank t);
}
