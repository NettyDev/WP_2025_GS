package pl.szwyngiel;

public class Model {
    private int first = 0;
    private int second = 0;
    private Operation operation;

    public void setFirst(int first) {
        this.first = first;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
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
                if(second != 0) {
                    return first / second;
                } else {
                    throw new ArithmeticException("Dzielenie przez zero");
                }
            default:
                throw new IllegalArgumentException("Operator niezdefiniowany");
        }
    }

    public void clear() {
        this.first = 0;
        this.second = -1;
        this.operation = null;
    }
}
