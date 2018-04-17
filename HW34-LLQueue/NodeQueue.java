// Maggie Zhao
// APCS2 pd01
// HW34-- The English Do Not Wait In Line
// 2018-04-16m

public class NodeQueue<Quasar> implements Queue<Quasar>
{
  private LLNode<Quasar> _head, _tail;
  private int _size;

  public NodeQueue() {
    _head = null;
    _tail = null;
    _size = 0;

  }
  //means of removing an element from collection:
  //Dequeues and returns the first element of the queue.
  public Quasar dequeue() {
     if (isEmpty() )
      return null;
     Quasar retVal = _head.getValue();
     _head = _head.getNext();
     _size--;
     return retVal;
  }

  //means of adding an element to collection:
  //Enqueue an element onto the back of this queue.
  public void enqueue( Quasar x ){

     LLNode<Quasar> newNode = new LLNode<Quasar>(x , null);
     if (isEmpty()){
        _head = newNode;
        _tail = newNode;
      }
    _tail.setNext(newNode);
    _tail = _tail.getNext();
    _size++;
  }

  //Returns true if this queue is empty, otherwise returns false.
  public boolean isEmpty() {
    return (_head == null);
  }

  //Returns the first element of the queue without dequeuing it.
  public Quasar peekFront() {
    if (isEmpty() ) return null;
    return _head.getValue();
  }
  public static void main (String[] args) {
    NodeQueue pulsar = new NodeQueue();

    System.out.println(pulsar.isEmpty()); // true

    pulsar.enqueue("astro");
    pulsar.enqueue("cosmic");
    pulsar.enqueue("vacuum");
    pulsar.enqueue("silence");
    pulsar.enqueue("satellite");
    pulsar.enqueue("blackhole");
    pulsar.enqueue("wormhole");
    pulsar.enqueue("asteroid");
    pulsar.enqueue("Io");
    pulsar.enqueue("Polaris");

    System.out.println(pulsar.peekFront());
    // astro
    pulsar.dequeue();
    System.out.println(pulsar.dequeue());
    // cosmic
    System.out.println(pulsar.peekFront());
    // vacuum
    System.out.println(pulsar.dequeue());
    // vacuum
    System.out.println(pulsar.dequeue());
    // silence
    System.out.println(pulsar.isEmpty());
    // false
    System.out.println(pulsar.dequeue());
    // satellite
    System.out.println(pulsar.dequeue());
    // blackhole
    System.out.println(pulsar.dequeue());
    // wormhole
    System.out.println(pulsar.dequeue());
    // asteroid
    System.out.println(pulsar.peekFront());
    // Io
    System.out.println(pulsar.dequeue());
    // Io
    System.out.println(pulsar.dequeue());
    // Polaris
    System.out.println(pulsar.isEmpty());
    // true
    //stack empty by now; SOP(null)
    System.out.println(pulsar.dequeue());
  }
}
