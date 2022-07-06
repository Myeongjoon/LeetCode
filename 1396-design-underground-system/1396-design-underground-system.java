import java.util.HashMap;

class UndergroundSystem {
    java.util.HashMap<Integer, String> id_to_station = new HashMap<> ();
    java.util.HashMap<Integer, Integer> id_to_time = new HashMap<> ();
    HashMap<String, HashMap<String, Integer>> diff_time_sum_from_to = new HashMap<> ();
    HashMap<String, HashMap<String, Integer>> count_from_to = new HashMap<> ();

    public UndergroundSystem() {

    }

    public void checkIn(int id, String stationName, int t) {
        id_to_time.put(id,t);
        id_to_station.put(id, stationName);
    }

    public void checkOut(int id, String stationName, int t) {
        int start_time = id_to_time.get(id);
        String start_station = id_to_station.get(id);
        if(!diff_time_sum_from_to.containsKey(start_station)){
            diff_time_sum_from_to.put(start_station,new HashMap<>());
            count_from_to.put(start_station,new HashMap<>());
        }

        if(!diff_time_sum_from_to.get(start_station).containsKey(stationName)){
            diff_time_sum_from_to.get(start_station).put(stationName, 0);
            count_from_to.get(start_station).put(stationName, 0);
        }

        int time_diff = t - start_time;

        diff_time_sum_from_to.get(start_station).put(stationName,diff_time_sum_from_to.get(start_station).get(stationName) + time_diff);
        count_from_to.get(start_station).put(stationName,count_from_to.get(start_station).get(stationName) + 1);
    }

    public double getAverageTime(String startStation, String endStation) {
        if(diff_time_sum_from_to.containsKey(startStation) && diff_time_sum_from_to.get(startStation).containsKey(endStation)){
            return (double)diff_time_sum_from_to.get(startStation).get(endStation)/count_from_to.get(startStation).get(endStation);
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        UndergroundSystem s = new UndergroundSystem();
        s.checkIn(1, "hello",1);
        s.checkOut(1, "hello2",2);
        System.out.println(s.getAverageTime("hello","hello2"));
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */