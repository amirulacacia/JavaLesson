package lesson.lesson7.consoleexample;

import java.util.Scanner;

public class ConsoleReaderExample {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int num =sc.nextInt();
        System.out.println("You entered: " + num);
        sc.close();
    }
}
