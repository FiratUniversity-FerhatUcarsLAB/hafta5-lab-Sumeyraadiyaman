/*
 * Ad Soyad: [Sümeyra Adıyaman]
 * Ogrenci No: [250541012]
 * Tarih: [12.11.2025]
 * Aciklama: Gorev 3 - E-Ticaret Sepet Hesaplayici
 *
 * Bu program 3 adet urunun sepet tutarini
 * KDV, indirim ve kargo dahil hesaplar.
 */

import java.util.Scanner;

public class SepetHesap {


    //Sabitleri Tanımlarız
    final static double KDV_ORANI = 0.18; //KDV oranı(%18)
    final static double KARGO_UCRETI = 29.99; //Sabit kargo ücreti (TL)

    //METOTLARI TANIMLIYORUZ
    //Metot1: bir ürünün toplam fiyatını hesaplar (fiyat * adet)
    public static double satirToplamiHesapla(double birimFiyat , double adet){
        return birimFiyat * adet;
    }

    //Metot2: sepetteki üç ürünün ara toplamını hesaplar
    public static double araToplamHesapla(double satir1, double satir2 , double satir3){
        return satir1 + satir2 + satir3;
    }

    //Metot3:İndirim tutarını hesaplar
    public static double indirimTutariHesapla(double araToplam , double indirimYuzdesi){
        return araToplam * (indirimYuzdesi/100);
    }

    //Metot4:İndirimli toplamı hesaplar
    public static double indirimUygula(double araToplam , double indirimTutari){
        return araToplam - indirimTutari;
    }

    //Metot5: KDV tutarını hesaplar
    public static double kdvHesapla(double indirimToplam , double kdvOrani){
        return indirimToplam * kdvOrani;
    }

    //Metot6: Genel Toplamı Hesaplar
    public static double genelToplamHesapla(double indirimliToplam , double kdvTutari , double kargoUcreti){
        return indirimliToplam + kdvTutari + kargoUcreti;
    }



    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("=== E-TİCARET SEPET HESAPLAYICI ===");
        System.out.println("\nLütfen 3 Ürünün Bilgilerini Giriniz");

        //ÜRÜN1 İÇİN DEĞERLER
        System.out.println("\nÜrün 1: ");
        System.out.print(" Ürünün Birim Fiyatını Giriniz (TL): ");
        double fiyat1 = input.nextDouble();
        System.out.print(" Ürünün Kaç Adet Olduğunu Giriniz: ");
        int adet1 = input.nextInt();

        //ÜRÜN2 İÇİN DEĞERLER
        System.out.println("\nÜrün 2: ");
        System.out.print(" Ürünün Birim Fiyatını Giriniz (TL): ");
        double fiyat2 = input.nextDouble();
        System.out.print(" Ürünün Kaç Adet Olduğunu Giriniz: ");
        int adet2 = input.nextInt();

        //ÜRÜN3 İÇİN DEĞERLER
        System.out.println("\nÜrün 3: ");
        System.out.print(" Ürünün Birim Fiyatını Giriniz (TL): ");
        double fiyat3 = input.nextDouble();
        System.out.print(" Ürünün Kaç Adet Olduğunu Giriniz: ");
        int adet3 = input.nextInt();

        //İNDİRİM TUTARI HESAPLAMA
        System.out.print("\nİndirim Kuponu Yüzdesi Giriniz (%): ");
        double indirimYuzdesi = input.nextDouble();

        //HESAPLAMALAR

        double urun1Toplam = satirToplamiHesapla(fiyat1 , adet1);
        double urun2Toplam = satirToplamiHesapla(fiyat2 , adet2);
        double urun3toplam = satirToplamiHesapla(fiyat3 , adet3);

        double araToplam = araToplamHesapla(urun1Toplam , urun2Toplam , urun3toplam);
        double indirimTutari = indirimTutariHesapla(araToplam , indirimYuzdesi);
        double indirimliToplam = indirimUygula(araToplam , indirimTutari);
        double kdvTutari = kdvHesapla(indirimliToplam , KDV_ORANI);
        double genelToplam = genelToplamHesapla(indirimliToplam , kdvTutari , KARGO_UCRETI);

        //SONUÇLARI EKRANA YAZDIR

        System.out.println("\n===========================================");
        System.out.println("               SİPARİŞ ÖZETİ               ");
        System.out.println("===========================================");

        System.out.printf("Ürün 1 Toplam Fiyat (%.2f TL x %d): %.2f TL\n" , fiyat1 , adet1 , urun1Toplam);
        System.out.printf("Ürün 2 Toplam Fiyat (%.2f TL x %d): %.2f TL\n" , fiyat2 , adet2 , urun2Toplam);
        System.out.printf("Ürün 3 Toplam Fiyat (%.2f TL x %d): %.2f TL\n" , fiyat3 , adet3 , urun3toplam);
        System.out.println("___________________________________________");

        System.out.printf("Ara Toplam                        : %.2f TL\n" , araToplam);
        //İndirim Tutarını Çıkarırken (%%%.0f) kullan yoksa hata veriyor + indirimi çıkaracağımız için %.2f başına (-) ekliyoruz
        System.out.printf("\nİndirim Tutarı (%%%.0f)              :  -%.2f TL\n" , indirimYuzdesi , indirimTutari);
        System.out.printf("İndirimli Toplam Tutar            : %.2f TL\n" , indirimliToplam);

        //Kdc ve kargo ücretinde tutarı ekleyeceğimiz için (+) kullan
        System.out.printf("\nKDV Tutarı (%%%.0f)                  : +%.2f TL\n" , (KDV_ORANI * 100) , kdvTutari );
        System.out.printf("Kargo Ücreti                      : +%.2f TL\n" , KARGO_UCRETI);

        System.out.println("___________________________________________");

        System.out.printf("GENEL TOPLAM                      : %.2f TL\n" , genelToplam);
        System.out.println("===========================================");

        input.close();
    }
}
