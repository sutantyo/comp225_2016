package week10.maze;

import java.util.*;

/**
 * Created by daniels on 3/11/2015.
 */
public class Game {

    Tile[][] board;
    private Tile current;

    private Stack<Tile> s = new Stack<Tile>();
    private Queue<Tile> q = new LinkedList<Tile>();

    private int gridSize;

    public Game(Random r, int gridSize, int obstaclesCount){

        this.gridSize = gridSize;

        Integer tileName = 1;
        board = new Tile[gridSize][gridSize];
        for(int i = 0; i < gridSize; i ++){
            for(int j = 0; j < gridSize; j ++){
                board[i][j] = new Tile((tileName++).toString(),"passable",i,j);
            }
        }
        for(int i = 0; i < obstaclesCount; i++){
            int r_x = r.nextInt(gridSize);
            int r_y = r.nextInt(gridSize);
            board[r_x][r_y] = new Tile("X","obstacle",r_x,r_y);
        }
        board[0][0] = new Tile("O","source",0,0);
        board[gridSize-1][gridSize-1] = new Tile("D","destination",gridSize-1,gridSize-1);

        Tile start= board[0][0];
        s.add(start);
        q.add(start);
        addConnection();
    }

    public Tile[][] getBoardState(){
        return board;
    }

    public String DFS(){

        if(!s.empty()){
            current = s.pop();
            if (current.getType() == "destination") {
                s.clear();
                return "Found exit";
            }

            if (!current.visited()){
                current.markAsVisited();
                if (current.left != null && !current.left.visited())
                    s.add(current.left);
                if (current.up != null && !current.up.visited())
                    s.add(current.up);
                if (current.right != null && !current.right.visited())
                    s.add(current.right);
                if (current.down != null && !current.down.visited())
                    s.add(current.down);
            }
            return "In progress";
        }
        return "No solution";

    }

    public String BFS(){

        if(!q.isEmpty()){
            current = q.poll();
            if (current.getType() == "destination") {
                q.clear();
                return "Found exit";
            }

            if (!current.visited()){
                current.markAsVisited();
                if (current.right != null && !current.right.visited())
                    q.add(current.right);
                if (current.down != null && !current.down.visited())
                    q.add(current.down);
                if (current.left != null && !current.left.visited())
                    q.add(current.left);
                if (current.up != null && !current.up.visited())
                    q.add(current.up);
            }
            return "In progress";
        }
        return "No solution";

    }

    public Tile getMarker(){
       return current;
    }

    public Stack getStack(){
       return s;
    }

    public Queue getQueue(){
        return q;
    }

    private void addConnection(){
        for(int i = 0; i < gridSize; i ++) {
            for (int j = 0; j < gridSize; j++) {
                Tile t = board[i][j];
                if (i-1 >= 0){
                   if(board[i-1][j].getType() != "obstacle")
                       t.up = board[i-1][j];
                }
                if (i+1 < gridSize){
                    if(board[i+1][j].getType() != "obstacle")
                        t.down = board[i+1][j];
                }
                if (j-1 >= 0){
                    if(board[i][j-1].getType() != "obstacle")
                        t.left = board[i][j-1];
                }
                if (j+1 < gridSize){
                    if(board[i][j+1].getType() != "obstacle")
                        t.right = board[i][j+1];
                }
            }
        }
    }

    public static void main(String[] args){
        Game game = new Game(new Random(100), 6, 8);
        game. DFS();
        game. DFS();
        game. DFS();
    }
}
