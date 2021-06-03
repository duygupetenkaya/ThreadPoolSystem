//Interface Visitor
public abstract class ThreadAttributesVisitor {

    void VisitMemory(Memory m) {
    }
}
//Concrete Visitor
class MemoryVisitor extends ThreadAttributesVisitor {
    void VisitMemory(HThreadMemory m) {
        super.VisitMemory(m);
    }

    void VisitMemory(LThreadMemory m) {
        super.VisitMemory(m);
    }
}
