package code.lowleveldesign.LRU;

import java.util.Stack;

class SpacialStack{
    Stack<Integer> minStack;
    public SpacialStack(){
       minStack  = new Stack<>();
    }
    //static Stack<Integer> minStack = new Stack<>();
    public void push(int a, Stack<Integer> s)
    {
        s.push(a);
        if(minStack.isEmpty() || this.minStack.peek() > a)
            minStack.push(a);
    }
    public int pop(Stack<Integer> s)
    {
        int val = s.pop();
        if(val == minStack.peek())
            minStack.pop();
       return  val;
    }
    public int min(Stack<Integer> s)
    {
        return minStack.peek();
    }
    public boolean isFull(Stack<Integer>s, int n)
    {
        return s.size() == n;
    }
    public boolean isEmpty(Stack<Integer> s)
    {
        return s.isEmpty();
    }
}
