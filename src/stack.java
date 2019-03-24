


//Written by Thomas Kocar
import java.util.Arrays;

public class stack {
    protected int top;
    protected Object stack[];

    /**
     * Constructor -- size indicates the size of stack that is allocated.
     * Once completed the stack has been allocated and is empty.
     *
     * @param size The size of stack to allocate for this object.
     */
    public stack(int size) {
        stack = new Object[size];
        top = -1;
    }

    /**
     * Default constructor.  Uses a default size of 10 for the stack.
     */
    public stack() {
        // TODO Auto-generated constructor stub
        this(100);

    }

    /* (non-Javadoc)
     * @see StackInterface#pop()
     */

    public void pop() throws stackunderflowexception {
        if (isEmpty()) {
            throw new stackunderflowexception("User tried to pop an empty stack.");
        }
        stack[top] = null;
        top--;
    }

    public Object get(int free) {
        return String.valueOf(this.stack[free]);
    }

    /* (non-Javadoc)
     * @see StackInterface#top()
     */

    public Object top() throws stackunderflowexception {
        // TODO Auto-generated method stub
        if (isEmpty()) {
            throw new stackunderflowexception("User tried to examine the top of an empty stack.");
        }

        return stack[top];
    }

    /* (non-Javadoc)
     * @see StackInterface#push(java.lang.Object)
     */
    public void push(Object element) throws stackoverflowexception {
        // TODO Auto-generated method stub
        if (isFull()) {
            throw new stackoverflowexception("User tried to push an element onto a full stack.");
        }
        top++;
        stack[top] = element;
        return;
    }

    /* (non-Javadoc)
     * @see StackInterface#isFull()
     */

    public boolean isFull() {
        // TODO Auto-generated method stub
        if (top == stack.length - 1) {
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see StackInterface#isEmpty()
     */

    public boolean isEmpty() {
        // TODO Auto-generated method stub
        if (top == -1) {
            return true;
        }
        return false;
    }

    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "ArrayStack [top=" + top + ", " + (stack != null ? "stack=" + Arrays.toString(stack) : "") + "]";
    }
}

