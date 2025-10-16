package s6722781059_Lab05;

public class BTNode<T>
{
	T element;
	BTNode<T> left = null;
	BTNode<T> right = null;

	public BTNode(T e)
	{
		element = e;
	}
}