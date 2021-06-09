import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class Game extends Application {
    Pane pane = new Pane();//creates a pane
    Player p = new Player();//creates a player

    private Map map() throws Exception{
        Map map = new Map("map1.txt");//opens class map with names string text file
        return map; //returns this map
    }

    private Player PlayerIs(){
        Player pl = new Player();//creates a player
        return pl;//returns a player
    }

    private Food food()throws Exception{
        Food fd = new Food(map(),p);//creates a food class with map -> map() and player -> p
        return fd;//returns it
    }


    int xAtMap;//crates a new x integer to two-dimension array
    int yAtMap;//crates a new y integer to two-dimension array

    public void start(Stage primaryStage) throws Exception {
        pane.getChildren().add(map());//adds all things from method map()
        Circle circle = map().getCircle();//creates a new circle with values from method map()
        pane.getChildren().add(circle);//adds this circle to pane
        Scene scene = new Scene(pane,600,600);//creates a new scene which contains pane

        Position positionOfCircle = map().getStartPosition();//gets a start position of circle
        int[][] mapIs = map().getMap();//creates a new two-dimension array with values from two-dimension array of method map()
        xAtMap = 0;//gives value to x
        yAtMap = 0;//gives value to y
        int size = map().getSize();//creates a new integer with value of size from method map()
        int unit = map().getUnit();//creates a new integer with value of unit from method map()

        scene.setOnKeyPressed(e -> { //do some action if any key pressed
            if (e.getCode() == KeyCode.DOWN) {//if this key is down arrow
                if (yAtMap+1<size) { int val = mapIs[xAtMap][yAtMap + 1];//and if circle wouldn't go away of map
                    if (val != 1) {//also if this rectangle is not black (1 in map)
                        p.moveDown(positionOfCircle, unit);//gives a new position to circle
                        moveDownDrow(positionOfCircle, unit, circle);//drows circle in new position and removes from pain the previous
                        yAtMap++;//adds 1 int to y
                    }
                }
            }
            if (e.getCode() == KeyCode.UP) {//if this key is up arrow
                if (yAtMap>0) { int val = mapIs[xAtMap][yAtMap - 1];//and if circle wouldn't go away of map
                    if (val != 1) {//also if this rectangle is not black (1 in map)
                        p.moveUp(positionOfCircle, unit);//gives a new position to circle
                        moveUpDrow(positionOfCircle, unit, circle);//drows circle in new position and removes from pain the previous
                        yAtMap--;//minus 1 int from y
                    }
                }
            }
            if (e.getCode() == KeyCode.LEFT) {//if this key is left arrow
                if (xAtMap>0) { int val = mapIs[xAtMap-1][yAtMap];//and if circle wouldn't go away of map
                     if (val!=1) {//also if this rectangle is not black (1 in map)
                        p.moveLeft(positionOfCircle, unit);//gives a new position to circle
                        moveLeftDrow(positionOfCircle, unit, circle);//drows circle in new position and removes from pain the previous
                        xAtMap--;//minus 1 int from x
                    }
                }
            }
            if (e.getCode() == KeyCode.RIGHT) {//if this key is right arrow
                if(xAtMap+1<size) { int val = mapIs[xAtMap + 1][yAtMap];//and if circle wouldn't go away of map
                    if (val != 1) {//also if this rectangle is not black (1 in map)
                        p.moveRight(positionOfCircle, unit);//gives a new position to circle
                        moveRightDrow(positionOfCircle, unit, circle);//drows circle in new position and removes from pain the previous
                        xAtMap++;//adds 1 int to x
                    }
                }
            }

        });

        pane.getChildren().add(food());//adds all elements of food() method
        primaryStage.setTitle("Eating Small balls)");//title of scene
        primaryStage.setScene(scene);//witch scene to use
        primaryStage.show();//shows this scene
    }

    public void moveLeftDrow(Position positionOfCircle,int unit,Circle circle){
        pane.getChildren().remove(circle);//removes an old circle
        positionOfCircle.setX(positionOfCircle.getX()-unit);//gives a new position
        circle.setCenterX(positionOfCircle.getX());//changes a center of circle
        pane.getChildren().add(circle);//draws a circle on new position
    }
    public void moveRightDrow(Position positionOfCircle,int unit,Circle circle){
        pane.getChildren().remove(circle);//removes an old circle
        positionOfCircle.setX(positionOfCircle.getX()+unit);//gives a new position
        circle.setCenterX(positionOfCircle.getX());//changes a center of circle
        pane.getChildren().add(circle);//draws a circle on new position
    }
    public void moveDownDrow(Position positionOfCircle,int unit,Circle circle){
        pane.getChildren().remove(circle);//removes an old circle
        positionOfCircle.setY(positionOfCircle.getY()+unit);//gives a new position
        circle.setCenterY(positionOfCircle.getY());//changes a center of circle
        pane.getChildren().add(circle);//draws a circle on new position
    }
    public void moveUpDrow(Position positionOfCircle,int unit,Circle circle){
        pane.getChildren().remove(circle);//removes an old circle
        positionOfCircle.setY(positionOfCircle.getY()-unit);//gives a new position
        circle.setCenterY(positionOfCircle.getY());//changes a center of circle
        pane.getChildren().add(circle);//draws a circle on new position
    }


    public static void main(String args[]){
        launch(args);//launch's the method start()
    }
}
