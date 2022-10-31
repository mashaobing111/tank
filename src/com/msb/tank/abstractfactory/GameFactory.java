package com.msb.tank.abstractfactory;

import com.msb.tank.Dir;
import com.msb.tank.Group;
import com.msb.tank.TankFrame;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:02
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public abstract class GameFactory {
    public abstract BaseTank createTank(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseBullet createBullet(int x, int y, Dir dir, Group group, TankFrame tf);
    public abstract BaseExplode createExplode(int x, int y, TankFrame tf);
}
