package com.salihpolat;

import java.util.Scanner;

public class EnBuyukEnKucukSayi {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Kaç Tane Sayı Sireceksiniz? ");

        int n = input.nextInt();

        if (n <= 0) {
            System.out.println("Lütfen Pozitif Bir Tamsayı Girin.");
            return;
        }

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            System.out.print((i + 1) + ". Sayıyı Girin: ");
            int sayi = input.nextInt();

            if (sayi < min) {
                min = sayi;
            }
            if (sayi > max) {
                max = sayi;
            }
        }

        System.out.println("En Küçük Sayı: " + min);
        System.out.println("En Büyük Sayı: " + max);

        input.close();
    }
}