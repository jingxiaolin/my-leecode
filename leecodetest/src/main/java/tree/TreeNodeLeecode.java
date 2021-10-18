package tree;

public class TreeNodeLeecode {
    public static void main(String[] args) {
        TreeNode rootNode = new TreeNode(1);
        rootNode.setLeftNode(new TreeNode(2));
        rootNode.setRightNode(new TreeNode(3));
        rootNode.getLeftNode().setLeftNode(new TreeNode(4));
        /*rootNode.getRightNode().setRightNode(new TreeNode(5));
        rootNode.getRightNode().getRightNode().setRightNode(new TreeNode(6));
        rootNode.getRightNode().getRightNode().getRightNode().setLeftNode(new TreeNode(7));*/
        //System.out.println("完全二叉树节点数 == "+treeNodeCount(rootNode));
        //System.out.println("完全二叉树节点数(new) == "+treeNodeCountNew(rootNode));
        System.out.println("二叉树的直径 == "+diameterOfBinaryTree(rootNode));
    }
    //1、二叉树的最大深度
    //leecode：er-cha-shu-de-shen-du-lcof
    private static int treeNodeDeep(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeDeep(rootNode.getLeftNode());
        int rightDeep = treeNodeDeep(rootNode.getRightNode());
        return leftDeep>rightDeep?leftDeep+1:rightDeep+1;
    }

    //2、二叉树的最小深度
    //leecode:minimum-depth-of-binary-tree
    //[2,null,3,null,4,null,5,null,6]
    private static int treeNodeMininumDeep(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeDeep(rootNode.getLeftNode());
        int rightDeep = treeNodeDeep(rootNode.getRightNode());
        //加这个判断的目的是，leecode 题目要求，求的是根节点到叶子节点的距离，如果没有叶子节点，
        //那么计算的深度无效
        if(leftDeep == 0 || rightDeep == 0){
            return leftDeep + rightDeep +1;
        }
        return leftDeep<rightDeep?leftDeep+1:rightDeep+1;
    }

    //3、完全二叉树节点个数
    //leecode:count-complete-tree-nodes
    //暴力法，不可取，没有利用完全二叉树的特性。
    private static int treeNodeCount(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeCount(rootNode.getLeftNode());
        int rightDeep = treeNodeCount(rootNode.getRightNode());
        return leftDeep+rightDeep+1;
    }

    //完全二叉树的定义如下：
    // 在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，
    // 并且最下面一层的节点都集中在该层最左边的若干位置。
    // 若最底层为第 h 层，则该层包含 1~ 2^h 个节点。
    private static int treeNodeCountNew(TreeNode rootNode){
        if(rootNode == null){
            return 0;
        }
        int leftDeep = treeNodeDeepForCountNew(rootNode.getLeftNode(),"left");
        int rightDeep = treeNodeDeepForCountNew(rootNode.getRightNode(),"right");
        if(leftDeep == rightDeep){
            return (int) (Math.pow(2,leftDeep)-1);
        }else {
            return treeNodeCountNew(rootNode.getLeftNode()) + treeNodeCountNew(rootNode.getRightNode())+1;
        }
    }

    private static int treeNodeDeepForCountNew(TreeNode rootNode,String lr){
        int deepRes = 1;
        while (null != rootNode){
            deepRes++;
            if(lr.equals("left")){
                rootNode = rootNode.getLeftNode();
            }else {
                rootNode = rootNode.getRightNode();
            }
        }
        return deepRes;
    }
    //4、求二叉树的直径
    private static int result = 0;
    private static int diameterOfBinaryTree(TreeNode root){
        if(null == root){
            return 0;
        }
        diameterOfBinaryTreeCount(root);
        return result;
    }

    private static int diameterOfBinaryTreeCount(TreeNode root){
        if(null == root){
            return 0;
        }
        int lr = root.getLeftNode() == null?0:diameterOfBinaryTreeCount(root.getLeftNode())+1;
        int rr = root.getRightNode() == null?0:diameterOfBinaryTreeCount(root.getRightNode())+1;
        result = Math.max(lr+rr,result);
        return lr>rr?lr:rr;
    }
}
