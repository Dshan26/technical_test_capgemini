package org.example;


public class Main3 {
    static int[] myArray = {1, 2, 9, 2, 5, 3, 5, 1, 5};
    static int n = 3;

    public static void main(String[] args) {
        int[][] matrixprincipal1 = new int[n][n];
        int tamValue1 = 0;

        {
            int i = 0;
            while (i < n) {
                for (int j = 0; j < n; j++) {
                    matrixprincipal1[i][j] = myArray[tamValue1++];
                }
                i++;
            }
        }

        int[][] varNum1 = new int[n][n];

        for (int i = 0; i < n; i++) {
            varNum1[i][0] = matrixprincipal1[i][0];
        }

        for (int col = 1; col < n; col++) {
            for (int row = 0; row < n; row++) {
                varNum1[row][col] = matrixprincipal1[row][col] + varNum1[row][col - 1];
                if (row - 1 >= 0) {
                    varNum1[row][col] = Math.min(varNum1[row][col], matrixprincipal1[row][col] + varNum1[row - 1][col - 1]);
                }
                if (row + 1 < n) {
                    varNum1[row][col] = Math.min(varNum1[row][col], matrixprincipal1[row][col] + varNum1[row + 1][col - 1]);
                }
            }
        }

        int minRow = 0;
        int minSum = varNum1[0][n - 1];

        for (int i = 1; i < n; i++) {
            if (varNum1[i][n - 1] < minSum) {
                minSum = varNum1[i][n - 1];
                minRow = i;
            }
        }

        int[] myNameArray = new int[n];
        myNameArray[n - 1] = minRow;

        for (int col = n - 1; col > 0; col--) {
            int current = varNum1[minRow][col] - matrixprincipal1[minRow][col];
            if (minRow - 1 >= 0 && varNum1[minRow - 1][col - 1] == current) {
                minRow--;
            } else if (minRow + 1 < n && varNum1[minRow + 1][col - 1] == current) {
                minRow++;
            }
            myNameArray[col - 1] = minRow;
        }

        for (int i = 0; i < n; i++) {
            System.out.print(matrixprincipal1[myNameArray[i]][i]);
            if (i < n - 1) {
                System.out.print(" ");
            }
        }
    }
}
