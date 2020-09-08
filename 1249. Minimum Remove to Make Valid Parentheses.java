class Solution {
    private class E {
        char c;
        int pos;
        public E(char c, int pos) {
            this.c = c;
            this.pos = pos;
        }
    }
    
    public String minRemoveToMakeValid(String s) {
      StringBuilder result = new StringBuilder(s);
        
      Stack<E> stack = new Stack();
      for (int i = 0; i < result.length(); ++i) {
        if (result.charAt(i) == '(') {
            stack.push(new E('(', i));
        }
        if (result.charAt(i) == ')') {
          if (!stack.empty() && stack.peek().c == '(') stack.pop();
          else stack.push(new E(')', i));
        }
      }
      while (!stack.empty())
        result.deleteCharAt(Math.abs(stack.pop().pos));
      return result.toString();
    }
}
