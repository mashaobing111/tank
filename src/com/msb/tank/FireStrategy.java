package com.msb.tank;

import com.msb.tank.abstractfactory.BaseTank;

/**
 * @author: msb
 * @date: 2022/10/30 - 10 - 30 - 15:23
 * @description: com.msb.tank
 * @version: 1.0
 */
public interface FireStrategy {
    void fire(Tank t);
}
