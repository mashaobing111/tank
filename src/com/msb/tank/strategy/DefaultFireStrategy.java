package com.msb.tank.strategy;

import com.msb.tank.Bullet;
import com.msb.tank.GameModel;
import com.msb.tank.Tank;
import com.msb.tank.decorator.RectDecorator;
import com.msb.tank.decorator.TailDecorator;
import org.w3c.dom.css.Rect;


/**
 * @author: msb
 * @date: 2022/10/30 - 10 - 30 - 15:25
 * @description: com.msb.tank
 * @version: 1.0
 */
public class DefaultFireStrategy implements FireStrategy {

    @Override
    public void fire(Tank t) {
        int bx = t.getX() + Tank.WIDTH / 2 - Bullet.WIDTH / 2;
        int by = t.getY() + Tank.HEIGHT /2 - Bullet.HEIGHT / 2;
        //装饰模式
        /*GameModel.getInstance().add(

                        new RectDecorator(
                                new TailDecorator(
                                new Bullet(bx, by, t.getDir(),t.getGroup()))));*/
        new Bullet(bx, by, t.getDir(), t.getGroup());
    }
}
