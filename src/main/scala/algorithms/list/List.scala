package algorithms.list
object List {

  /**
    * https://leetcode.com/problems/rotate-list/
    * @param head
    * @param k
    * @return
    */
  def rotateRight(head: ListNode, k: Int): ListNode = {
    if (head == null || head.next == null && k <= 0) return head
    
    var length = 1
    var end: ListNode = head

    while (end.next != null) {
      end = end.next
      length = length + 1
    }
    end.next = head
    
    var newEnd = head
    
    // avoid k > length
    for (i <- 0 until length - k % length -1 ) newEnd = newEnd.next
    
    val newHead = newEnd.next
    newEnd.next = null
    newHead
  }
  
  
  /**
    * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
    * 1 -> 2 -> [3] -> (4) -> 5 -> 6  n = 3
    * 1 -> 2 -> 3 -> 4 -> 5 n = 3
    * @param head
    * @param n
    * @return
    *
    */
  def removeNthFromEnd(head: ListNode, n: Int): ListNode = {
    var flag = head
    var p = head
    var _n = n

    for (_ <- 1 to n if flag != null) {
      flag = flag.next
      _n = _n - 1
    }

    if (flag == null && _n == 0) return head.next
    else if (flag == null && _n > 0) return head

    while (flag.next != null) {
      flag = flag.next
      p = p.next
    }
    p.next = p.next.next
    
    head
  }
  
  def reverse(head: ListNode): ListNode = {
    var p: ListNode = head
    var q: ListNode = null
    
    while (p != null) {
      val temp = p
      p = p.next
      temp.next = q
      q = temp
    }
  
    q
  }
}