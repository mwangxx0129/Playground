package May20_2018;

import java.util.*;

public class RandomizedSet {
    // inset O(1) => hashMap  <val, index>
    // remove O(1) => hashMap <val, index>
    // getRadmon O(1) <index, val>
    // index <-> val
    // val <-> index

    Map<Integer, Integer> map;
    List<Integer> list;
    Random rand = new Random();
    RandomizedSet() {
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        int lastE = list.get(list.size() - 1);
        list.set(index, lastE);
        list.remove(list.size() - 1);
        map.put(lastE, index);
        return true;
    }

    public int getRandom() {
        int randIndex = rand.nextInt(list.size());
        return list.get(randIndex);
    }
}
