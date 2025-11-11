/*
 * Ad Soyad: [SÜMEYRA ADIYAMAN]
 * Ogrenci No: [250541012]
 * Tarih: [11.11.2025]
 * Aciklama: Gorev 2 - Fizik Formulu Asistani
 *
 * Bu program temel fizik formullerini kullanarak
 * hesaplamalar yapar.
 */

import java.util.Scanner;

public class FizikFormul {

    // Sabitler
    final static double GRAVITY = 9.8;
    final static double KE_SBT = 0.5;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("==== FİZİK FORMUL ASISTANI =====\n");

        // KULLANICIDAN ALINACAK TEMEL ÖLÇÜMLER
        System.out.println("TEMEL ÖLÇÜMLER");
        System.out.print("Kütle(kg): ");
        double kutle = input.nextDouble();

        System.out.print("Mesafe(m): ");
        double mesafe = input.nextDouble();

        System.out.print("Zaman(t): ");
        double zaman = input.nextDouble();

        System.out.print("Hız Değişimi(m/s): ");
        double hızDegisimi = input.nextDouble();

        System.out.print("Yükseklik(h): ");
        double yukseklik = input.nextDouble();

        // HESAPLAMALAR
        double hız = calculateVelocity(mesafe, zaman);
        double ivme = calculateAcceleration(hızDegisimi, zaman);
        double kuvvet = calculateForce(kutle, ivme);
        double iş = calculateWork(kuvvet, mesafe);
        double guc = calculatePower(iş, zaman);
        double KE = calculateKineticEnergy(KE_SBT, kutle, hız);
        double PE = calculatePotentialEnergy(kutle, GRAVITY, yukseklik);
        double momentum = calculateMomentum(kutle, hız);

        // SONUÇLARI YAZDIR
        System.out.println("\n_________________________________________________");
        System.out.println("============== HESAPLAMA SONUÇLARI ===============\n");

        System.out.println("HIZ ve HAREKET:");
        System.out.printf("  Hız (v = s/t)             : %.2f m/s\n", hız);
        System.out.printf("  İvme (a = Δv/t)           : %.2f m/s²\n", ivme);

        System.out.println("\nKUVVET ve İŞ:");
        System.out.printf("  Kuvvet (F = m*a)          : %.2f N\n", kuvvet);
        System.out.printf("  İş (W = F*d)              : %.2f J\n", iş);
        System.out.printf("  Güç (P = W/t)             : %.2f W\n", guc);

        System.out.println("\nENERJİ:");
        System.out.printf("  Kinetik Enerji (KE)       : %.2f J\n", KE);
        System.out.printf("  Potansiyel Enerji (PE)    : %.2f J\n", PE);
        System.out.printf("  Toplam Enerji (ME)        : %.2f J\n", (PE + KE));

        System.out.println("\nMOMENTUM:");
        System.out.printf("  Momentum (p = m*v)        : %.2f kg·m/s\n", momentum);

        System.out.println("\n========================================");

        input.close();
    }

    // Fonksiyonlar
    public static double calculateVelocity(double mesafe, double zaman) {
        return mesafe / zaman;
    }

    public static double calculateAcceleration(double hızDegisimi, double zaman) {
        return hızDegisimi / zaman;
    }

    public static double calculateForce(double kutle, double ivme) {
        return kutle * ivme;
    }

    public static double calculateWork(double kuvvet, double mesafe) {
        return kuvvet * mesafe;
    }

    public static double calculatePower(double is, double zaman) {
        return is / zaman;
    }

    public static double calculateKineticEnergy(double KE_SBT, double kutle, double hız) {
        return KE_SBT * kutle * Math.pow(hız, 2);
    }

    public static double calculatePotentialEnergy(double kutle, double GRAVITY, double yukseklik) {
        return kutle * GRAVITY * yukseklik;
    }

    public static double calculateMomentum(double kutle, double hız) {
        return kutle * hız;
    }
}
