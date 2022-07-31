package uet.oop.bomberman.entities.animatableEntities;

import javafx.scene.image.Image;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.Portal;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.MoveableEntities;
import uet.oop.bomberman.entities.stillEntities.Wall;


public class Flame extends AnimatableEntites {
   private int size = 1;
   private String direction = "CENTER";
   private boolean edge = false;
   private final double animationTime = 0.35 * 60;

   public Flame(int boardX, int boardY, int size, Board board) {
       super(boardX, boardY, Sprite.bomb_exploded.getFxImage(), board);
       this.size = size;
       addFlameIfPossible();
   }

   private Flame(int boardX, int boardY, String direction, boolean isEdge, Board board) {
       super(boardX, boardY, null, board);
       this.direction = direction;
       this.edge = isEdge;
   }

   private void addFlameIfPossible() {
       int up = size, right = size, left = size, down = size;

       //UP
       for (int i = 1; i <= size; i++) {
           Entity entity = board.getStillObjectsByBoard(boardX, boardY - i);
           if (entity instanceof Wall || entity instanceof Portal) {
               up = i - 1;
               break;
           } else if(entity instanceof Brick) {
               up = i - 1;
               Brick brick = (Brick) entity;
               brick.destroy();
               break;
           }
       }
       if (up > 0) {
           for (int i = 1; i < up; i++) {
               board.add
           }
       }

   }
}
