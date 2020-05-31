import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;

class BinTree{
    private BinNode root;
    private int size;

    BinTree(){
        root = null;
        size = 0;
    }

    BinTree(List<Integer> input){
        if(input.size() == 0) return;
        root = new BinNode(input.get(0));
        size++;
        final Random rng = new Random(1);
        for(int i = 1; i < input.size(); i ++){
            int rand = rng.nextInt();
            if(rand%2 == 0 ){
                BinNode node = findEmptyLeftChild(root);
                node.setLeft(new BinNode(input.get(i)));
            }else{
                BinNode node = findEmptyRightChild(root);
                node.setRight(new BinNode(input.get(i)));
            }
            size++;
        }
    }

    public int getSize(){
        return size;
    }

    public BinNode getRoot(){
        return root;
    }

    public int totalSum(BinNode node){
        //return the total sum off all nodes in this tree
        if(node == null) return 0;
        int current = node.getData();
        int sumLeftTree = totalSum(node.getLeft());
        int sumRightTree = totalSum(node.getRight());

        return current + sumLeftTree + sumRightTree;
    }

    public int height(BinNode node){
        //return the height of the tree
        if(node == null) return 0;
        return Math.max(height(node.getLeft()), height(node.getRight())) + 1;
    }

    public int rangeOfTree(){
        //return the max of the tree - min of the tree
        return largestNode(root).getData() - smallestNode(root).getData();
    }

    public BinNode smallestNode(BinNode node){
        //returns the smallest node in the tree
        BinNode current = node;
        BinNode leftMax = smallestNode(node.getLeft());
        BinNode rightMax = smallestNode(node.getRight());

        if(leftMax.getData() < current.getData()) {
            return leftMax;
        } else if(rightMax.getData() < current.getData()) {
            return rightMax;
        } else {
            return current;
        }
    }

    public BinNode largestNode(BinNode node){
        //returns the largest node in the tree
        BinNode current = node;
        BinNode leftMax = largestNode(node.getLeft());
        BinNode rightMax = largestNode(node.getRight());

        if(leftMax.getData() > current.getData()) {
            return leftMax;
        } else if(rightMax.getData() > current.getData()) {
            return rightMax;
        } else {
            return current;
        }
    }

    public int averageOfTree(){
        //returns the average of the tree
        return totalSum(root) / size;
    }

    public int numNodes(BinNode node){
        //returns the number of nodes in the tress
        return size;
    }


    public String toString(){
        Queue<Integer> treeList = toString(root, new LinkedList<Integer>());
        StringBuilder builder = new StringBuilder();
        int level = 0;
        
        while(treeList.size() > 0){
            int numNodesToProcess = (int) Math.pow(2, level);
            builder.append("Level " + level + ": ");
            for(int i = 0; i < numNodesToProcess; i++){
                builder.append(treeList.poll() + " " );
            }
            builder.append("\n");
            level++;
        }

        return builder.toString();
    }

    private Queue<Integer> toString(BinNode root, Queue<Integer> list){
        if(root == null) return list;
        int numNodesAdded = 0;
        Queue<BinNode> queue = new LinkedList<>();
        queue.add(root);
        while(queue.size() > 0){
            BinNode current = queue.poll();
            if(current != null){
                list.add(current.getData());
                queue.add(current.getLeft());
                queue.add(current.getRight());
                numNodesAdded++;
            }else{
                list.add(null);
                queue.add(null);
                queue.add(null);
            }

            if(numNodesAdded == size) break;
        }
        return list;

    }

    private BinNode findEmptyLeftChild(BinNode root){
        if(root.getLeft() == null) return root;
        if(root.getRight() == null) return findEmptyLeftChild(root.getLeft());
        final Random rng = new Random();
        final int rand = rng.nextInt();
        return rand%2 == 0 ? findEmptyLeftChild(root.getLeft()) : findEmptyLeftChild(root.getRight());
    }

    private BinNode findEmptyRightChild(BinNode root){
        if(root.getRight() == null) return root;
        if(root.getLeft() == null) return findEmptyRightChild(root.getRight());
        final Random rng = new Random();
        final int rand = rng.nextInt();
        return rand%2 == 0 ? findEmptyRightChild(root.getLeft()) : findEmptyRightChild(root.getRight());
    }
}