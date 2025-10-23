public class BT<T>
{
    int size;
    BTNode<T> root = null;

    BT()
    {
        root = null;
        size = 0;
    }

    BT(T data)
    {
        this(new BTNode(data));
    }

    BT(BTNode<T> root)
    {
        this.root = root;
        size = 1;
    }

    BT(BTNode<T> root, BT<T> Lsubtree, BT<T> Rsubtree)
    {
        this.root = root;
        root.left = Lsubtree.root;
        root.right = Rsubtree.root;
        size = Lsubtree.size + Rsubtree.size + 1;
    }

    int findHeight()
    {
        return findHeight(root);
    }

    int findHeight(BTNode<T> root)
    {
        if (root == null)
            return 0;
        else if (isLeaf(root))
            return 1;
        else
        {
            int lheight = findHeight(root.left);
            int rheight = findHeight(root.right);
            if (lheight >= rheight)
                return 1 + lheight;
            else
                return 1 + rheight;
        }

    }

    boolean isLeaf(BTNode<T> root)
    {
        if (root != null && root.left == null && root.right == null)
            return true;
        else
            return false;
    }

    boolean isBalanced()
    {
        return isBalanced(root);
    }

    boolean isBalanced(BTNode<T> root)
    {
        if (root == null)
            return true;
        int LH = findHeight(root.left);
        int RH = findHeight(root.right);
        int B = Math.abs(LH - RH);
        if (B <= 1)
            return (isBalanced(root.left) && isBalanced(root.right));
        else
            return false;
    }

    /* Inorder traversal from the root */
    public void inorder()
    {
        inorder(root);
    }

    /* Inorder traversal from a subtree */
    protected void inorder(BTNode<T> root)
    {
        if (root == null)
        {
            return;
        }
        inorder(root.left);
        System.out.print(root.element + " ");
        inorder(root.right);
    }

    /* Postorder traversal from the root */
    public void postorder()
    {
        postorder(root);
    }

    /* Postorder traversal from a subtree */
    protected void postorder(BTNode<T> root)
    {
        if (root == null)
        {
            return;
        }
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.element + " ");
    }

    /* Preorder traversal from the root */
    public void preorder()
    {
        preorder(root);
    }

    /* Preorder traversal from a subtree */
    protected void preorder(BTNode<T> root)
    {
        if (root == null)
        {
            return;
        }
        System.out.print(root.element + " ");
        preorder(root.left);
        preorder(root.right);
    }

    void PrintBFT()
    {
        Queue<BTNode<T>> Q = new Queue<BTNode<T>>();
        BTNode<T> tmp;
        Q.enqueue(root);
        while (!Q.isEmpty())
        {
            tmp = Q.dequeue();
            if (tmp.left != null)
                Q.enqueue(tmp.left);
            if (tmp.right != null)
                Q.enqueue(tmp.right);
            System.out.print(tmp.element + " ");
        }
    }

    void PrintDFT()
    {
        Stack<BTNode<T>> S = new Stack<BTNode<T>>();
        BTNode<T> tmp;
        S.push(root);
        while (!S.isEmpty())
        {
            tmp = S.pop();
            if (tmp.right != null)
                S.push(tmp.right);
            if (tmp.left != null)
                S.push(tmp.left);
            System.out.print(tmp.element + " ");
        }
    }

    public int getSize()
    {
        return size;
    }

    public BTNode<T> getRoot()
    {
        return root;
    }
}