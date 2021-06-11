//ConcreteFactory2
//Template Pattern Concrete2



public class LThread extends Thread {
    private String threadState;
    private Memory memory;
    private Priority priority;

    public String getThreadState() {

        Notify();
        return threadState;
    }

    public void setThreadState(String threadState) {

        this.threadState = threadState;
    }

    public LThread(ThreadPool threadPool) {

        this.threadPool = threadPool;
        this.createThread();
    }

    @Override
    void allocateMemory() {
        memory = new LThreadMemory(256);
    }

    @Override
    void createEntryThread() {
        setThreadState("IDLE");

    }

    @Override
    void assignPriority() {
        priority = new LThreadPriority(5);
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

    public void accept(MemoryManager manager){
        manager.VisitMemory(this);
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