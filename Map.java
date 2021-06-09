import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Map extends Pane {
    private int unit=50;
    private int size;
    private int[][] map;
    private Position start;
    Circle circle = new Circle();

    public Map(String n) throws Exception{
        String firstLine = Files.readAllLines(Paths.get(n)).get(0);//gets the first line's number which is the amount of rows and columns
        size = Integer.valueOf(firstLine);//converts it to integer
        map = new int[size][size];//creates a two-dimensional array
        int everyLine = 1;

        for (int i = 0; i<size;i++){
            String lines = Files.readAllLines(Paths.get(n)).get(everyLine);//reads every line of txt file from 1'st line till the size of it
            String[] everyNum = lines.split("\\s+");//splits this line by space
            for (int k = 0; k < everyNum.length; k++) {//reads every element of splited line
                map[k][everyLine-1]=Integer.valueOf(everyNum[k]);//gives a value to map at x(k) and y(everyLine-1)
                Rectangle rect = new Rectangle(unit,unit);//creates a rectangle
                rect.setTranslateX(k*unit);//gives it's place on x
                rect.setTranslateY((everyLine-1)*unit);//gives it's place on y
                rect.setStroke(Color.BLACK); //strokes it with black color
                if (everyNum[k].equals("2")){ //if checking number equals 2 than says that it's start pos and fills rectangle with white color
                    rect.setFill(Color.WHITE);
                    circle.setCenterX(unit*k+25);
                    circle.setCenterY(unit*i+25);
                    circle.setRadius(25);
                    circle.setFill(Color.RED);
                    start = new Position(unit*k+25,unit*i+25);
                }
                else if (everyNum[k].equals("1")){//if checking number equals 1 than fills rectangle with blackk color
                    rect.setFill(Color.BLACK);
                }
                else{
                    rect.setFill(Color.WHITE); // in any other case fill's rectangle with white color
                }
                getChildren().add(rect);//adds every created rectangle
            }
            everyLine++;//and goes to next line
        }
    }

    public int getUnit() {
        return unit;
    } //gets unit(size of every rectangle)
    public int getSize() {
        return size;
    } //gets the size of map
    public int[][] getMap() {
        return map;
    } //gets the two-dimension array
    public Position getStartPosition() {
        return start;
    } //gets start position of circle
    public Circle getCircle() {
        return circle;
    } //gets the circle (my own method to move circle)
}
