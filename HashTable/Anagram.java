public class Solution {
	public ArrayList<ArrayList<Integer>> anagrams(final List<String> a) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    int size = a.size();
	    if (size == 0)
	        return res;
	    else if (size == 1) {
	        ArrayList<Integer> tmp = new ArrayList<Integer>();
	        tmp.add(1);
	        res.add(tmp);
	        return res;
	    } else {
	        HashMap<Character, Integer> charCount = new HashMap<Character, Integer>();
	        HashMap<Character, Integer> compareCharCounts = new HashMap<Character, Integer>();
	        Boolean[] stringVisited = new Boolean[size];
	        for (int idx = 0; idx < size; idx++) {
	            stringVisited[idx] = false;
	        }
	        int i = 0;
	        while (i < size) {
	            int k = 0;
	            ArrayList<Integer> anagramIndices = new ArrayList<Integer>();
	            anagramIndices.add(i+1);
                String str = a.get(i);
                if (stringVisited[i] == true) {
                    i++;
                    continue;
                } else 
                    stringVisited[i] = true;
                charCount.clear();
                // System.out.println("getting anagrams for : " + str);
                // add the characters of the string
                for (k = 0; k < str.length(); k++) {
                    char ch = str.charAt(k);
                    int val = 0;
                    if (charCount.containsKey(ch)) {
                        val = charCount.get(ch);
                    }
                    charCount.put(ch, ++val);
                }
                // find the anagrams
                for (int j = i ; j < size; j++) {
                    // check if the string is an anagram of str, 
                    // if so mark this as visited and                     
	                // check if this string is an anagram
	                boolean isAnagram = true;
	                String compareStr = a.get(j);
	               // System.out.println("compare string = " + compareStr);
	                if (stringVisited[j] == true) {
	                   // System.out.println("Visited");
	                    continue;
	                }
	                compareCharCounts.clear();
	                for (k = 0; k < compareStr.length(); k++) {
                        char ch = compareStr.charAt(k);
	                    if (!charCount.containsKey(ch)) {
	                        break;
	                    }
	                    int val = 0;
	                    if (compareCharCounts.containsKey(ch)) {
	                        val = compareCharCounts.get(ch);
	                    }
	                    compareCharCounts.put(ch, ++val);
	                }
	                // ensure that the char counts in comapreCharCounts 
	                // is the same as that in charCount
	                for (k = 0; k < compareStr.length(); k++) {
                        char ch = compareStr.charAt(k);
                        int count1 = 0;
                        if (charCount.containsKey(ch))
                            count1 = charCount.get(ch);
                        else {
                            isAnagram = false;
                            break;
                        }
	                    int count2 = compareCharCounts.get(ch);
	                    if (count1 != count2) {
	                        isAnagram = false;
	                        break;
	                    }
	                }
	                if (isAnagram) {
	                   stringVisited[j] = true;
	                   anagramIndices.add(j+1);
	                }
                }
                res.add(anagramIndices);
	        }
	    }
	    return res;
	}
}
