import java.util.ArrayList;

//Interface Visitor
interface MemoryManager {
    abstract void VisitMemory(LThreadMemory m);

    abstract void VisitMemory(HThreadMemory m);
}
//Interface Element of Visitor
interface _Memory {
    void accept(MemoryManager memoryManager);
}

class MemoryManagerStructure extends Memory{
    private ArrayList<Memory> memories = new ArrayList<Memory>();

    public void add(Memory memory){ memories.add(memory);};

    public void remove(Memory memory) {
        for (int i = 0; i< memories.size(); i++) {
            if (memories.get(i).getValue() == memory.getValue()) {
                memories.remove(i);
                return;
            }
        }
    }
    public void accept(MemoryManager MemoryManager) {

        for (int i = 0; i < memories.size(); i++) {
            memories.get(i).accept(MemoryManager);		}
    }
}
//Concrete Visitor
class MemoryController implements MemoryManager {

    public void VisitMemory(HThreadMemory m) {
        m.setMemory(m.getValue()*2);

    }

    public void VisitMemory(LThreadMemory m) {
        m.setMemory(m.getValue()*2);

    }
}
