import java.util.Scanner;

public class Siakad2 {
    static Scanner scanner = new Scanner(System.in);

    // Array untuk menyimpan data mahasiswa
    static String[][] data = new String[100][4];


    // static Mahasiswa[] Mahasiswa = new Mahasiswa[1000];
    static int totalData = 0;
    static boolean isRunning = true;

    public static void main(String[] args) {
        while (isRunning) {
            // Tampilkan menu
            System.out.println("=== SIAKAD ===");
            System.out.println("1. Tambah Data");
            System.out.println("2. Lihat Data");
            System.out.println("3. Urutkan Data");
            System.out.println("4. Cari Data");
            System.out.println("5. Edit Data");
            System.out.println("6. Hapus Data");
            System.out.println("7. Keluar");
            System.out.print("Pilihan: ");

            // Baca input dari user
            int pilihan = scanner.nextInt();

            // Lakukan aksi sesuai dengan pilihan user
            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    lihatData();
                    break;
                case 3:
                    urutkanData();
                    break;
               case 4:
                   cariData();
                   break;
               case 5:
                   editData();
                   break;
               case 6:
                   hapusData();
                   break;
                case 7:
                    isRunning = false;
                    break;
               default:
                   System.out.println("Pilihan tidak valid!");
            }   
        }
    }

    public static void tambahData() {
        // Baca input dari user
        System.out.print("NIM: ");
        String nim = scanner.next();
        System.out.print("Nama: ");
        String nama = scanner.next();
        System.out.print("Jurusan: ");
        String jurusan = scanner.next();

        // Tambahkan data ke array
        data[totalData][0] = nim;
        data[totalData][1] = nama;
        data[totalData][2] = jurusan;
        totalData++;

        System.out.println("Data berhasil ditambahkan!");
    }

    public static void lihatData() {
        // Tampilkan data mahasiswa
        System.out.println("Daftar Mahasiswa: ");
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] != null) {
                System.out.println("NIM: " + data[i][0]);
                System.out.println("Nama: " + data[i][1]);
                System.out.println("Jurusan: " + data[i][2]);
            }
        }
    }

    public static void urutkanData() {
        int pilihanUrutData;
        do {
            // Tampilkan menu Urutkan Data
            System.out.println("=== SIAKAD ===");
            System.out.println("1. Exchange Sort");
            System.out.println("2. Selection Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Bubble Sort");
            System.out.println("5. Shell Sort");
            System.out.println("6. Kembali");
            System.out.print("Pilihan: ");

            // Baca input dari user
            pilihanUrutData = scanner.nextInt();

            // Lakukan aksi sesuai dengan pilihan user
            switch (pilihanUrutData) {
                case 1:
                    exchangeSort();
                    break;
                case 2:
                    selectionSort();
                    break;
                case 3:
                    quickSort(0, data.length - 1);
                    break;
                case 4:
                    bubbleSort();
                    break;
                case 5:
                    shellSort();
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihanUrutData != 6);
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Exchange Sort
    public static void exchangeSort() {
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i][1].compareTo(data[j][1]) > 0) {
                    String[] temp = data[i];
                    data[i] = data[j];
                    data[j] = temp;
                }
            }
        }
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Selection Sort
    public static void selectionSort() {
        for (int i = 0; i < data.length - 1; i++) {
        int minIndex = i;
        for (int j = i + 1; j < data.length; j++) {
            if (data[j][1].compareTo(data[minIndex][1]) < 0) {
            minIndex = j;
            }
        }
        if (minIndex != i) {
            String[] temp = data[i];
            data[i] = data[minIndex];
            data[minIndex] = temp; 
        }
        }
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Quick Sort
    public static void quickSort(int left, int right) {
        if (left < right) {
          int pivotIndex = partition(left, right);
          quickSort(left, pivotIndex - 1);
          quickSort(pivotIndex + 1, right);
        }
      }

    // metode untuk mempartisi data mahasiswa
    public static int partition(int left, int right) {
        String pivot = data[right][1];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (data[j][1].compareTo(pivot) < 0) {
                i++;
                String[] temp = data[i];
                data[i] = data[j];
                data[j] = temp;
            }
        }
        String[] temp = data[i + 1];
        data[i + 1] = data[right];
        data[right] = temp;
        return i + 1;
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Bubble Sort
    public static void bubbleSort() {
        for (int i = 0; i < data.length - 1; i++) {
          for (int j = 0; j < data.length - i - 1; j++) {
            if (data[j][1].compareTo(data[j + 1][1]) > 0) {
                String[] temp = data[j];
                data[j] = data[j + 1];
                data[j + 1] = temp;
            }
          }
        }
      }

    // Method untuk mengurutkan data mahasiswa menggunakan Shell Sort
    public static void shellSort() {
        int gap = data.length / 2;
        while (gap > 0) {
            for (int i = gap; i < data.length; i++) {
                int j = i;
                while (j >= gap && data[j - gap][1].compareTo(data[j][1]) > 0) {
                    // Tukar posisi dataMahasiswa[j] dan dataMahasiswa[j - gap]
                    String[] temp = data[j];
                    data[j] = data[j - gap];
                    data[j - gap] = temp;
                }
            }
        }
    }

    private static void cariData(){
        int pilihanCariData;
        do {
            // Tampilkan menu Urutkan Data
            System.out.println("=== SIAKAD ===");
            System.out.println("1. Linear Search");
            System.out.println("2. Binary Search");
            System.out.println("3. Kembali");
            System.out.print("Pilihan: ");

            // Baca input dari user
            pilihanCariData = scanner.nextInt();

            // Lakukan aksi sesuai dengan pilihan user
            switch (pilihanCariData) {
                case 1:
                    linearSearch();
                    break;
               case 2:
                   binarySearch();
                   break;
               default:
                   System.out.println("Pilihan tidak valid!");
                   break;
            }
        } while (pilihanCariData != 3);
    }

    public static void linearSearch(){
        // Cari data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari: ");
        String cari = scanner.next();
        boolean found = false; // variabel untuk menandakan apakah data ditemukan atau tidak
        // Lakukan sequential search untuk mencari data mahasiswa
        for (int i = 0; i < data.length; i++) {
            if (data[i][0].equals(cari)) {
                // Data ditemukan, tampilkan informasi mahasiswa
                System.out.println("Data ditemukan:");
                System.out.println("NIM: " + data[i][0]);
                System.out.println("Nama: " + data[i][1]);
                System.out.println("Jurusan: " + data[i][2]);
                found = true;
                break;
            }
            if (!found) {
                // Data tidak ditemukan
                System.out.println("Data tidak ditemukan");
            }
        } 
    }

    public static void binarySearch(){
        // Cari data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari: ");
        String nim = scanner.next();
        boolean found = false; // variabel untuk menandakan apakah data ditemukan atau tidak

        // Lakukan binary search untuk mencari data mahasiswa
        int low = 0;
        int high = data.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (data[mid][0].compareTo(nim) == 0) {
                // Data ditemukan, tampilkan informasi mahasiswa
                System.out.println("Data ditemukan:");
                System.out.println("NIM: " + data[mid][0]);
                System.out.println("Nama: " + data[mid][1]);
                System.out.println("Jurusan: " + data[mid][2]);
                found = true;
                break;
            } 
            else if (data[mid][0].compareTo(nim) < 0) {
                low = mid + 1;
            } 
            else {
                high = mid - 1;
            }
            if (!found) {
                // Data tidak ditemukan
                System.out.println("Data tidak ditemukan");
            }
        }
    }

    public static void editData(){
        // Edit data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang akan diedit: ");
        String nim = scanner.nextLine();
        boolean dataDitemukan = false;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] != null && data[i][0].equals(nim)) {
                // Data mahasiswa ditemukan
                dataDitemukan = true;
                System.out.print("Masukkan nama baru: ");
                String nimBaru = scanner.nextLine();
                data[i][0] = nimBaru;
                System.out.print("Masukkan nama baru: ");
                String namaBaru = scanner.nextLine();
                data[i][1] = namaBaru;
                System.out.print("Masukkan jurusan baru: ");
                String jurusanBaru = scanner.nextLine();
                data[i][2] = jurusanBaru;
            }
        }
        if (dataDitemukan) {
            System.out.println("Data mahasiswa berhasil diedit");
        } 
        else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
        }
    }

    public static void hapusData(){
        // Hapus data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        String nim = scanner.nextLine();

        // Cari indeks mahasiswa dengan NIM yang diberikan
        int indeks = -1;
        for (int i = 0; i < data.length; i++) {
            if (data[i][0] != null && data[i][0].equals(nim)) {
                indeks = i;
                break;
              }
        }

        if (indeks != -1) {
            // Tanya apakah akan dihapus
            System.out.println("Data yang akan dihapus: " + data[indeks][0] + " - " + data[indeks][1] + " - " + data[indeks][2]);
            System.out.print("Apakah Anda yakin akan menghapus data ini? (y/n) ");
            String confirm = scanner.nextLine();
          
            if (confirm.equals("y")) {
                // Hapus data
                for (int i = indeks; i < data.length - 1; i++) {
                    data[i] = data[i + 1];
                }

                data[data.length - 1] = null;
                System.out.println("Data berhasil dihapus");

            }
            else {
              // Batalkan hapus data
              System.out.println("Hapus data dibatalkan");
            }
        }
        else {
            System.out.println("Mahasiswa dengan NIM " + nim + " tidak ditemukan");
        }
    }
}