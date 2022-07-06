class WordDistance {
    String[] wordsDict;
    HashMap<String, List<Integer>> map = new HashMap<String, List<Integer>>();
    public WordDistance(String[] wordsDict) {
        this.wordsDict = wordsDict;
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
        for(int i=0;i<map.get(word1).size();i++){
            for(int j=0;j<map.get(word2).size();j++){
                min = Math.min(min, Math.abs(map.get(word1).get(i) - map.get(word2).get(j)));
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