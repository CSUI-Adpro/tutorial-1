# Tutorial 1

Setelah mempelajari dasar-dasar dari Spring Boot pada `Tutorial 0` sebelumnya, kamu akan mulai belajar menerapkan ide-ide design pattern dalam Spring Boot. Dalam tutorial ini, kamu akan berkenalan dengan 2 jenis design pattern, yaitu `Strategy Pattern` dan `Observer Pattern`.

## Strategy Pattern

------------------------

Dalam `tutorial-1` ini, kamu akan membantu seorang juragan mencari **strategi** terbaik untuk perjalanannya. Juragan tersebut harus memikirkan dua hal untuk perjalanannya, yaitu **lokasi tujuan** dan **alat transportasi** perjalanan. Dari kedua faktor tersebut, akan diketahui **harga**, **waktu**, dan tingkat **satisfaction** sang juragan dari perjalanan tersebut.

### Requirements

- Menampilkan tarif, waktu, dan tingkat kepuasan (*satisfaction*) untuk perjalanan ke lokasi yang tersedia menggunakan moda transportasi mobil, motor, dan pesawat terbang pada *endpoint* `/transport` yang memiliki tampilan sebagai berikut.

![Tampilan Kalkulator Transportasi di Endpoint /transport](/transport-calculator-screenshot.png)

- Ketentuan perhitungan tarif perjalanan:
  
    - Untuk transportasi berupa motor, tarif perjalanan yang tidak lebih dari 2 km adalah **Rp5.000,00**. Selebihnya akan dikenakan tambahan biaya **Rp1.500,00 per km**. Jarak maksimum yang dapat ditempuh oleh jasa transportasi motor adalah **25 km**.
    - Untuk transportasi berupa mobil, tarif perjalanan yang tidak lebih dari 2 km adalah **Rp10.000,00**. Selebihnya akan dikenakan tambahan biaya **Rp3.500,00 per km**. Jarak maksimum yang dapat ditempuh oleh jasa transportasi mobil adalah **50 km**.
    - Untuk transportasi berupa pesawat terbang, tarif perjalanan hanya meningkat setiap kelipatan 100 km. Sebagai contoh, tarif perjalanan untuk jarak 300 dan 301 km adalah sama, tetapi tarif perjalanan untuk jarak 300 km berbeda dengan 400 km. Tarif perjalanan untuk jarak minimum yang dapat ditempuh oleh jasa transportasi pesawat terbang (300 km) adalah **Rp500.000,00**, sementara besar peningkatan tarif setiap 100 km adalah **Rp150.000,00**.

- Ketentuan perhitungan waktu perjalanan:

    - Kecepatan rata-rata jasa transportasi motor adalah **40 km/jam**.
    - Kecepatan rata-rata jasa transportasi mobil adalah **30 km/jam**.
    - Kecepatan rata-rata pesawat terbang adalah **800 km/jam**.
  
- Ketentuan perhitungan tingkat kepuasan:

    - Tingkat kepuasan diukur dengan skala 1-10.
    - Tingkat kepuasan di awal perjalanan selalu bernilai 10.
    - **Moda Motor**
        - Konstan pada **10 km** pertama.
        - Turun **1 poin setiap 10 km berikutnya** karena sulit untuk mengubah posisi duduk di motor.
    - **Moda Mobil**
        - Turun **1 poin setiap 5 km berikutnya** karena mobil rawan terjebak macet.
    - **Moda Pesawat Terbang**
        - Turun sebanyak **1 poin setiap 100 km** karena kabin penumpang pesawat terbang yang cukup dingin.
  
### UML Diagram

![Diagram UML Strategy Pattern](/Strategy-UML.png)

## Observer Pattern - Newsletter Service

Sebuah perusahaan ternama menyediakan layanan Newsletter secara gratis untuk pelanggan yang berlangganan. Kamu sebagai salah satu *software engineer* pada perusahaan tersebut diminta untuk melengkapi sebuah sistem pengiriman berita yang dimiliki oleh perusahaan tersebut untuk mengirimkan berita ke setiap pengguna yang berlangganan pada kategori yang sesuai.

Terdapat 3 layanan Newsletter, yaitu GameStart yang menyediakan berita mengenai game, Koped Travel yang menyediakan berita mengenai tempat wisata, dan BI Sports yang mengirimkan berita mengenai hasil pertandingan. 

Pengguna harus dapat melakukan *subscribe* dan *unsubcribe* pada suatu kategori Newsletter. Untuk pelanggan yang berlangganan harus dapat menerima pesan yang dikirim oleh Newsletter terkait.

### Requirements

- Endpoint `/newsletter/subscribe` digunakan untuk mengatur pengguna yang men-*subscribe* suatu layanan Newsletter
![Tampilan Subscribe Service](/subscribe-manager-screenshot.jpeg)
- Endpoint `/newsletter` digunakan untuk mengirim sekaligus melihat kiriman yang dilakukan oleh layanan Newsletter
![Tampilan Newsletter Service](/newsletter-service-screenshot.jpeg)
- Melengkapi method `handleNewSubscriber `agar `Newsletter` dapat menambahkan atau menghapus `User` yang berlangganan suatu `Newsletter` jika tombol **Subscribe** ditekan
- Melengkapi method `handleNewEdition` agar `Newsletter` dapat menotifikasi semua yang berlangganan `Newsletter` terkait.
- Melengkapi bagian `Controller` untuk menampilkan pesan yang diterima `User` yang berlangganan ketika suatu `Newsletter` melakukan broadcast
- Melengkapi method `handleNotification` untuk mengatur pesan yang diterima oleh user
- Melengkapi method `addSubscriber`, `removeSubscriber`, dan `notifySubscriber`

### UML Diagram

![Diagram UML Observer Pattern](/observer-uml.png)

------------------------
