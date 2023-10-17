package com.salihpolat;

import java.util.Scanner;

public class VucutKitleIndeksiHesaplama {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Lütfen Kilonuzu (kg) Giriniz: ");
        double kilo = scanner.nextDouble();

        System.out.print("Lütfen Boyunuzu (metre Cinsinden) Giriniz: ");
        double boy = scanner.nextDouble();

        double vucutKitleIndeksi = kilo / (boy * boy);

        System.out.println("Vücut Kitle İndeksi: " + vucutKitleIndeksi);

        scanner.close();
    }
}