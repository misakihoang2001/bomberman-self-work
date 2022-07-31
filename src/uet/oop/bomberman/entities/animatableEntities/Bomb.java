package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;

public class Bomb extends AnimatableEntites {
    private boolean exploded = false;
    private final double animateTime = 2.65 * 60;

    public Bomb(int boardX, int boardY, Image img, Board board) {
        super(boardX, boardY, img, board);
    }

    public void animate() {
        if (!exploded) {
            if (anime < animateTime) {
                anime++;
                imageAnimationHandler();
            } else {
                exploded();
            }
        }
    }

    @Override
    public void collide(Entity entity) {
        if (entity instanceof Flame)
    }


}
