package lesson2;

public class Main {
    private static final int LENGTH = 4;

    public static void main(String[] args) {

        String[][] array = {
                {"h", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };
        // ловит только 1 исключение: либо размер, либо ошибку в элементе. Не знаю как оба словить.
        try {
            myArray(array);
        } catch (MyArraySizeException e) {
            System.out.println(e.message);
        } catch (MyArrayDataException b) {
            System.out.println(b.getMessage() + "[" + b.getLine() + "]" + "[" + b.getElement() + "]");
        }
    }

    public static void myArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int sum = 0;
        int arrayElement;
        for (int i = 0; i < array.length; i++) {
            if (array.length != LENGTH) {
                throw new MyArraySizeException("Длина массива не корректна");
            }
            for (int j = 0; j < array.length; j++) {
                if (array[i].length != LENGTH) {
                    throw new MyArraySizeException("Длина массива не корректна");
                }
                try {
                    arrayElement = Integer.parseInt(array[i][j]);
                    sum += arrayElement;
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Некорректный элемент " + '"' + array[i][j] + '"' + " в ", i, j, array[i][j]);
                }
            }
        }
        System.out.println(sum);
    }
}
