
//Abstract Element of Visitor
//Abstract Product1
abstract class Memory implements _Memory {

    protected int memory;
//We could set the method name as getMemory but we would like to have the same method calling for both memory and priority
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
//We could set the method name as getMemory but we would like to have the same method calling for both memory and priority
    public int getValue() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

}