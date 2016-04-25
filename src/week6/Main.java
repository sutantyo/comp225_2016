package week6;

/**
 * Created by daniels on 25/04/2016.
 */
public class Main {

    public static void main(String[] args){
        IntBST main_tree = new IntBST();

        main_tree.insert(10);
        main_tree.insert(5);
        main_tree.insert(20);
        main_tree.insert(4);
        main_tree.insert(6);
        main_tree.insert(15);
        main_tree.insert(30);

        System.out.println(main_tree.inorder());

    }
}
