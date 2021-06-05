//ConcreteFactory1
//Template Pattern Concrete1

public class HThread extends Thread implements Runnable {
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
        memory.setMemory(512);
    }

    @Override
    void createEntryThread() {
        setThreadState("IDLE");
    }

    @Override
    void assignPriority() {
        priority.setPriority(1);
    }


    //Register the Observers
    @Override
    public void Attach(StateWatcher watchers) {
        this.watchers.add(watchers);
    }

    //Unregister from the list of Observers.
    @Override
    public void Detach(StateWatcher watchers) {
        for (int i = 0; i < this.watchers.size(); i++) {
          /*  if (this.watchers.get(i).getWatcher_name() == watchers.getWatcher_name()) {
                this.watchers.remove(i);
                return;
            }*/
        }
    }

    //Notify the Observers.
    @Override
    public void Notify() {    // set argument to something that helps
        // tell the Observers what happened
        for (int i = 0; i < watchers.size(); i++) {

            watchers.get(i).Update(this);
        }
    }


    @Override
    public void run() {

    }
}


//Concrete ElementA of Visitor
//Concrete Product1A
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

//ConcreteProduct2A
class HThreadPriority extends Priority {
    private int priority;

    public HThreadPriority(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}