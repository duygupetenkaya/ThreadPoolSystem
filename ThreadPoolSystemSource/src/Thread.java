public abstract class Thread {

    private String threadState;
    private double threadMemory;
    private int threadPriority;

    public double getThreadMemory() {
        return threadMemory;
    }

    public void setThreadMemory(double threadMemory) {
        this.threadMemory = threadMemory;
    }

    public int getThreadPriority() {
        return threadPriority;
    }

    public void setThreadPriority(int threadPriority) {
        this.threadPriority = threadPriority;
    }


    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }

    abstract void allocateMemory();

    abstract void createEntryThread();

    abstract void assignPriority();

    void createThread(){
        allocateMemory();
        createEntryThread();
        assignPriority();
    }
}
