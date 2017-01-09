/* SList.java */
package homework3;
/**
 *  The SList class is a singly-linked implementation of the linked homework4
 *  abstraction.  SLists are mutable data structures, which can grow at either
 *  end.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 **/

public class SList {

  private SListNode head;
  private int size;

  /**
   *  SList() constructs an empty homework4.
   **/

  public SList() {
    size = 0;
    head = null;
  }

  /**
   *  isEmpty() indicates whether the homework4 is empty.
   *  @return true if the homework4 is empty, false otherwise.
   **/

  public boolean isEmpty() {
    return size == 0;
  }

  /**
   *  length() returns the length of this homework4.
   *  @return the length of this homework4.
   **/

  public int length() {
    return size;
  }

  /**
   *  insertFront() inserts item "obj" at the beginning of this homework4.
   *  @param obj the item to be inserted.
   **/

  public void insertFront(Object obj) {
    head = new SListNode(obj, head);
    size++;
  }

  /**
   *  insertEnd() inserts item "obj" at the end of this homework4.
   *  @param obj the item to be inserted.
   **/

  public void insertEnd(Object obj) {
    if (head == null) {
      head = new SListNode(obj);
    } else {
      SListNode node = head;
      while (node.next != null) {
        node = node.next;
      }
      node.next = new SListNode(obj);
    }
    size++;
  }

  /**
   *  nth() returns the item at the specified position.  If position < 1 or
   *  position > this.length(), null is returned.  Otherwise, the item at
   *  position "position" is returned.  The homework4 does not change.
   *  @param position the desired position, from 1 to length(), in the homework4.
   *  @return the item at the given position in the homework4.
   **/

  public Object nth(int position) {
    SListNode currentNode;

    if ((position < 1) || (head == null)) {
      return null;
    } else {
      currentNode = head;
      while (position > 1) {
        currentNode = currentNode.next;
        if (currentNode == null) {
          return null;
        }
        position--;
      }
      return currentNode.item;
    }
  }

  /**
   *  squish() takes this homework4 and, wherever two or more consecutive items are
   *  equal(), it removes duplicate nodes so that only one consecutive copy
   *  remains.  Hence, no two consecutive items in this homework4 are equal() upon
   *  completion of the procedure.
   *
   *  After squish() executes, the homework4 may well be shorter than when squish()
   *  began.  No extra items are added to make up for those removed.
   *
   *  For example, if the input homework4 is [ 0 0 0 0 1 1 0 0 0 3 3 3 1 1 0 ], the
   *  output homework4 is [ 0 1 0 3 1 0 ].
   *
   *  IMPORTANT:  Be sure you use the equals() method, and not the "=="
   *  operator, to compare items.
   **/

  public void squish() {
    SListNode node = head;
    while (node !=null && node.next != null){
      if (node.next.item.equals(node.item)) {
        node.next = node.next.next;
      } else {
        node = node.next;
      }
    }
  }

  /**
   *  twin() takes this homework4 and doubles its length by replacing each node
   *  with two consecutive nodes referencing the same item.
   *
   *  For example, if the input homework4 is [ 3 7 4 2 2 ], the
   *  output homework4 is [ 3 3 7 7 4 4 2 2 2 2 ].
   *
   *  IMPORTANT:  Do not try to make new copies of the items themselves.
   *  Just copy the references to the items.
   **/

  public void twin() {
    SListNode node = head;
    while (node != null) {
      node.next = new SListNode(node.item, node.next);
      size++;
      node = node.next.next;
    }
  }

  /**
   *  toString() converts the homework4 to a String.
   *  @return a String representation of the homework4.
   **/

  public String toString() {
    int i;
    Object obj;
    String result = "[  ";

    SListNode cur = head;

    while (cur != null) {
      obj = cur.item;
      result = result + obj.toString() + "  ";
      cur = cur.next;
    }
    result = result + "]";
    return result;
  }


  /**
   *  main() runs test cases on the SList class.  Prints summary
   *  information on basic operations and halts with an error (and a stack
   *  trace) if any of the tests fail.
   **/

  public static void main (String[] args) {
    testEmpty();
    testAfterInsertFront();
    testAfterInsertEnd();
  }

    
  /**
   *  testEmpty() tests toString(), isEmpty(), length(), insertFront(), and
   *  insertEnd() on an empty homework4.  Prints summary information of the tests
   *  and halts the program if errors are detected.
   **/

  private static void testEmpty() {
    SList lst1 = new SList();
    SList lst2 = new SList();
    System.out.println();
    System.out.println("Here is a homework4 after construction: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  ]"),
		      "toString on newly constructed homework4 failed");

    System.out.println("isEmpty() should be true. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == true,
		      "isEmpty() on newly constructed homework4 failed");

    System.out.println("length() should be 0. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 0, 
		      "length on newly constructed homework4 failed");
    lst1.insertFront(new Integer(3));
    System.out.println("Here is a homework4 after insertFront(3) to an empty homework4: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  3  ]"),
		      "InsertFront on empty homework4 failed");
    lst2.insertEnd(new Integer(5));
    System.out.println("Here is a homework4 after insertEnd(5) on an empty homework4: "
		       + lst2.toString());
    TestHelper.verify(lst2.toString().equals("[  5  ]"),
		      "insertEnd on empty homework4 failed");
  }

  /**
   *  testAfterInsertFront() tests toString(), isEmpty(), length(),
   *  insertFront(), and insertEnd() after insertFront().  Prints summary
   *  information of the tests and halts the program if errors are detected.
   **/

  private static void testAfterInsertFront() {
    SList lst1 = new SList();
    lst1.insertFront(new Integer(3));
    lst1.insertFront(new Integer(2));
    lst1.insertFront(new Integer(1));
    System.out.println();
    System.out.println("Here is a homework4 after insertFront 3, 2, 1: "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  1  2  3  ]"),
		      "InsertFronts on non-empty homework4 failed");
    System.out.println("isEmpty() should be false. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == false,
		      "isEmpty() after insertFront failed");    
    System.out.println("length() should be 3. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 3, 
		      "length() after insertFront failed");
    lst1.insertEnd(new Integer(4));
    System.out.println("Here is the same homework4 after insertEnd(4): "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  1  2  3  4  ]"),
		      "insertEnd on non-empty homework4 failed");
  }
    
  /**
   *  testAfterInsertEnd() tests toString(), isEmpty(), length(),
   *  insertFront(), and insertEnd() after insertEnd().  Prints summary
   *  information of the tests and halts the program if errors are detected.
   **/

  private static void testAfterInsertEnd() {
    SList lst1 = new SList();
    lst1.insertEnd(new Integer(6));
    lst1.insertEnd(new Integer(7));
    System.out.println();
    System.out.println("Here is a homework4 after insertEnd 6, 7: "
		       + lst1.toString());
    System.out.println("isEmpty() should be false. It is: " +
		       lst1.isEmpty());
    TestHelper.verify(lst1.isEmpty() == false,
		      "isEmpty() after insertEnd failed");    
    System.out.println("length() should be 2. It is: " +
		       lst1.length());
    TestHelper.verify(lst1.length() == 2, 
		      "length() after insertEndfailed");
    lst1.insertFront(new Integer(5));
    System.out.println("Here is the same homework4 after insertFront(5): "
		       + lst1.toString());
    TestHelper.verify(lst1.toString().equals("[  5  6  7  ]"),
		      "insertFront after insertEnd failed");
  }
}
