package lists;
import exceptionclasses.*;

/**
 * <p>Title: ArrayOrderedList.java</p>
 *
 * <p>Description: Represents an array implementation of an ordered list.</p>
 */
public class ArrayOrderedList<E> extends ArrayList<E> implements OrderedListADT<E>
{
	/**
	 * default constructor -- 
	 * creates an empty list using the default capacity.
	 */
	public ArrayOrderedList()
	{
		super();
	}

	/**
	 * Creates an empty list using the specified capacity.
	 * @param initialCapacity the initial size of the list as specified by the user
	 */
	public ArrayOrderedList (int initialCapacity)
	{
		super(initialCapacity);
	}

	/**
	 * add --
	 * adds the specified Comparable item to this list, keeping
	 * the items in sorted order.
	 * @param newItem a reference to the new item to be added to the list  
	 */
	public void add(E item)
	{
		if(count == contents.length)
			expandCapacity();
		int pos = 0;
		Comparable<E> temp = (Comparable<E>) item;
		while ((pos < count) && (temp.compareTo(contents[pos]) > 0))
				pos++;
		for(int i = count; i > pos; i--)
			contents[i] = contents[i-1];
		contents[pos] = item;
		count++;
	}
	
	/**
	 * find --
	 * overrides the find method in the parent class, ArrayList. This is 
	 * done to improve efficiency when searching an ordererd list.  
	 * @param target a reference to the item to locate
	 * @return the index of the specified target if it is found; -1 if it
	 * is not found
	 */
	@SuppressWarnings("unchecked")
	protected int find(E target)
	{
		Comparable<E> temp = (Comparable<E>) target;
		int pos = 0;
		while((pos < count) && (temp.compareTo(contents[pos]) > 0))
			pos++;
		if(pos == count)
			return -1;
		else if (temp.compareTo(contents[pos]) == 0)
			return pos;
		else 
			return -1;
	}
	
	/**
	 * binSearch --
	 * locates and returns the target from the list if it is found
	 * @param target a reference to an "initialized" item containing a value
	 * for the key-field
	 * @return a reference to the item from the list if found
	 * @throws an EmptyCollection if the list is empty
	 * @throws an ElementNotFoundException if the target is not found
	 */
	@SuppressWarnings("unchecked")
	public E binSearch(E target)
	{
		if(isEmpty())
			throw new EmptyCollectionException("ArrayOrderedList");
		int first = 0;
		int last = count - 1;
		int midpoint = (first + last)/2;
		Comparable<E> temp = (Comparable<E>) target;
		while(first <= last)
		{
			if(temp.compareTo(contents[midpoint]) < 0)
				last = midpoint - 1;
			else if(temp.compareTo(contents[midpoint]) > 0)
				first = midpoint + 1;
			else
				return contents[midpoint];
			midpoint = (first + last)/2;
		}
		throw new ElementNotFoundException("ArrayOrderedList");
	}
	
	/**
	 * removeBefore --
	 * Removes the items whose key field is less than the parameter's key field 
	 * @param target which contains the key field that removeBefore uses 
	 */
	public void removeBefore (E target)
	{
		// Find the index of the target
        int targetIndex = find(target);
        if (targetIndex > 0) {
            // Remove items from list before target
            for (int i = 0; i < targetIndex; i++) 
            {
                this.removeFirst();
            }
        }
	}
}



