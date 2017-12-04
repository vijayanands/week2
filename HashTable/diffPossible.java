public class Solution {
	public int diffPossible(final List<Integer> a, int b) {
	    int size = a.size();
	    if (size <= 1)
	        return 0;
	    HashMap<Integer,Integer> sumHash = new HashMap<Integer, Integer>();
	    int j = 0;
	    for (Integer i : a) {
	        sumHash.put(i+b, j);
	        j++;
	    }
	    
	    j = 0;
	    for (Integer k : a) {
	       // System.out.println("j = " + j);
	        if (sumHash.containsKey(k)) {
	            int val = sumHash.get(k);
	            if (j != val)
	                return 1;
	        }
	        j++;
	    }
	    return 0;
	}
}
