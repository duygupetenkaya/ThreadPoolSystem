import java.util.List;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ThreadPool threadPool = ThreadPool.threadPoolCreate();
        List<Thread> threads = threadPool.getThreads();
        MemoryController memoryController = new MemoryController();

        for (Thread thread : threads) {
            thread.Notify();
            System.out.print("\nMemory usage of current thread: ");
            System.out.println(thread.memory.getValue());
            threadPool.execute(thread);
            thread.memory.accept(memoryController);
            System.out.println("The currently working thread needs to use more memory!");
            System.out.print("Memory usage of current thread: ");
            System.out.println(thread.memory.getValue());
            System.out.println("The task is finished!");
            thread.Notify();
        }

threadPool.shutdown();
    }

}
