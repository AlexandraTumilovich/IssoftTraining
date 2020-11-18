package task1_1;

import java.util.Scanner;

public class Calculator {
    double memory;
    double result;
    boolean turnedOn = false;
    Scanner scanner;

    {
        scanner = new Scanner(System.in);
    }

    private double addition(double a, double b) {
        double c = a + b;
        System.out.println(a + " + " + b + " = " + c);
        return c;
    }

    private double subtraction(double a, double b) {
        double c = a - b;
        System.out.println(a + " - " + b + " = " + c);
        return c;
    }

    private double multiplication(double a, double b) {
        double c = a * b;
        System.out.println(a + " * " + b + " = " + c);
        return c;
    }

    private double division(double a, double b) {
        double c = a / b;
        System.out.println(a + " / " + b + " = " + c);
        return c;
    }

    private void saveInMemory() {
        memory = result;
    }

    private void showCurrentStatus() {
        System.out.println("Result: " + result + ". Memory: " + memory + ".");
    }


    public void start() {
        if (!turnedOn) {
            turnedOn = true;
            System.out.println("START");
            result = getNumber();
        }

        showCurrentStatus();

        int action = selectOperation();
        if (action == 5) {
            saveInMemory();
            start();
        } else if (action == 6) {
            System.out.println("EXIT. Result = " + result + ".");
            turnedOn = false;
        }

        if (turnedOn){
            double enteredNumber = getNumber();
            switch (action) {
                case 1:
                    result = addition(result, enteredNumber);
                    start();
                    break;
                case 2:
                    result = subtraction(result, enteredNumber);
                    start();
                    break;
                case 3:
                    result = multiplication(result, enteredNumber);
                    start();
                    break;
                case 4:
                    result = division(result, enteredNumber);
                    start();
                    break;
                default:
                    System.out.println("Error.");
                    break;
            }
        }
    }

    private int selectOperation() {
        System.out.println("Select operation:" +
                "\n1 - Addition" +
                "\n2 - Subtraction" +
                "\n3 - Multiplication" +
                "\n4 - Division" +
                "\n5 - Save in memory" +
                "\n6 - Exit"
        );
        int myNumber;
        if (scanner.hasNextInt()) {
            myNumber = scanner.nextInt();
            if (myNumber < 1 || myNumber > 6) {
                System.out.println("You entered invalid value!");
                selectOperation();
                return 0;
            } else {
                return myNumber;
            }
        } else {
            System.out.println(scanner.nextLine());
            System.out.println("You entered invalid value!");
            selectOperation();
            return 0;
        }
    }

    private double getNumber() {
        System.out.println("Enter a number or enter \"M\" to select a number from memory.");
        if (scanner.hasNextDouble()) {
            return scanner.nextDouble();
        } else {
            String line = skipEmptyLine();
            if (line.equals("M")) {
                return memory;
            } else {
                System.out.println("It was not a number!");
                return getNumber();
            }
        }
    }

    private String skipEmptyLine(){
        String line = scanner.nextLine();
        if (line.equals("")){
            return skipEmptyLine();
        } else {
            return line;
        }
    }
}
