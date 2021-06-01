public class LThread extends Thread {
    private String threadState;
    private LThreadMemory memory;
    private LThreadPriority priority;


    public String getThreadState() {
        return threadState;
    }

    public void setThreadState(String threadState) {
        this.threadState = threadState;
    }


    @Override
    void allocateMemory() {

    }

    @Override
    void createEntryThread() {

    }

    @Override
    void assignPriority() {

    }
}
