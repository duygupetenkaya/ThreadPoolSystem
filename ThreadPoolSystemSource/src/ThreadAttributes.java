abstract class ThreadAttributes {
    abstract public double getValue();
}

//Abstract Element of Visitor
//Abstract Product1
abstract class Memory extends ThreadAttributes {
    public void setMemory(double memory) {
        this.memory = memory;
    }

    protected double memory;

    @Override
    public double getValue() {
        return memory;
    }
}

//Abstract Product2
abstract class Priority extends ThreadAttributes {
    protected int priority;

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public double getValue() {
        return priority;
    }
}