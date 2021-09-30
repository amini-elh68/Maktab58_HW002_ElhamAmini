package Maktab58_HW002_ElhamAmini;

import java.util.Scanner;

public class Two {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("تعداد اعداد را وارد کنید");
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.println("عدد " + (i + 1) + " را وارد کنید");
            numbers[i] = scanner.nextInt();
        }
        String response = "{";
        for (int i : numbers) {
            response += i;
            if (numbers[numbers.length - 1] != i) {
                response += ", ";
            }
        }
        response += "} =====>    ";
        System.out.print(response);
        System.out.println(getBiggerNumber(numbers));
    }

    public static int getBiggerNumber(int[] numbers) {
        if (numbers.length > 2) {
            int a1length = numbers.length / 2;
            int[] array1 = new int[a1length];
            int[] array2 = new int[numbers.length - a1length];
            for (int i = 0; i < numbers.length; i++) {
                if (i < array1.length) {
                    array1[i] = numbers[i];
                } else {
                    array2[i - a1length] = numbers[i];
                }
            }
            int result1 = getBiggerNumber(array1);
            int result2 = getBiggerNumber(array2);
            return result1 > result2 ? result1 : result2;
        } else if (numbers.length == 2) {
            return numbers[0] > numbers[1] ? numbers[0] : numbers[1];
        } else {
            return numbers[0];
        }
    }
}
