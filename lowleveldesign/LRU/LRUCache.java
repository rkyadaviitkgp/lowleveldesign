package code.lowleveldesign.LRU;

import java.util.HashMap;
import java.util.Map;

class LRUCache
{
    //Constructor for initializing the cache capacity with the given value.
    static Map<Integer, LRUCacheNode> map =  new HashMap<>();;
    static LRUCacheList list = new LRUCacheList() ;
    static int capacity ;

    LRUCache(int cap)
    {
        capacity = cap;
    }

    //Function to return value corresponding to the key.
    public static int get(int key)
    {
        if(map.containsKey(key)){
            LRUCacheNode temp = map.get(key);
            list.updateRecentlyUsedNode(temp);
            return temp.val;
        }
        return -1;
    }

    //Function for storing key-value pair.
    public static void set(int key, int value)
    {
        if(map.containsKey(key))
        {
            LRUCacheNode temp = map.get(key);
            temp.setVal(value);
            get(key);
        }else{
            if(map.size() == capacity)
            {
                map.remove(list.tail.key);
                list.deleteLRUNode(list.tail);
            }
            LRUCacheNode temp = list.insertNode(key, value);
            map.put(key, temp);
        }
    }

    public static void main(String args[]) {
        LRUCache lru = new LRUCache(2);
        LRUCache.set(1,2);
        System.out.println(LRUCache.get(1));
    }
}
