package lesson2;

public class MyArrayDataException extends NumberFormatException {
    int line;
    int element;
    String wrong;

    public int getLine() {
        return line;
    }

    public int getElement() {
        return element;
    }

    public MyArrayDataException(String message, int line, int element, String wrong) {
        super(message);
        this.line = line;
        this.element = element;
        this.wrong = wrong;
    }
}
