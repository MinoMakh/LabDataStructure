
public class Driver {

	public static void main(String[] args) {
		CLinkedList<Integer> list = new CLinkedList<>();

		list.addAtHead(5);
		list.addAtHead(70);
		list.addAtHead(77);
		list.addAtHead(72);
		list.traverse();
		list.sort();
		System.out.println("Sorted:");
		list.traverse();
		list.insertSorted(75);
		list.traverse();
		
		list.reverse();
		System.out.println("Reverse:");
		list.traverse();

	}

}
