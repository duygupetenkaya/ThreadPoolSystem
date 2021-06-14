import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = ThreadPool.threadPoolCreate();
        List<Thread> threads = threadPool.getThreads();
        MemoryController memoryController=new MemoryController();

        threads.get(0).Notify();
        System.out.print("Memory usage of current thread: ");
        System.out.println(threads.get(0).memory.getValue());
threadPool.execute(threads.get(0));
        threads.get(0).memory.accept(memoryController);
        System.out.println("The currently working thread needs to use more memory!");
        System.out.print("Memory usage of current thread: ");
        System.out.println(threads.get(0).memory.getValue());
        System.out.println("The task is finished!");
    threads.get(0).Notify();

    }

}
