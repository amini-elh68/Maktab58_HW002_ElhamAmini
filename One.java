package Maktab58_HW002_ElhamAmini;

import java.util.Scanner;

public class One {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("لطفا تعداد کاراکترها را وارد کنید");
        int count = scanner.nextInt();
        String[] chars = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.println("لطفا کاراکتر " + (i + 1) + " را وارد کنید");
            String s = scanner.next();
            if (s.length() != 1) {
                System.out.println("مقدار ورودی نامعتبر است");
                i--;
            } else {
                chars[i] = s;
            }
        }
        boolean isValid = false;
        int size = 0;
        while (!isValid) {
            System.out.println("طول رشته های مورد نظر را وارد کنید");
            size = scanner.nextInt();
            if (size <= count) {
                isValid = true;
            }
        }
        String result = "{";
        for (int i = 0; i < count; i++) {
            result += ("'" + chars[i] + "'");
            if (i != count - 1)
                result += ", ";
        }
        result += "}  ,  n=" + size + "  =====>  ";
        System.out.print(result);
        String phrases = getPhrases(chars, size, "");
        System.out.println(phrases.substring(0, phrases.length() - 2));
    }

    public static String getPhrases(String[] chars, int number, String str) {
        String result = "";
        if (str.length() == number) {
            result += str + ", ";
        } else if (str.length() < number) {
            String[] copy;
            for (int i = 0; i < chars.length; i++) {
                copy = new String[chars.length - 1];
                int cnt = 0;
                for (int j = 0; j < chars.length; j++) {
                    if (i != j) {
                        copy[cnt++] = chars[j];
                    }
                }
                result += getPhrases(copy, number, str + chars[i]);
            }
        }
        return result;
    }
}
