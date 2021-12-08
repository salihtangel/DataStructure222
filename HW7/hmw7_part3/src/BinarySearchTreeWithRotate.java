//basladi
/** A Node represents a node in a B‐tree.
private static class Node<E> {
    // Data Fields
    *//** The number of data items in this node *//*
    private int size = 0;
    *//** The information *//*
    private E[] data;
    *//** The links to the children. child[i] refers to the subtree of
     children < data[i] for i < size and to the subtree
     of children > data[size‐1] for i == size
     *//*
    private Node<E>[] child;
    *//** Create an empty node of size order
     @param order The size of a node
     *//*
    @SuppressWarnings("unchecked")
    public Node(int order) {
        data = (E[]) new Comparable[order‐1];
        child = (Node<E>[]) new Node[order];
        size = 0;
    }
}

*//** An implementation of the B‐tree. A B‐tree is a search tree
 in which each node contains n data items where n is between
 (order‐1)/2 and order‐1. (For the root, n may be between 1
 and order‐1.) Each node not a leaf has n+1 children. The tree is
 always balanced in that all leaves are on the same level, i.e.,
 of the path from the root to a leaf is constant.
 the length @author Koffman and Wolfgang
 *//*
public class BTree<E extends Comparable<E>>
// Nested class
*//** A Node represents a node in a B‐tree. *//*
private static class Node<E> {

}
    *//** The root node. *//*
    private Node<E> root = null;
    *//** The maximum number of children of a node *//*
    private int order;

    *//** Construct a B‐tree with node size order
     @param order the size of a node
     *//*
    public BTree(int order) {
        this.order = order;
        root = null;
    }

    *//** Recursively insert an item into the B‐tree. Inserted
     item must implement the Comparable interface
     @param root The local root
     @param item The item to be inserted
     @return true if the item was inserted,
     false if the item is already in the tree
     *//*
    private boolean insert(Node<E> root, E item) {
        int index = binarySearch(item, root.data, 0, root.size);
        if (index != root.size && item.compareTo(root.data[index]) == 0) {
            return false;
        }
        if (root.child[index] == null) {
            if (root.size < order‐1) {
                insertIntoNode(root, index, item, null);
                newChild = null;
            } else {
                splitNode(root, index, item, null);
            }
            return true;
        } else {
            boolean result = insert(root.child[index], item);
            if (newChild != null) {
                if (root.size < order‐1) {
                    insertIntoNode(root, index, newParent, newChild);
                    newChild = null;
                } else {
                    splitNode(root, index, newParent, newChild);
                }
            }
            return result;
        }
    }*/
//bitti

/**
 * Extends the BinarySearchTree by adding the rotate operations.
 * Rotation will change the balance of a search tree while preserving the search tree property.
 * Used as a common base for self-balancing trees.
 *
 * @param <E> The type of data stored. Must be a Comparable type
 * @author Jacob/ Koffman & Wolfgang
 */
@SuppressWarnings("serial")
public class BinarySearchTreeWithRotate<E extends Comparable<E>> extends BinarySearchTree<E> {

    //Methods

    /**
     * Method to perform a right rotation
     * pre: root is the root of a binary search tree
     * post: root.left is the root of a binary search tree
     * root.left.left is raised one level
     * root.left.right does not change levels
     * root.right is lowered one level
     * the new root is returned
     *
     * @param root The root of the binary tree to be rotated
     * @return The new root of the rotated tree
     */
    protected Node<E> rotateRight(Node<E> root) {
        Node<E> temp = root.left;
        root.left = temp.right;
        temp.right = root;
        return temp;
    }

    /**
     * Method to perform a left rotation
     * pre: root is the root of a binary search tree
     * post: root.right is the root of a binary search tree
     * root.right.right is raised one level
     * root.right.left does not change levels
     * root.left is lowered one level
     * the new root is returned
     *
     * @param root The root of the binary tree to be rotated
     * @return The new root of the rotated tree
     */
    protected Node<E> rotateLeft(Node<E> root) {
        Node<E> temp = root.right;
        root.right = temp.left;
        temp.left = root;
        return temp;
    }
}
