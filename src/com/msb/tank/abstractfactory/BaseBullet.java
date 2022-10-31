package com.msb.tank.abstractfactory;

import com.msb.tank.Tank;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:07
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public abstract class BaseBullet {
    public abstract void paint(Graphics g);

    public abstract void collideWith(BaseTank tank);
}
