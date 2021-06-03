//Abstract Element of Visitor
//Abstract Product1
abstract class Memory {
}
//Concrete ElementA of Visitor
//Concrete Product1A
class HThreadMemory extends Memory {

    private double memory;

    public HThreadMemory(double memory) {
        this.memory = memory;
    }


    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }

}
//Concrete ElementB of Visitor
//Concrete Product1B
class LThreadMemory extends Memory {
    private double memory;

    public LThreadMemory(double memory) {
        this.memory = memory;
    }

    public double getMemory() {
        return memory;
    }

    public void setMemory(double memory) {
        this.memory = memory;
    }


}