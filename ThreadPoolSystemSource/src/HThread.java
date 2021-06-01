public class HThread extends Thread {
    private String threadState;

    private HThreadMemory memory;
    private HThreadPriority priority;

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
 class HThreadMemory extends Memory {

    private double memory;

    public HThreadMemory(double memory) {
        this.memory = memory;
    }



    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

}
 class HThreadPriority extends Priority {
    private int priority;

    public HThreadPriority( int priority) {
        this.priority = priority;
    }
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
