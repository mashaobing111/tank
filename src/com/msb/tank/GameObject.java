package com.msb.tank;

import java.awt.*;
import java.io.Serializable;

/**
 * @author: msb
 * @date: 2022/11/1 - 11 - 01 - 16:57
 * @description: com.msb.tank
 * @version: 1.0
 */
public abstract class GameObject implements Serializable {//创建一个游戏物体的父类抽象
    public int x, y;  //protected ：子类能使用父类属性
    public abstract void paint(Graphics g);
    public abstract int getWidth();
    public abstract int getHeight();
}
