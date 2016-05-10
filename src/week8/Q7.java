package week8;
import java.util.PriorityQueue;
import java.util.Comparator;

class Q7{
    public static void main(String[] args){
        Comparator<Item> comp = new ItemComparator();
        Item A = new Item(5,12);
        Item B = new Item(10,10);
        Item C = new Item(3,4);

        PriorityQueue<Item> pq = new PriorityQueue<Item>(comp);
        pq.add(A);
        pq.add(B);
        pq.add(C);

        System.out.println("Top item is " + pq.poll());
    }
}

class ItemComparator implements Comparator<Item>
{
    @Override
    public int compare(Item a, Item b)
    {
        Double distance = Math.sqrt(a.getX()*a.getX()+a.getY()*a.getY()) - Math.sqrt(b.getX()*b.getX()+b.getY()*b.getY());
        return distance.intValue();
    }

}

class Item {

    private int x;
    private int y;

    public Item(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public  int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public String toString() {
        return "(" + x + "," + y + ")";
    }
}

