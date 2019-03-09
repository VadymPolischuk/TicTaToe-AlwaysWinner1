package com.company;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        int n = 3;
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = 0;
            }
        }
        ShowField(a, n);
        for (int i = 0; i < n * n; i++) {
            NextMove(a, i % 2 + 1);
            ShowField(a, n);
            if (CheckVictory(a, n, i % 2 + 1))
                System.out.println("Winner is " + ((i % 2 + 1) == 1 ? "Player 1" : "Player 2"));

        }

    }

    public static void ShowField(int a[][], int n) {
        System.out.println("\n\n");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("\t" + (a[i][j] == 0 ? " " : (a[i][j] == 1 ? "X" : " O")));
            }
            System.out.println();
        }
    }

    public static void NextMove(int[][] a, int m) {
        Random random = new Random();
        int moveX;
        int moveY;
        while (a[moveX = random.nextInt(3)][moveY = random.nextInt(3)] != 0) {
            moveX = random.nextInt(3);
            moveY = random.nextInt(3);

        }
        a[moveX][moveY] = m;
    }

    public static boolean CheckVictory(int a[][], int n, int m) {
        int c = 0;
        int i;
        boolean isVictory = false;
        for (i = 0; i < n; i++) {
            c = 0;
            for (int j = 0; j < n; j++) {
                if (a[j][i] == m) {
                    c++;
                }
                if (c == 2)
                    return true;

            }

        }
        for (i = 0; i < n; i++) {
            c = 0;

            for (int j = 0; j < n; j++) {
                if (a[j][j] == m)
                    c++;

            }
            if (c == 2)
                return true;

        }
        for (i = 0; i < n; i++) {
            if (a[i][i] == m) c++;
            if (c == 2)
                return true;


        }
        for (i = n-1; i >= 0; i--) {
            if(a[i][i]==m) c++;
            if(c==2) return true;

        }
        return false;
    }


}
