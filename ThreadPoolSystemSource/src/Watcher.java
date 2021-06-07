//Abstract Observer
public abstract class Watcher {
    abstract void Update(Thread thread);

}

//Concrete Observer
class StateWatcher extends Watcher {
    private String threadState;
    private HThread Hthread;
    private LThread Lthread;

    @Override
    void Update(Thread thread) {
             threadState = thread.getThreadState();

       /* System.out.println("Notified " + watcher_name + " of " + securityCamName +
                "'s " + "change to " + threadState);*/
    }

}