//ConcreteFactory2
//Template Pattern Concrete2


public class LThread extends Thread {
    private String threadState;
    private LThreadMemory memory;
    private LThreadPriority priority;

    public String getThreadState() {

        Notify();
        return threadState;
    }

    public void setThreadState(String threadState) {

        this.threadState = threadState;
    }

    public LThread(ThreadPool threadPool) {
        this.createThread();
        if (threadPool != null)
            System.out.println(threadPool.threadPoolName + "- New LThread " + this.threadState + " Memory: " + this.memory.getValue() + " Priority: " + this.priority.getValue());
    }

    @Override
    void allocateMemory() {
        this.memory = new LThreadMemory(256);

    }

    @Override
    void createEntryThread() {
        this.setThreadState("IDLE");

    }

    @Override
    void assignPriority() {
        this.priority = new LThreadPriority(5);
    }
}

//Concrete ElementB of Visitor
//Concrete Product1B
class LThreadMemory extends Memory {

    public LThreadMemory(int memory) {
        this.memory = memory;
    }


    public void accept(MemoryManager manager) {
        manager.VisitMemory(this);
    }

}

//ConcreteProduct2B
class LThreadPriority extends Priority {

    public LThreadPriority(int priority) {
        this.priority = priority;
    }


}