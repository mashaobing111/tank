package com.msb.tank.abstractfactory;

import com.msb.tank.Group;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/10/31 - 10 - 31 - 17:06
 * @description: com.msb.tank.abstractfactory
 * @version: 1.0
 */
public abstract class BaseTank {
    //默认坦克阵营
    public Group group = Group.BAD;

    public Rectangle rect = new Rectangle();
    public abstract void paint(Graphics g);

    public Group getGroup(){
        return this.group;
    }

    public abstract void die();

    public abstract int getX();

    public abstract int getY();
}
