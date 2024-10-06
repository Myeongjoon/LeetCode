class Solution {
    int[][] map;
    List<List<Integer>> graph = new ArrayList<>();
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        map = new int[n][n];
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> notFinished = new HashSet<Integer>();
        HashSet<Integer> finished = new HashSet<Integer>();
        HashMap<Integer, Integer> inDegree = new HashMap<Integer, Integer>();
        for(int i=0;i<n;i++){
            graph.add(new ArrayList<>());
            notFinished.add(i);
            inDegree.put(i,0);
        }
        for(int i=0;i<prerequisites.length;i++){
            int[] current = prerequisites[i];
            int left = current[0];
            int right = current[1];
            if(map[left][right] != 1){
                map[left][right] = 1;
                inDegree.put(left,inDegree.get(left) + 1);
                graph.get(right).add(left);
            }
        }
        for(int i=0;i<n;i++){
            if(inDegree.get(i) == 0){
                queue.offer(i);
            }
        }
        while(!queue.isEmpty()){
            int front = queue.poll();

            if(finished.contains(front)){
                continue;
            }
            finished.add(front);
            notFinished.remove(front);
            for(int i : graph.get(front)){
                if(notFinished.contains(i)){
                    notFinished.add(i);
                    int modified = inDegree.get(i)-1;
                    inDegree.put(i,modified);
                    if(inDegree.get(i) == 0){
                        queue.offer(i);
                    }
                }
            }
        }
        
        return notFinished.isEmpty();
    }
}