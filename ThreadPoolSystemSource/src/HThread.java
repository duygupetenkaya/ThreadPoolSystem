// ELİF DUYGU PETENKAYA
// SANEM YAMAN
// HİLAL RANA ANARSAY
// MEHMET SÖNMEZ
//THREAD POOL SYSTEM





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
//-------------------------------------------------------------------------------------------
//ConcreteFactory2
//Template Pattern Concrete2

 class LThread extends Thread {
    //We did not add HThreadMemory like we did for priority, because when we put it here
    //in the main to show you, we have to add more and unnecessary methods for calling,
    //in this approach, HThread's memory is coming as HThreadMemory by calling the memory
    //attribute of Thread abstract class
    private LThreadPriority priority;

    //this method is for the creation of LThread in ThreadPool class
    public LThread(ThreadPool threadPool) {
        this.createThread();

        System.out.println(threadPool.threadPoolName + "- New LThread " + this.getThreadState() + " Memory: " + this.memory.getValue() + " Priority: " + this.priority.getValue());
    }

    //The following three methods are for call them in template method for thread creation
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

    //This method is for Visitor, therefore visitor can check the memory
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