import java.util.ArrayList;
//Singleton Class
public class ThreadPool {
       private static ThreadPool instance = null;


    public static ThreadPool ThreadPoolCreate() {

        if (instance == null) {
            instance = new ThreadPool();
        }
        return instance;
    }

    private ThreadPool(){

    }
}
