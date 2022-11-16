package com.msb.tank.observer;

import com.msb.tank.Tank;

/**
 * @author: msb
 * @date: 2022/11/7 - 11 - 07 - 17:01
 * @description: com.msb.tank.observer
 * @version: 1.0
 */
public class TankFireHandler implements TankFireObserver{

    @Override
    public void actionOnFire(TankFireEvent e) {
        Tank t = e.getSource();
        t.fire();
    }
}
