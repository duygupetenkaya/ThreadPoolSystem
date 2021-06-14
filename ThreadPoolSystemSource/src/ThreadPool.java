import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

//Singleton Class
public class ThreadPool {
    private static ThreadPool instance = null;
    // holds the pool of worker threads
    private List<Thread> threads=new ArrayList<>();
    // check if shutdown is initiated
    private AtomicBoolean isThreadPoolShutDownInitiated;

    String threadPoolName="SE311-ThreadPool";

    public static ThreadPool threadPoolCreate() throws InterruptedException {
        if (instance == null) {
            instance = new ThreadPool();

        }
        return instance;
    }

    private ThreadPool() throws InterruptedException {
        this.threads = createThreadPoolThreads();
        this.isThreadPoolShutDownInitiated = new AtomicBoolean(false);
    }

    public void execute(Thread thread) throws InterruptedException {
        if (!isThreadPoolShutDownInitiated.get()) {
            if(thread instanceof HThread)
            System.out.println("HThread is executing the task...");
            else if(thread instanceof LThread)
                System.out.println("LThread is executing the task...");
        } else {
            throw new InterruptedException("Thread Pool shutdown is initiated, unable to execute task");
        }
    }

    public void shutdown() {
        System.out.println("\n"+threadPoolName+" is finished all tasks and shutting down now!");
        isThreadPoolShutDownInitiated = new AtomicBoolean(true);
    }

    public List<Thread> createThreadPoolThreads() {
        StateWatcher stateWatcher=new StateWatcher();

        threads.add(new HThread( this));
        threads.add(new HThread( this));
        threads.add(new LThread( this));
        threads.add(new LThread( this));

        for (int i = 0; i < threads.size(); i++) {
            threads.get(i).attach(stateWatcher);
        }
        return threads;
    }

    public List<Thread> getThreads(){
        return threads;
    }

}


//Template of Abstract Factory
//Subject of Observer
 abstract class Thread {
    protected ArrayList<StateWatcher> stateWatchers = new ArrayList<StateWatcher>();
    MemoryController memoryController = new MemoryController();

    protected Memory memory;
    protected Priority priority;
    protected String threadState;



    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;

    }

    abstract void allocateMemory();

    abstract void createEntryThread();

    abstract void assignPriority();

    void createThread() {
        allocateMemory();
        createEntryThread();
        assignPriority();

    }

    //Register the Observers
    void attach(StateWatcher watchers) {
        this.stateWatchers.add(watchers);
    }

   //Unregister from the list of Observers.
    void Detach(StateWatcher watchers) {
        for (int i = 0; i < this.stateWatchers.size(); i++) {
            if (this.stateWatchers.get(i) == watchers) {
                this.stateWatchers.remove(i);
                return;
            }
        }
    }

    //Notify the Observers.
    void Notify() {
        for (int i = 0; i < stateWatchers.size(); i++) {
            stateWatchers.get(i).update(this);
        }
    }
}
