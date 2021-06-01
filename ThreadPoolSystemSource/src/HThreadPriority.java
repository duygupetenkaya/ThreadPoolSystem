public class HThreadPriority extends Priority {
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
