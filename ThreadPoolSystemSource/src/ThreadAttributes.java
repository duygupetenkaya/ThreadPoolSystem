abstract class ThreadAttributes {
    abstract public int getValue();
}

//Abstract Element of Visitor
//Abstract Product1
abstract class Memory extends ThreadAttributes {

    protected int memory;

    @Override
    public int getValue() {
        return memory;
    }

    abstract void accept(MemoryManager manager);
}

//Abstract Product2
abstract class Priority extends ThreadAttributes {
    protected int priority;


    @Override
    public int getValue() {
        return priority;
    }
}