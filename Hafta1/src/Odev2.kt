/**
 * Innova Android Bootcamp
 * Ödev - 2
 *
 * @author Ömer Faruk Bitikçioğlu
 */
class Odev2 {
    // Celsius -> Fahrenheit dönüşümü yapar
    fun soru1(derece: Double): Double {
        return derece * 1.8 + 32
    }

    // Verilen kenarlar ile dikdörtgenin çevresini hesaplar
    fun soru2(kenar1: Double, kenar2: Double): Double {
        if (kenar1 <= 0.0 || kenar2 <= 0.0)
            throw IllegalArgumentException("Verilen $kenar1 ve $kenar2 değerleri pozitif sayı olmalı!")
        return 2 * (kenar1 + kenar2)
    }

    // Verilen sayının faktoriyelini hesaplar
    fun soru3(sayi: Int): Int {
        var sonuc = 1
        if (sayi < 0)
            throw IllegalArgumentException("Verilen $sayi değeri 0 veya pozitif sayı olmalı!")
        for (i in 1..sayi) {
            sonuc *= i
        }
        return sonuc
    }

    // Verilen harfin kelimede kaç adet olduğunu hesaplar
    fun soru4(kelime: String, harf: Char): Int {
        var sayac = 0
        for (i in 0..kelime.length - 1) {
            if (kelime[i] == harf)
                sayac++
        }
        return sayac
    }

    // Verilen kenar sayısına göre bir çokgenin iç açılar toplamını hesaplar
    fun soru5(kenarSayisi: Int): Int {
        if (kenarSayisi < 3)
            throw IllegalArgumentException("Verilen $kenarSayisi değeri 3 veya 3'ten büyük bir sayı olmalıdır!")
        return (kenarSayisi - 2) * 180
    }

    // Verilen gün sayısına göre maaş hesabı yapar
    fun soru6(gunSayisi: Int): Int {
        // Sabitler
        val gunlukCalismaSaati = 8
        val calismaSaatUcreti = 10
        val mesaiSaatUcreti = 20
        val mesaiSaatLimiti = 160

        val calisilanSaat = gunSayisi * gunlukCalismaSaati
        if (calisilanSaat < 0)
            throw IllegalArgumentException("Verilen $gunSayisi değeri 0 veya pozitif sayı olmalı!")
        else if (calisilanSaat > mesaiSaatLimiti) {
            val yapilanMesai = calisilanSaat - mesaiSaatLimiti
            return mesaiSaatLimiti * calismaSaatUcreti + yapilanMesai * mesaiSaatUcreti
        } else
            return calisilanSaat * calismaSaatUcreti
    }

    // Girilen harcama miktarına göre ödenmesi gereken ücreti hesaplar
    fun soru7(kotaMiktari: Int): Int {
        // Sabitler
        val kota = 50
        val kotaUcreti = 100
        val asimBedeli = 4

        if (kotaMiktari < 0)
            throw IllegalArgumentException("Verilen $kotaMiktari değeri 0 veya pozitif sayı olmalı!")
        else if (kotaMiktari <= kota)
            return kotaUcreti
        else
            return kotaUcreti + (kotaMiktari - kota) * asimBedeli
    }
}