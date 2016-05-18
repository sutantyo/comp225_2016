package week8;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.ArrayList;

class Dict3 {
	private ArrayList<PriorityQueue<String>> dict;
	public Dict3(int maxSize) {
		dict = new ArrayList<PriorityQueue<String>>(maxSize);
		for (int i = 0; i < maxSize; i++) {
			PriorityQueue<String> pq = new PriorityQueue<String>();
			dict.add(pq);
		}
	}
	public void add(String s) {
		int index = (int) s.charAt(0) - (int) 'a';
		dict.get(index).add(s);
	}

	public int numWordsStartingWith(char c){
		/* get the index that you need */
		/* get the priority queue in that index from the arraylist */
		/* return the size of the priority queue */
		return 0;
	}

	public void printWordsStartingWith(char c){
		/* get the index that you need */
		/* get the priority queue in that index from the arraylist */
		/* print out all the elements in the priority queue BUT MAKE SURE YOU DO NOT DESTROY THE PRIORITY QUEUE */
	}

}

public class PQexDict3 {
	
	public static void main(String[] args) {
		String words[] = {"in", "the", "second", "century", "of", "the",
                  "christian",  "era", "the", "empire", "of", "rome",
                  "comprehended", "the", "fairest", "part", "of",
                  "the", "earth", "camera", "candle", "cart"};

		Dict3 myDict = new Dict3(26);
		
		for (int i = 0; i < words.length; i++)
			myDict.add(words[i]);

		System.out.println("Number of words: " + myDict.numWordsStartingWith('c'));
		myDict.printWordsStartingWith('c');

	}
}
