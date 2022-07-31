package uet.oop.bomberman;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import uet.oop.bomberman.entities.Entity;
import uet.oop.bomberman.entities.stillEntities.Grass;
import uet.oop.bomberman.entities.stillEntities.Wall;
import uet.oop.bomberman.entities.animatableEntities.moveableEntities.Bomber;
import uet.oop.bomberman.graphics.Sprite;


import java.util.ArrayList;
import java.util.List;

import java.io.File;
import java.io.IOException;
import java.net.URL;

public class BombermanGame extends Application {
    
    public static final int SCREEN_WIDTH = 20;
    public static final int SCREEN_HEIGHT = 15;

    public static boolean running = false;
    public static int level = 1;
    public static double bomberSpeed = 2.0 / Sprite.SCALE;
    public static int totallevels = 4; // this could cause trouble

    public static int loopcount = 0;
    public static long start = System.currentTimeMillis();

    
    public static GraphicsContext gc;
    public static Canvas canvas;
    public static Stage screenStage;
    public static Pane screenPane = new Pane();
    //Tao scene
    public static Scene gameScene = new Scene(screenPane);

    //Tao board
    public static Board board = null;

//    private List<Entity> entities = new ArrayList<>();
//    private List<Entity> stillObjects = new ArrayList<>();



    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * SCREEN_WIDTH, Sprite.SCALED_SIZE * SCREEN_HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        createMap();

        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
