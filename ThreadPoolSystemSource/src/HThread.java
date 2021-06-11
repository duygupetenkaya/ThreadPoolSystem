//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread {
    private String threadState;
    private HThreadMemory memory;
    private HThreadPriority priority;

    public String getThreadState() {
        Notify();
        return threadState;

    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;

    }

    public HThread(ThreadPool threadPool) {
        this.createThread();
        System.out.println(threadPool.threadPoolName+"- New HThread "+this.threadState+ " Memory: " +memory.getValue()+" Priority: "+this.priority.getValue( ));
    }

    @Override
    void allocateMemory() {
        memory=new HThreadMemory(512);

    }

    @Override
    void createEntryThread() {
        this.setThreadState("IDLE");
    }

    @Override
    void assignPriority() {
        this.priority=new HThreadPriority(1);
    }


}

//Concrete ElementA of Visitor
//Concrete Product1A
class HThreadMemory extends Memory {

    public HThreadMemory(int memory) {
        this.memory = memory;
    }


    public void accept(MemoryManager manager) {
        manager.VisitMemory(this);
    }
}

//ConcreteProduct2A
class HThreadPriority extends Priority {

    public HThreadPriority(int priority) {
        this.priority = priority;
    }



}