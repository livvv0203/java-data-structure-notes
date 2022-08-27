package com.jieqing;
import java.util.Scanner;

public class FizzBuzz {
    FizzBuzz() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a Number: ");
        int number = scanner.nextInt();

        if (number % 5 == 0 && number % 3 == 0)
            System.out.println("FizzBuzz");
        else if (number % 5 == 0)
            System.out.println("Fizz");
        else if (number % 3 == 0)
            System.out.println("Buzz");
        else
            System.out.println("[" + number + "]" + " is not divisible by either 3 or 5.");
    }
}











