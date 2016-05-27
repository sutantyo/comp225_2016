package week10.maze;

/**
 * Created by daniels on 3/11/2015.
 */
public class Tile {

    private String type;
    private int x_coord;
    private int y_coord;
    private Boolean visited;

    public String name;
    public Tile up;
    public Tile down;
    public Tile right;
    public Tile left;


    public Tile(String name, String type, int x, int y){
        up = down = right = left = null;
        visited = false;

        this.name = name;
        this.type = type;
        this.x_coord = x;
        this.y_coord = y;
    }

    public void markAsVisited(){
       visited = true;
    }

    public Boolean visited(){
        return visited;
    }

    public String toString(){
        return name;
    }
    public String getType(){
        return type;
    }

    public int getX(){
        return x_coord;
    }
    public int getY(){
        return y_coord;
    }

}
