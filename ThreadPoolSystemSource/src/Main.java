import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = ThreadPool.threadPoolCreate();
        List<Thread> threads = threadPool.getThreads();
        MemoryController memoryController=new MemoryController();

        threads.get(0).Notify();
        System.out.println(threads.get(0).memory.getValue());

        threads.get(0).memory.accept(memoryController);

        System.out.println(threads.get(0).memory.getValue());
    threads.get(0).Notify();

    }

}
