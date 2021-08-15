package search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap {
    private List<Bucket> hashTable;
    private int keySpace;

    public MyHashMap() {
        this.keySpace = 2069;
        this.hashTable = new ArrayList<>();
        for (int i = 0; i < keySpace; i++) {
            this.hashTable.add(new Bucket());
        }

    }

    public Integer get(Integer key) {
        int hashKey = key % this.keySpace;
        return hashTable.get(hashKey).get(key);

    }

    public void put(Integer key, Integer value) {
        int hashKey = key % this.keySpace;
        hashTable.get(hashKey).update(key, value);
    }

    public void remove(Integer key) {
        int hashKey = key % this.keySpace;
        hashTable.get(hashKey).remove(key);
    }

    class Bucket {
        List<Pair<Integer, Integer>> bucket;

        public Bucket() {
            bucket = new LinkedList<>();
        }

        public Integer get(Integer key) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.first.equals(key)) {
                    return pair.second;
                }
            }
            return -1;
        }

        public void update(Integer key, Integer value) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.first.equals(key)) {
                    pair.second = value;
                    return;
                }
            }
            this.bucket.add(new Pair<>(key, value));
        }

        public void remove(Integer key) {
            for (Pair<Integer, Integer> pair : bucket) {
                if (pair.first.equals(key)) {
                    bucket.remove(pair);
                    break;
                }
            }
        }

    }

    class Pair<U, V> {
        U first;
        V second;

        public Pair(U first, V second) {
            this.first = first;
            this.second = second;
        }
    }
    public static void main(String[] args) {
        MyHashMap myHashMap = new MyHashMap();
        int key=10;
        int val=20;
        System.out.println(myHashMap.get(key));
        myHashMap.put(key, val);
        System.out.println(myHashMap.get(key));
        myHashMap.put(key,val+20);
        System.out.println(myHashMap.get(key));
        myHashMap.remove(key);
        System.out.println(myHashMap.get(key));
    }

}