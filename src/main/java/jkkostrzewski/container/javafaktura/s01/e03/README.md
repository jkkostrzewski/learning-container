Thread
-
- A single path of execution within a program (process)
- Thread contains program counter (a pointer to the instruction that
is currently executing), and a stack of frames (in Java every frame
contains next nested method calls)
- Frame contains local variables, and a reference to return value
- Creating new thread:
    - new Thread(Runnable)
    - ~~Extend Thread class and override run()~~ - Not preferred (can't extend
    more than one class)
- Useful methods: 
    - start - running thread operations
    - thread properties
        - setName (setting name will improve debugging capabilities)
        - setDaemon (main thread will not wait for daemon threads)
        - setPriority (higher priority threads will be executed first by processor -
        in case there are two threads with the same priority - FIFO ordering is followed)
        - setUncaughtExceptionHandler - implementing interface that runs in case
        thread throws an exception while executing operations (if this interface is not 
        implemented the exceptions from the threads will be ignored)
    - join - block further execution of the code that uses this function until
    all the threads joined stop their execution
    - static currentThread - we can see what thread is currently executing
    - ~~static sleep~~ - stopping thread from executing code for a certain amount of
    time - we shouldn't use this in production code
- Creating thread safe methods:
    - synchronized - Java makes sure only one thread can enter this 
    method at the same time (it's a costly operation - the process of suspending
    and then resuming a thread is very expensive)
    - Atomic variables - special classes that use low-level atomic machine 
    instructions such as compare-and-swap (CAS) to ensure data integrity - 
    The CAS operation updates atomically the value M to B, but only if the 
    existing value in M matches A, otherwise no action is taken.
- Other thread mechanisms
    - Semaphore - one thread notifies other threads about an event that occurred
    - Mutex(Mutual exclusion) - Token that only one of the threads has at one point
    and it can use it to enter critical code block. When it exits this  block it gives
     this token to the next thread.
    - Barrier - Mechanism of blocking threads until a certain amount of threads reach
    this barrier
    - Latch - Similar block to Barrier except we don't count threads but
    wait for certain events to occur
    
ExecutorService
-
- Framework that simplifies the execution of tasks in asynchronous mode
- Automatically provides a pool of threads and API for assigning tasks to it
