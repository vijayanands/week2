public class Solution {
	public int lengthOfLongestSubstring(String a) {
        HashMap<Character, Integer> charLocMap = new HashMap<Character, Integer>();
        int i = 0;
        int start = 0;
        int size = a.length();
        if (size <= 1)
            return size;
        int result = 0;
        while (i < size) {
            char ch = a.charAt(i);
            if (charLocMap.containsKey(ch)) {
                int charLoc = charLocMap.get(ch);
                if (charLoc >= start) {
                    // found duplicate
                    int len = i - start;
                    result = Math.max(len, result);
                    start = charLoc+1;
                } 
            }
            charLocMap.put(ch, i);
            i++;            
        }
        return Math.max(result, i-start);
	}
}
