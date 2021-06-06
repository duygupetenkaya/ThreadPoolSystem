//ConcreteFactory2
//Template Pattern Concrete2

import java.util.concurrent.BlockingQueue;

public class LThread extends Thread {
    private String threadState;
    private LThreadMemory memory;
    private LThreadPriority priority;


    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }


    public LThread(BlockingQueue<Runnable> taskQueue, ThreadPool threadPool) {
        this.taskQueue = taskQueue;
        this.threadPool = threadPool;
        this.createThread();
    }

    @Override
    void allocateMemory() {
        memory.setMemory(256);
    }

    @Override
    void createEntryThread() {
        setThreadState("IDLE");

    }

    @Override
    void assignPriority() {
        priority.setPriority(5);
    }

    //Register the Observers
    @Override
    public void Attach(StateWatcher watchers) {
        this.watchers.add(watchers);
    }

    //Unregister from the list of Observers.
    @Override
    public void Detach(StateWatcher watchers) {
        for (int i = 0; i < this.watchers.size(); i++) {
          /*  if (this.watchers.get(i).getWatcher_name() == watchers.getWatcher_name()) {
                this.watchers.remove(i);
                return;
            }*/
        }
    }

    //Notify the Observers.
    @Override
    public void Notify() {    // set argument to something that helps
        // tell the Observers what happened
        for (int i = 0; i < watchers.size(); i++) {

            watchers.get(i).Update(this);
        }
    }

    @Override
    public void run() {
        try {
            // continue until all tasks finished processing
            while (!threadPool.isThreadPoolShutDownInitiated.get() || !taskQueue.isEmpty()) {
                Runnable r;
                // Poll a runnable from the queue and execute it
                while ((r = taskQueue.poll()) != null) {
                    r.run();
                }
                Thread.sleep(1);
            }
        } catch (RuntimeException | InterruptedException e) {
            throw new ThreadPoolException(e);
        }
    }
}

//Concrete ElementB of Visitor
//Concrete Product1B
class LThreadMemory extends Memory {
    private double memory;

    public LThreadMemory(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }


}

//ConcreteProduct2B
class LThreadPriority extends Priority {
    private int priority;

    public LThreadPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}