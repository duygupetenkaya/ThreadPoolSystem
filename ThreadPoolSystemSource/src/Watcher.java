//Abstract Observer
interface Watcher {
    void Update(Thread thread);
}

//Concrete Observer->Investor
class StateWatcher implements Watcher {
    private String watcher_name;
    private Thread thread;

    @Override
    public void Update(Thread _thread) {

        if (thread.getThreadState().equals("IDLE"))
            thread.setThreadState("BUSY");
        else
            thread.setThreadState("IDLE");

        System.out.println("Notified " + watcher_name + " of " + _thread.getThreadState()+
                "'s " + "change to " + thread.getThreadState());
    }

    public String getWatcher_name() {
        return watcher_name;
    }
}