//Team Igtailspay -- Zane Wang, Sophia Xia, Maggie Zhao
//APCS2 pd1
//HW23 -- Give and Take
//2018-03-22

/*****************************************************
* class LList
* Implements a linked list of LLNodes, each containing String data
*****************************************************/

public class LList implements List //your List interface must be in same dir
{

  //instance vars
  private LLNode _head;
  private int _size;

  // constructor -- initializes instance vars
  public LList( )
  {
    _head = null; //at birth, a list has no elements
    _size = 0;
  }


  //--------------v  List interface methods  v--------------

  public boolean add( String newVal )
  {
    LLNode tmp = new LLNode( newVal, _head );
    _head = tmp;
    _size++;
    return true;
  }

  public String get( int index )
  {
    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    String retVal;
    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //check target node's cargo hold
    retVal = tmp.getCargo();
    return retVal;
  }


  public String set( int index, String newVal )
  {

    if ( index < 0 || index >= size() )
    throw new IndexOutOfBoundsException();

    LLNode tmp = _head; //create alias to head

    //walk to desired node
    for( int i=0; i < index; i++ )
    tmp = tmp.getNext();

    //store target node's cargo
    String oldVal = tmp.getCargo();

    //modify target node's cargo
    tmp.setCargo( newVal );

    return oldVal;
  }
  // inserts a node containing s at position i
  public void add(String newVal, int index)
  {
    LLNode tmp = _head;
    for (int i = 0; i < index - 1; i++) {
      tmp = tmp.getNext();
    }
    tmp.setNext(new LLNode(newVal,tmp.getNext()));
    _size ++;
  }

  // removes node at position i and removes cargo
  public String remove(int index)
  {
    String retStr = "";
    if (index == 0){
      retStr = _head.getCargo();
      _head = _head.getNext();
      _size --;
    }

    else{
      LLNode tmp = _head;
      for (int i = 0; i < index - 1; i++) {
        tmp = tmp.getNext();
      }

      retStr = tmp.getNext().getCargo();
      tmp.setNext((tmp.getNext()).getNext());
      _size --;
    }
    return retStr;

  }

  //return number of nodes in list
  public int size() { return _size; }

  //--------------^  List interface methods  ^--------------


  // override inherited toString
  public String toString()
  {
    String retStr = "HEAD->";
    LLNode tmp = _head; //init tr
    while( tmp != null ) {
      retStr += tmp.getCargo() + "->";
      tmp = tmp.getNext();
    }
    retStr += "NULL";
    return retStr;
  }


  //main method for testing
  public static void main( String[] args )
  {
    LList james = new LList();

    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("beat");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("a");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("need");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    james.add("I");
    System.out.println( james );
    System.out.println( "size: " + james.size() );

    System.out.println( "2nd item is: " + james.get(1) );

    james.set( 1, "got" );
    System.out.println( "...and now 2nd item is: " + james.set(1,"got") );

    System.out.println( james );

    LList pigs = new LList();

    System.out.println( pigs );
    System.out.println( "size: " + pigs.size() );

    pigs.add("pig");
    System.out.println( pigs );
    System.out.println( "size: " + pigs.size() );

    pigs.add("tails",1);
    System.out.println( pigs );
    System.out.println( "size: " + pigs.size() );


    // Testing remove()
    System.out.println("====================================");

    //Original LList: HEAD->pig->tails->NULL
    System.out.println(pigs.remove(0)); // pig
    System.out.println( pigs ); // HEAD->tails->NULL
    System.out.println( "size: " + pigs.size() ); // 1

    // Original LList: HEAD->I->got->a->beat->NULL
    System.out.println( james );
    james.remove(2); // a
    System.out.println( james );
    james.remove(2); // beat
    System.out.println( james );
    james.remove(1); // got
    System.out.println( james ); // HEAD->I->NULL
    System.out.println( "size: " + james.size() );


  }

}//end class LList
