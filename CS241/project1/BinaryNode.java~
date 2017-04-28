public class BinaryNode<T>
{
    private T data;
    private BinaryNode<T> leftChild;
    private BinaryNode<T> rightChild;    
    
    public BinaryNode()
    {
	this(null);
    }
    
    public BinaryNode(T dataPortion)
    {
	this(dataPortion, null, null);
    }
    
    private BinaryNode(T dataPortion, BinaryNode<T> leftChildNode, BinaryNode<T> rightChildNode)
    {
	data = dataPortion;
	leftChild = leftChildNode;
	rightChild = rightChildNode;
    }
   
    public T getData()
    {
	return data;
    }
    
    public void setData(T dataPortion)
    {
	data = dataPortion;
    }

    public BinaryNode<T> getLeftChild()
    {
	return leftChild;
    }

    public void setLeftChild(BinaryNode<T> leftChildNode)
    {
	leftChild = leftChildNode;
    }

    public BinaryNode<T> getRightChild()
    {
	return rightChild;
    }

    public void setRightChild(BinaryNode<T> rightChildNode)
    {
	rightChild = rightChildNode;
    }

    public boolean hasLeftChild()
    {
	return leftChild != null;
    }

    public boolean hasRightChild()
    {
	return rightChild != null;
    }
 
    public boolean isLeaf()
    {
	return leftChild == null && rightChild == null;
    }
    
  


}