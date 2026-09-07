/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node curr = head;

        // initialise the hashMap
        Map<Node, Node> map = new HashMap<>();
        while (curr != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        // connect the links
        for (Node l : map.keySet()) {
            map.get(l).next = map.get(l.next);
            map.get(l).random = map.get(l.random);
        }

        return map.get(head);
    }
}

/*
iterate through the linked list two times
    once to initialise all the nodes
    second to connect all the random nodes
*/