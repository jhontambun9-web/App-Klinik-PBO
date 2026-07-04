#🏥 Sistem Informasi Klinik (App-Klinik-PBO)
Aplikasi ini adalah sistem manajemen klinik sederhana yang dibangun dengan Java Desktop (Apache NetBeans & Maven). Sistem ini dirancang untuk memudahkan staf klinik dalam mengelola data pasien, dokter, dan perawat secara efisien dan terorganisir.

##🚀 Keseluruhan Fitur
Sistem ini dilengkapi dengan fitur-fitur utama untuk operasional klinik:
- <font size="4">**Autentikasi Aman:** Sistem login berbasis role untuk memastikan hanya staf berwenang yang dapat mengakses data.</font>
- <font size="4">**Manajemen Data Pasien (CRUD):**</font>
- <font size="3.5">Menambahkan data pasien baru.</font>
- <font size="3.5">Menampilkan daftar seluruh pasien.</font>
- <font size="3.5">Memperbarui informasi pasien.</font>
- <font size="3.5">Menghapus data pasien dari sistem.</font>
- <font size="3.5">Pencarian cepat data pasien.</font>
- <font size="4">**Manajemen Data Dokter:** Pengelolaan data dokter spesialis yang bertugas di klinik.</font>
- <font size="4">**Manajemen Data Perawat:** Pengelolaan data perawat yang terdaftar di klinik.</font>
- <font size="4">**Dashboard Terintegrasi:** Tampilan antarmuka (UI) intuitif yang memudahkan navigasi antar modul.</font>

### 🛠️ Prasyarat Sistem
Sebelum menjalankan aplikasi, pastikan Anda telah menyiapkan lingkungan pengembangan berikut:
- <font size="4">☕ **JDK 21** atau versi terbaru.</font>
- <font size="4">📦 **Apache NetBeans IDE** dengan dukungan Maven.</font>
- <font size="4">🐘 **XAMPP** (untuk menjalankan MySQL Database).</font>
- <font size="4">🔌 **MySQL Connector/J** (sudah terkonfigurasi di `pom.xml`).</font>

## 📖 Cara Penggunaan Lengkap

### 1. Persiapan Database
1. <font size="4">Buka **XAMPP Control Panel** dan aktifkan **Apache** serta **MySQL**.</font>
2. <font size="4">Buka browser dan akses URL berikut:</font>
   ```url
   http://localhost/phpmyadmin/
   ```
3. <font size="4">Buat database baru dengan nama `db_klinik`.</font>
4. <font size="4">Pilih database tersebut, klik tab **Import**, pilih file `db_klinik.sql` yang ada di direktori root proyek ini, lalu klik **Go**.</font>
---
### 2. Menjalankan Aplikasi
1. <font size="4">Buka proyek **AppKlinik** melalui Apache NetBeans.</font>
2. <font size="4">Pastikan *dependency* (library MySQL Connector) terunduh otomatis melalui Maven.</font>
3. <font size="4">Klik kanan pada file `LoginFrame.java` (atau *main class* Anda) dan pilih **Run File** (atau tekan `Shift + F6`).</font>
4. <font size="4">**Login:** Gunakan kredensial berikut untuk masuk pertama kali:</font>
   ```text
   Username : admin
   Password : admin123
   ```
---
### 3. Mengelola Data
* <font size="4">**Dashboard:** Setelah login, Anda akan diarahkan ke Menu Utama. Klik tombol yang sesuai untuk masuk ke modul yang diinginkan (Pasien, Dokter, atau Perawat).</font>
* <font size="4">**Menambah Data:** Isi kolom yang tersedia pada form, lalu klik tombol **Simpan**.</font>
* <font size="4">**Mengedit/Menghapus:** Klik salah satu baris data pada tabel yang tampil, form akan terisi otomatis. Anda dapat mengubah data lalu klik **Ubah**, atau klik **Hapus** untuk menghapus data.</font>
* <font size="4">**Logout:** Klik tombol **Logout** pada menu utama untuk kembali ke halaman login dan mengakhiri sesi.</font>
