
import java.util.Vector;

/**
 * Clase vector heap como cola de prioridad con elementos genéricos comparables
 * @author javi-
 * @param <E>
 */
public class VectorHeap<E extends Comparable<E>> implements PriorityQueue<E>
{
    
	protected Vector<E> data; // the data, kept in heap order

    /**
     * Constructor vacío
     */
    public VectorHeap()
	// post: constructs a new priority queue
	{
		data = new Vector<E>();
	}

    /**
     * Constructor a partir de un vector
     * @param v el vector de la cola existente
     */
    public VectorHeap(Vector<E> v)
	// post: constructs a new priority queue from an unordered vector
	{
		int i;
		data = new Vector<E>(v.size()); // we know ultimate size
		for (i = 0; i < v.size(); i++)
		{ // add elements to heap
			add(v.get(i));
		}
	}
    
    /**
     * parent devuelve el nodo padre del nodo i
     * @param i
     * @return nodo padre del nodo i
     */
    protected static int parent(int i)
	// pre: 0 <= i < size
	// post: returns parent of node at location i
	{
		return (i-1)/2;
	}

    /**
     * left devuelve el nodo izquierdo del nodo i
     * @param i
     * @return nodo izquierdo del nodo i
     */
    protected static int left(int i)
	// pre: 0 <= i < size
	// post: returns index of left child of node at location i
	{
		return 2*i+1;
	}

    /**
     * right devuelve el nodo derecho del nodo i
     * @param i
     * @return nodo derecho del nodo i
     */
    protected static int right(int i)
	// pre: 0 <= i < size
	// post: returns index of right child of node at location i
	{
		return (2*i+1) + 1;
	}

    /**
     * mueve la hoja leaf hasta dejarla ordenada
     * @param leaf la hoja a ordenar
     */
    protected void percolateUp(int leaf)
	// pre: 0 <= leaf < size
	// post: moves node at index leaf up to appropriate position
	{
		int parent = parent(leaf);
		E value = data.get(leaf);
		while (leaf > 0 &&
		(value.compareTo(data.get(parent)) < 0))
		{
			data.set(leaf,data.get(parent));
			leaf = parent;
			parent = parent(leaf);
		}
		data.set(leaf,value);
	}

    /**
     * agrega un nuevo nodo a la cola de prioridad, inicia como hoja y lo ordena con percolateUp
     * @param value el valor del nuevo nodo
     */
    @Override
	public void add(E value)
	// pre: value is non-null comparable
	// post: value is added to priority queue
	{
		data.add(value);
		percolateUp(data.size()-1);
	}

    /**
     * mueve la raíz del árbol hacia abajo hasta dejarla ordenada
     * @param root la raíz del árbol
     */
    protected void pushDownRoot(int root)
	// pre: 0 <= root < size
	// post: moves node at index root down
	// to appropriate position in subtree
	{
		int heapSize = data.size();
		E value = data.get(root);
		while (root < heapSize) {
			int childpos = left(root);
			if (childpos < heapSize)
			{
				if ((right(root) < heapSize) &&
				((data.get(childpos+1)).compareTo
				(data.get(childpos)) < 0))
				{
					childpos++;
				}
			// Assert: childpos indexes smaller of two children
			if ((data.get(childpos)).compareTo
				(value) < 0)
			{
				data.set(root,data.get(childpos));
				root = childpos; // keep moving down
			} else { // found right location
				data.set(root,value);
				return;
			}
			} else { // at a leaf! insert and halt
				data.set(root,value);
				return;
			}
		}
	}

        @Override
        public int size(){
            return data.size();
        }
        
        @Override
        public boolean isEmpty(){
            return data.isEmpty();
        }
        @Override
        public void clear(){
            data.clear();
        }
        
    /**
     * devuelve el primer elemento en cola sin eliminarlo
     * @return el primer elemento en cola
     */
    @Override
        public E getFirst(){
            if(!this.isEmpty())
                return data.firstElement();
            else return null;
        }

    /**
     * devuelve el primer elemento en cola y lo elimina
     * @return el primer elemento en cola
     */
    @Override
	public E remove()
	// pre: !isEmpty()
	// post: returns and removes minimum value from queue
	{
		E minVal = getFirst();
		data.set(0,data.get(data.size()-1));
		data.setSize(data.size()-1);
		if (data.size() > 1) pushDownRoot(0);
		return minVal;
	}
}

