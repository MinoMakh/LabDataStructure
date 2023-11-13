public class CLinkedList<T extends Comparable<T>> {

	private Node<T> head;

	public void addAtHead(T data) {

		Node newNode = new Node(data);

		if (head == null) {
			head = newNode;
			newNode.setNext(head);
		} else {
			Node last = head;
			while (last.getNext() != head) {
				last = last.getNext();
			}
			newNode.setNext(head);
			head = newNode;
			last.setNext(head);
		}
	}

	public void traverse() {
		Node<T> current = head;
		if (current != null) {
			do {
				System.out.print(current.getData() + " -> ");
				current = current.getNext();

			} while (current != head);
		} else {
			System.out.println("The list is empty.");
		}
		System.out.println("");
	}

	public Node<T> search(T data) {
		Node<T> current = head;
		if (current != null) {
			do {
				if (current.getData().compareTo(data) == 0) {
					return current;
				} else {
					current = current.getNext();
				}
			} while (current != head);
		}

		return null;
	}

	private Node<T> searchRecursive(T data, Node<T> current) {
		if (current == null) {
			return null;
		} else if (current.getData().compareTo(data) == 0) {
			return current;
		} else {
			if (current.getNext() != head) {
				searchRecursive(data, current.getNext());
			}

		}
		return null;
	}

	public boolean delete(T data) {
		Node<T> current = head;
		Node<T> prev = head;
		do {
			prev = prev.getNext();
		} while (prev.getNext() != head);

		if (current != null) {
			do {
				if (current.getData().compareTo(data) == 0) {

					if (current == head && prev == head) { // The list only has one element.
						head = null;
					}

					else if (current == head) { // The element to delete is the head
						prev.setNext(head.getNext());
						head = head.getNext();

					} else { // Any other case
						prev.setNext(current.getNext());
					}
					return true;
				} else {
					prev = prev.getNext();
					current = current.getNext();
				}
			} while (current != head);
		}
		return false;
	}

	public void sort() {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}
		Node<T> current = head;
		while (current.getNext() != head) {
			Node<T> innerCurrent = current.getNext();
			while (innerCurrent != head) {
				if ((int) current.getData() > (int) innerCurrent.getData()) {

					T temp = innerCurrent.getData();
					innerCurrent.setData(current.getData());
					current.setData(temp);

				}
				innerCurrent = innerCurrent.getNext();
			}
			current = current.getNext();
		}

	}

	public void insertSorted(T data) {
		if (head == null) {
			System.out.println("The list is empty.");
			return;
		}
		Node<T> newNode = new Node<>(data);
		Node<T> current = head;
		Node<T> prev = head;
		do {
			prev = prev.getNext();
		} while (prev.getNext() != head);

		do {
			if ((int) data < (int) current.getData()) {
				if (current == head) { // The element to insert its in the head
					prev.setNext(newNode);
					newNode.setNext(current);
					head = newNode;
					return;
				}

				else { // The element to insert is between two elements
					prev.setNext(newNode);
					newNode.setNext(current);
					return;
				}
			}
			current = current.getNext();
			prev = prev.getNext();

		} while (current != head);

		prev.setNext(newNode); // The element to insert is at last
		newNode.setNext(head);
	}

	public void reverse() {
		Node<T> current = head;
		Node<T> prev = head;
		Node<T> next;

		do {
			prev = prev.getNext();
		} while (prev.getNext() != head);

		do {
			next = current.getNext();
			current.setNext(prev);
			prev = current;
			current = next;
		} while (current != head);
		head = prev;
	}

	public int lenght() {
		int i = 0;
		Node<T> current = head;
		if (head != null) {
			do {
				i++;
				current = current.getNext();
			} while (current != head);
		}
		return i;
	}
}