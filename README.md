# CRUD Sederhana Aplikasi Toko Bangunan

## Syarat menjalankan Aplikasi
Untuk menjalankan aplikasi perlu membuat Database dulu di lokal:

Kemudian ubah dan sesuaikan pengaturan di appliaction.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/{nama database}
spring.datasource.username={username database}
spring.datasource.password={pasword database}

## Spec API terlampir dalam folder docs

## Server di set pada port : 80 (/)

## Panduan CRUD di client / front end

1. Akses awal aplikasi di browser dengan url: http://localhost/dashboard
2. Create: Tekan tab Product -> Add Product
3. Read:
    Get All: Tekan tab Product -> All Product
    Get By Name : Isi input search -> Tekan Icon Search
    Get By Id : Digunakan untuk update/edit dan delete
4. Update: Tekan Icon Edit pada masing-masing product -> Tampil modal untuk mengedit product -> simpan / batal
5. Delete: Tekan Icon Delete pada masing-masing product -> Tampil modal untuk menghapus product -> hapus / batal


