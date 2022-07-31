package uet.oop.bomberman;

import javafx.scene.Scene;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.entities.animatableEntities.Bomb;
import uet.oop.bomberman.entities.animatableEntities.Brick;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.graphics.Sprite;


import java.util.ArrayList;
import java.util.List;


public class Board {
    public int width;
    public int height;
    private int level = 0;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();

    // Tránh java.util.ConcurrentModificationException
    private List<Entity> entitiesBuffer = new ArrayList<>();
    private List<Entity> StillObjectsBuffer = new ArrayList<>();
    private Scene scene = null;

    public Board(Scene scene, int level){
        this.scene = scene;
        this.level = level;


    }

    public int getLevel() {
        return level;
    }

    public Scene getScene() {
        return scene;
    }

    public List<Entity> getEntities() {
        return entities;
    }

    public List<Entity> getStillObjects() {
        return stillObjects;
    }

    public Entity getStillObjectsByBoard(int boardX, int boardY) {
        // trả về stillObject ở trên cùng
        for (int i = stillObjects.size() - 1;i >= 0; --i) {
            Entity object = stillObjects.get(i);
            if (object.getBoardX() == boardX && object.getBoardY() == boardY ) {
                return object;
            }
        }
        return null;
    }

    public Entity getStillObjectsByCanvas(int x, int y) {
        // Trả về stillObject ở trên cùng
        for (int i = stillObjects.size() - 1; i >= 0; --i) {
            Entity object = stillObjects.get(i);
            if (object.getBoardX() == x / Sprite.SCALED_SIZE && object.getBoardY() == y/ Sprite.SCALED_SIZE) {
                return object;
            }
        }
        return null;
    }

    public boolean isWall(int x, int y) {
        if (this.getStillObjectsByBoard(x, y) instanceof Wall) {
            return true;
        } else
            return false;
    }

    public boolean isBrick(int x, int y) {
        if (this.getStillObjectsByBoard(x, y) instanceof Brick) {
            return true;
        } else
            return false;
    }

    public boolean isBomb(int x, int y) {
        if(this.getStillObjectsByBoard(x, y) instanceof Bomb) {
            return true;
        } else
            return false;
    }

    public Entity getBomber() {
        for (int i = entities.size() - 1; i >= 0; i--) {
            Entity object = entities.get(i);
            if (object instanceof Bomber) {
                return object;
            }
        }
        return null;
    }

    public boolean bomberIsOnBomb() {
        Entity bomber = getBomber();
        for (Entity e : stillObjects()) {
            if (e instanceof Bomb && e.getBoardX() == bomber.getBoardX() && e.getBoardY() == bomber.getBoardY()) {
                return true;
            }
        }
        return false;
    }




}
