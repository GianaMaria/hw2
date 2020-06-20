package lesson2;

public class MyArraySizeException extends RuntimeException {
    String message;

    public MyArraySizeException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
