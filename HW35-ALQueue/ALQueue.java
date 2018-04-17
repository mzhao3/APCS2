//Team Umbrella: Maggie Zhao, Richard Wong
//APCS2 pd1
//HW35 -- ...Nor Do Aussies
//2018-04-17 T

/*****************************************************
 * class ALQueue
 * Includes only methods listed in AP subset of Java
 * Uses ArrayList to implement local Queue specification
 *****************************************************/

import java.util.ArrayList;
    
public class ALQueue<T> implements Queue<T>
{
    ArrayList<T> umbrella = new ArrayList<T>();
    
    //~~~~~~~~~~~~~~~~~~begin AP subset~~~~~~~~~~~~~~~~~~
    //means of removing an element from collection:
    //Dequeues and returns the first element of the queue.
    public T dequeue()
    {
	if (isEmpty()) {
	    return null;
	}
	else {
	    return umbrella.remove(0);
	}
    }

    //means of adding an element to collection:
    //Enqueue an element onto the back of this queue.
    public void enqueue(T x)
    {
	umbrella.add(x);
    }

    //Returns true if this queue is empty, otherwise returns false.
    public boolean isEmpty()
    {
	return umbrella.size() == 0;
    }

    //Returns the first element of the queue without dequeuing it.
    public T peekFront()
    {
	if (isEmpty()) {
	    return null;
	}
	else {
	    return umbrella.get(0);
	}
    }
    //~~~~~~~~~~~~~~~~~~~end AP subset~~~~~~~~~~~~~~~~~~~

    public static void main(String[] args) {
	ALQueue<String> queue = new ALQueue<String>();
	queue.enqueue("one");
	queue.enqueue("two");
	queue.enqueue("three");

	for(int i = 0; i < 4; i++) {
	    System.out.println("peek: " + queue.peekFront());
	    System.out.println("dequeue: " + queue.dequeue());
	    System.out.println();
	}
    }
}

