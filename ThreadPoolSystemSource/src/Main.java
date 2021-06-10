public class Main {

    public static void main(String [] args) throws InterruptedException {
        ThreadPool threadPool=ThreadPool.ThreadPoolCreate();

        threadPool.createThreadPoolThreads();
        HThread hThread = new HThread(threadPool);
        Thread lThread = new HThread(threadPool);
        hThread.createEntryThread();
        ((HThread) hThread).getThreadState();
        hThread.allocateMemory();
        MemoryController memoryController = new MemoryController();
        hThread.allocateMemory();
        HThreadMemory hThreadMemory= new HThreadMemory(512);
        memoryController.VisitMemory(hThreadMemory);
        StateWatcher stateWatcher = new StateWatcher();
        stateWatcher.Update(hThread);
        stateWatcher.Update(hThread);

    }

}
