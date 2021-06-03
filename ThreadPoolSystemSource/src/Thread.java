//Template Pattern Abstract
//Subject of Observer
public abstract class Thread implements Runnable{

    abstract void allocateMemory();

    abstract void createEntryThread();

    abstract void assignPriority();

    void createThread(){
        allocateMemory();
        createEntryThread();
        assignPriority();
    }
    @Override
    public void run() {
        System.out.println("A Thread is running");
    }
}
