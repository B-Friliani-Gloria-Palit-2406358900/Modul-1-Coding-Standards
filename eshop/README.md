### Reflection 1

You already implemented two new features using Spring Boot. Check again your source code
and evaluate the coding standards that you have learned in this module. Write clean code
principles and secure coding practices that have been applied to your code. If you find any
mistake in your source code, please explain how to improve your code.


Beberapa Clean Code Principles yang saya terapkan, yaitu meaningful names, dimana saya memberi nama variabel dan fungsi yang cukup self-explanatory seperti editProductPage, editProductPost, deleteProduct. Fungsi yang saya buat juga menerapkan Single Responsibility Principle, dimana tiap bagian melakukan tugasnya masing-masing, seperti Controller yang menangani HTTP request dan navigasi halaman, Service yang menangani logika bisnis, dan repository yang menangani data. Saya juga menerapkan Small Function/Method, dimana method yang dibuat rata-rata hanya terdiri dari sedikit baris kode dan hanya melakukan satu hal (do one thing). Secure Coding yang saya terapkan adalah menggunakan UUID untuk id produk, hal ini untuk mencegah penyerang untuk mengetahui ID produk karena UUID digenerate secara random. Output encoding juga saya terapkan dengan adanya penggunaan th:text pada thymeleaf.
Meskipun kode sudah berjalan, ada beberapa bagian dari kode yang mungkin bisa diperbaiki/ditingkatakan. Salah satunya adalah kurangnya validasi input. Untuk kode saya saat ini, user bisa memasukkan nama kosong atau quantity negatif. Kesalahan ini bisa saya improve dengan menggunakan @Valid dan Spring Boot Starter Validation di model dan controller.


