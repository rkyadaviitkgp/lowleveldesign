package code.lowleveldesign.LRU;

public class LRUCacheList {
    LRUCacheNode head;
    LRUCacheNode tail;

    public LRUCacheList() {
        head = null;
        tail = null;
    }

    // new node will be added and it will be added at head because it is recently used node
    public LRUCacheNode insertNode(int key, int val){
        LRUCacheNode node = new LRUCacheNode(val, key);
        return addNode(node);
    }

    // add a new node
    public LRUCacheNode addNode(LRUCacheNode node){
        if(head == null) {
            head = tail = node;
            node.next = node.prev = null;
        }else{
            node.next = head;
            node.prev = null;
            head.prev = node;
            head = node;
        }
        return node;
    }

    //delete a node
    public void deleteLRUNode(LRUCacheNode node){
        if(head == node){
            if(tail == head)
            {
                tail = head = null;
                return;
            }
            head.next.prev = null;
            head = head.next;
            return;
        }
        if(tail == node){
            tail = node.prev;
            tail.next = null;
        }else{
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }

    //make a just accessed node as recently used node
    public void updateRecentlyUsedNode(LRUCacheNode node){
        deleteLRUNode(node);
        addNode(node);
    }

}
