class BinNode{
    private int data;
    private BinNode left, right;

    BinNode(int input){
        data = input;
        left = right = null;
    }
    BinNode(int input, BinNode left, BinNode right){
        data = input;
        this.left = left;
        this.right = right;
    }
    public void setData(int input){
        data = input;
    }
    public int getData(){
        return data;
    }
    public void setLeft(BinNode left){
        this.left = left;
    }
    public BinNode getLeft(){
        return left;
    }
    public void setRight(BinNode right){
        this.right = right;
    }
    public BinNode getRight(){
        return right;
    }
}