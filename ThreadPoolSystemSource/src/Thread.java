import java.util.ArrayList;

//Template of Abstract Factory
//Subject of Observer
public abstract class Thread {
    protected ArrayList<StateWatcher> stateWatchers = new ArrayList<StateWatcher>();
    MemoryController memoryController=new MemoryController();

    protected String threadState;

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

    //Register the Observers
    void attach(StateWatcher watchers) {
        this.stateWatchers.add(watchers);
    }

  /*  //Unregister from the list of Observers.
    void Detach(StateWatcher watchers) {
        for (int i = 0; i < this.stateWatchers.size(); i++) {
            if (this.stateWatchers.get(i).getWatcher_name() == watchers.getWatcher_name()) {
                this.stateWatchers.remove(i);
                return;
            }
        }
    }*/

    //Notify the Observers.
    void Notify() {
        for (int i = 0; i < stateWatchers.size(); i++) {
            stateWatchers.get(i).Update(this);
        }
    }
}
