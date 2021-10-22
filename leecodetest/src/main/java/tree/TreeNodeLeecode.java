package tree;

import sun.reflect.generics.tree.Tree;

import java.util.Objects;

public class TreeNodeLeecode {
    public static void main(String[] args) {
        //TreeNode rootNode = new TreeNode(-3);
        TreeNode rootNode = new TreeNode(2);
        rootNode.setLeftNode(new TreeNode(7));
        rootNode.setRightNode(new TreeNode(3));
        /*rootNode.getLeftNode().setLeftNode(new TreeNode(4));
        rootNode.getLeftNode().setRightNode(new TreeNode(5));*/
        //rootNode.getLeftNode().getLeftNode().setRightNode(new TreeNode(6));
        /*rootNode.getRightNode().getRightNode().setRightNode(new TreeNode(6));
        rootNode.getRightNode().getRightNode().getRightNode().setLeftNode(new TreeNode(7));*/
        //System.out.println("完全二叉树节点数 == "+treeNodeCount(rootNode));
        //System.out.println("完全二叉树节点数(new) == "+treeNodeCountNew(rootNode));
        //System.out.println("二叉树的直径 == "+diameterOfBinaryTree(rootNode));
        //System.out.println("二叉树最长路径的和 == "+diameterOfBinaryTreeSum(rootNode));
        //System.out.println("是否是完全二叉树 == "+checkTreeBalance(rootNode));
        //System.out.println("二叉树是否镜像 == "+checkTreeSymmetric(rootNode));
        System.out.println("二叉树是否是二叉搜索树 == "+validTreeNode(rootNode));
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
    //diameter-of-binary-tree
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

    private static boolean resultBalance = true;
    private static int diameterOfBinaryTreeCountForBalance(TreeNode root){
        if(null == root){
            return 0;
        }
        int lr = root.getLeftNode() == null?0:diameterOfBinaryTreeCount(root.getLeftNode())+1;
        int rr = root.getRightNode() == null?0:diameterOfBinaryTreeCount(root.getRightNode())+1;
        if(resultBalance){
            resultBalance = Math.abs(lr-rr)<=1;
        }
        return lr>rr?lr:rr;
    }

    //5、求二叉树的最大的路径和
    //binary-tree-maximum-path-sum
    private static int resultSum = 0;
    private static int diameterOfBinaryTreeSum(TreeNode root){
        if(null == root){
            return 0;
        }
        resultSum = root.getVal();
        //diameterOfBinaryTreeCountSum(root);
        diameterOfBinaryTreeCountSumSimple(root);
        return resultSum;
    }

    private static int diameterOfBinaryTreeCountSum(TreeNode root){
        if(null == root){
            return 0;
        }
        int lr = root.getLeftNode() == null?0:diameterOfBinaryTreeCountSum(root.getLeftNode())+root.getLeftNode().getVal();
        int rr = root.getRightNode() == null?0:diameterOfBinaryTreeCountSum(root.getRightNode())+root.getRightNode().getVal();
        if(lr < 0){
            lr = 0;
        }
        if(rr < 0){
            rr = 0;
        }
        resultSum = Math.max(lr+rr+root.getVal(),resultSum);
        return lr>rr?lr:rr;
    }
    //5、求二叉树的最大的路径和
    //binary-tree-maximum-path-sum
    //优雅写法
    private static int diameterOfBinaryTreeCountSumSimple(TreeNode root){
        if(null == root){
            return 0;
        }
        int lr=Math.max(0,diameterOfBinaryTreeCountSum(root.getLeftNode()));
        int rr=Math.max(0,diameterOfBinaryTreeCountSum(root.getRightNode()));
        resultSum = Math.max(lr+rr+root.getVal(),resultSum);
        return lr>rr?lr+root.getVal():rr+root.getVal();
    }

    //6、判断平衡二叉树，左右子树高度差不超过1
    //ping-heng-er-cha-shu-lcof
    private static boolean checkTreeBalance(TreeNode root){
        if(null == root){
            return true;
        }
        diameterOfBinaryTreeCountForBalance(root);
        return resultBalance;
    }

    //7、判断二叉树是否是镜像的
    //dui-cheng-de-er-cha-shu-lcof
    //思路
    /*
    * 递归的函数要干什么？
函数的作用是判断传入的两个树是否镜像。
输入：TreeNode left, TreeNode right
输出：是：true，不是：false
递归停止的条件是什么？
左节点和右节点都为空 -> 倒底了都长得一样 ->true
左节点为空的时候右节点不为空，或反之 -> 长得不一样-> false
左右节点值不相等 -> 长得不一样 -> false
从某层到下一层的关系是什么？
要想两棵树镜像，那么一棵树左边的左边要和二棵树右边的右边镜像，一棵树左边的右边要和二棵树右边的左边镜像
调用递归函数传入左左和右右
调用递归函数传入左右和右左
只有左左和右右镜像且左右和右左镜像的时候，我们才能说这两棵树是镜像的
调用递归函数，我们想知道它的左右孩子是否镜像，传入的值是root的左孩子和右孩子。这之前记得判个root==null。
    *  */
    //其实也可以，先求左子树的镜像，看和右子树是否相等
    public static boolean checkTreeSymmetric(TreeNode root){
        if(null == root){
            return true;
        }
        return checkTreeSymmetricRecurrence(root.getLeftNode(),root.getRightNode());
    }

    private static boolean checkTreeSymmetricRecurrence(TreeNode leftNode,TreeNode rightNode) {
        if(null == leftNode && null == rightNode){
            return true;
        }
        if(null == leftNode || null == rightNode){
            return false;
        }
        return Objects.equals(leftNode.getVal(),rightNode.getVal()) &&
                checkTreeSymmetricRecurrence(leftNode.getLeftNode(),rightNode.getRightNode()) &&
                checkTreeSymmetricRecurrence(leftNode.getRightNode(),rightNode.getLeftNode())
                ;
    }

    //8、求一颗二叉树的镜像树
    //er-cha-shu-de-jing-xiang-lcof
    private static TreeNode getTreeNodeImage(TreeNode root){
        if(root == null){
            return root;
        }
        imageTreeNode(root);
        return root;
    }

    private static void imageTreeNode(TreeNode root) {
        if(root == null){
            return;
        }
        TreeNode tmpNode = root.getLeftNode();
        root.setLeftNode(root.getRightNode());
        root.setRightNode(tmpNode);
        imageTreeNode(root.getLeftNode());
        imageTreeNode(root.getRightNode());
    }

    //9、验证二叉搜索树
    //validate-binary-search-tree
    private static boolean validTreeNode(TreeNode root){
        if(null == root){
            return true;
        }
        return validSearchTree(root,null,null);
    }

    //一个失败的方案，主要是只考虑了左<跟<右,没有考虑，需要左子树的节点全部小于根节点再小于右子树的全部节点
    /*private static boolean validSearchTree(TreeNode root) {
        if(null == root){
            return true;
        }
        boolean tmpRes = true;
        if(null != root.getLeftNode()){
            tmpRes = root.getVal()>root.getLeftNode().getVal();
        }
        if(null != root.getRightNode()){
            tmpRes = tmpRes && root.getVal()<root.getRightNode().getVal();
        }
        return tmpRes && validSearchTree(root.getLeftNode()) && validSearchTree(root.getRightNode());
    }*/
    //思路，每次向下遍历都需要带着一个界限，比如跟根节点，上下界限为空。跟的左，上界为根，下界为空
    //跟的右节点，上界为空，下界为根
    private static boolean validSearchTree(TreeNode root,Integer low,Integer up) {
        if(null == root){
            return true;
        }
        int val = root.getVal();
        if(null != low && val<low){
            return false;
        }
        if(null != up && val>up){
            return false;
        }
        return validSearchTree(root.getLeftNode(),low,val) && validSearchTree(root.getRightNode(),val,up);
    }
}
