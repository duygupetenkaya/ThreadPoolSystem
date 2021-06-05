//Abstract Observer
public abstract class Watcher {
    abstract void Update(HThread thread);

    abstract void Update(LThread thread);
}

//Concrete Observer
class StateWatcher extends Watcher {
    private String threadState;
    private HThread Hthread;
    private LThread Lthread;

    @Override
    void Update(HThread thread) {
        Hthread = thread;
        threadState = thread.getThreadState();

       /* System.out.println("Notified " + watcher_name + " of " + securityCamName +
                "'s " + "change to " + threadState);*/
    }

    @Override
    void Update(LThread thread) {
        Lthread = thread;
        threadState = thread.getThreadState();
 /* System.out.println("Notified " + watcher_name + " of " + securityCamName +
                "'s " + "change to " + threadState);*/
    }
}