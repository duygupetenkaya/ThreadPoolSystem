//Interface Visitor
public abstract class MemoryManager {

    void VisitMemory(Memory m) {
    }
}
//Concrete Visitor
class MemoryController extends MemoryManager {
    void VisitMemory(HThreadMemory m) {
        super.VisitMemory(m);
    }

    void VisitMemory(LThreadMemory m) {
        super.VisitMemory(m);
    }
}
