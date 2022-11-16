package com.msb.tank.observer;

import com.msb.tank.Tank;

/**
 * @author: msb
 * @date: 2022/11/7 - 11 - 07 - 16:58
 * @description: com.msb.tank
 * @version: 1.0
 */
public class TankFireEvent {
    Tank tank;
    public Tank getSource(){
        return tank;
    }
    public TankFireEvent(Tank tank){
        this.tank = tank;
    }
}
