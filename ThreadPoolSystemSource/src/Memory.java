
//Abstract Element of Visitor
//Abstract Product1
abstract class Memory implements _Memory {

    protected int memory;

    public int getValue() {
        return memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }

}

//Abstract Product2
abstract class Priority  {
    protected int priority;

    public int getValue() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}