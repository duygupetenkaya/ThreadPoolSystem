//Abstract Observer
public abstract class Watcher {
    abstract void Update();
}
//Concrete Observer
class StateWatcher extends  Watcher{
    private String subjectState;

    @Override
    void Update() {

    }
}