//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread {
    private String threadState;

    private HThreadPriority priority;

    public HThread(ThreadPool threadPool) {
        this.createThread();
        System.out.println(threadPool.threadPoolName+"- New HThread "+this.getThreadState()+ " Memory: " +memory.getValue()+" Priority: "+this.priority.getValue( ));
    }

    @Override
    void allocateMemory() {
        this.memory=new HThreadMemory(512);

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
        manager.visitMemory(this);
    }
}

//ConcreteProduct2A
class HThreadPriority extends Priority {

    public HThreadPriority(int priority) {
        this.priority = priority;
    }



}