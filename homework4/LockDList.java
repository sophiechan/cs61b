package homework4;

/**
 * Created by Sophie on 1/3/17.
 */
public class LockDList extends DList{

    protected DListNode newNode(Object item, DListNode prev, DListNode next) {
        return new LockDListNode(item, prev, next);
    }

    public void lockNode(DListNode node) {
        ((LockDListNode)node).lock = true;
    }

//    public void insertFront(Object item) {
//        LockDListNode newNode = new LockDListNode(item, head, head.next);
//        newNode.prev.next = newNode;
//        newNode.next.prev = newNode;
//        size++;
//    }

    public void remove(DListNode node) {
        if (!((LockDListNode)node).lock){
//            node.prev.next = node.next;
//            node.next.prev = node.prev;
//            size--;
            super.remove(node);
        }
    }
}
