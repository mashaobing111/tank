package com.msb.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: msb
 * @date: 2022/10/27 - 10 - 27 - 14:49
 * @description: com.msb.tank
 * @version: 1.0
 */
public class ResourceMgr {
    //定义坦克方向变量：
    public static BufferedImage tankU, tankD, tankL, tankR;
    //定义子弹方向变量：
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    //定义爆炸数组
    public static BufferedImage[] explodes = new BufferedImage[9];
    static{
        try {
            //导入坦克方向
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageUtil.rotateImage(tankU,180);
            tankL = ImageUtil.rotateImage(tankU,-90);
            tankR = ImageUtil.rotateImage(tankU,90);
            //导入子弹方向：
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            bulletD = ImageUtil.rotateImage(bulletU,180);
            bulletL = ImageUtil.rotateImage(bulletU,-90);
            bulletR = ImageUtil.rotateImage(bulletU,90);
            for (int i = 0; i < 9; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e" + (i+1) +".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
