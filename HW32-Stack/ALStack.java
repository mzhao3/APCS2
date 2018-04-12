// Maggie Zhao
// APCS2 pd01
// HW32-- Leon Leonwood Stack
// 2018-04-11r

import java.util.ArrayList;

public class ALStack<PANCAKE> implements Stack<PANCAKE> {

  private ArrayList<PANCAKE> _stack;
  private int _stackSize;

  public ALStack() {
    _stack  = new ArrayList<PANCAKE>();
    _stackSize = 0;
  }
  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty() {
    return (_stackSize == 0);
  }

  //Return top element of stack without popping it.
  public PANCAKE peek(){
    return _stack.get(_stackSize - 1);
  }
  //Pop and return top element of stack.
  public PANCAKE pop() {
    if (!isEmpty()) {
      PANCAKE popper = _stack.remove(_stackSize - 1);
      _stackSize -- ;
      return popper;
    }
    return null;
  }

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ){
    _stack.add(x);
    _stackSize++;
  }

  public String toString()
  {
    String foo = "Bottom o' the stack -> [";
    for( int i = 0; i < _stackSize; i++ ) {
      foo += _stack.get(i) + ",";
    }
    if ( foo.length() > 1 )
      //shave off trailing comma
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]-> Top o' the stack.";
    return foo;
  }
}
