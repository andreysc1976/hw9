public class Main {
    public static int sumArray(String[][] array){
        int sum=0;
        //п.1 проверим размерность
        if (array.length!=4) {  //будем считать что все строки в массиве всегда одинаковой длины
            throw new MyArraySizeException(String.format("Array size exeption, line count = %d",array.length));
        }

        for (int i = 0; i <array.length ; i++) {
            if(array[i].length!=4){
                throw new MyArraySizeException(String.format("Array size exeption, in line %d count elements = %d",i,array[i].length));
            }
        }

        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException ex) {
                    throw new MyArrayDataException(String.format("Not integer value in array in position(%d,%d) (%s)",i,j,array[i][j]), ex);
                }

            }
        }

        return sum;
    }

    public static void main(String[] args) {
        String[][] array = {{"1","2","3","4"},{"1","2","3","4"},{"1","2","3","4f"},{"1","2","3","4"}};
        int sum;
        try {
            sum = sumArray(array);
            System.out.printf("Сумма элементов массива %d\n",sum);
        } catch ( MyArrayDataException ex) {
            ex.printStackTrace();
            System.out.println("Не удалось посчитать сумму массива");
        } catch (MyArraySizeException ex) {
            ex.printStackTrace();
            System.out.println("Не корректная размерность массива");
        } finally {
            System.out.println("Работа программы завершена");
        }
    }
}
