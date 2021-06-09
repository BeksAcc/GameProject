public class Position {
    private double x;
    private double y;

    public Position(double x,double y){//creates a new position with given values
        this.x = x;
        this.y = y;
    }
    public double getX() {//gets x value of position
        return x;
    }
    public void setX(double x) {//changes x value of position
        this.x = x;
    }
    public double getY() {//gets y value of position
        return y;
    }
    public void setY(double y) {//changes y value of position
        this.y = y;
    }
    public boolean equals(Position n){//if x and y values of two position equals returns true, false in any other case
        if (x == n.getX() && y ==n.getY())
            return true;
        else{
            return false;
        }
    }
}
