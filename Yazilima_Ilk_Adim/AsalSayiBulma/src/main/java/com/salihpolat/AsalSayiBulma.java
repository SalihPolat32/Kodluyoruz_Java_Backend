package com.salihpolat;

import java.util.Scanner;

public class AsalSayiBulma {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Sayı Giriniz: ");
        int sayi = scanner.nextInt();
        scanner.close();

        if (asalMi(sayi)) {
            System.out.println(sayi + " sayısı ASALDIR !");
        } else {
            System.out.println(sayi + " sayısı ASAL değildir !");
        }
    }

    public static boolean asalMi(int sayi) {
        if (sayi <= 1) {
            return false;
        }
        return asalMiYardimci(sayi, sayi - 1);
    }

    private static boolean asalMiYardimci(int sayi, int bolen) {
        if (bolen == 1) {
            return true;
        }
        if (sayi % bolen == 0) {
            return false;
        }
        return asalMiYardimci(sayi, bolen - 1);
    }
}