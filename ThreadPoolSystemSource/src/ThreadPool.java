import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

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
        queue = new ArrayBlockingQueue(512);

    }

    public void execute(final Runnable task) {
        queue.add(task);
    }

    public void shutdownImmediately() {
        for (int i = 0; i < threads.length; i++) {
            threads[i].setThreadState("IDLE");
            threads[i] = null;
        }
    }
}
