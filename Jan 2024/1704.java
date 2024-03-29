// Time Comp : O(n), Space : O(1)
class Solution {
    public boolean halvesAreAlike(String s) {
        String vowels = "aeiouAEIOU";
        int count = 0;
        int left = 0, right = s.length() - 1;

        while(left < right){
            if(vowels.indexOf(s.charAt(left++)) != -1){
                count ++;
            }

            if(vowels.indexOf(s.charAt(right--)) != -1){
                count --;
            }
        }

        return count == 0;
    }
}
