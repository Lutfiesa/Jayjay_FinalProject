
# API-WebAutomationGitAction


This repository contains a sample GitHub Actions setup for CI/CD automation.

## 🔧 Tools & Technology
| Teknologi            | Versi | Keterangan                                 |
|----------------------|-------|--------------------------------------------|
| Java                 | 21    | Bahasa pemrograman utama                   |
| Gradle               | 8.5   | Build automation tool                      |

- **GitHub Actions**: CI/CD automatio
- **Gradle** – sebagai build tool

## 🚀 Features

- Automated build and test pipeline
- CI trigger on push and pull request
- Simple and extensible workflow design

## ▶️ Cara Menggunakan

1. Fork atau clone repositori ini
2. Lakukan push atau buat pull request
3. Workflow akan berjalan secara otomatis melalui GitHub Actions


## 🧪 Menjalankan Project dengan Gradle

Berikut beberapa perintah yang dapat digunakan untuk membangun dan menjalankan pengujian pada proyek ini:

| Perintah                                | Keterangan                                                                             |
|-----------------------------------------|----------------------------------------------------------------------------------------|
| `./gradlew build`                       | Melakukan build proyek secara keseluruhan                                              |
| `./gradlew webTest`                     | Menjalankan skenario Cucumber Automation Web                                           |
| `./gradlew webApi`                      | Menjalankan skenario Cucumber Automation Api                                           |
| `./gradlew webTest -Ptags="@login"`     | Menjalankan Cucumber berdasarkan tag tertentu                                          |
> **Catatan:** Pastikan Anda sudah menginstall Gradle dan JDK yang sesuai sebelum menjalankan perintah di atas.

## 📌 Catatan

- Pastikan konfigurasi `automation.yml` sesuai dengan kebutuhan proyek Anda
- Workflow ini hanya sebagai contoh dasar dan dapat dikembangkan lebih lanjut

---

Dibuat oleh [Lutfi](https://github.com/Lutfiesa)
