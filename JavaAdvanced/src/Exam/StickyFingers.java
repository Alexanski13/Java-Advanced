package Exam;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class StickyFingers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] commands = scanner.nextLine().split(",");


        char[][] matrix = new char[size][size];

        int thiefRow = 0;
        int thiefCol = 0;
        for (int row = 0; row < size; row++) {
            List<Character> characterList = Arrays.stream(scanner.nextLine().split(" "))
                    .map(e -> e.charAt(0))
                    .collect(Collectors.toList());

            for (int col = 0; col < characterList.size(); col++) {
                char currentChar = characterList.get(col);
                if (currentChar == 'D') {
                    thiefRow = row;
                    thiefCol = col;
                    currentChar = '+';
                }
                matrix[row][col] = currentChar;
            }
        }

        int totalMoney = 0;
        boolean caughtLacking = false;
        for (int i = 0; i < commands.length; i++) {
            switch (commands[i]) {
                case "up":
                    if (thiefRow != 0) {
                        matrix[thiefRow][thiefCol] = '+';
                        thiefRow--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "down":
                    if (thiefRow != size - 1) {
                        matrix[thiefRow][thiefCol] = '+';
                        thiefRow++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "right":
                    if (thiefCol != size - 1) {
                        matrix[thiefRow][thiefCol] = '+';
                        thiefCol++;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
                case "left":
                    if (thiefCol != 0) {
                        matrix[thiefRow][thiefCol] = '+';
                        thiefCol--;
                    } else {
                        System.out.println("You cannot leave the town, there is police outside!");
                    }
                    break;
            }

            if (matrix[thiefRow][thiefCol] == '$') {
                int stolenMoney = thiefRow * thiefCol;
                totalMoney += stolenMoney;
                System.out.printf("You successfully stole %d$.%n", stolenMoney);
            } else if (matrix[thiefRow][thiefCol] == 'P') {
                matrix[thiefRow][thiefCol] = '#';
                caughtLacking = true;
                break;
            }
            matrix[thiefRow][thiefCol] = 'D';
        }
        if (!caughtLacking) {
            System.out.printf("Your last theft has finished successfully with %d$ in your pocket.%n", totalMoney);
        } else {
            System.out.printf("You got caught with %d$, and you are going to jail.%n", totalMoney);
        }

        for (char[] arr : matrix) {
            for (char c : arr) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }
}
