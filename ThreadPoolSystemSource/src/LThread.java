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
        memory.setMemory(256);
    }

    @Override
    void createEntryThread() {

    }

    @Override
    void assignPriority() {
        priority.setPriority(5);
    }
}

class LThreadMemory extends Memory {
    private double memory;

    public LThreadMemory(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }


}

class LThreadPriority extends Priority {
    private int priority;

    public LThreadPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}
