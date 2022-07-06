import java.util.ArrayList;
import java.util.HashMap;

class RandomizedSet {
    ArrayList<Integer> random_number = new ArrayList<Integer>();
    HashMap<Integer,Integer> indexToVal = new HashMap<Integer,Integer>();

    public RandomizedSet() {

    }

    public boolean insert(int val) {
        if(indexToVal.containsKey(val)){
            return false;
        }else{
            random_number.add(val);
            indexToVal.put(val,random_number.size()-1);
            return true;
        }
    }

    public boolean remove(int val) {
        if(indexToVal.containsKey(val)){
            int index = indexToVal.get(val);
            random_number.set(index, random_number.get(random_number.size()-1));
            indexToVal.put(random_number.get(index),index);
            random_number.remove(random_number.size()-1);
            indexToVal.remove(val);
            return true;
        }else{
            return false;
        }
    }

    public int getRandom() {
        int random_index = (int)(Math.random() * random_number.size());
        return random_number.get(random_index);
    }

    public static void main(String[] args) {
        RandomizedSet s = new RandomizedSet();
        s.remove(0);
        s.remove(0);
        s.insert(0);
        s.remove(0);
    }
}

