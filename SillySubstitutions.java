import java.util.Scanner;

/*
    Problem
    You are given a string S of length N which consists of digits 0-9. You do the following operations on the string in the order given.

        Find all the substrings 01 and replace each of them with 2.
        Find all the substrings 12 and replace each of them with 3.
        Find all the substrings 23 and replace each of them with 4.
        Find all the substrings 34 and replace each of them with 5.
                                    .
                                    .
                                    .
        Find all the substrings 89 and replace each of them with 0.
        Find all the substrings 90 and replace each of them with 1.

    You repeat this process in the same given order until none of the above operations change the string.
    For example, if S is 12 then we do not stop at operation 1 since it does not affect the string but perform operation 2 and change the string to 3.
    We can see that the string does not change further no matter how many times we repeat the above process.

    Your task is to find how the final string will look like for the given S.
 */

public class SillySubstitutions {
    static class LinkedList {
        Node head;
        public LinkedList() {
            head = new Node();
        }
        public void translate(String s){
            Node temp = head;
            for(int i = 0; i < s.length(); i++){
                temp.next = new Node(s.charAt(i));
                temp = temp.next;
            }
        }
        public boolean findAndReplace(char first, char second, char replace){
            Node temp = head;
            boolean flag = false;
            while (temp != null && temp.next != null && temp.next.next != null){
                if (temp.next.c == first && temp.next.next.c == second) {
                    temp.next.next.c = replace;
                    temp.next = temp.next.next;
                    flag = true;
                }
                else {
                    temp = temp.next;
                }
            }
            return flag;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Node temp = head.next;
            while (temp!=null){
                sb.append(temp.c);
                temp = temp.next;
            }
            return sb.toString();
        }

        class Node {
            char c;
            Node next;
            public Node(){}
            public Node(char c){
                this.c = c;
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 1; t <= T; t++) {
            int N = scanner.nextInt();
            String S = scanner.next();
            LinkedList list = new LinkedList();
            list.translate(S);
            boolean flag = true;
            while (flag) {
                flag = false;
                char first = '0';
                char second = '1';
                char replace = '2';
                do {
                    boolean store = list.findAndReplace(first, second, replace);
                    flag = flag || store;
                    first++;
                    if (second == '9') second = '0';
                    else second++;
                    if (replace == '9') replace = '0';
                    else replace++;

                } while (second != '1');

            }
            System.out.println("Case #" + t + ": " + list);
        }
    }
}