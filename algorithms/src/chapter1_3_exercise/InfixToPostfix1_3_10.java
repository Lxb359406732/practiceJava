package chapter1_3_exercise;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class InfixToPostfix1_3_10
{
    public static void infix2postfix(String s)
    {
        Queue<Character> postfix = new Queue<>();
        Stack<Character> ops = new Stack<>();
        for(int i = 0;i<s.length();i++)
        {
            char item = s.charAt(i);
            if(item == '+' || item == '*') {ops.push(item);}
            else if(item == ')') {postfix.enqueue(ops.pop());}
            else if(item == '(') {}
            else {postfix.enqueue(item);}
        }
        for(char a : postfix) {StdOut.print(a);}
    }
    public static void main(String[] args)
    {
        while (!StdIn.isEmpty())
        {
            String item = StdIn.readString();
            infix2postfix(item);
        }
    }
}
