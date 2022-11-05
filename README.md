# diyetProgram
/*

    *** BMI - Vucut Kitle Indeksi ***
    kilo/(boy*boy)  --- boy metre cinsinden hesaplamaya dahil edilecek


    *** Bazal Metabolizma Hizi Hesaplama ***

    Kadin = (10*kilo) + (6.25*boy)-(5*yas)-161
    Erkek = (10*kilo) + (6.25)-(5*yas)+5
        Note : boy cantimetre cinsinden hesaplamaya dahil edilecek


    *** Hareket / Aktivite seviyeleri ***
    1 - Masa basi is / cak az - Hareketsiz  = 1.2
    2 - Az Aktif / haftada 1-2 egzersiz     = 1.3
    3 - Orta Aktif / haftada 3-5 egzersiz   = 1.55
    4 - Cok aktif / haftada 6-7agir egzersiz= 1.7
    5 - Cok agir egzesiz agir is            = 1.9

    *** Alinmasi gerekli kalori miktari hesaplama ---

    *** Zayif ve normaller icin ***
    BMI < 25 ise = Bazal Metabolizma Hizi * Hareket Seviyesi

    **** Zayiflamak icin ****
    BMI > 25 ise
    A = Bazal Metabolizma Hizi * Haretet Seviyesi - 500
    B = Bazal Metabolizma Hizi * Haretet Seviyesi - 750

    Kisi gunluk olarak "Bazal metabolizma" hizindan dusuk kalori alamaz
    Yani A ve B  Bazal Meytabolizma Hizindan kucuk ise = gunluk Bazal Meytabolizma Hizi kadar kalori almali
    Yani A ve B  Bazal Meytabolizma Hizindan buyuk ise = gunluk A ve B degerleri arasinda kalori almali
    B kBazal Meytabolizma Hizindan kucuk ise = gunluk Bazal Meytabolizma Hizi ile A degeri arasinda kalori almali

    Kullanicidan alinacak input datalar
    1-Cinsiye   2-Yas   3-Boy   4  -kilo    5-Hareket seviyesi


     */

