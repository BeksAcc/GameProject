
public class Player{
    private Position ps = new Position(25,25);//if in txt file doesn't exists number 2, than it starts from position 25x and 25y

    public void moveRight(Position pos, int unit){
        this.ps = new Position(pos.getX()+unit,pos.getY());//moves position to unit pixels right
    }
    public void moveLeft(Position pos, int unit){
        this.ps = new Position(pos.getX()-unit,pos.getY());//moves position to unit pixels left
    }
    public void moveUp(Position pos, int unit){
        this.ps = new Position(pos.getX(),pos.getY()-unit);//moves position to unit pixels up
    }
    public void moveDown(Position pos, int unit){
        this.ps = new Position(pos.getX(),pos.getY()+unit);//moves position to unit pixels down
    }
    public Position getPosition (){
        return this.ps;//returns changed position or default one
    }
}
