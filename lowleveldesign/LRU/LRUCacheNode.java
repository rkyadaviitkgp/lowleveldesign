package code.lowleveldesign.LRU;

public class LRUCacheNode {
    int val;
    int key;
    LRUCacheNode next;
    LRUCacheNode prev;

    public LRUCacheNode(int val, int key) {

        this.val = val;
        this.key = key;
        next = null;
        prev = null;

    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public LRUCacheNode getPrev() {
        return prev;
    }

    public void setPrev(LRUCacheNode prev) {
        this.prev = prev;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public LRUCacheNode getNext() {
        return next;
    }

    public void setNext(LRUCacheNode next) {
        this.next = next;
    }
}
