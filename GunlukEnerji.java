package DiyetProgrami;

import java.util.Scanner;

public class GunlukEnerji {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Lufen cinsiystinizi giriniz..\nErkek = E\nKadin = K");
        char cinsiyet = input.next().toUpperCase().charAt(0);
        System.out.println("Lutfen yasinizi giririz...");
        int yas = input.nextInt();
        System.out.println("Lutfen kilonuzu giririz...");
        double kilo = input.nextDouble();
        System.out.println("Lutfen boyunuzu cm olatak giririz. Ornek = 175 cm");
        double boyCm = input.nextDouble();
        double boyM = boyCm / 100;

       // GunlukEnerji bMI = new GunlukEnerji();
        double bMISonuc = bMIHesap(kilo, boyM);

        if (bMISonuc < 18.5) {
            System.out.println("BMI : " + bMISonuc + "  Zayifsiniz.");
        } else if (bMISonuc < 25) {
            System.out.println("BMI : " + bMISonuc + "  Normalsiniz.");
        } else if (bMISonuc < 30) {
            System.out.println("BMI : " + bMISonuc + "  Kilolusunuz.");
        } else if (bMISonuc < 35) {
            System.out.println("BMI : " + bMISonuc + "  Obez.");
        } else if (bMISonuc < 40) {
            System.out.println("BMI : " + bMISonuc + "  Ileri derecede obez.");
        } else if (bMISonuc >= 40) {
            System.out.println("BMI : " + bMISonuc + "  Morbid obez.");
        }
        System.out.println("--------------------------------------");

        System.out.println("Lutfen hareket/aktivite seviyenizi girirniz.\n--------------------------------------\n" +
                "1 - Masa basi is cok az/hareketsiz\n2 - Az aktif / haftada bir/iki egzersiz." +
                "\n3 - Orta aktif / haftada uc/bes egzersiz.\n4 - Cok aktif haftada yedi/sekiz egzersiz." +
                "\n5 - Agir is / Cok agir egzersiz. \n--------------------------------------  ");

        int hareket = input.nextInt();

        double hrkDeger = 0;
        switch (hareket) {
            case 1: hrkDeger = 1.2;
                break;
            case 2: hrkDeger = 1.3;
                break;
            case 3: hrkDeger = 1.55;
                break;
            case 4: hrkDeger = 1.7;
                break;
            case 5: hrkDeger = 1.9;
                break;
            default:
                System.out.println("Lutfen gecerli deger giriniz..");
        }

        double bMHiziKadin = bMHiziKadin(kilo, boyCm, yas);
        double bMHiziErkek = bMHiziErkek(kilo, boyCm, yas);

        double erkekEnerji = bMHiziErkek * hrkDeger;    // BMI 25'den kucuk olanlar icin Gunluk Enerji Miktari
        double bMIErkA = bMHiziErkek * hrkDeger - 500;
        double bMIErkB = bMHiziErkek * hrkDeger - 750;

        double kadinEnerji = bMHiziKadin * hrkDeger;   // BMI 25'den kucuk olanlar icin Gunluk Enerji Miktari
        double bMIKdnA = bMHiziKadin * hrkDeger - 500;
        double bMIKdnB = bMHiziKadin * hrkDeger - 750;

        if (cinsiyet == 'E') {
            System.out.println("Bazal Metabolizma Hizi = " + bMHiziErkek);

            if (bMISonuc < 25) {                          // burada kilo vermez ve almaz sabit kalir.
                System.out.println("Gunluk almaniz gereken kalori miktari : " + erkekEnerji);
                System.out.println("Karbonhidrat : " + (erkekEnerji*0.6) +
                        ", Protein : " + (erkekEnerji*0.25) + ", Yag : " + (erkekEnerji*0.15));
            } else {
                            //**** Kilo vermesi icin *****
                if ((bMIErkA < bMHiziErkek) && (bMIErkB < bMHiziErkek)) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : " + bMHiziErkek);
                    System.out.println("Karbonhidrat : " + (bMHiziErkek*0.6) +
                            ", Protein : " + (bMHiziErkek*0.25) + ", Yag : " + (bMHiziErkek*0.15));
                } else if ((bMIErkA > bMHiziErkek) && (bMIErkB > bMHiziErkek)) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : "
                            + bMIErkB + " ile " + bMIErkA + " araliginda olmali***");
                    System.out.println("Karbonhidrat : " + (((bMIErkA+bMIErkB)/2)*0.60) +
                            ", Protein : " + (((bMIErkA+bMIErkB)/2)*0.25) +", Yag : " + (((bMIErkA+bMIErkB)/2)*0.15) );
                } else if ((bMIErkB < bMHiziErkek) && (bMIErkA > bMHiziErkek) ) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : "
                            + bMHiziErkek + " ile " + bMIErkA + " araliginda olmali**");
                    System.out.println("Karbonhidrat : " + (((bMHiziErkek+bMIErkA)/2)*0.60) +
                            ", Protein : " + (((bMHiziErkek+bMIErkA)/2)*0.25) +", Yag : " + (((bMHiziErkek+bMIErkA)/2)*0.15) );
                }
            }

        } else if (cinsiyet == 'K') {
            System.out.println("Bazal Metabolizma Hizi = " + bMHiziKadin);

            if (bMISonuc < 25) {                // burada kilo vermez ve almaz sbit kalir.
                System.out.println("Gunluk almaniz gereken maximum kalori miktari : " + kadinEnerji);
                System.out.println("Karbonhidrat : " + (kadinEnerji*0.6) +", Protein : "
                        + (kadinEnerji*0.25) + ", Yag : " + (kadinEnerji*0.15));

            } else {            //**** Kilo vermesi icin *****
                if ((bMIKdnA < bMHiziKadin) && (bMIKdnB < bMHiziKadin)) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : " + bMHiziKadin);
                    System.out.println("Karbonhidrat : " + (bMHiziKadin*0.6) +", Protein : "
                            + (bMHiziKadin*0.25) + ", Yag : " + (bMHiziKadin*0.15));

                } else if ((bMIKdnA > bMHiziKadin) && (bMIKdnB > bMHiziKadin)) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : "
                            + bMIKdnB + " ile " + bMIKdnA + " araliginda olmali***");
                    System.out.println("Karbonhidrat : " + (((bMIKdnA+bMIKdnB)/2)*0.60) +
                            ", Protein : " + (((bMIKdnA+bMIKdnB)/2)*0.25) +", Yag : " + (((bMIKdnA+bMIKdnB)/2)*0.15) );

                } else if ((bMIKdnB < bMHiziKadin) && (bMIKdnA > bMHiziKadin)) {
                    System.out.println("Gunluk almaniz gereken kalori miktari : "
                            + bMHiziKadin + " ile " + bMIKdnA + " araliginda olmali**");
                    System.out.println("Karbonhidrat : " + (((bMHiziKadin+bMIKdnA)/2)*0.60) +
                            ", Protein : " + (((bMHiziKadin+bMIKdnA)/2)*0.25) +", Yag : " + (((bMHiziKadin+bMIKdnA)/2)*0.15) );
                }
            }
        } else {
            System.out.println("Bu cinsiyet tanimlanmamis, lutfen gecerli bir cinsiyet giriniz.");
        }
    }


    public static double bMIHesap(double a, double b){
      return a/(b*b);
    }

    public static double bMHiziKadin(double kilo, double boyCm, int yas){
        return ((10*kilo)+(6.25*boyCm)-(5*yas))-161;
    }

    public static double bMHiziErkek(double kilo, double boyCm, int yas){
        return ((10*kilo)+(6.25*boyCm)-(5*yas))+5;
    }

}
