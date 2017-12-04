public class Solution {
	public ArrayList<Integer> twoSum(final List<Integer> a, int b) {
	    int size = a.size();
	   // System.out.println("size of input array = " + size);
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if (size <= 1)
	        return res;
	    HashMap<Integer,Integer> sumHash = new HashMap<Integer, Integer>();
	    int j = 0;
	    for (Integer i : a) {
	       // System.out.println("key = " + i + ", val = " + j);
	       if (!sumHash.containsKey(i))
	            sumHash.put(i, j);
	       j++;
	    }

	    j = 0;
	    int index1 = -1;
	    int index2 = -1;
	    for (Integer k : a) {
	        if (sumHash.containsKey(b-k)) {
	           // System.out.println("k= " + k + ", b-k = " + (b-k));
	            int val = sumHash.get(b-k);
	            if (j != val) {
	                int idx1 = j+1;
	                int idx2 = val+1;
	                if (idx1 > idx2) {
	                    int tmp = idx1;
	                    idx1 = idx2;
	                    idx2 = tmp;
	                }
	               // System.out.println("idx1 = " + idx1 + ", idx2 = " + idx2);
	                // check if index1 and index2 exist
	                if (index1 != -1) {
	                    // we have a current solution
	                    if (idx2 < index2) {
	                        // new solution found
	                        index1 = idx1;
	                        index2 = idx2;
	                        if (index1 > index2) {
	                            int tmp = index1;
	                            index1 = index2;
	                            index2 = tmp;
	                        }
	                       // System.out.println("index1 = " + index1);
	                       // System.out.println("index2 = " + index2);
	                    } else if (idx2 == index2) {
	                        if (idx1 < index1) {
	                            // new solution found
	                            index1 = idx1;
	                            index2 = idx2;
	                            if (index1 > index2) {
	                                int tmp = index1;
	                                index1 = index2;
	                                index2 = tmp;
	                            }
    	                       // System.out.println("index1 = " + index1);
    	                       // System.out.println("index2 = " + index2);
	                        }
	                    }
	                } else {
	                    // first solution
	                    index1 = j+1;
	                    index2 = val+1;
	                    if (index1 > index2) {
	                        int tmp = index1;
	                        index1 = index2;
	                        index2 = tmp;
	                    }
	                   // System.out.println("index1 = " + index1);
	                   // System.out.println("index2 = " + index2);
	                }
	            }
	        }
	        j++;
	    }
	    if (index1 != -1) {
	        // solution found
	        res.add(index1);
	        res.add(index2);
	    }
	    return res;
	}
}
