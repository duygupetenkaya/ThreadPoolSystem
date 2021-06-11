//ConcreteFactory2
//Template Pattern Concrete2


public class LThread extends Thread {
    private String threadState;
    private LThreadPriority priority;

    public LThread(ThreadPool threadPool) {
        this.createThread();
        if (threadPool != null)
            System.out.println(threadPool.threadPoolName + "- New LThread " + this.getThreadState() + " Memory: " + this.memory.getValue() + " Priority: " + this.priority.getValue());
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
        manager.visitMemory(this);
    }

}

//ConcreteProduct2B
class LThreadPriority extends Priority {

    public LThreadPriority(int priority) {
        this.priority = priority;
    }


}