🏥 Sistem Informasi Klinik (App-Klinik-PBO)
Aplikasi ini adalah sistem manajemen klinik sederhana yang dibangun dengan Java Desktop (Apache NetBeans & Maven). Sistem ini dirancang untuk memudahkan staf klinik dalam mengelola data pasien, dokter, dan perawat secara efisien dan terorganisir.

🚀 Keseluruhan Fitur
Sistem ini dilengkapi dengan fitur-fitur utama untuk operasional klinik:

Autentikasi Aman: Sistem login berbasis role untuk memastikan hanya staf berwenang yang dapat mengakses data.

Manajemen Data Pasien (CRUD):

Menambahkan data pasien baru.

Menampilkan daftar seluruh pasien.

Memperbarui informasi pasien.

Menghapus data pasien dari sistem.

Pencarian cepat data pasien.

Manajemen Data Dokter: Pengelolaan data dokter spesialis yang bertugas di klinik.

Manajemen Data Perawat: Pengelolaan data perawat yang terdaftar di klinik.

Dashboard Terintegrasi: Tampilan antarmuka (UI) intuitif yang memudahkan navigasi antar modul.

🛠️ Persiapan & Instalasi
Sebelum menjalankan aplikasi, pastikan Anda telah menyiapkan lingkungan pengembangan berikut:

JDK 21 atau versi terbaru.

Apache NetBeans IDE dengan dukungan Maven.

XAMPP (untuk menjalankan MySQL Database).

MySQL Connector/J (sudah terkonfigurasi di pom.xml).

📖 Cara Penggunaan Lengkap
1. Persiapan Database
Buka XAMPP Control Panel dan aktifkan Apache serta MySQL.

Buka browser dan akses http://localhost/phpmyadmin/.

Buat database baru dengan nama db_klinik.

Pilih database tersebut, klik tab Import, pilih file db_klinik.sql yang ada di direktori root proyek ini, lalu klik Go.

2. Menjalankan Aplikasi
Buka proyek AppKlinik melalui Apache NetBeans.

Pastikan dependency (library MySQL Connector) terunduh otomatis melalui Maven.

Klik kanan pada file LoginFrame.java (atau main class Anda) dan pilih Run File (atau tekan Shift + F6).

Login: Gunakan kredensial berikut untuk masuk pertama kali:

Username: admin

Password: admin123

3. Mengelola Data
Dashboard: Setelah login, Anda akan diarahkan ke Menu Utama. Klik tombol yang sesuai untuk masuk ke modul yang diinginkan (Pasien, Dokter, atau Perawat).

Menambah Data: Isi kolom yang tersedia pada form, lalu klik tombol Simpan.

Mengedit/Menghapus: Klik salah satu baris data pada tabel yang tampil, form akan terisi otomatis. Anda dapat mengubah data lalu klik Ubah, atau klik Hapus untuk menghapus data.

Logout: Klik tombol Logout pada menu utama untuk kembali ke halaman login dan mengakhiri sesi.
