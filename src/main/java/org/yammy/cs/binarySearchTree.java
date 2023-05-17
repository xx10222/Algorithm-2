package org.yammy.cs;

public class binarySearchTree {
    public class Node {
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.setData(data);
            setLeft(null);
            setRight(null);
        }

        public int getData() {
            return data;
        }

        public void setData(int data) {
            this.data = data;
        }

        public Node getLeft() {
            return left;
        }

        public Node getRight() {
            return right;
        }

        public void setLeft(Node left) {
            this.left = left;
        }

        public void setRight(Node right) {
            this.right = right;
        }
    }

    public Node root;

    public binarySearchTree() {
        this.root = null;
    }

    public boolean find(int id) {
        Node current = root;

        while (current != null) {
            // 현재 노드와 찾는 값이 같으면
            if (current.getData() == id) {
                return true;
            } else if (current.getData() > id) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    public boolean delete(int id) {
        Node parent = root;
        Node current = root;
        boolean isLeftChild = false;
        while (current.getData() != id) {
            parent = current;
            if (current.getData() > id) {
                isLeftChild = true;
                current = current.getLeft();
            } else {
                isLeftChild = false;
                current = current.getRight();
            }
            if (current == null) {
                return false;
            }
        }
        //Case 1: 자식노드가 없는 경우
        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            }
            if (isLeftChild == true) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
        }
        //Case 2 : 하나의 자식을 갖는 경우
        else if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeftChild) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }
        } else if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeftChild) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }
        }
        //Case 3 : 두개의 자식을 갖는 경우
        else if (current.getLeft() != null && current.getRight() != null) {
            // 오른쪽 서브트리의 최소값을 찾음
            Node successor = getSuccessor(current);
            if (current == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }
            successor.setLeft(current.getLeft());
        }
        return true;
    }

    public Node getSuccessor(Node deleteNode) {
        Node successor = null;
        Node successorParent = null;
        Node current = deleteNode.getRight();
        while (current != null) {
            successorParent = successor;
            successor = current;
            current = current.getLeft();
        }
        if (successor != deleteNode.getRight()) {
            successorParent.setLeft(successor.getRight());
            successor.setRight(deleteNode.getRight());
        }
        return successor;
    }

    public void insert(int id) {
        Node newNode = new Node(id);
        if (root == null) {
            root = newNode;
            return;
        }
        Node current = root;
        Node parent = null;
        while (true) {
            parent = current;
            if (id < current.getData()) {
                current = current.getLeft();
                if (current == null) {
                    parent.setLeft(newNode);
                    return;
                }
            } else {
                current = current.getRight();
                if (current == null) {
                    parent.setRight(newNode);
                    return;
                }
            }
        }
    }

    // pre-order 순회 (중위 순회)
    public void display(Node root) {
        if (root != null) {
            display(root.getLeft());
            System.out.print(" " + root.getData());
            display(root.getRight());
        }
    }

    public static void main(String[] args) {
        binarySearchTree bst = new binarySearchTree();
        //트리에 노드를 삽입
        bst.insert(3);
        bst.insert(8);
        bst.insert(1);
        bst.insert(4);
        bst.insert(6);
        bst.insert(2);
        bst.insert(10);
        bst.insert(9);
        bst.insert(20);
        bst.insert(25);
        bst.insert(15);
        bst.insert(16);

        System.out.println("트리삽입 결과 : ");
        bst.display(bst.root);
        System.out.println("");
        System.out.println("이진트리에서 4를 탐색 : " + bst.find(4));
        System.out.println("이진트리에서 2를 삭제 : " + bst.delete(2));
        bst.display(bst.root);
        System.out.println("\n이진트리에서 4를 삭제 : " + bst.delete(4));
        bst.display(bst.root);
        System.out.println("\n이진트리에서 10을 삭제 : " + bst.delete(10));
        bst.display(bst.root);
    }

}