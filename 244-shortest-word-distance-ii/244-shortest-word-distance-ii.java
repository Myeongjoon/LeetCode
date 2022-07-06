class WordDistance {
    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public WordDistance(String[] wordsDict) {
        for(int i=0;i<wordsDict.length;i++){
            if(map.containsKey(wordsDict[i])){
                map.get(wordsDict[i]).add(i);
            }else{
                map.put(wordsDict[i], new ArrayList<Integer>());
                map.get(wordsDict[i]).add(i);
            }
        }
    }
    
    public int shortest(String word1, String word2) {
        int min = Integer.MAX_VALUE;
        int l1 = 0;
        int l2 = 0;
        while(l1 < map.get(word1).size() && l2 < map.get(word2).size()){
            min = Math.min(min, Math.abs(map.get(word1).get(l1) - map.get(word2).get(l2)));
            if(map.get(word1).get(l1)>map.get(word2).get(l2)){
                l2++;
            }else{
                l1++;
            }
        }
        return min;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */