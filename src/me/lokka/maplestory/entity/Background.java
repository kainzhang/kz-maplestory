package me.lokka.maplestory.entity;

import me.lokka.maplestory.client.MapleStoryClient;
import me.lokka.maplestory.constant.Constant;
import me.lokka.maplestory.util.ImageUtil;

import java.awt.*;

/**
 * @Description 背景图片类
 * @Author: kainzhang (张健)
 * @Date: 2020/11/30 10:45 AM
 */
public class Background extends AbstractMapleStoryObject{

    public Background() {
        this.speed = Constant.HERO_SPEED;
    }

    public Background(MapleStoryClient msc, Image img) {
        this();
        this.msc = msc;
        this.img = img;
        this.width = img.getWidth(null);
        this.height = img.getHeight(null);
        this.x = 0;
        this.y = Constant.GAME_HEIGHT - this.height;
        this.dir = Direction.LEFT;
        this.action = Action.STAND;
    }

    @Override
    public void move() {
        switch (msc.hero.dir) {
            case RIGHT:
                if (msc.hero.moving
                        && msc.hero.x > Constant.GAME_WIDTH / 2 - msc.hero.width / 2
                        && x + width > Constant.GAME_WIDTH
                ) {
                    x -= speed;
                    msc.hero.speed = 0;
                } else {
                    msc.hero.speed = Constant.HERO_SPEED;
                }
                break;

            case LEFT:
                if (msc.hero.moving
                        && msc.hero.x < Constant.GAME_WIDTH / 2 - msc.hero.width / 2
                        && x < 0
                ) {
                    x += speed;
                    msc.hero.speed = 0;
                } else {
                    msc.hero.speed = Constant.HERO_SPEED;
                }
                break;
        }
//        switch (msc.hero.verticalDir) {
//            case UP:
//                if (msc.hero.moving && msc.hero.y > Constant.GAME_HEIGHT / 2 - msc.hero.height / 2) {
//                    y += msc.hero.deltaHeight;
//                    msc.hero.y -= msc.hero.deltaHeight;
//                }
//                break;
//            case DOWN:
//                if (msc.hero.moving && msc.hero.y < Constant.GAME_HEIGHT / 2 - msc.hero.height / 2) {
//                    y -= msc.hero.deltaHeight;
//                    msc.hero.y += msc.hero.deltaHeight;
//                }
//                break;
//        }
    }

    @Override
    public void draw(Graphics g) {
        move();
        g.drawImage(img, x, y + 100, null);
//        ele.draw(g);
    }

    @Override
    public Rectangle getRectangle() {
        return null;
    }


//    Ele ele = new Ele();
//    class Ele extends AbstractMapleStoryObject {
//
//        public Ele() {
//            this.x = 500;
//            this.y = 625;
//            this.img = ImageUtil.getValue("logo").get(0);
//        }
//
//        @Override
//        public void draw(Graphics g) {
//            g.drawImage(img, x, y, null);
//        }
//
//        @Override
//        public void move() {
//
//        }
//    }
}
