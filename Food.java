import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.application.Platform;

import java.util.Random;

public class Food extends Pane {
    private Map map;
    private Player pl;
    private Label seconds;
    private int unit = 50;
    private int [][] mapLikeCell;
    private Position foodPosition;
    private int points = 0;
    private int time = 5;
    private int size;
    private int numberOfBalls = 10;
    private Circle food;

    public Food(Map var1,Player var2){
        this.map = var1;
        this.pl = var2;
        this.mapLikeCell = this.map.getMap();
        this.size = this.map.getSize();


        Thread var3 = new Thread(() ->{
            while(this.numberOfBalls > 0)  {
                try {
                    createFood();
                }
                catch (Exception ex){}
                Platform.runLater(() -> {
                    getChildren().addAll(this.food, this.seconds);
                });
                for(this.time = 5; this.time > 0; --this.time) {
                    Platform.runLater(() -> {
                        this.seconds.setText("" + this.time);
                    });
                    if (this.pl.getPosition().getX()==this.foodPosition.getX() && this.pl.getPosition().getY()==this.foodPosition.getY()) {
                        this.points += this.time;
                        break;
                    }
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException var) {
                    }
                }
                try {
                    Thread.sleep(10L);
                } catch (InterruptedException var) {
                }
                Platform.runLater(() -> {
                    getChildren().clear();
                });
                this.numberOfBalls--;
            }
            System.out.println(this.getPoints());
        });
        var3.start();

    }

    public int getPoints() {
        return this.points;
    }

    private void createFood()throws Exception{
        Random random = new Random();
        boolean start = true;
        while (start) {
            int x = random.nextInt(7);
            int y = random.nextInt(7);
            int val = mapLikeCell[x][y];
            if (val != 1 && foodPosition != pl.getPosition()) {
                this.food = new Circle(unit * x + 25, unit * y + 25, unit / 2 - 10, Color.GREEN);
                start = false;
                foodPosition = new Position(unit * x + 25, unit * y + 25);
                this.seconds = new Label("5");
                this.seconds.setTranslateX((double) x * unit);
                this.seconds.setTranslateY((double) y * unit);
            }
        }
    }
}
