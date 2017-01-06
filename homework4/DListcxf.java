package homework4;

public class DListcxf {

    private int size = 0;
    private DListNode sentinel = new DListNode();

    private class DListNode {
        private int item;
        private DListNode prev;
        private DListNode next;

        DListNode(int item, DListNode prev, DListNode next){
            this.item = item;
            this.prev = prev;
            this.next = next;
            prev.next = this;
            next.prev = this;
        }

        DListNode(){
            this.item = 0;
            this.prev = this;
            this.next = this;
        }
    }

    public void insert(int item){
        DListNode newNode = new DListNode(item, sentinel.prev, sentinel);
        System.out.println(newNode.item);
        size++;
    }

    public void delete(int n){
        DListNode currentNode = sentinel;
        if (n >= 0 && n < size){
            for(; n >= 0; n--){
                currentNode = currentNode.next;
            }
            currentNode.prev.next = currentNode.next;
            currentNode.next.prev = currentNode.prev;
            size--;
        } else {
            System.out.println("invalid index");
        }
    }

    public void printout(){
        DListNode currentNode = sentinel.next;
        for (int n = size; n >= 1; n--){
            System.out.println(currentNode.item);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args){
        DListcxf dl = new DListcxf();
        dl.insert(5);
        dl.printout();
        System.out.println("----");
        dl.insert(4);
        dl.printout();
        System.out.println("----");
        dl.insert(3);
        dl.printout();
        System.out.println("----");
        dl.delete(0);
        dl.printout();
    }
}
