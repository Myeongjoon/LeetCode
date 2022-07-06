class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String,Integer> count = new HashMap<>();
        for(int i =0;i<cpdomains.length;i++){
            String[] splited = cpdomains[i].split(" ");
            String[] splitedDomain = splited[1].split("\\.");
            String current = "";
            int prefix = Integer.parseInt(splited[0]);
            for(int j=splitedDomain.length-1;j>=0;j--){
                if(j == splitedDomain.length-1){
                    current = splitedDomain[splitedDomain.length-1];
                }else{
                    current = splitedDomain[j] + "." + current;
                }
                if(count.containsKey(current)){
                    count.put(current, count.get(current) + prefix);
                }else{
                    count.put(current, prefix);
                }
            }
        }
        List<String> response = new ArrayList<String>();
        for(String s : count.keySet()){
            response.add(count.get(s) + " " + s);
        }
        return response;
    }
}