package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.entities.Entity;

public class Brick extends AnimatableEntites {
    public boolean destroyed = false;
    private final double animationTime = 0.35 * 60;

    public Brick(int boardX, int boardY, Image img, Board board ) {
        super( boardX, boardY, img, board);
    }

    public void animate() {
        if (destroyed) {
            if(anime < animationTime) {
                anime++;
                imageAnimationHandler();
            } else {
                removedFromBoard();
            }
        }
    }

    public void destroy() {
        destroyed = true;
    }

    @Override
    public void collide(Entity entity) {

    }

    @Override
    public void update() {
        animate();
        collisionHandler();
    }

    @Override
    public void imageAnimateionHandler() {
        assert destroyed;

    }
}
