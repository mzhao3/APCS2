//Team Hydration
//Roster: Zane Wang, Sophia Xia, Maggie Zhao
//APCS2 pd1
//L02 -- All Hands on Deque! (Not Schenectady; rather, synecdoche.)
//2018-04-18

public interface Deque<Card>{

    //List of ALL Methods listed in the API

    //Size Method
    public int size();

    //add methods
    public boolean add(Card c);
    public void addFirst(Card c);
    public void addLast(Card c);

    //-----Insertion Methods: seems redundant since it just inserts an element at tail, front or end
    //public boolean offer(Card c);
    //public boolean offerFirst(Card c);
    //public boolean offerLast(Card c);

    //Search methods
    //doesn't seem to be the most important right now
    //public boolean contains(Object o);

    //Iterator Methods
    public Iterator<Card> descendingIterator();
    public Iterator<Card> iterator();

    //Accessor Methods
    public Card element();
    public Card getFirst();
    public Card getLast();

    //-----peek: seems redundant since it just retrieves the values
    public Card peek();
    public Card peekFirst();
    public Card peekLast();

    //Stack Methods
    //Deque will not be implementing a stack
    //public Card pop();
    //public void push(Card c);

    //Remove Methods
    public Card remove();
    public Card removeFirst();
    public Card removeLast();

    //-----removeObjects:
    //public boolean remove(Object o);
    //public boolean removeFirstOccurence(Object o);
    //public boolean removeLastOccurence(Object o);

    //-----poll: seems redundant since it just removes and returns elements
    public Card poll();
    public Card pollFirst();
    public Card pollLast();


}
