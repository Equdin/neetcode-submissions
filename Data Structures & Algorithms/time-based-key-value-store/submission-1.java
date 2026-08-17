class TimeMap {
    Map<String, List<Pair>> keyStore;

    public TimeMap() {
        keyStore = new HashMap<>(10);
    }
    
    public void set(String key, String value, int timestamp) {
        keyStore
            .computeIfAbsent(key, k -> new ArrayList<>())
            .add(new Pair(timestamp, value));
        // OR
        // if (keyStore.containsKey(key)) {
        //      List<Pair> list = keyStore.get(key);
        //      list.add(new Pair(timestamp, value));
        // } else {
        //     keyStore.put(key, new ArrayList<>(List.of(new Pair(timestamp, value))));
        // }
    }
    
    public String get(String key, int timestamp) {
        if (!keyStore.containsKey(key)) {
            return "";
        }

        String result = "";
        List<Pair> list = keyStore.get(key);

        int low = 0;
        int high = list.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int value = list.get(mid).timestamp;

            if (value == timestamp) {
                return list.get(mid).value;
            }

            if (value < timestamp) {
                result = list.get(mid).value;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}

class Pair {
    public int timestamp;
    public String value;

    public Pair(int timestamp, String value) {
        this.timestamp = timestamp;
        this.value = value;
    }
}
