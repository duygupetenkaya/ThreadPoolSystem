//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread implements Runnable{
    private String threadState;

    private HThreadMemory memory;
    private HThreadPriority priority;

    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }


    @Override
    void allocateMemory() {
        memory.setMemory(512);
    }

    @Override
    void createEntryThread() {

    }

    @Override
    void assignPriority() {
        priority.setPriority(1);
    }


    @Override
    public void run() {

    }
}


