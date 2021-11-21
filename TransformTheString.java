import java.util.Scanner;

/*
    Problem
    You are given a string S which denotes a padlock consisting of lower case English letters.
    You are also given a string F consisting of set of favorite lower case English letters. You are allowed to perform several operations on the padlock.
    In each operation, you can change one letter of the string to the one following it or preceding it in the alphabetical order.
    For example: for the letter c, you are allowed to change it to either b or d in an operation.
    The letters can be considered in a cyclic order, i.e., the preceding letter for letter a would be letter z.
    Similarly, the following letter for letter z would be letter a.

    Your aim is to find the minimum number of operations that are required such that each letter in string S after applying the operations, is present in string F.
 */

public class TransformTheString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 1; t <= T; t++){
            String S = scanner.next();
            String F = scanner.next();
            boolean[] present = new boolean[26];
            for(int i = 0; i < F.length(); i++){
                present[F.charAt(i) - 'a'] = true;
            }
            int count = 0;
            for(int i = 0; i < S.length(); i++){
                int start = S.charAt(i) - 'a';
                int end = start;
                while (!present[start] && !present[end]){
                    start--;
                    end++;
                    if(end == present.length) end = 0;
                    if(start < 0) start = present.length - 1;
                    count++;
                }
            }
            System.out.println("Case #" + t + ": " + count);
        }
    }
}
