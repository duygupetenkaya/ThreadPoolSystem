import java.util.ArrayList;
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
        this.threads = createThreadPoolThreads();
        this.isThreadPoolShutDownInitiated = new AtomicBoolean(false);

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).start();
        }
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
    public List<Thread> createThreadPoolThreads() {
        List<Thread> threads = new ArrayList<>();

        threads.add(new HThread(runnableQueue, this));
        threads.add(new HThread(runnableQueue, this));
        threads.add(new LThread(runnableQueue, this));
        threads.add(new LThread(runnableQueue, this));

        return threads;
    }
}

class ThreadPoolException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThreadPoolException(Throwable t) {
        super(t);
    }
}