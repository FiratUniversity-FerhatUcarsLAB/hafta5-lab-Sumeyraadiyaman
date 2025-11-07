/*
 * Ad Soyad: [Sümeyra Adıyaman]
 * Ogrenci No: [250541012]
 * Tarih: [07.11.2025]
 * Aciklama: Gorev 1 - Geometrik Sekil Hesaplayici
 * 
 * Bu program temel geometrik sekillerin alan ve
 * cevre hesaplamalarini yapar.
 */

package GeometrikSekilHesaplayici;

import java.util.Scanner;

public class GeometrikSekilHesaplayici {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.println(" ");
        System.out.println("========== GEOMETRİK ŞEKİL HESAPLAYICI ==========");
        System.out.println(" ");

        // Kare Hesaplamaları
        System.out.print("Karenin Kenar Uzunluğunu Giriniz: ");
        double kenar_uzunlugu = scan.nextDouble();
        System.out.println(" ");
        System.out.println("====== KARE SONUÇLARI ======");
        double kare_alan = calculateSquareArea(kenar_uzunlugu);
        double kare_cevre = calculateSquarePerimeter(kenar_uzunlugu);
        System.out.printf("Karenin Alanı: %.2f\n", kare_alan);
        System.out.printf("Karenin Çevresi: %.2f\n", kare_cevre);


        // Dikdörtgen Hesaplamaları
        System.out.println();
        System.out.print("Dikdörtgenin Kısa Kenarını Giriniz: ");
        double kisa_kenar = scan.nextDouble();
        System.out.print("Dikdörtgenin Uzun Kenarını Giriniz: ");
        double uzun_kenar = scan.nextDouble();
        System.out.println(" ");
        System.out.println("====== DİKDÖRTGEN SONUÇLARI ======");
        double dikdortgen_alan = calculateRectangleArea(kisa_kenar, uzun_kenar);
        double dikdortgen_cevre = calculateRectanglePerimeter(kisa_kenar, uzun_kenar);
        System.out.printf("Dikdörtgenin Alanı: %.2f\n", dikdortgen_alan);
        System.out.printf("Dikdörtgenin Çevresi: %.2f\n", dikdortgen_cevre);


        // Daire Hesaplamaları
        System.out.println();
        System.out.print("Dairenin Yarıçapını Giriniz: ");
        double r = scan.nextDouble();
        System.out.println(" ");
        System.out.println("====== DAİRE SONUÇLARI ======");
        double daire_alan = calculateCircleArea(r);
        double daire_cevre = calculateCircleCircumference(r);
        System.out.printf("Dairenin Alanı: %.2f\n", daire_alan);
        System.out.printf("Dairenin Çevresi: %.2f\n", daire_cevre);


        // Üçgen Hesaplamaları
        System.out.println();
        System.out.print("Üçgenin 1. Kenarını Giriniz: ");
        double kenar1 = scan.nextDouble();
        System.out.print("Üçgenin 2. Kenarını Giriniz: ");
        double kenar2 = scan.nextDouble();
        System.out.print("Üçgenin 3. Kenarını Giriniz: ");
        double kenar3 = scan.nextDouble();
        System.out.println(" ");
        System.out.println("====== ÜÇGEN SONUÇLARI ======");
        double s = (kenar1 + kenar2 + kenar3) / 2;
        double ucgen_alan = calculateTriangleArea(kenar1, kenar2, kenar3, s);
        double ucgen_cevre = calculateTrianglePerimeter(kenar1, kenar2, kenar3);
        System.out.printf("Üçgenin Çevresi: %.2f\n", ucgen_cevre);
        System.out.printf("Üçgenin Alanı: %.2f\n", ucgen_alan);
        System.out.println(" ");
        System.out.println("=============================================");


        scan.close();
    }

    // Kare alan hesaplama
    public static double calculateSquareArea(double kenar_uzunlugu) {
        return kenar_uzunlugu * kenar_uzunlugu;
    }

    // Kare çevre hesaplama
    public static double calculateSquarePerimeter(double kenar_uzunlugu) {
        return 4 * kenar_uzunlugu;
    }

    // Dikdörtgen alan hesaplama
    public static double calculateRectangleArea(double kisa_kenar, double uzun_kenar) {
        return kisa_kenar * uzun_kenar;
    }

    // Dikdörtgen çevre hesaplama
    public static double calculateRectanglePerimeter(double kisa_kenar, double uzun_kenar) {
        return 2 * (kisa_kenar + uzun_kenar);
    }

    // Daire alan hesaplama
    public static double calculateCircleArea(double r) {
        return Math.PI * r * r;
    }

    // Daire çevre hesaplama
    public static double calculateCircleCircumference(double r) {
        return 2 * Math.PI * r;
    }

    // Üçgen alan hesaplama (Heron formülü)
    public static double calculateTriangleArea(double kenar1, double kenar2, double kenar3, double s) {
        return Math.sqrt(s * (s - kenar1) * (s - kenar2) * (s - kenar3));
    }

    // Üçgen çevre hesaplama
    public static double calculateTrianglePerimeter(double kenar1, double kenar2, double kenar3) {
        return kenar1 + kenar2 + kenar3;
    }
}
