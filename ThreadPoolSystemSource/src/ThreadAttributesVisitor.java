public abstract class ThreadAttributesVisitor {
    void VisitPriority(Priority p) {
    }

    void VisitMemory(Memory m) {
    }
}

class PriorityVisitor extends ThreadAttributesVisitor {

    void VisitPriority(HThreadPriority p) {
        super.VisitPriority(p);
    }

    void VisitPriority(LThreadPriority p) {
        super.VisitPriority(p);
    }
}

class MemoryVisitor extends ThreadAttributesVisitor {
    void VisitMemory(HThreadMemory m) {
        super.VisitMemory(m);
    }

    void VisitMemory(LThreadMemory m) {
        super.VisitMemory(m);
    }
}
