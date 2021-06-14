//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread {
    //We did not add HThreadMemory like we did for priority, because when we put it here
    //in the main to show you, we have to add more and unnecessary methods for calling,
    //in this approach, HThread's memory is coming as HThreadMemory by calling the memory
    //attribute of Thread abstract class
    private HThreadPriority priority;

    //this method is for the creation of HThread in ThreadPool class
    public HThread(ThreadPool threadPool) {
        this.createThread();
        System.out.println(threadPool.threadPoolName + "- New HThread " + this.getThreadState() + " Memory: " + memory.getValue() + " Priority: " + this.priority.getValue());
    }

    //The following three methods are for call them in template method for thread creation
    @Override
    void allocateMemory() {
        this.memory = new HThreadMemory(512);
    }

    @Override
    void createEntryThread() {
        this.setThreadState("IDLE");
    }

    @Override
    void assignPriority() {
        this.priority = new HThreadPriority(1);
    }


}

//Concrete ElementA of Visitor
//Concrete Product1A
class HThreadMemory extends Memory {

    public HThreadMemory(int memory) {
        this.memory = memory;
    }

    //This method is for Visitor, therefore visitor can check the memory
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