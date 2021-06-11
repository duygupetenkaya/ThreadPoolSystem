//Abstract Observer
interface Watcher {
    void Update(Thread thread);
}

//Concrete Observer->Investor
class StateWatcher implements Watcher {
    private String threadWatcher;

    public StateWatcher() {
        threadWatcher = "ThreadsMemoryWatcher";
    }

    @Override
    public void Update(Thread _thread) {
        if (_thread.getThreadState().equals("IDLE")) {
            _thread.setThreadState("BUSY");
            System.out.println("ThreadState: IDLE change to " + _thread.getThreadState());
        } else {
            _thread.setThreadState("IDLE");
            System.out.println("ThreadState: BUSY change to " + _thread.getThreadState());

        }
    }

}