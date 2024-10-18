package Search;

public class BiTree {
    public Node Root;
    
    public BiTree()
    {
    }

    public void Insert(Node node)
    {
        Node p = Root;
        Node x = Root;
        while (x != null) 
        {
            p = x;
            if(x.Key > node.Key)
            {
                x = x.Left;
            }
            else
            {
                x = x.Right;
            }
        }

        if(p == null)
        {
            Root = node;
        }
        else if(p.Key > node.Key)
        {
            p.Left = node;
        }
        else
        {
            p.Right = node;
        }
    }

    public void InorderWark(Node node)
    {
        if(node != null)
        {
            InorderWark(node.Left);
            System.err.print(" " + node.Key);
            InorderWark(node.Right);
        }
    }

    public Node Minimum()
    {
        Node x = Root;
        while (x.Left != null) 
        {
          x = x.Left;   
        }
        return x;
    }

    public Node Maximum()
    {
        Node x = Root;
        while(x.Right != null)
        {
            x = x.Right;
        }
        return x;
    }

}
