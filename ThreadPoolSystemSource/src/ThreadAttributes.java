abstract class ThreadAttributes {
    abstract public double getValue();
}

//Abstract Element of Visitor
//Abstract Product1
abstract class Memory extends ThreadAttributes {

    protected double memory;

    @Override
    public double getValue() {
        return memory;
    }
}

//Abstract Product2
abstract class Priority extends ThreadAttributes {
    protected int priority;


    @Override
    public double getValue() {
        return priority;
    }
}