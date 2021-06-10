//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread {
    private String threadState;
    private ThreadAttributes memory;
    private ThreadAttributes priority;

    public String getThreadState() {
        Notify();
        return threadState;

    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;

    }

    public HThread(ThreadPool threadPool) {
        this.threadPool = threadPool;
        this.createThread();
    }

    @Override
    void allocateMemory() {
        setMemory(new HThreadMemory(512));
        System.out.println(((HThreadMemory) getMemory()).getMemory());
    }

    @Override
    void createEntryThread() {
        setThreadState("IDLE");
        System.out.println(getThreadState());
    }

    @Override
    void assignPriority() {
        setPriority(new HThreadPriority(1));
    }

    public ThreadAttributes getMemory() {
        return memory;
    }

    public void setMemory(ThreadAttributes memory) {
        this.memory = memory;
    }

    public ThreadAttributes getPriority() {
        return priority;
    }

    public void setPriority(ThreadAttributes priority) {
        this.priority = priority;
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