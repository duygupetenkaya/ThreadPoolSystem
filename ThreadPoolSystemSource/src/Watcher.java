//Abstract Observer
interface Watcher {
    void Update(Thread thread);
}

//Concrete Observer->Investor
class StateWatcher implements Watcher {

    @Override
    public void Update(Thread _thread) {
       _thread.createEntryThread();
        if (_thread.getThreadState().equals("IDLE")){
            _thread.setThreadState("BUSY");
            System.out.println("ThreadState: IDLE change to " + _thread.getThreadState());
        }
        else {
            _thread.setThreadState("IDLE");
            System.out.println("ThreadState: BUSY change to " + _thread.getThreadState());

        }
    }

}