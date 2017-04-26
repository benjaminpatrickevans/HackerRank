/*
Detect a cycle in a linked list. Note that the head pointer may be 'null' if the list is empty.

A Node is defined as: 
    class Node {
        int data;
        Node next;
    }
*/

boolean hasCycle(Node head) {
    return hasCycle(head, new HashSet<Node>());
}

boolean hasCycle(Node head, Set<Node> visited){
    if(head == null) return false;
    if(visited.contains(head)) return true;
    visited.add(head);
    return hasCycle(head.next, visited);
}

