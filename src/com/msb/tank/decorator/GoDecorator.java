package com.msb.tank.decorator;

import com.msb.tank.GameObject;

import java.awt.*;

/**
 * @author: msb
 * @date: 2022/11/5 - 11 - 05 - 16:02
 * @description: com.msb.tank.decorator
 * @version: 1.0
 */
public abstract class  GoDecorator extends GameObject {

    GameObject go;

    public GoDecorator(GameObject go) {

        this.go = go;
    }

    @Override
    public abstract void paint(Graphics g);

}
