package Lab6;

import java.util.*;

public class BSTTester {
    public static void main(String[] args) {
        LinkedBinarySearchTree<Integer> BST = new LinkedBinarySearchTree<Integer>();
        BST.addElement(11);
        BST.addElement(6);
        BST.addElement(8);
        BST.addElement(19);
        BST.addElement(4);
        BST.addElement(10);
        BST.addElement(5);
        BST.addElement(17);
        BST.addElement(43);
        BST.addElement(49);
        BST.addElement(31);
        //For Coursemology Q1
        System.out.println(inOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(preOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(postOrder(BST.root, new ArrayList<Integer>()));
        System.out.println(levelOrder(BST));
        // For Coursemology Q2
        System.out.println(BST);

        // For Coursemology Q3
        ArrayList<Integer> preOrder = new ArrayList<Integer>(Arrays.asList(11, 6, 4, 5, 8, 10, 19, 17, 43, 31, 49));
        ArrayList<Integer> inOrder = new ArrayList<Integer>(Arrays.asList(4, 5, 6, 8, 10, 11, 17, 19, 31, 43, 49));
        System.out.println(constructTree(preOrder, inOrder));
    }

    // Q1: Complete the inOrder Traversal here
    public static ArrayList<Integer> inOrder(BinaryTreeNode<Integer> curr, ArrayList<Integer> result) {
        ArrayList<Integer> r = new ArrayList<>();
        if (curr.left != null) r.addAll(inOrder(curr.left, null));
        r.add(curr.element);
        if (curr.right != null) r.addAll(inOrder(curr.right, null));
        return r;
    }

    // Q1: Complete the preOrder Traversal here
    public static ArrayList<Integer> preOrder(BinaryTreeNode<Integer> curr, ArrayList<Integer> result) {
        if (curr.numChildren() == 0) return new ArrayList<>(Arrays.asList(curr.element));
        ArrayList<Integer> r = new ArrayList<>();
        r.add(curr.element);
        if (curr.left != null) r.addAll(preOrder(curr.left, null));
        if (curr.right != null) r.addAll(preOrder(curr.right, null));
        return r;
    }

    // Q1: Complete the postOrder Traversal here
    public static ArrayList<Integer> postOrder(BinaryTreeNode<Integer> curr, ArrayList<Integer> result) {
        if (curr.numChildren() == 0) return new ArrayList<>(Arrays.asList(curr.element));
        ArrayList<Integer> r = new ArrayList<>();
        if (curr.left != null) r.addAll(postOrder(curr.left, null));
        if (curr.right != null) r.addAll(postOrder(curr.right, null));
        r.add(curr.element);
        return r;
    }

    // Q1: Complete an iterative levelOrder Traversal here
    public static ArrayList<Integer> levelOrder(LinkedBinarySearchTree<Integer> BST) {
        ArrayList<Integer> r = new ArrayList<>();
        Deque<BinaryTreeNode<Integer>> queue = new ArrayDeque<>();
        queue.offer(BST.root);
        while (!queue.isEmpty()) {
            BinaryTreeNode<Integer> curr = queue.poll() ;
            if (curr.left != null) queue.offer(curr.left);
            if (curr.right != null) queue.offer(curr.right);
            r.add(curr.element);
        }
        return r;
    }

    // Q3: Complete the following method to construct a tree from the pre and in order traversals
    // You may add your own auxillary methods
    public static LinkedBinarySearchTree<Integer> constructTree(ArrayList<Integer> preOrder, ArrayList<Integer> inOrder) {
        BinaryTreeNode<Integer> root;
        if (preOrder.isEmpty()) {
            root = null;
        } else {
            root = new BinaryTreeNode<>(preOrder.get(0));
        }
        if (preOrder.size() > 1) {
            int i = inOrder.indexOf(preOrder.get(0));
            LinkedBinarySearchTree<Integer> left = constructTree(
                    new ArrayList<>(preOrder.subList(1, i+1)),
                    new ArrayList<>(inOrder.subList(0, i))
            );
            LinkedBinarySearchTree<Integer> right = constructTree(
                    new ArrayList<>(preOrder.subList(i+1, preOrder.size())),
                    new ArrayList<>(inOrder.subList(i+1, inOrder.size()))
            );
            root.left = left.root;
            root.right = right.root;
        }
        LinkedBinarySearchTree<Integer> t = new LinkedBinarySearchTree<>();
        t.root = root;
        return t;
    }

}
