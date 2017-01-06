package homework4;

/**
 * Created by Sophie on 1/3/17.
 */
public class LockDListNode extends DListNode{

//    public Object item;
//    protected LockDListNode prev;
//    protected LockDListNode next;
    protected boolean lock;

    LockDListNode(Object i, DListNode p, DListNode n) {
        super(i,p,n);
        lock = false;
    }
}
