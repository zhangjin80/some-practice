import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    private List<Bucket> hashTable;
    private int keySpace;

    public MyHashMap() {
        this.keySpace = 2096;
        hashTable = new ArrayList<>();
        for (int i = 0; i < keySpace; i++) {
            hashTable.add(new Bucket());
        }
    }

    public void put(String key, String value) {
        if (key==null)
            return;

        int hashKey = key.hashCode() % keySpace;
        hashTable.get(hashKey).update(key, value);
    }

    public String get(String key) {
        if (key==null)
            return null;
        int hashKey = key.hashCode() % keySpace;
        return hashTable.get(hashKey).get(key);
    }

    public void remove(String key) {
        if (key==null)
            return;
        int hashKey = key.hashCode() % keySpace;
        hashTable.get(hashKey).remove(key);

    }
    class Pair<U,V>{
        U first;
        V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }

    class Bucket{
        List<Pair<String,String>> bucket;

        public Bucket() {
            this.bucket = new LinkedList<>();
        }

        public String get(String key) {
            for (Pair<String, String> pair : bucket) {
                if (pair.first.equals(key)) {
                    return pair.second;
                }
            }
            return null;
        }

        public void update(String key, String value) {
            for (Pair<String, String> pair : bucket) {
                if (pair.first.equals(key)) {
                    pair.second = value;
                    return;
                }
            }
            bucket.add(new Pair<>(key, value));
        }

        public void remove(String key) {
            for (Pair<String, String> pair : bucket) {
                if (pair.first.equals(key)) {
                    bucket.remove(pair);
                }
            }
        }
    }

    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        String key = "key";
        String  value ="aaaa";
        System.out.println(myHashMap.get(key));
        myHashMap.put(key, value);
        System.out.println(myHashMap.get(key));

    }

}
