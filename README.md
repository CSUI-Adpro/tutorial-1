# Tutorial 1

Setelah mempelajari dasar-dasar dari Spring Boot pada `tutorial-0` sebelumnya, kamu akan mulai belajar menerapkan ide-ide design pattern menggunakan Spring Boot. Dalam tutorial ini, kamu akan berkenalan dengan dua jenis design pattern, yaitu `Strategy Pattern` dan `Observer Pattern`.

## Strategy Pattern

------------------------
Dalam `tutorial-1` ini, kamu akan membantu seorang juragan mencari **strategi** terbaik untuk perjalanannya. Juragan tersebut harus memikirkan dua hal untuk perjalanannya, yaitu **lokasi tujuan** dan **alat transportasi** perjalanan. Dari kedua faktor tersebut, akan diketahui **harga**, **waktu**, dan tingkat **satisfaction** sang juragan dari perjalanan tersebut.

Kamu diharapkan dapat melengkapi beberapa bagian kode yang ditandai dengan `//TODO`. Tarif perjalanan dihitung dengan ketentuan berikut:

- Untuk transportasi berupa motor, tarif perjalanan yang tidak lebih dari 2 km adalah **Rp5.000,00**. Selebihnya akan dikenakan tambahan biaya **Rp1.500,00 per km**. Jarak maksimum yang dapat ditempuh oleh jasa transportasi motor adalah **25 km**.
- Untuk transportasi berupa mobil, tarif perjalanan yang tidak lebih dari 2 km adalah **Rp10.000,00**. Selebihnya akan dikenakan tambahan biaya **Rp3.500,00 per km**. Jarak maksimum yang dapat ditempuh oleh jasa transportasi mobil adalah **50 km**.
- Untuk transportasi berupa pesawat terbang, tarif perjalanan hanya meningkat setiap kelipatan 100 km. Sebagai contoh, tarif perjalanan untuk jarak 300 dan 301 km adalah sama, tetapi tarif perjalanan untuk jarak 300 km berbeda dengan 400 km. Tarif perjalanan untuk jarak minimum yang dapat ditempuh oleh jasa transportasi pesawat terbang (300 km) adalah **Rp500.000,00**, sementara besar peningkatan tarif setiap 100 km adalah **Rp150.000,00**.

Selain menghitung *cost* secara finansial, kamu juga menghitung *cost* berupa waktu untuk masing-masing moda transportasi dengan ketentuan berikut:

- Kecepatan rata-rata jasa transportasi motor adalah **40 km/jam**.
- Kecepatan rata-rata jasa transportasi mobil adalah **30 km/jam**.
- Kecepatan rata-rata pesawat terbang adalah **800 km/jam**.

Terakhir, kamu juga menghitung estimasi *cost* berupa tingkat kepuasan (*satisfaction*) dengan skala 1-10. Setiap perjalanan dimulai dengan tingkat kepuasan maksimum, yaitu 10. Setelah itu, tingkat kepuasan akan berubah sesuai ketentuan berikut:

- **Moda Motor**
    - Konstan pada **10 km** pertama.
    - Turun **1 poin setiap 10 km berikutnya** karena sulit untuk mengubah posisi duduk di motor.
 - **Moda Mobil**
    - Turun **1 poin setiap 5 km berikutnya** karena mobil rawan terjebak macet.
- **Moda Pesawat Terbang**
    - Turun sebanyak **1 poin setiap 100 km** karena kabin penumpang pesawat terbang yang cukup dingin.

Setelah mengimplementasikan kode untuk perhitungan-perhitungan tersebut, kamu juga harus memastikan bahwa hasil perhitungan tersebut dapat dilihat oleh juragan melalui *endpoint* `/transport` yang memiliki tampilan sebagai berikut.

![Tampilan Kalkulator Transportasi di Endpoint /transport](/transport-calculator-screenshot.png)

### UML Diagram

![Diagram UML Strategy Pattern](/Strategy-UML.png)

## Observer Pattern - Newsletter Service

------------------------

Melihat performamu yang begitu bagus dalam membantu seorang juragan dalam menyelesaikan masalahnya, kamu direkrut oleh sebuah perusahaan ternama yang menyediakan layanan `Newsletter`. Dengan bayaran yang cukup menarik, kamu pun memutuskan untuk menerima tawaran tersebut.

Atasanmu, Pak Arsene langsung memintamu untuk menyelesaikan sebuah program baru yang akan digunakan untuk mengirim Newsletter. Mengingat ini adalah pekerjaan pertamamu di tempat ini, kamu sudah diberikan struktur kode yang sudah dibuat oleh senior di tempat kerjamu dan beberapa instruksi lanjutan untuk menyelesaikan program tersebut. Tentunya program ini harus dibuat dengan *design pattern* yang tepat terhadap masalah yang ada.

Perusahaan ini menyediakan 3 layanan Newsletter, yaitu GameStart yang menyediakan berita mengenai game, Koped Travel yang menyediakan berita mengenai tempat wisata, dan BI Sports yang mengirimkan berita mengenai hasil pertandingan. Kamu harus melengkapi fitur agar pelanggan dapat melakukan `subscribe` maupun `unsubcribe` dari suatu kategori Newsletter pada endpoint `/newsletter/subscribe`.

Tidak hanya itu, sistem ini tidak akan lengkap jika pelanggan yang telah berlangganan tidak bisa menerima berita. Aneh rasanya jika pelanggan tidak bisa menerima apapun, bukan? Jadi, kamu juga harus melengkapi program tersebut agar pelanggan dapat menerima notifikasi kiriman dari kategori yang sesuai dengan yang ada pada endpoint `/newsletter`.

Saat menguji pada bagian HTML-nya, kamu juga melihat bahwa data yang dikirim dari BackEnd masih dalam bentuk hardcode. Kamu berinisiatif untuk memperbaikinya agar program tidak lagi menggunakan hardcode.

### Contoh Interaksi

Pada endpoint `/newsletter/subscribe`, kamu akan melihat halaman sebagai berikut. Disini, kamu dapat melihat daftar `User` yang berlangganan pada masing-masing kategori Newsletter. 

Kamu juga dapat melakukan `subscribe` dan `unsubscribe` pada masing-masing kategori Newsletter.

![Tampilan Halaman Subscribe Newsletter](/subscribe-manager-screenshot.jpeg)

Pada endpoint `/newsletter`, kamu akan melihat halaman sebagai berikut. Disini, kamu dapat melihat daftar `User` yang berlangganan pada masing-masing kategori Newsletter.

Kamu juga dapat mengirim edisi baru `Newsletter` dan melihat hasilnya pada masing-masing *inbox* `User`.

![Tampilan Halaman Newsletter Service](/newsletter-service-screenshot.jpeg)

### UML Diagram

![Diagram UML Observer Pattern](/observer-uml.png)
