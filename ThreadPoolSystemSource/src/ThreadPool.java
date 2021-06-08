import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;

//Singleton Class
public class ThreadPool {
    private static ThreadPool instance = null;
    // holds the pool of worker threads
    private List<Thread> threads;
    // check if shutdown is initiated
    protected AtomicBoolean isThreadPoolShutDownInitiated;

    public static ThreadPool ThreadPoolCreate() throws InterruptedException {
        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    private ThreadPool() throws InterruptedException {
        this.threads = createThreadPoolThreads();
        this.isThreadPoolShutDownInitiated = new AtomicBoolean(false);

    }

    public void execute() throws InterruptedException {
        if (!isThreadPoolShutDownInitiated.get()) {

        } else {
            throw new InterruptedException("Thread Pool shutdown is initiated, unable to execute task");
        }
    }

    public void shutdown() {
        isThreadPoolShutDownInitiated = new AtomicBoolean(true);
    }

    public List<Thread> createThreadPoolThreads() {
        List<Thread> threads = new ArrayList<>();
        threads.add(new HThread( this));
        threads.add(new HThread( this));
        threads.add(new LThread( this));
        threads.add(new LThread( this));
        return threads;
    }
}

class ThreadPoolException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public ThreadPoolException(Throwable t) {
        super(t);
    }
}