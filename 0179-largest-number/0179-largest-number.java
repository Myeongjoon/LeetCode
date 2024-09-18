import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    public String largestNumber(int[] nums) {
        // 문자열을 내림차순으로 정렬하는 우선순위 큐 (큰 숫자가 먼저 오도록)
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                // 두 문자열을 비교하여 내림차순으로 정렬
                return (s2 + s1).compareTo(s1 + s2);
            }
        });

        StringBuilder response = new StringBuilder();
        for(int i : nums){
            String current = String.valueOf(i);
            pq.offer(current);
        }
        while(!pq.isEmpty()){
            String front = pq.poll();
            if(front.equals("0") && response.toString().equals("0")){

            }else{
                response.append(front);
            }
        }
        return response.toString();
    }
}