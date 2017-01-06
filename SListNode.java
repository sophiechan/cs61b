/* SListNode.java */

/**
 *  SListNode is a class used internally by the SList class.  An SList object
 *  is a singly-linked homework4, and an SListNode is a node of a singly-linked
 *  homework4.  Each SListNode has two references:  one to an object, and one to
 *  the next node in the homework4.
 *
 *  @author Kathy Yelick and Jonathan Shewchuk
 */

class SListNode {
  Object item;
  SListNode next;


  /**
   *  SListNode() (with two parameters) constructs a homework4 node referencing the
   *  item "obj", whose next homework4 node is to be "next".
   */

  SListNode(Object obj, SListNode next) {
    item = obj;
    this.next = next;
  }

  /**
   *  SListNode() (with one parameter) constructs a homework4 node referencing the
   *  item "obj".
   */

  SListNode(Object obj) {
    this(obj, null);
  }
}
