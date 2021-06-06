import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;

//Singleton Class
public class ThreadPool {
    private static ThreadPool instance = null;

    private BlockingQueue queue;
    private Thread[] threads;

    public static ThreadPool ThreadPoolCreate() {

        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    private ThreadPool() {
        queue = new ArrayBlockingQueue(5);

    }

    public void execute(final Runnable task) {
        queue.add(task);
    }

    public void shutdown() {

    }
}
