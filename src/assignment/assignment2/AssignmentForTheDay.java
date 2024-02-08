package assignment.assignment2;

import java.util.Arrays;
import java.util.Scanner;

public class AssignmentForTheDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Length of Array: ");
        int length = scanner.nextInt();
        System.out.print("Min Random Number: ");
        int min = scanner.nextInt();
        System.out.print("Max Random Number: ");
        int max = scanner.nextInt();
        scanner.close();

        int[] randNum = new int[length];
        randNum = generateNumber(randNum, length, max, min);
        System.out.println(Arrays.toString(randNum));

        selectionSort(randNum);
        System.out.println(Arrays.toString(randNum));

        getMean(randNum);
        getMode(randNum);
        getMedian(randNum);
    }

    public static void getMedian(int[] num) {
        int median;

        if (num.length % 2 == 0) {
            median = (num.length + 1) / 2;
        } else {
            median = (num.length / 2 + (num.length / 2 + 1)) / 2;
        }

        System.out.println("Median = " + num[median]);
    }

    public static void getMode(int[] num) {
        int[] mode = new int[num.length];
        int frequencyMode = 1;
        int modeLength = 0;
        int[][] tempMode = new int[num.length][2];
        int tempModeLength = 0;

        for (int i = 0, j = 0; i < num.length; i++) {
            if (i == 0 || tempMode[j][0] != num[i]) {
                tempMode[j][0] = num[i];
                tempMode[j][1] = 1;
            } else
                ;

            if (i < num.length - 1 && tempMode[j][0] == num[i + 1]) {
                tempMode[j][1]++;
            } else {
                j++;
                tempModeLength++;
            }
        }

        tempMode = selectionSort(tempMode, tempModeLength);

        for (int i = tempModeLength - 1, j = 0; i >= 0; i--) {
            if (i < tempModeLength - 1) {
                if (frequencyMode == tempMode[i][1]) {
                    mode[j] = tempMode[i][0];
                    j++;
                } else{
                    modeLength = j;
                    break;
                }   
            } else {
                mode[j] = tempMode[i][0];
                frequencyMode = tempMode[i][1];
                j++;
            }

            modeLength = j;
        }

        System.out.print("Mode = ");
        for (int i = 0; i < modeLength; i++) {
            System.out.print(mode[i] + ", ");
        }

        System.out.println("");
    }

    public static void getMean(int[] num) {
        double sum = 0;

        for (int i = 0; i < num.length; i++) {
            sum += num[i];
        }

        System.out.printf("Mean = %.1f\n", (sum / num.length));
    }

    public static int[][] selectionSort(int[][] num, int size) {
        int temp, index, tempIndex;

        for (int i = 0; i < size; i++) {
            index = findMinIdx(num, i, size);
            temp = num[i][0];
            tempIndex = num[i][1];
            num[i][0] = num[index][0];
            num[i][1] = num[index][1];
            num[index][0] = temp;
            num[index][1] = tempIndex;
        }

        return num;
    }

    public static int findMinIdx(int[][] num, int minIdx, int size) {

        for (int i = minIdx; i < size; i++) {
            if (num[i][1] < num[minIdx][1]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

    public static int[] generateNumber(int[] num, int length, int max, int min) {
        double randomNum;

        for (int i = 0; i < length; i++) {

            // You can try check using min = 11 and max = 12 to see the difference between
            // this 2 code.
            // This is due to double number being change into integer. Where the double
            // number were not round off to nearest number.
            randomNum = Math.random() * (max - min + 1) + min; // This give high chance for max number to be trigger due
                                                               // to percentage
            // randomNum = Math.random() * (max - min) + min; // This give very low chance
            // for max number to be trigger
            // System.out.println(randomNum);
            num[i] = (int) randomNum;
        }

        return num;
    }

    public static int[] selectionSort(int[] num) {
        int temp, index;

        for (int i = 0; i < num.length; i++) {
            index = findMinIdx(num, i);
            temp = num[i];
            num[i] = num[index];
            num[index] = temp;
        }
        return num;
    }

    public static int findMinIdx(int[] num, int minIdx) {

        for (int i = minIdx; i < num.length; i++) {
            if (num[i] < num[minIdx]) {
                minIdx = i;
            }
        }
        return minIdx;
    }

}
