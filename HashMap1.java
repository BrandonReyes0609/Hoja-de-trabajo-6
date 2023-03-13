import java.lang.annotation.Retention;
import java.util.ArrayList;
import java.util.List;

public class HashMap1 implements interfazMap{
    private List<Entry<K,V>> entries;

        /**
     * @post returns the number of entries in the map
     */
    public int size(){
        return 1;
    }

    /**
     * @post returns true iff this map does not contain any entries
     */
    public boolean isEmpty(){
        return false;
    }

    /**
     * @pre k is non-null
     * @post returns true iff k is in the domain of the map
     */
    public boolean containsKey(K k){
        return false;
    }

    /**
     * @pre v is non-null
     * @post returns true iff v is the target of at least one map entry;
     * that is, v is in the range of the map
     */
    public boolean containsValue(V v){
        return false;
    }

    /**
     * @pre k is a key, possibly in the map
     * @post returns the value mapped to from k, or null
     */
    public V get(K k){
        return "dEVUELVE EL VALOR V";
    }

    /**
     * @pre k and v are non-null
     * @post inserts a mapping from k to v in the map
     */
    public V put(K k, V v){
        boolean keyFound = false;

        for (Entry<K, V> entry : entries) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                keyFound = true;
            }
        }

        if (!keyFound) {
            entries.add(new Entry<>(key, value));
        }
    }
    
    /**
     * @pre k is non-null
     * @post removes any mapping from k to a value, from the mapping
     */
    public V remove(K k){
        return "dEVUELVE EL VALOR V removido";
    }

    /**
     * @pre other is non-null
     * @post all the mappings of other are installed in this map,
     * overriding any conflicting maps
     */
    public void putAll(Map<K,V> other){
        //return "dEVUELVE EL VALOR V";
    }

    /**
     * @post removes all map entries associated with this map
     */
    public void clear(){
        print("Clear");
    }
    /**
     * @post returns a set of all keys associated with this map
     */
    public Set<K> keySet(){
        print("");
        return null;
    }
    

    /**
     * @post returns a structure that contains the range of the map
     */
    public Structure<V> values(){
            return null;
        }

    /**
     * @post returns a set of (key-value) pairs, generated from this map
     */
    public Set<Association<K,V>> entrySet(){
        return null;
    }

    /**
     * @pre other is non-null
     * @post returns true iff maps this and other are entry-wise equal
     */
    public boolean equals(Object other){
        return false;
    }
    
    /**
     * @post returns a hash code associated with this structure
     */
    public int hashCode(){
        return 0;
    }
}