package lists;
import javax.swing.text.AbstractDocument.Content;
import exceptionclasses.*;

/**
 * <p>Title: LinkedList.java</p>
 *
 * <p>Description: Represents a linked implementation of a list. The front of
 * the list is referenced by contents. This class will be extended
 * to create a specific kind of list.</p>
 *
 * @author Feazan Yaseen, Robenson Sam 
 */
public class LinkedList<E> implements ListADT<E>
{
	protected int count;
	protected Node<E> contents;

	/**
	 * default constructor --
	 * Creates an empty list.
	 */
	public LinkedList()
	{
		count = 0;
		contents = null;
	}

	/**
	 * removeLast -- 
	 * removes and returns the last item in the list.
	 * @return the item removed from the end of the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	//THIS METHOD DOES NOT WORK AS EXPECTED
	public E removeLast()
	{
		if (isEmpty())
			throw new EmptyCollectionException("LinkedList");

		Node<E> temp = contents;
		Node<E> current = contents;  
		Node<E> prev = null;		

		while (current.getNext() != null) 
		{
			prev = current; 
			current = current.getNext();
		} 
		prev.setNext(null); 

		count--;
		return temp.getItem();

	}

	/**
	 * removeFirst -- 
	 * removes and returns the first item in the list.
	 * @return a reference to what was the first item in the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public E removeFirst() throws EmptyCollectionException
	{
		return null;
	}

	/**
	 * remove --
	 * locates and removes the target from the list.
	 * @param target a reference to an initialized item containing data 
	 * in its key-field
	 * @return a reference to the removed item
	 * @throws ElementNotFoundException if the target is not found
	 */
	//THIS METHOD DOES NOT WORK AS EXPECTED
	public E remove (E target)
	{
		if (isEmpty())
			throw new ElementNotFoundException("LinkedList");

		Node<E> current = contents;
		Node<E> prev = null;
		boolean found = false;

		while (!found && current != null)
		{
			if (current.getItem().equals(target))
				found = true;
			prev = current;
			current = current.getNext();
		}

		if (!found)
			throw new ElementNotFoundException("LinkedList");
		else
		{
			prev.setNext(current.getNext());
			count--;
		}

		return current.getItem();
	}


	/**
	 * first --
	 * returns a reference to the item at the front of the list. The item
	 * is not removed from the list.
	 * @return a reference to the first item in the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public E first() throws EmptyCollectionException
	{
		if (isEmpty())
			throw new EmptyCollectionException ("list");

		return contents.getItem();
	}

	/**
	 * last -- 
	 * returns a reference to the item at the end of the list. The item
	 * is not removed from the list.
	 * @return a reference to the last item in the list
	 * @throws EmptyCollectionException if the list is empty
	 */
	public E last() throws EmptyCollectionException
	{
		Node<E> current = contents;
		if (current == null)
			throw new EmptyCollectionException("LinkedList");

		while (current.getNext() != null)
			current = current.getNext();

		return current.getItem();
	}

	/**
	 * contains --
	 * returns true if the list contains the specified target.
	 * @param target a reference to the item to be located
	 * @return true if the target is found; false otherwise
	 */
	public boolean contains (E target)
	{
		boolean found = false;

		Node<E> current = contents;

		while (current != null && !found)
		{
			if (target.equals (current.getItem()))
				found = true;
			else
				current = current.getNext();
		}

		return found;
	}

	/**
	 * isEmpty --
	 * determines whether or not the list is empty.
	 * @return true if this list is empty; false otherwise
	 */
	public boolean isEmpty()
	{
		return (count == 0);
	}

	/**
	 * size --
	 * returns a count of the number of items in the list.
	 * @return the number of items currently in the list
	 */
	public int size()
	{
		return count;
	}

	/**
	 * toString --
	 * returns a string representation of the list.
	 * @return a reference to a String containing the items in the list
	 */
	public String toString()
	{
		Node<E> current = contents;
		String result = new String();

		while (current != null)
		{
			result = result + current.getItem().toString() + "\n";
			current = current.getNext();
		}

		return result;
	}

}
