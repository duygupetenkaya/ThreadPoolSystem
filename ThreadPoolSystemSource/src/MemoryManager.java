import java.util.ArrayList;

//Interface Visitor
interface MemoryManager {
    abstract void visitMemory(LThreadMemory m);

    abstract void visitMemory(HThreadMemory m);
}
//Interface Element of Visitor
interface _Memory {
    void accept(MemoryManager memoryManager);
}

//Concrete Visitor
class MemoryController implements MemoryManager {

    public void visitMemory(HThreadMemory m) {
            m.setMemory(m.getValue() * 2);
    }

    public void visitMemory(LThreadMemory m) {
            m.setMemory(m.getValue() * 2);
    }
}
