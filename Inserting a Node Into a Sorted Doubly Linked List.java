// HR
// Inserting a Node Into a Sorted Doubly Linked List

// Brute Force

// T = O(n);
// S = O(1);
public static DoublyLinkedListNode sortedInsert(DoublyLinkedListNode llist, int data) {
// Write your code here
	// If list is empty
	if(llist == null) {
		return new DoublyLinkedListNode(data);
	}
	
	// Insertion at start
	if(llist.data > data) {
		DoublyLinkedListNode node = new DoublyLinkedListNode(data);
		node.next = llist;
		llist.prev = node;
		return node;
	}
	
	DoublyLinkedListNode head = llist;
	while(llist!=null) {
		// Insertion in middle
		if(llist.data >= data) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(data);
			llist.prev.next = node;
			node.prev = llist.prev;
			node.next = llist;
			llist.prev = node;
			break;
		}
		// Insertion at end
		if(llist.next == null) {
			DoublyLinkedListNode node = new DoublyLinkedListNode(data);
			llist.next = node;
			node.prev = llist;
			break;
		}
		llist = llist.next;
	}
	return head;
}
