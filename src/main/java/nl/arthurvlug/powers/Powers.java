package nl.arthurvlug.powers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an equation in the form 2^i * 3^j where i,j,k,l >=0 are integers.
 * Write a program to generate numbers from that equation in sorted order efficiently.
 * 
 * For example numbers from that equation will be in the order 1,2,3,4,6,8..... and so on..
 * 
 * See: http://www.careercup.com/question?id=23823662
 * 
 * @author arthur
 *
 */
public class Powers {
	private List<Integer> bases;
	private PriorityQueue<Integer> queue = new PriorityQueue<Integer>();

	/**
	 * Constructor for the Powers algorithm
	 * @param bases the numbers we want to calculate the powers for
	 */
	public Powers(Integer... bases) {
		if(bases.length == 0) {
			throw new IllegalArgumentException("You should give at least one number");
		}
		this.bases = Arrays.asList(bases);
	}

	/**
	 * Calculates an ordered list of powers without duplicates. We limit the list by `size` items.
	 * Each item i in the list is an integer with the property:
	 * 
	 * 	L[i] = b1^x1 * b2^x2 * b3^x3 * ... * bn^xn,
	 * 
	 * where b1 ... bn are the base numbers and xn are integers of at least 0.
	 * 
	 * Also, if L[i] is smaller than L[j], then i is before j. Formally:
	 *  L[i] < L[j] -> i < j
	 * 
	 * 
	 * @param size The amount of items we want
	 * @return An ordered list of powers.
	 */
	public List<Integer> calculatePowerList(int size) {
		List<Integer> result = new ArrayList<Integer>();
		queue.add(1);
		Integer lastProcessed = null;
		for(int i = 0; i < size && !queue.isEmpty(); i++) {
			Integer polledElement = queue.poll();
			if(polledElement.equals(lastProcessed)) {
				// We already processed this one
				i--;
				continue;
			}
			// Multiply the polledElement by the base numbers and add them to the queue
			for(Integer base : bases) {
				queue.add(polledElement * base);
			}
			result.add(polledElement);
			lastProcessed = polledElement;
		}
		return result;
	}
}
