public class Main {

    public static void main(String [] args) throws InterruptedException {
        Runnable r = () -> {
            try {
                Thread.sleep(1000);
                System.out.println(Thread.currentThread().getPriority() + " is executing task.");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };

        ThreadPool threadPool=ThreadPool.ThreadPoolCreate();

        threadPool.execute(r);
        threadPool.execute(r);
        threadPool.shutdown();
    }

}
