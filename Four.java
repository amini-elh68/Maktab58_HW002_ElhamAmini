package Maktab58_HW002_ElhamAmini;

import java.util.Scanner;

public class Four {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("تعداد اعداد را وارد کنید");
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            System.out.println("عدد " + (i + 1) + " را وارد کنید");
            numbers[i] = scanner.nextInt();
        }
        System.out.println("عدد مورد نظر برای جستجو را وارد کنید");
        int searchNumber = scanner.nextInt();
        String response = "{";
        for (int i : numbers) {
            response += i;
            if (numbers[numbers.length - 1] != i) {
                response += ", ";
            }
        }
        response += "} ,  search=" + searchNumber + " =====>    ";
        System.out.print(response);
        int[] copy = new int[count];
        for (int i = 0; i < count; i++) {
            copy[i] = numbers[i];
        }
        for (int i = 0; i < count; i++) {
            for (int j = i + 1; j < count; j++) {
                if (copy[j] < copy[i]) {
                    int temp = copy[i];
                    copy[i] = copy[j];
                    copy[j] = temp;
                }
            }
        }
        int result = binarySearch(copy, 0, count, searchNumber);
        if (result != -1) {
            for (int i = 0; i < count; i++) {
                if (numbers[i] == copy[result]) {
                    result = i;
                    break;
                }
            }
        }
        String s = (result == -1 ? searchNumber + " There is not in list!" : String.valueOf(result));
        System.out.println(s);
    }

    public static int binarySearch(int[] array, int first, int last, int searchNumber) {
        int index = -1;
        if (first < last) {
            int mid = (first + last - 1) / 2;
            if (array[mid] == searchNumber) {
                index = mid;
            } else if (array[mid] > searchNumber) {
                index = binarySearch(array, first, mid - 1, searchNumber);
            } else if (array[mid] < searchNumber) {
                index = binarySearch(array, mid + 1, last, searchNumber);
            }
        }
        return index;
    }
}
