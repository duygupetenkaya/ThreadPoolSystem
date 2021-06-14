//Abstract Observer
interface Watcher {
    void update(Thread thread);
}

//Concrete Observer->Investor
class StateWatcher implements Watcher {
    private String threadWatcher;

    public StateWatcher() {
        threadWatcher = "ThreadsMemoryWatcher";
    }

    @Override
    public void update(Thread _thread) {
        if (_thread.getThreadState().equals("IDLE")) {
            _thread.setThreadState("BUSY");
            if (_thread instanceof HThread)
                System.out.println("\nHThreadState: IDLE change to " + _thread.getThreadState());
            if (_thread instanceof LThread)
                System.out.println("\nLThreadState: IDLE change to " + _thread.getThreadState());
        } else {
            _thread.setThreadState("IDLE");
            if (_thread instanceof HThread)
                System.out.println("\nHThreadState: BUSY change to " + _thread.getThreadState());
            if (_thread instanceof LThread)
                System.out.println("\nLThreadState: BUSY change to " + _thread.getThreadState());
        }
    }

}