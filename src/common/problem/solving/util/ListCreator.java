package common.problem.solving.util;

import java.util.*;
import java.util.function.Consumer;

public class ListCreator {
    
    private ListCreator() {
        throw new UnsupportedOperationException("This class not for instance creation");
    }
    
    public static class Node {
        public int value;
        public Node next;
        public Node random;
        
        public Node(int value) {
            this.value = value;
        }
    }
    
    public static Node createList(int[] nums) {
        var head = new Node(nums[0]);
        var curr = head;
        for (int i = 1; i < nums.length; ++i) {
            curr.next = new Node(nums[i]);
            curr = curr.next;
        }
        return head;
    } 
    
    public static Node createRandomPointerList(Integer[][] input) {
        var head = createList(Arrays.stream(input).mapToInt(ints -> ints[0]).toArray());
        var list = toList(head);
        var curr = head;
        for (var ints : input) {
            if (ints[1] != null) {
                curr.random = list.get(ints[1]);
            }
            curr = curr.next;
        }
        return head;
    }
    
    public static List<Node> toList(Node head) {
        List<Node> nodes = new ArrayList<>();
        forEach(head, nodes::add);
        return nodes;
    }
    
    public static void printList(Node head) {
        forEach(head, node -> {
            System.out.println("Node:");
            System.out.println("  value  => " + node.value);
            System.out.println("  this   => " + node);
            System.out.println("  next   => " + node.next);
            System.out.println("  random => " + node.random);
        });
    }
    
    public static void forEach(Node head, Consumer<Node> action) {
        while (head != null) {
            action.accept(head);
            head = head.next;
        }
    }
}
