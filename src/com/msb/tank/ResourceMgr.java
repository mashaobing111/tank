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
    public static BufferedImage tankU, tankD, tankL, tankR;

    static{
        try {
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
