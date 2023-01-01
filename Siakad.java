import java.util.Scanner;

public class Siakad {
    static Scanner scanner = new Scanner(System.in);

    // Array untuk menyimpan data mahasiswa
    static Mahasiswa[]  mahasiswa = new Mahasiswa[1000];

    static int totalData = 0;
    static boolean isRunning = true;

    public static void menu(){
        while(isRunning){
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
    public static void main(String[] args){
        menu();
    }

    public static void tambahData() {
        // Baca input dari user
        System.out.println("Silahkan Tambah Data Mahasiswa");
        System.out.print("NIM: ");
        String nim = scanner.next();
        System.out.print("Nama: ");
        String nama = scanner.next();
        System.out.print("Jurusan: ");
        String jurusan = scanner.next();

        // Tambahkan data ke array
        mahasiswa[totalData] = new Mahasiswa();
        mahasiswa[totalData].setNama(nama);
        mahasiswa[totalData].setNim(nim);
        mahasiswa[totalData].setJurusan(jurusan);
        totalData++;

        System.out.println("Data berhasil ditambahkan!");
    }

    public static void lihatData() {
        // Tampilkan data mahasiswa
        System.out.println("Berikut Data Diri Anda : ");
        int i = 0;
        while (i<totalData){
            int nomer = i+1;
            System.out.println(nomer+". " + mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim() + "  " + mahasiswa[i].getJurusan());
            i++;
        }
    }

    public static void urutkanData() {
        int pilihanUrutData;
        do {
            // Tampilkan menu Urutkan Data
            System.out.println("Pilih Algoritma Pengurutan");
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
                case 2:
                    selectionSort();
                case 3:
                    quickSort(mahasiswa,0,totalData-1);
                case 4:
                    bubbleSort();
                case 5:
                    shellSort();
                default:
                    System.out.println("Pilihan tidak valid!");
                    break;
            }
        } while (pilihanUrutData != 6);
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Exchange Sort
    public static void exchangeSort() {
        for(int x = 0; x<totalData; x++){
            for(int y = x+1; y<totalData; y++){
                int temp2 = Integer.parseInt(mahasiswa[x].getNim());
                int temp3 = Integer.parseInt(mahasiswa[y].getNim());
                if(temp2>=temp3){
                Mahasiswa temp = mahasiswa[x];
                mahasiswa[x] = mahasiswa [y];
                mahasiswa [y] = temp;
                }
            }
        }
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Selection Sort
    public static void selectionSort() {
        for(int i = 0;i<totalData-1;i++){
            int min_x = i;
            for(int j = i+1;j<totalData;j++){
                int temp2 = Integer.parseInt(mahasiswa[j].getNim());
                int temp3 = Integer.parseInt(mahasiswa[min_x].getNim());
                if(temp2<=temp3){
                    min_x = j;
                    Mahasiswa temp = mahasiswa[min_x];
                    mahasiswa[min_x] = mahasiswa[i];
                    mahasiswa[i] = temp;
                }   
            }
        }
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Quick Sort
    static void quickSort(Mahasiswa arr[], int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    // metode untuk mempartisi data mahasiswa
    static int partition(Mahasiswa arr[], int low, int high) {
        int coba = Integer.parseInt(arr[high].getNim());
        int pivot = coba;
        int i = (low - 1);
        Mahasiswa temp;
        for (int j = low; j <= high - 1; j++) {
            int temp2 = Integer.parseInt(mahasiswa[j].getNim());
            if (temp2 < pivot) {
                i++;
                temp = mahasiswa[j];
                mahasiswa[j] = mahasiswa[i];
                mahasiswa[i] = temp;

            }
        }
        temp = mahasiswa[i + 1];
        mahasiswa[i + 1] = mahasiswa[high];
        mahasiswa[high] = temp;
        return (i + 1);
    }

    // Method untuk mengurutkan data mahasiswa menggunakan Bubble Sort
    public static void bubbleSort() {
        for(int i = 0; i<totalData-1;i++){
            for(int j=0;j<totalData-i-1;j++){
                int temp2 = Integer.parseInt(mahasiswa[j].getNim());
                int temp3 = Integer.parseInt(mahasiswa[j+1].getNim());
                if(temp2 >= temp3){
                    Mahasiswa temp = mahasiswa[j];
                    mahasiswa[j] = mahasiswa[j+1];
                    mahasiswa[j+1] = temp;
                }
            }
        }
      }

    // Method untuk mengurutkan data mahasiswa menggunakan Shell Sort
    public static void shellSort(){
        int juml=totalData-1;
        int gap=juml/2;
        boolean swap =true;
        Mahasiswa temp;
        while(gap>0){
            swap=true;
            while(swap==true){
                swap=false;
                for(int i=0;i<=(juml-gap);i++){
                    int temp2 = Integer.parseInt(mahasiswa[i].getNim());
                    int temp3 = Integer.parseInt(mahasiswa[i+gap].getNim());;
                    if(temp2>temp3){
                        temp=mahasiswa[i];
                        mahasiswa[i]=mahasiswa[i+gap];
                        mahasiswa[i+gap]=temp;
                        swap=true;
                    }
                }
            }
            gap=gap/2;

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
               System.out.print("Masukan Nim = ");
               String filterValue=scanner.next();
               Integer indexFound=binarySearch(mahasiswa,filterValue,0,totalData-1);
               if(indexFound!=null){
                   System.out.println("Data yang anda cari :");
                   System.out.println(mahasiswa[indexFound].getNama() + " " + mahasiswa[indexFound].getNim() + " " + mahasiswa[indexFound].getJurusan());
               }
               else{
                   System.out.println("Data tidak ditemukan");
               }
            }
        } while (pilihanCariData != 3);
    }

    public static void linearSearch(){
        // Cari data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang ingin dicari: ");
        String xdata = scanner.nextLine();
        for (int i = 0; i < totalData; i++) {
            String temp = mahasiswa[i].getNama();
            String temp2 = mahasiswa[i].getNim();
            if (xdata.equals(temp)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim() + "  " + mahasiswa[i].getJurusan());
                System.out.println(" ");
            }
            else if (xdata.equals(temp2)){
                System.out.println("Data Yang Dicari Ditemukan!!");
                System.out.println(mahasiswa[i].getNama() + "  " + mahasiswa[i].getNim() + "  " + mahasiswa[i].getJurusan());
                System.out.println(" ");
            }
          }
    }

    public static Integer binarySearch(Mahasiswa []arr,String filterValue, int low, int high){
        quickSort(mahasiswa,0,totalData-1);
            if (low>high){
                return null;
            }
    
            else {
                int mid=(low+high)/2;
                int temp2 = Integer.parseInt(arr[mid].getNim());
                if(Integer.valueOf(filterValue)==temp2){
    
                    return mid;
                }
                else if(Integer.valueOf(filterValue)>temp2){
                    return binarySearch(mahasiswa,filterValue,mid+1,high);
    
                }
                else{
                   return binarySearch(mahasiswa,filterValue,low,mid-1);
                }
            }
    }

    public static void editData(){
        int i = 0;
        while (i<totalData){
            System.out.print(i+1+ ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }

        // Edit data mahasiswa
        System.out.print("Masukan NIM Yang Akan Diubah = ");
        int xdata = scanner.nextInt() - 1;
        System.out.print("Masukan Nama Baru = ");
        String nama = scanner.next();
        System.out.print("Masukan NIM Baru = ");
        String nim = scanner.next();
        System.out.print("Masukan Jurusan Baru = ");
        String jurusan = scanner.next();

        mahasiswa[xdata].setNama(nama);
        mahasiswa[xdata].setNim(nim);
        mahasiswa[xdata].setJurusan(jurusan);
    }

    public static void hapusData(){
        // Cari indeks mahasiswa dengan NIM yang diberikan
        int i = 0;
        while (i<totalData){
            System.out.print(i +1 + ". ");
            System.out.println(mahasiswa[i].getNama() + " " + mahasiswa[i].getNim());
            i++;
        }
    
        // Hapus data mahasiswa
        System.out.print("Masukkan NIM mahasiswa yang akan dihapus: ");
        int xdata = scanner.nextInt() - 1;
    
        System.out.println("Nama : "+mahasiswa[xdata].getNama());
        System.out.println("Nim : "+mahasiswa[xdata].getNim());
        System.out.println("Hapus Data ini? y/n");
        String pil= scanner.next();
        if(pil.equalsIgnoreCase("y")){
            mahasiswa[xdata]=null;
            for(i=0;i<totalData-1;i++){
                if(mahasiswa[i]==null){
                    mahasiswa[i]=mahasiswa[i+1];
                    mahasiswa[i+1]=null;
                }
            }
            totalData=totalData-1;
    
            System.out.println("Data Terhapus!");
        }
        else{
    
        }
    }
}