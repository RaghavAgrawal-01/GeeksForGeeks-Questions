class kQueues {
    int[] arr;
    int[] front;
    int[] rear;
    int[] next;
    int free;
    int n, k;

    kQueues(int n, int k) {
        // Initialize your data members
        this.n = n;
        this.k = k;
        arr = new int[n];
        front = new int[k];
        rear = new int[k];
        next = new int[n];

        for(int i = 0; i < k; i++) 
        {
            front[i] = -1;
            rear[i] = -1;
        }

        for(int i = 0; i < n - 1; i++) 
        {
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        free = 0;
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        if(isFull()) 
        {
            return;
        }

        int nextFree = next[free];

        if(isEmpty(i)) 
        {
            front[i] = free;
        } 
        else 
        {
            next[rear[i]] = free;
        }

        next[free] = -1;
        arr[free] = x;
        rear[i] = free;
        free = nextFree;
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        if(isEmpty(i)) 
        {
            return -1;
        }

        int frontIdx = front[i];
        front[i] = next[frontIdx];

        if(front[i] == -1) 
        {
            rear[i] = -1;
        }

        next[frontIdx] = free;
        free = frontIdx;

        return arr[frontIdx];
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        return front[i] == -1;
    }

    boolean isFull() {
        // check if array is full
        return free == -1;
    }
}
