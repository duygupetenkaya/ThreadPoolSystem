public abstract class Thread {

    abstract void allocateMemory();

    abstract void createEntryThread();

    abstract void assignPriority();

    void createThread(){
        allocateMemory();
        createEntryThread();
        assignPriority();
    }
}
