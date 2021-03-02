package chapter1_3_exercise;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;

import java.util.Scanner;

public class Parentheses1_3_4
{
    public static boolean isBalanced()
    {
        Stack<Character> s = new Stack<>();
        while (!StdIn.isEmpty())
        {
            char item = StdIn.readChar();
            if (item == '(' || item == '[' || item == '{') {s.push(item);}
            if (item == ')') {if(s.pop() != '(') {return false;}}
            else if (item == ']') {if(s.pop() != '[') {return false;}}
            else if (item == '}') {if(s.pop() != '{') {return false;}}

        }
        return true;
    }
    public static void main(String[] args)
    {
        System.out.println(isBalanced());
    }
}
