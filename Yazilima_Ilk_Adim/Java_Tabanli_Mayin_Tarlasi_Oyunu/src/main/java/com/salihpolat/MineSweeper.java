package com.salihpolat;

import java.util.Scanner;
import java.util.Random;

public class MineSweeper {
    private int[][] minefield;
    private boolean[][] revealed;
    private int numRows;
    private int numCols;
    private int numMines;

    public MineSweeper(int numRows, int numCols, int numMines) {
        this.numRows = numRows;
        this.numCols = numCols;
        this.numMines = numMines;
        this.minefield = new int[numRows][numCols];
        this.revealed = new boolean[numRows][numCols];
        initializeMinefield();
    }

    public void initializeMinefield() {
        // Mayınları rastgele yerleştir
        Random random = new Random();
        int placedMines = 0;
        while (placedMines < numMines) {
            int row = random.nextInt(numRows);
            int col = random.nextInt(numCols);
            if (minefield[row][col] != -1) {
                minefield[row][col] = -1;
                placedMines++;
            }
        }

        // Mayınlar etraflarına +1 ekler
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (minefield[i][j] == -1) {
                    incrementAdjacentCells(i, j);
                }
            }
        }
    }

    public void incrementAdjacentCells(int row, int col) {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newRow = row + i;
                int newCol = col + j;
                if (newRow >= 0 && newRow < numRows && newCol >= 0 && newCol < numCols
                        && minefield[newRow][newCol] != -1) {
                    minefield[newRow][newCol]++;
                }
            }
        }
    }

    public void display() {
        System.out.println("===========================");
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (revealed[i][j]) {
                    if (minefield[i][j] == -1) {
                        System.out.print("* ");
                    } else {
                        System.out.print(minefield[i][j] + " ");
                    }
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println();
        }
        System.out.println("===========================");
    }

    public boolean isGameWon() {
        int safeCells = numRows * numCols - numMines;
        int revealedCells = 0;

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                if (revealed[i][j]) {
                    revealedCells++;
                }
            }
        }

        return safeCells == revealedCells;
    }

    public void play() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            display();
            System.out.print("Satır Giriniz: ");
            int row = scanner.nextInt();
            System.out.print("Sütun Giriniz: ");
            int col = scanner.nextInt();

            if (row < 0 || row >= numRows || col < 0 || col >= numCols) {
                System.out.println("Geçersiz koordinatlar. Tekrar deneyin.");
                continue;
            }

            if (revealed[row][col]) {
                System.out.println("Bu hücre zaten açıldı. Başka bir hücre seçin.");
                continue;
            }

            if (minefield[row][col] == -1) {
                display();
                System.out.println("Game Over!!");
                break;
            }

            revealed[row][col] = true;

            if (isGameWon()) {
                display();
                System.out.println("Oyunu Kazandınız !");
                break;
            }
        }

        scanner.close();
    }

    public static void main(String[] args) {
        System.out.println("Mayın Tarlası Oyuna Hoşgeldiniz !");
        MineSweeper game = new MineSweeper(4, 3, 3); // Örnek: 4x3 boyutunda ve 3 mayınla oyunu başlat
        game.play();
    }
}