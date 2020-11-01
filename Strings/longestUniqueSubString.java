/*Given a string s, find the length of the longest substring without repeating characters.

Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
*/

//https://leetcode.com/problems/longest-substring-without-repeating-characters/

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        if(s.length() == 1) return 1;
        
        int i = 0, j = 0, count = 0;
        HashSet<Character> set = new HashSet<>();
        
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
            }
            else {
                set.remove(s.charAt(i++));
            }
            count = Math.max(count, set.size());
        }
        return count;
        
        
	/* naive approach
		
	int count = 0;
	
	for(int i = 0; i < s.length(); i++) {
	    int tempCount = 0;
	    HashSet<Character> set = new HashSet<>();
	    
	    for(int j = i; j < s.length(); j++) {
		if(set.contains(s.charAt(j))) break;
		set.add(s.charAt(j));
		tempCount++;
	    }
	    count = tempCount > count? tempCount : count;
        }
        return count;*/
    }
}
