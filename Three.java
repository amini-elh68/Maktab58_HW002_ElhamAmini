package Maktab58_HW002_ElhamAmini;

import java.util.Scanner;

public class Three {
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
        System.out.println(getCostOfMerge(numbers));
    }

    public static int getCostOfMerge(int[] numbers) {
        int calCost = 0;
        if (numbers.length == 2) {
            return numbers[0] + numbers[1];
        } else if (numbers.length == 1) {
            return 0;
        }
        int size;
        if (numbers.length % 2 == 0) {
            size = numbers.length / 2;
        } else {
            size = numbers.length / 2 + 1;
        }
        int[] mergedArray = new int[size];
        int mergedArrayIndex = 0;
        for (int i = 0; i < numbers.length / 2; i++) {
            mergedArray[mergedArrayIndex++] = numbers[2 * i] + numbers[2 * i + 1];
            calCost += numbers[2 * i] + numbers[2 * i + 1];
        }
        if (numbers.length % 2 == 1) {
            mergedArray[mergedArrayIndex] = numbers[numbers.length - 1];
        }
        return calCost + getCostOfMerge(mergedArray);
    }
}
