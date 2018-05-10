/*****************************************************
 * Maggie Zhao
 * APCS2 pd01
 * HW44- Prune your tree
 * 2018-05-03r
 * class BST - v1:partial
 * Implementation of the BINARY SEARCH TREE abstract data type (ADT)
 *
 * A BST maintains the invariant that, for any node N with value V,
 * L<V && V<R, where L and R are node values in N's left and right
 * subtrees, respectively.
 * (Any value in a node's left subtree must be less than its value,
 *  and any value in its right subtree must be greater.)
 * This BST only holds ints (its nodes have int cargo)
 *****************************************************/

public class BST
{

  //instance variables / attributes of a BST:
  TreeNode _root;

  /*****************************************************
   * default constructor
   *****************************************************/
  BST( )
  {
    _root = null;
  }
  /*****************************************************
   * void insert( int )
   * Adds a new data element to tree.
   *****************************************************/
  public void insert( int newVal )
  {
    TreeNode newNode = new TreeNode( newVal );

    if ( _root == null ) {
      _root = newNode;
      return;
    }
    insert( _root, newNode );
  }
  //recursive helper for insert(int)
  public void insert( TreeNode stRoot, TreeNode newNode )
  {
    if ( newNode.getValue() < stRoot.getValue() ) {
      //if no left child, make newNode the left child
      if ( stRoot.getLeft() == null )
        stRoot.setLeft( newNode );
      else //recurse down left subtree
        insert( stRoot.getLeft(), newNode );
      return;
    }
    else { // new val >= curr, so look down right subtree
      //if no right child, make newNode the right child
      if ( stRoot.getRight() == null )
        stRoot.setRight( newNode );
      else //recurse down right subtree
        insert( stRoot.getRight(), newNode );
      return;
    }
  }//end insert()

  public void remove ( int target ) {
    TreeNode leader = _root;
    TreeNode follower = _root;

    if ( leader == null )
      return;
// goes through the tree so that leader is now the target node, and follower is its parent
    while ( leader.getValue() != target ) {
      //follower = leader;
      if (  leader.getValue() < target)
        leader = leader.getRight();
      else if(leader.getValue() > target){
        leader = leader.getLeft();
      }
      if(leader.getValue()!=target){
        follower = leader;
      }

    }

    // first case: target node is a a leaf node
    if ( leader.getLeft() == null && leader.getRight() == null ) {
      if(leader.getValue() > follower.getValue())
        follower.setRight(null);
      follower.setLeft(null);
    }

    // second case: only has one child
    // there is only a left child
    else if (leader.getLeft() != null && leader.getRight() == null ) {
      if(leader.getValue() > follower.getValue())
        follower.setLeft(leader.getLeft());
      follower.setRight(leader.getLeft());
    }
    // there is only a right child
    else if (leader.getLeft() == null && leader.getRight() != null ) {
      if(leader.getValue() > follower.getValue())
        follower.setRight(leader.getRight());
      follower.setLeft(leader.getRight());
    }

    // last case: the target node is a root
    else {
      // first go to left subtree
      if(leader.getLeft()!= null){
        leader = leader.getLeft();
      }
      // find max value in left subtree
      follower = leader;
      while(leader.getRight()!= null){
        leader = leader.getRight();
        if(leader.getRight() != null){
          follower = leader;
        }
      }
      _root.setValue(leader.getValue());
      follower.setRight(null);
    }

  }
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  //recurse left, process root, recurse right
  public void inOrderTrav()
  { inOrderTrav( _root ); }
  public void inOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    inOrderTrav( currNode.getLeft() );
    System.out.print( currNode.getValue() + " " );
    inOrderTrav( currNode.getRight() );
  }
   //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 100 );
    arbol.insert( 50 );
    arbol.insert( 150 );
    arbol.insert( 75 );
    arbol.insert( 60 );
    arbol.insert( 90 );

    System.out.println( "\n-----------------------------");
    System.out.println( "Pre-removal in-order traversal:" );
    arbol.inOrderTrav();
    System.out.println( "\n-----------------------------");

    //arbol.remove( 150 );
    arbol.remove(50);
     //arbol.remove(100);

    System.out.println( "\n-----------------------------");
    System.out.println( "Post-removal in-order traversal:" );
    arbol.inOrderTrav();
    System.out.println( "\n-----------------------------");



    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      <<< YOUR NEW TEST CALLS HERE >>>
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
