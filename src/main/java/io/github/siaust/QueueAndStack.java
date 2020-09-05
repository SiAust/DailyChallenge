package io.github.siaust;

import java.util.*;

public class QueueAndStack {

    public static void main(String[] args) {
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put(')', '(');
        pairs.put(']', '[');
        pairs.put('}', '{');

        char[] input = new Scanner(System.in).nextLine().toCharArray();

        Deque<Character> bracketQ = new ArrayDeque<>();

        boolean isBalanced = true;

        for (Character c : input) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    bracketQ.add(c);
                    break;
                case ')':
                case ']':
                case '}':
                    if (bracketQ.peek() == null) {
                        isBalanced = false;
                        break;
                    }
                    System.out.println(bracketQ.peekLast() + " " + pairs.get(c));
                    if (bracketQ.pollLast() != pairs.get(c)) {
                        isBalanced = false;
                        break;
                    }
            }
        }
        if (bracketQ.size() > 0) {
            isBalanced = false;
        }
        System.out.println(isBalanced);
    }
}

/*You're dealing with a string consisting of brackets. Write a program to examine whether the pairs of
"{", "}", "(", ")", "[", "]" are correct or balanced. This means that each opening bracket must have a corresponding
closing one (and vice versa) and they must go in the correct order.

For example, the program should print true for the string [()]{}{[()()]()} and false for ()[]}.

The classic algorithm for solving this problem relies on using a stack.

1. create an instance of a stack;
2. traverse the input string;
    2.1 if the current character is a starting bracket "(" or "{" or "[" then push it to the stack;
    2.2 if the current is a closing bracket ")" or "}" or "]" then remove (pop) the top element from the stack.
    If the popped bracket does not match the starting bracket then parentheses are not balanced;
3. if there are some starting brackets left in the stack after completing traversal,
then the parentheses are not balanced

Sample Input 1:

([][])
Sample Output 1:

true
Sample Input 2:

([](){([])})
Sample Output 2:

true
Sample Input 3:

{{[()]]
Sample Output 3:

false */