package task1_2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[][] arr1 = new int[5][5];
        for (int i = 0; i < arr1.length; i++) {
            for(int j = 0; j < arr1[i].length; j++){
                arr1[i][j] = (int)(Math.random()*98 - 1);

            }
        }
        printArr(arr1);
        int[][] arr2 = turnArray(arr1);
        System.out.println("\nNew array:");
        printArr(arr2);
    }

    private static void printArr(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++){
                if(arr[i][j] < 10){
                    System.out.print(arr[i][j] + "  ");
                } else {
                    System.out.print(arr[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static int[][] turnArray(int[][] arrOld){
        int[][] arrNew = new int[arrOld.length][arrOld[1].length];
        for (int i = 0; i < arrNew.length; i++) {
            for (int j = 0; j < arrNew[i].length; j++) {
                arrNew[i][j] = arrOld[arrOld.length-j-1][i];
            }
        }
        return arrNew;
    }
}
