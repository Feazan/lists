package lists;
import exceptionclasses.*;

/**
 * <p>Title: LinkedUnorderedList.java</p>
 *
 * <p>Description: Represents a linked implementation of an unordered list.</p>
 *
 * @author <Feazan Yaseen, Robenson Sam>
 */
public class LinkedUnorderedList<E> extends LinkedList<E>
         							implements UnorderedListADT<E>
{
	/**
	 * default constructor --
	 * creates an empty list.
	 */
	public LinkedUnorderedList()
	{
		super();
	}

	/**
	 * addToFront -- 
	 * adds the specified item to the front of the list.
	 * @param item a reference to the item to be added
	 */
	public void addToFront (E item)
	{
		contents = new Node<E>(item, contents);
		count++;
	}

	/**
	 * addToRear --
	 * adds a node to the end of the list.
	 * @param item a reference to the item to be added
	 */
	public void addToRear(E item)
	{
		Node<E> current = contents;

		if (isEmpty())
		{
			contents = new Node<E>(item, contents);
		} 
		else
		{
			while(current.getNext() != null)
				current = current.getNext();

			current.setNext(new Node<E>(item));
		}
		count++;
	}

	/**
	 * addAfter --
	 * adds the new item after the specified target.
	 * @param target a reference to the item to be located in the list
	 * @param item a reference to the new item to be added
	 * @throws ElementNotFoundException if the target is not found in the list
	 */
	public void addAfter (E item, E target)
	{
		Node<E> current = contents;
		Node<E> temp = new Node<E>(item);

		if(isEmpty())
		{
			throw new EmptyCollectionException("empty");
		}
		while(!current.getItem().equals(target) && current.getNext() != null)
			current = current.getNext();

		if(current.getNext() == null && !current.getItem().equals(target))
			throw new ElementNotFoundException("not found");

		temp.setNext(current.getNext());
		current.setNext(temp);
	}

}
