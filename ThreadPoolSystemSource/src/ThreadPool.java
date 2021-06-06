import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

//Singleton Class
public class ThreadPool {
    private static ThreadPool instance = null;
    // holds tasks
    private BlockingQueue<Runnable> runnableQueue;

    // holds the pool of worker threads
    private List<Thread> threads;

    // check if shutdown is initiated
    protected AtomicBoolean isThreadPoolShutDownInitiated;


    public static ThreadPool ThreadPoolCreate() {

        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    private ThreadPool() {
        this.runnableQueue = new LinkedBlockingQueue<>();
        // this.threads = new ArrayList<>(noOfThreads);
        this.isThreadPoolShutDownInitiated = new AtomicBoolean(false);
        // create worker threads
        /*for (int i = 1; i <= noOfThreads; i++) {
            WorkerThread thread = new WorkerThread(runnableQueue, this);
            thread.setName("Worker Thread - " + i);
            thread.start();
            threads.add(thread);
        }*/
    }

    public void execute(Runnable r) throws InterruptedException {
        if (!isThreadPoolShutDownInitiated.get()) {
            runnableQueue.put(r);
        } else {
            throw new InterruptedException("Thread Pool shutdown is initiated, unable to execute task");
        }
    }

    public void shutdown() {
        isThreadPoolShutDownInitiated = new AtomicBoolean(true);
    }
}

class ThreadPoolException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThreadPoolException(Throwable t) {
        super(t);
    }
}