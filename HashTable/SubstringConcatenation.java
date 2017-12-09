public class Solution {
	public ArrayList<Integer> findSubstring(String a, final List<String> b) {
	    int noOfStrings = b.size();
	    ArrayList<Integer> res = new ArrayList<Integer>();
	    if ((a == null) || (noOfStrings == 0))
	        return res;
	    int wordHash = 0;
	    int wordLength = b.get(0).length();
	    HashMap<String,Integer> wordsMap = new HashMap<String,Integer>();
	    for (int i = 0; i < noOfStrings; i++) {
	        String tmpStr = b.get(i);
	        wordHash += tmpStr.hashCode();
	        int val = 0;
	        if (wordsMap.containsKey(tmpStr))
	            val = wordsMap.get(tmpStr);
	        wordsMap.put(tmpStr,val+1);
	    }
	   // System.out.println("wordHash = " + wordHash);
	    // iterate through the String a and compute the hash 
	    // for every substring and compare with wordHash
	    int j = 0;
	    int totalLengthOfWords = (noOfStrings * wordLength);
	    int k = j + totalLengthOfWords;
	    while (k <= a.length()) {
	       // System.out.println("j = " + j);
	        // compute the hash of words of length wordLength 
	        // for string starting at j
	        int tmpHash = 0;
	        HashMap<String, Integer> tmpWordsMap = new HashMap<String, Integer>();
	        for (int l = 0; l < noOfStrings; l++) {
	            int start = j+(l*wordLength);
	            int end = start+wordLength;
	            String tmpStr = a.subSequence(start, end).toString();
	           // System.out.println("tmpStr = " + tmpStr + ", hashCode = " + tmpStr.hashCode());;
	            tmpHash += tmpStr.hashCode();
	            int val = 0;
	            if (tmpWordsMap.containsKey(tmpStr))
	                val = tmpWordsMap.get(tmpStr);
	            tmpWordsMap.put(tmpStr,val+1);
	        }
	       // System.out.println("tmpHash = " + tmpHash);
	        if (tmpHash == wordHash) {
	            // confirm that the char counts are the same
	            boolean matching = true;
	            for (String tmpStr : wordsMap.keySet()) {
	                int val1 = wordsMap.get(tmpStr);
	                if (tmpWordsMap.containsKey(tmpStr)) {
	                    int val2 = tmpWordsMap.get(tmpStr);
	                    if (val1 == val2) 
	                        continue;
	                }
	                matching = false;
	                break;
	            }
	            if (matching) {
	               // System.out.println("adding " + j);
	                res.add(j);
	            }
	        }
	        j++;
	        k = j + totalLengthOfWords;
	    }
	    return res;
	}
}
