class Solution {
    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Integer> mapA = new HashMap<>();
        HashMap<Character, Integer> mapB = new HashMap<>();
        if(s.length()!=t.length()){
            return false;
        }
        for(int i=0;i<s.length();i++){
            if(mapA.containsKey(s.charAt(i)) && !mapB.containsKey(t.charAt(i))){
                return false;
            }
            if(!mapA.containsKey(s.charAt(i)) && mapB.containsKey(t.charAt(i))){
                return false;
            }
            if(mapA.containsKey(s.charAt(i))){
                if(mapA.get(s.charAt(i)) != mapB.get(t.charAt(i))){
                    return false;
                }
            }
            else{
                mapA.put(s.charAt(i), i);
                mapB.put(t.charAt(i), i);
            }
        }
        return true;
    }
}