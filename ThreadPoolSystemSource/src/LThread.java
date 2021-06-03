//ConcreteFactory2
//Template Pattern Concrete2

public class LThread extends Thread implements Runnable {
    private String threadState;
    private LThreadMemory memory;
    private LThreadPriority priority;


    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
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

    @Override
    public void run() {

    }
}


