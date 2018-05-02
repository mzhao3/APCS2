/*****************************************************
 * Maggie Zhao
 * APCS2 pd01
 * HW43 -- BSTs is the Perfect Place for Shade
 * 2018-05-02w
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
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~v~~TRAVERSALS~~v~~~~~~~~~~~~~~~~~~~~~

  // each traversal should simply print to standard out
  // the nodes visited, in order

  //process root, recurse left, recurse right
  public void preOrderTrav()
  {
    preOrderTrav( _root );
  }
  public void preOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    System.out.print( currNode.getValue() + " " );
    preOrderTrav( currNode.getLeft() );
    preOrderTrav( currNode.getRight() );
  }

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
  //recurse left, recurse right, process root
  public void postOrderTrav()
  { postOrderTrav( _root ); }
  public void postOrderTrav( TreeNode currNode )
  {
    if ( currNode == null ) //stepped beyond leaf
      return;
    postOrderTrav( currNode.getLeft() );
    postOrderTrav( currNode.getRight() );
    System.out.print( currNode.getValue() + " "  );
  }
  //~~~~~~~~~~~~~^~~TRAVERSALS~~^~~~~~~~~~~~~~~~~~~~~~
  //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
    /*****************************************************
     * TreeNode search(int)
     * returns pointer to node containing target,
     * or null if target not found
     *****************************************************/
    TreeNode search( int target )
    { return search(_root, target); }

    TreeNode search( TreeNode currNode, int target )
    {
      TreeNode pointer = null;
      if(currNode == null){
        return null;
      }
      else if(currNode.getValue() == target){
        pointer = currNode;
        return pointer;
      }
      else if(currNode.getValue() <= target){
        return search(currNode.getRight(), target);
      }
      return search(currNode.getLeft(), target);
    }


    /*****************************************************
     * int height()
     * returns height of this tree (length of longest leaf-to-root path)
     * eg: a 1-node tree has height 0
     *****************************************************/
    public int height()
    { return height(_root); }
    // child, how high are you?
    public int height(TreeNode currNode)
    {
      // if you go past the node
      if (currNode == null)
        return 0;
      // find the larger height of the left and right subtrees
      return (1 + Math.max( height(currNode.getLeft()) , height(currNode.getRight()) ) );
    }
    /*****************************************************
     * int numLeaves()
     * returns number of leaves in tree
     *****************************************************/
    public int numLeaves()
    { return numLeaves(_root); }
    public int numLeaves(TreeNode currNode)
    {
      // if you go past a leaf
      if ( currNode == null ) {
        return 0;
      }
      // if the node is a leaf (has no left or right children)
      if (currNode.getLeft() == null && currNode.getRight() == null){
        return 1;
      }
      // find number of leaves in left and right subtree
      return(numLeaves(currNode.getLeft()) + numLeaves(currNode.getRight()));
    }
  //main method for testing
  public static void main( String[] args )
  {
    BST arbol = new BST();

    //PROTIP: sketch state of tree after each insertion
    //        ...BEFORE executing these.
    arbol.insert( 4 );
    arbol.insert( 2 );
    arbol.insert( 5 );
    arbol.insert( 6 );
    arbol.insert( 1 );
    arbol.insert( 3 );

    System.out.println(arbol.height()); //3
    System.out.println(arbol.numLeaves()); //3
    System.out.println(arbol.search(4));  //pointer
    System.out.println(arbol.search(1));  //pointer
    System.out.println(arbol.search(10)); //null
    /*~~~~~~~~~~~~move~me~down~~~~~~~~~~~~~~~~~~~~~~
      <<< YOUR NEW TEST CALLS HERE >>>
      ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
  }

}//end class
