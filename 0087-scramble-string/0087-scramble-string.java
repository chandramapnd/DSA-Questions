class Solution {
    HashMap<String, Boolean> map = new HashMap<>();
    public boolean isScramble(String s1, String s2) {

        String key = s1 + "#" + s2;
        if(map.containsKey(key)) return map.get(key);

        if(s1.equals(s2)){
            map.put(key, true);
            return true;
        }

        if(s1.length()<=1) {
            map.put(key, false);
            return false;
        }

        int n = s1.length();

        if(!isAnagram(s1, s2)){
            map.put(key, false);
            return false;
        }

        for(int i=1; i<= n-1;i++){
            boolean cond1 = isScramble(s1.substring(0,i), s2.substring(n-i,n)) && isScramble(s1.substring(i,n), s2.substring(0,n-i));
            boolean cond2 = isScramble(s1.substring(0,i), s2.substring(0,i)) && isScramble(s1.substring(i,n), s2.substring(i,n));

            if(cond1 || cond2){
                map.put(key, true);
                return true;
            }
        }
        map.put(key, false);
        return false;
    }

    private boolean isAnagram(String a, String b){
        int[] freq = new int[26];
        for(char c : a.toCharArray()) freq[c-'a']++;
        for(char c : b.toCharArray()) freq[c-'a']--;
        for(int x : freq){
            if(x != 0) return false;
        }
        return true;
    }
}