import java.nio.DoubleBuffer

/**
 * Innova Android Bootcamp
 * Ödev - 2
 *
 * Odev2 metodlarının test edildiği yer
 *
 * @author Ömer Faruk Bitikçioğlu
 */

fun main() {
    val odev2 = Odev2()

    //Soru1 test
    println("Soru 1 test...")
    val cDerece = -4.0;
    val fDerece = odev2.soru1(cDerece)
    println("$cDerece Celsius = $fDerece Fahrenheit")

    //Soru2 test
    println("Soru 2 test...")
    val kenar1 = 10.0; val kenar2 = 22.5
    try {
        val cevre = odev2.soru2(kenar1, kenar2)
        println("Kenar1= $kenar1 br, Kenar2= $kenar2 br, Çevre= $cevre br")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    //Soru3 test
    println("Soru 3 test...")
    val sayi = 5
    try {
        val fact = odev2.soru3(sayi)
        println("$sayi! = $fact")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    //Soru4 test
    println("Soru 4 test...")
    val kelime = "kedi"; val harf = 'a'
    val kacAdet = odev2.soru4(kelime, harf)
    println("$kelime kelimesi $kacAdet tane $harf harfi içerir")

    //Soru5 test
    println("Soru 5 test...")
    val kenarSayisi = 7
    try {
        val icAcilarToplami = odev2.soru5(kenarSayisi)
        println("$kenarSayisi kenarı olan bir çokgenin iç açılar toplamı= $icAcilarToplami")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    //Soru6 test
    println("Soru 6 test...")
    try {
        val gunSayisi = 1
        val maas = odev2.soru6(gunSayisi)
        println("$gunSayisi gün calışan birisi $maas TL maaş almalı")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

    //Soru7 test
    println("Soru 7 test...")
    val kotaMiktari = 120
    try {
        val fatura = odev2.soru7(kotaMiktari)
        println("$kotaMiktari GB harcama karşılığı ödenmesi gereken $fatura TL")
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }

}