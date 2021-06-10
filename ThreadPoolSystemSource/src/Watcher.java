//Abstract Observer
interface Watcher {
    void Update(Thread thread);
}

//Concrete Observer->Investor
class StateWatcher implements Watcher {
    private String watcher_name;
    private HThread hthread;

    @Override
    public void Update(Thread _thread) {
        _thread.createEntryThread();
        if (_thread.getThreadState().equals("IDLE"))
            _thread.setThreadState("BUSY");
        else
            _thread.setThreadState("IDLE");

        System.out.println("Notified " + getWatcher_name() +  " change to " + _thread.getThreadState());
    }

    public String getWatcher_name() {
        return watcher_name;
    }
}