//Interface Visitor
interface MemoryManager {
    abstract void VisitMemory(LThreadMemory m);

    abstract void VisitMemory(HThreadMemory m);
}

//Concrete Visitor
class MemoryController implements MemoryManager {

    public void VisitMemory(HThreadMemory m) {
        m.setMemory(m.getMemory()*2);
        System.out.println(m.getMemory());
    }

    public void VisitMemory(LThreadMemory m) {
        m.setMemory(m.getMemory()*2);

    }
}
