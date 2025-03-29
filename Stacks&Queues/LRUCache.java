class LRUCache {
    int cap;
    ListNode right; //MRU
    ListNode left; // LRU
    Map<Integer, ListNode> map;

    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        left = new ListNode(new Pair(0, 0));
        right = new ListNode(new Pair(0, 0));
        left.next = right;
        right.prev = left;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            ListNode temp = map.get(key);
            remove(temp);
            insert(temp);
            return temp.p.value;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            remove(map.get(key));
        }
        ListNode temp = new ListNode(new Pair(key,value));
        map.put(key, temp);
        insert(temp);
        if(map.size() > cap) {
            map.remove(left.next.p.key);
            remove(left.next);
        }
    }

    private void remove(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void insert(ListNode node){
        //insert at the rightmost position
        ListNode prev = right.prev;
        ListNode next = right;
        prev.next = node;
        next.prev = node;
        node.next = next;
        node.prev = prev;
    }
}

class ListNode{
    Pair p;
    ListNode next;
    ListNode prev;

    public ListNode(Pair p){
        this.p = p;
        this.next = null;
        this.prev = null;
    }
}

class Pair{
    int key;
    int value;

    Pair(int k, int v){
        this.key = k;
        this.value = v;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
