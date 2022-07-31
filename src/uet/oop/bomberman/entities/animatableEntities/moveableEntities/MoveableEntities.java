package uet.oop.bomberman.entities.animatableEntities.moveableEntities;

import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import jdk.internal.foreign.ArenaAllocator;
import sun.security.provider.ConfigFile;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.graphics.Sprite;



public abstract class MoveableEntities extends AnimatableEntities {
    protected boolean up = false, left = false, down = false, right = false;
    protected String facingDirection = "RIGHT";
    protected boolean moving;
    protected boolean alive = true;
    protected double speed = 2.0 / Sprite.SCALE;
    protected final int DIE_TIME_SECOND = 2;
    protected int deadAnimeTime = 60 * DIE_TIME_SECOND;

    public boolean isAlive() {
        return alive;
    }

    public MoveableEntities(int boardX, int boardY, Image img, Board board) {
        super(boardX, boardY, img, board);
    }

    public void moveHandler() {
        int xS = 0, yS = 0;
        if(up) yS -= Math.ceil(speed * Sprite.SCALE);
        if(down) yS += Math.ceil(speed * Sprite.SCALE);
        if(left) xS -= Math.ceil(speed * Sprite.SCALE);
        if(right) xS += Math.ceil(speed * Sprite.SCALE);

        //Thứ tự quan trọng khi bấm phím cùng lúc

        if(xS > 0) facingDirection = "RIGHT";
        if(xS < 0) facingDirection = "LEFT";
        if(yS > 0) facingDirection = "DOWN";
        if(yS < 0) facingDirection = "UP";

        if (xS == 0 && yS == 0) {
            moving = false;
            return;
        }
        move(xS, yS);
        moving = true;
    }

    public void move(int xS, int yS) {
        // Chia ra làm 2 để xử lý khi ấn 2 nút lúc đang đập đầu vào
        if (canMove(xS, 0)) {
            this.x += xS;
            realBodyRectangle.setX
        }
    }

    public abstract boolean canMove(int xS, int yS);


}
