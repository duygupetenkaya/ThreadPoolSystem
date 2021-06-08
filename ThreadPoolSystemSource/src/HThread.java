//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread {
    private String threadState;
    ThreadAttributes memory;
    ThreadAttributes priority;

    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
        notify();
    }

    public HThread(ThreadPool threadPool) {
        this.threadPool = threadPool;
        this.createThread();
    }

    @Override
    void allocateMemory() {
        memory = new HThreadMemory(512);
    }

    @Override
    void createEntryThread() {
        setThreadState("IDLE");
    }

    @Override
    void assignPriority() {
        priority = new HThreadPriority(1);
    }

}

//Concrete ElementA of Visitor
//Concrete Product1A
class HThreadMemory extends Memory {

    private double memory;

    public HThreadMemory(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

    public void accept(MemoryManager manager) {
        manager.VisitMemory(this);
    }
}

//ConcreteProduct2A
class HThreadPriority extends Priority {
    private int priority;

    public HThreadPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}