class RandomizedSet {

    List<Integer> list;
    Map<Integer, Integer> map;

    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        map.put(val, list.size());
        list.add(val);

        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }

        int index = map.get(val);
        int last = list.get(list.size() - 1);

        list.set(index, last);
        map.put(last, index);

        list.remove(list.size() - 1);
        map.remove(val);

        return true;
    }

    public int getRandom() {
        int index = (int)(Math.random() * list.size());
        return list.get(index);
    }
}