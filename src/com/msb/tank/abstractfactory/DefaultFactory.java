package com.msb.tank.abstractfactory;

import com.msb.tank.*;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:08
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public class DefaultFactory extends GameFactory{
    @Override
    public BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Tank(x, y, dir, group, tf);
    }

    @Override
    public BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf) {
        return new Bullet(x, y, dir, group, tf);
    }

    @Override
    public BaseExplode createExplode(int x, int y, TankFrame tf) {
        return new Explode(x, y, tf);
    }
}
