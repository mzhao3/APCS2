/*****************************************************
* class DLLNode
* Implements a doubly-linked node,
* for use in lists and other collection classes.
* Stores data of type String
*****************************************************/

public class DLLNode
{
  private String _cargo;    //cargo may only be of type String
  private DLLNode _nextNode, _prevNode; //pointers to next, prev DLLNodes

  //YOUR IMPLEMENTATION HERE...

  // constructor -- initializes instance vars
  public DLLNode( DLLNode previous, String value, DLLNode next ) {
    _prevNode = previous;
    _cargo = value;
    _nextNode = next;
  }


  //--------------v  ACCESSORS  v--------------
  public DLLNode getPrev() {return _prevNode; }

  public String getCargo() { return _cargo; }

  public DLLNode getNext() { return _nextNode; }
  //--------------^  ACCESSORS  ^--------------


  //--------------v  MUTATORS  v--------------
  
  public DLLNode setPrev( DLLNode newPrev ) {
      DLLNode foo = getPrev();
      _prevNode = newPrev;
      return foo;
  }

  public String setCargo( String newCargo ) {
    String foo = getCargo();
    _cargo = newCargo;
    return foo;
  }

  public DLLNode setNext( DLLNode newNext ) {
    DLLNode foo = getNext();
    _nextNode = newNext;
    return foo;
  }
  //--------------^  MUTATORS  ^--------------


  // override inherited toString
  public String toString() { return _cargo.toString(); }

}//end class DLLNode
