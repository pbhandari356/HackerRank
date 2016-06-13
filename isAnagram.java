/*FROM LEETCODE.COM
* Given two strings s and t, write a function to determine if t is an anagram of s.
* You may assume the string contains only lowercase alphabets.
*/


public class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length()!=t.length())
            return false; 
            
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        String s_sorted = new String(s1);
        String t_sorted = new String(t1);
        
        if (s_sorted.equals(t_sorted))
            return true; 
            
        return false; 
    }
}