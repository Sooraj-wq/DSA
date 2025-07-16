import java.util.*;

public class CustomHashMap{

    static class HashMap <K,V>{

        private class Node{
            K key;
            V value;

            public Node(K key, V value){
                this.key = key;
                this.value = value;
             }
        }


        private int n;
        private int N = 4;
        private LinkedList<Node> buckets[];

        @SuppressWarnings("unchecked")
        public HashMap(){
            this.buckets = new LinkedList[N]; //This line creates the array of LinkedList<Node>, but only the array structure — the individual elements inside (buckets[0], buckets[1], etc.) are still null. \
            for(int i=0; i<4; i++){
                this.buckets[i] = new LinkedList<>(); //Note that the datatype of Node within buckets[i] is not mentioned.
            }
        }

        private int hashFunction(K key){
            int bi = key.hashCode();
            return Math.abs(bi) % N; //So that value remains positive and within list range
        }

        private int searchInLL(K key,int bi){
            LinkedList<Node> ll = buckets[bi];

            for(int i=0; i<ll.size(); i++){
                if(ll.get(i).key == key){
                    return i;
                }
            }

            return -1;
        }

        @SuppressWarnings("unchecked")
        private void rehash(){
            LinkedList<Node> oldBucket[] = buckets;
            buckets = new LinkedList[N*2];

            for(int i=0; i<N*2; i++){
                buckets[i] = new LinkedList<>();
            }

            for(int i=0; i<oldBucket.length; i++){
                LinkedList<Node> ll = oldBucket[i];
                for(int j=0; j<ll.size(); j++){
                    Node node = ll.get(j);
                    put(node.key, node.value);
                }
            }
        }

        public void put(K key,V value){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                buckets[bi].add(new Node(key, value));
                n++;
            } else {
                Node node = buckets[bi].get(di);
                node.value = value;
            }

            double lambda = (double)n/N;

            if(lambda>2.0){
                rehash();
            }
        }

        public boolean containsKey(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                return false;
            } else {
                return true;
            }
        }

        public V remove(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                return null;
            } else {
                Node node = buckets[bi].remove(di);
                n--;
                return node.value;
            }
        }

        public V get(K key){
            int bi = hashFunction(key);
            int di = searchInLL(key, bi);

            if(di == -1){
                return null;
            } else {
                Node node = buckets[bi].get(di);
                return node.value;
            }
        }

        public ArrayList<K> keySet(){

            ArrayList<K> keys = new ArrayList<>();

            for(int i=0; i<buckets.length; i++){
                LinkedList<Node> ll = buckets[i];
                for(int j=0; j<ll.size();j++){
                    Node node = ll.get(j);
                    keys.add(node.key);
                }
            }

            return keys;
        }

        public boolean isEmpty(){
            return n == 0;
        }
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Potato", 50);
        map.put("Lettuce", 80);
        map.put("Aubergine",120);

        ArrayList<String> keys = map.keySet();
        for(int i=0; i<keys.size(); i++) {
            System.out.println(keys.get(i)+" "+map.get(keys.get(i)));
        }

        map.remove("Aubergine");
        System.out.println(map.get("Aubergine"));
    }
}