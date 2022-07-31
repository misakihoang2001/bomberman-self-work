package uet.oop.bomberman.entities;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.shape.Rectangle;
import uet.oop.bomberman.Board;
import uet.oop.bomberman.graphics.Sprite;

public abstract class Entity {
    //Tọa độ X tính từ góc trái trên trong Canvas
    protected int x;

    //Tọa độ Y tính từ góc trái trên trong Canvas
    protected int y;

    protected int boardX;
    protected int boardY;

    protected Image img;
    protected EntityRectangle realBodyRectangle;
    protected Board board = null;

    public void removeFromBoard() {
        this.removedFromBoard = true;
    }

    public boolean isRemoveFromBoard() {
        return removedFromBoard;
    }

    protected boolean removedFromBoard = false;




    //Khởi tạo đối tượng, chuyển từ tọa độ đơn vị sang tọa độ trong canvas
    public Entity( int boardX, int boardY, Image img, Board board) {
        this.boardX = boardX;
        this.boardY = boardY;
        this.x = boardX * Sprite.SCALED_SIZE;
        this.y = boardY * Sprite.SCALED_SIZE;
        this.img = img;
        this.realBodyRectangle = new EntityRectangle( x, y, Sprite.SCALED_SIZE, Sprite.SCALED_SIZE);
        this.board = board;
    }

    public Rectangle getRealBodyRectangle() {
        return realBodyRectangle;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getBoardX() {
        return boardX;
    }

    public void setBoardX(int boardX) {
        this.boardX = boardX;
    }

    public int getBoardY() {
        return boardY;
    }

    public void setBoardY(int boardY) {
        this.boardY = boardY;
    }

    public void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
    }
    public abstract void update();
}
