//Team Hydration
//Roster: Zane Wang, Sophia Xia, Maggie Zhao
//APCS2 pd1
//L02 -- All Hands on Deque! (Not Schenectady; rather, synecdoche.)
//2018-04-18

import java.util.Iterator;
public class QQKachoo<D> implements Deque<D>{

  //INSTANCE VARIABLES =============================================
  private DLLNode<D> _head, _tail;
  private int _size;

  //METHODS =========================================================
  // ****************************DEQUE METHODS**************************

  //Returns the number of elements in this deque.
  public int size(){
    return _size;
  }

  //Retrieves, but does not remove, the first element of this deque.
  public D getFirst(){
    return _head.getCargo();
  }

  //Retrieves, but does not remove, the last element of this deque.
  public D getLast(){
    return _tail.getCargo();
  }


  //Inserts the specified element at the front of this deque if it is possible to do so immediately without violating capacity restrictions
  public void addFirst(D d){
    DLLNode<D> newNode= new DLLNode<D>(d, null, _head);
    if (size() == 0)
    _head = _tail = newNode;
    else {
      newNode.setNext(_head);
      _head.setPrev(newNode);
      _head = newNode;
    }
    _size ++;
  }

  //Inserts the specified element at the end of this deque if it is possible to do so immediately without violating capacity restrictions.
  public void addLast(D d){
    DLLNode<D> newNode = new DLLNode<D>(d, _tail, null);
    if (size() == 0)
    _head = _tail = newNode;
    else {
      _tail.setNext(newNode);
      newNode.setPrev(_tail);
      _tail = newNode;
    }
    _size++;
  }

  //Remove Methods
  // throws an exception if empty
  public D removeFirst(){
    if (_size == 0)
    throw new NoSuchElementException();
    else {
      D temp = _head.getCargo();
      _head = _head.getNext();
      _head.setPrev(null);
      _size--;
      return temp;
    }
  }

  // throws an exeption if empty
  public D removeLast(){
    if (_size = 0)
    throw new NoSuchElementException();
    else {
      D temp = _tail.getCargo();
      _tail = _tail.getPrev();
      _tail.setNext(null);
      _size--;
      return temp;
    }
  }

  public D pollFirst() {
    if (_size == 0)
    return null;
    else {
      D temp = _head.getCargo();
      _head = _head.getNext();
      _head.setPrev(null);
      _size--;
      return temp;
    }
  }

  public D pollLast() {
    if (_size = 0)
    return null;
    else {
      D temp = _tail.getCargo();
      _tail = _tail.getPrev();
      _tail.setNext(null);
      _size--;
      return temp;
    }

  }

  public Iterator<D> iterator() {
  }

  public Iterator<D> descendingIterator(){

  }
  // ****************************QUEUE METHODS**************************
  //Retrieves, but does not remove, the head of the queue represented by this deque (in other words, the first element of this deque). Throws a NoSuchElementException if the deque is empty.
  // * Throw exception.
  public D element(){
    return _head.getCargo();
  }

  //Inserts the specified element into the queue represented by this deque (in other words, at the tail of this deque) if it is possible to
  public boolean add(D d){
    addLast(d);
    return true;
  }

  public D poll() {
    return pollFirst();
  }

  public D remove(){
    return removeFirst();
  }


  public D peek() {
    return peekFirst();
  }
  // ****************************STACK METHODS**************************


  public D peekFirst() {
    if (_size == 0)
    return null;
    return _head.getValue();
  }

  public D peekLast() {
    if (_size == 0)
    return null;
    return _tail.getValue();
  }

  public static void main(String[] args){

  }
}
