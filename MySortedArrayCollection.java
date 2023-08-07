package Program3;

import java.util.ArrayList;

public class MySortedArrayCollection<T> extends SortedArrayCollection<T>
		implements MySortedArrayCollectionInterface<T> {

	public MySortedArrayCollection() {
		super();
	}

	public MySortedArrayCollection(int capacity) {
		super(capacity);
	}

	public String toString() {
		String tempString = "";
		tempString += "Size: " + this.numElements;
		tempString += "\nisEmpty(): " + this.isEmpty();
		tempString += "\nisFull(): " + this.isFull();
		tempString += "\nSmallest(): " + this.smallest();
		for (int i = 0; i < this.numElements; i++) {
			tempString += "\nElement[" + i + "] " + this.elements[i];
		}
		return tempString + "\n";
	}

	public T smallest() {
		if (this.isEmpty())
			return null;
		return this.elements[0];
	}

	public int greater(T element) {
		this.contains(element);
		return this.numElements - (this.location + 1);
	}

	public MySortedArrayCollection<T> combine(MySortedArrayCollection<T> other) {
		MySortedArrayCollection<T> tempCollection = new MySortedArrayCollection<T>(
				this.numElements + other.numElements);
		for (int i = 0; i < this.numElements; i++) {
			tempCollection.add(this.elements[i]);
		}
		for (int i = 0; i < other.numElements; i++) {
			tempCollection.add(other.elements[i]);
		}
		return tempCollection;
	}

	public T[] toArray() {
		T[] array = (T[]) new Object[this.size()];
		for (int i = 0; i < this.size(); i++)
			array[i] = elements[i];
		return array;
	}

	public void clear() {
		for (int i = 0; i < this.numElements; i++) {
			this.elements[i] = null;
		}
		this.numElements = 0;
	}

	public boolean equals(Object obj) {
		return obj.equals(this.getClass());
	}

	public boolean addAll(MySortedArrayCollection<T> other) {
		for (int i = 0; i < other.numElements; i++) {
			this.add(other.elements[i]);
		}
		return true;
	}

	public boolean retainAll(MySortedArrayCollection<T> retain) {
		T[] tempArray = (T[]) new Object[retain.numElements];
		int k = 0;
		for (int i = 0; i < retain.numElements; i++) {
			if (this.contains(retain.elements[i])) {
				tempArray[k++] = retain.elements[i];
			}
		}

		for (int i = 0; i < this.numElements; i++) {
			this.elements[i] = null;
		}
		this.numElements = 0;
		for (int i = 0; i < tempArray.length; i++) {
			this.elements[i] = tempArray[i];
			if (tempArray[i] != null) {
				this.numElements++;
			}
		}
		return true;
	}

	public void removeAll(MySortedArrayCollection<T> remove) {
		for (int i = 0; i < remove.numElements; i++) {
			this.contains(remove.elements[i]);
			if (super.elements[this.location].equals(remove.elements[i])) {
				for (int j = this.location; j < this.numElements; j++) {
					super.elements[j] = this.elements[j + 1];
				}
				this.elements[super.numElements] = null;
				this.numElements--;
			}

		}
	}
}
