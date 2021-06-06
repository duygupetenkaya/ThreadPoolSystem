import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;

//Template of Abstract Factory
//Subject of Observer
public abstract class Thread extends java.lang.Thread {
    protected ArrayList<StateWatcher> watchers = new ArrayList<StateWatcher>();
    protected String threadState;

    // holds tasks
    protected BlockingQueue<Runnable> taskQueue;

    // check if shutdown is initiated
    protected ThreadPool threadPool;


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

    @Override
    public void run() {

    }

    //Register the Observers
    abstract void Attach(StateWatcher watchers);

    //Unregister from the list of Observers.
    abstract void Detach(StateWatcher watchers);

    //Notify the Observers.
    abstract void Notify();
}
