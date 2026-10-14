class SpecialQueue {
    Queue<Integer> q = new LinkedList<>();
    Deque<Integer> mn = new ArrayDeque<>(), mx = new ArrayDeque<>();

    public SpecialQueue() {
        // Define Data Structures
    }

    public void enqueue(int x) {
        // Insert element into the queue
        q.offer(x);
        while(!mn.isEmpty() && mn.peekLast()>x)
        {
            mn.pollLast();
        }
        mn.offerLast(x);
        while(!mx.isEmpty() && mx.peekLast()<x)
        {
            mx.pollLast();
        }
        mx.offerLast(x);
    }

    public void dequeue() {
        // Remove element from the queue
        int f = q.poll();
        if(f==mn.peekFirst())
        {
            mn.pollFirst();
        }
        if(f==mx.peekFirst())
        {
            mx.pollFirst();
        }
    }

    public int getFront() {
        // Get front element
        return q.peek();
    }

    public int getMin() {
        // Get minimum element
        return mn.peekFirst();
    }

    public int getMax() {
        // Get maximum element
        return mx.peekFirst();
    }
}
