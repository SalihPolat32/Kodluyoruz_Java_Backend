package com.salihpolat;

import java.util.Scanner;

public class UcakBiletiHesaplama {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Kullanıcıdan mesafe, yaş ve yolculuk tipi bilgilerini al
        System.out.print("Mesafe (KM): ");
        int mesafe = input.nextInt();

        System.out.print("Yaşınız: ");
        int yas = input.nextInt();

        System.out.print("Yolculuk Tipi (1: Tek Yön, 2: Gidiş-Dönüş): ");
        int yolculukTipi = input.nextInt();

        input.close();

        // Hatalı veri kontrolü
        if (mesafe <= 0 || yas <= 0 || (yolculukTipi != 1 && yolculukTipi != 2)) {
            System.out.println("Hatalı Veri Girdiniz!");
            return;
        }

        // Mesafe başına ücret
        double birimFiyat = 0.10;

        // Toplam fiyat hesaplama
        double toplamFiyat = mesafe * birimFiyat;

        // Yaş indirimleri
        if (yas < 12) {
            toplamFiyat *= 0.5; // %50 indirim
        } else if (yas >= 12 && yas <= 24) {
            toplamFiyat *= 0.9; // %10 indirim
        } else if (yas >= 65) {
            toplamFiyat *= 0.7; // %30 indirim
        }

        // Yolculuk tipi indirimi
        if (yolculukTipi == 2) {
            toplamFiyat *= 0.8; // %20 indirim
        }

        // Sonuçları yazdır
        System.out.println("Toplam Bilet Fiyatı: " + toplamFiyat + " TL");
    }
}