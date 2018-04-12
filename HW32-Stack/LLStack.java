// Maggie Zhao
// APCS2 pd01
// HW32-- Leon Leonwood Stack
// 2018-04-11r

import java.util.LinkedList;

public class LLStack<PANCAKE> implements Stack<PANCAKE> {

  private LinkedList<PANCAKE> _stack;
  private int _stackSize;

  public LLStack() {

    _stack = new LinkedList<PANCAKE>();
    _stackSize = 0;

  }
  //Return true if this stack is empty, otherwise false.
  public boolean isEmpty(){
    return (_stackSize == 0);
  }

  //Return top element of stack without popping it.
  public PANCAKE peek(){
    return _stack.get( _stackSize - 1);
  }

  //Pop and return top element of stack.
  public PANCAKE pop(){
    if (!isEmpty()) {
      PANCAKE popper = _stack.removeLast();
      _stackSize--;
      return popper;
    }
      return null;

  }

  //Push an element onto top of this stack.
  public void	push( PANCAKE x ) {
    _stack.add( x );
    _stackSize++;
  }

  public String toString()
  {
    String retStr = "BOTTOM->";
    int i = 0;
    while (i < _stackSize) {
      retStr += _stack.get(i) + "->";
      i ++;
    }
    retStr += "TOP";
    return retStr;
  }
}
