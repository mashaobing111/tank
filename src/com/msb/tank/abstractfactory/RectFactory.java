package com.msb.tank.abstractfactory;

import com.msb.tank.*;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:36
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public class RectFactory extends GameFactory {
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectTank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new RectBullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new RectExplode(x, y, tf);
    }
}
