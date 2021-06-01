public class ThreadPool {
       private static ThreadPool instance = null;
private Thread thread;
    public static ThreadPool ThreadPoolCreate() {

        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    private ThreadPool(){
    }
}
