package pl.szwyngiel;

public class Calc {
    private int first = -1;
    private int second = -1;
    private Operation operation;

    public Calc() {
    }

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    public Operation getOperation() {
        return operation;
    }

    public int getResult() {
        switch (operation) {
            case ADD:
                return first + second;
            case SUB:
                return first - second;
            case MUL:
                return first * second;
            case DIV:
                return first / second;
            default:
                return 0;
        }
    }

    public void clear() {
        this.first = -1;
        this.second = -1;
        this.operation = null;
    }
}
