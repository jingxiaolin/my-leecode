package tree;

public class TreeNodeLeecode {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        //rootNode.setLeftNode(new TreeNode(2));
        rootNode.setRightNode(new TreeNode(3));
        //rootNode.getLeftNode().setLeftNode(new TreeNode(4));
        rootNode.getRightNode().setRightNode(new TreeNode(5));
        rootNode.getRightNode().getRightNode().setRightNode(new TreeNode(6));
        rootNode.getRightNode().getRightNode().getRightNode().setLeftNode(new TreeNode(7));
        System.out.println("二叉树的最大深度 == "+treeNodeMininumDeep(rootNode));
    }
    //1、二叉树的最大深度
    private static int treeNodeDeep(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeDeep(rootNode.getLeftNode());
        int rightDeep = treeNodeDeep(rootNode.getRightNode());
        return leftDeep>rightDeep?leftDeep+1:rightDeep+1;
    }

    //1、二叉树的最小深度
    //[2,null,3,null,4,null,5,null,6]
    private static int treeNodeMininumDeep(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeDeep(rootNode.getLeftNode());
        int rightDeep = treeNodeDeep(rootNode.getRightNode());
        if(leftDeep == 0 || rightDeep == 0){
            return leftDeep + rightDeep +1;
        }
        return leftDeep<rightDeep?leftDeep+1:rightDeep+1;
    }
}
