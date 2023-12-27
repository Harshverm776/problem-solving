// HR
// Find Merge Point of Two Lists

// Brute Force

// T = O(m*n);
// S = O(1);
static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
	SinglyLinkedListNode temp;
	while(head1!=null) {
		temp = head2;
		while(temp!=null) {
			if(head1==temp) {
				return head1.data;
			}
			temp = temp.next;
		}
		head1 = head1.next;
	}
	return -1;
}

// LC
// Using HashSet - Iterate one list first and store their references in set. Then iterate second list if node contains in set then return. 

// T = O(m+n);
// S = O(m);
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<ListNode>();
        while(headA!=null) {
          set.add(headA);
          headA = headA.next;
        }
        while(headB!=null) {
            if(set.contains(headB)) {
              return headB;
            }
            headB = headB.next;  
        }
        return null;
    }
}

// Optimal - 1 - Not Recommended - Lengthy
// Approach - based on the difference of both the list -> make the list of same size then compare. (Imaginary)

// T = O(m) + O(m-n) + O(n)= O(2m); [m is the size of largest list]
// S = O(1);
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      int lenA = 0, lenB = 0;
      ListNode p1 = headA, p2 = headB;
      // Find the length of both lists.
      while(p1!=null || p2!=null){
        if(p1!=null){
          lenA++;
          p1=p1.next;
        }
        if(p2!=null){
          lenB++;
          p2=p2.next;
        }
      }

      // Find the different, based on it - make the respective pointer ahead by same difference. So, that we can start comparing the list at same length.
      int diff = lenA - lenB;
      boolean forA = diff>=0 ? true : false; // pointing out the list for which we need to move by the difference.
      p1 = headA;
      p2 = headB;
      diff = Math.abs(diff);
      
	  while(diff>0){
        if(forA)
          p1 = p1.next;
        else
          p2 = p2.next;
        diff--;
      }
      
	  // Start comparing
      while(p1!=null) {
        if(p1==p2){
          return p1;
        }
        p1=p1.next;
        p2=p2.next;
      }
      return null;
    }
}
// Optimal - 2
// Approach - Take help of size/length
// Start iterating until the pointer reaches null, then point it to another head.
// Once another pointer reaches null, then both the pointers will be at same distance.
// Therefore, once they are equal then we got the merge.

// T = O(m+n);
// S = O(1);
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
      if(headA == null || headB==null){
        return null;
      }
      ListNode p1=headA, p2=headB;
	  // The pointers will be equal to each other when
	  // They reach the merged or both points to null(Reached the end)
      while(p1!=p2) {
		// if it is null then point it to another head (similar with p2)
        p1 = p1==null ? headB : p1.next;
        p2 = p2==null ? headA : p2.next;
      }
      return p1;
    }
}

// More readable version
static Node intersectPoint(Node head1, Node head2)
{
    Node ptr1 = head1;
    Node ptr2 = head2;
    if (ptr1 == null || ptr2 == null) {
        return null;
    }
    while (ptr1 != ptr2) {
        ptr1 = ptr1.next;
        ptr2 = ptr2.next;
        if (ptr1 == ptr2) {
            return ptr1;
        }
        if (ptr1 == null) {
            ptr1 = head2;
        }
        if (ptr2 == null) {
            ptr2 = head1;
        }
    }
    return ptr1;
}
