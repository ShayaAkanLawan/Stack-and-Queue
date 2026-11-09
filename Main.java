import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        Queue antrean = new Queue(100);
        Queue riwayat = new Queue(100);

        int pilihan = 0;

        do {

            System.out.println("\n================================");
            System.out.println("      INFIX TO POSTFIX APP");
            System.out.println("================================");
            System.out.println("1. Tambahkan Ekspresi");
            System.out.println("2. Lihat Antrean");
            System.out.println("3. Proses Antrean");
            System.out.println("4. Lihat Riwayat Konversi");
            System.out.println("5. Keluar");
            System.out.println("================================");

            System.out.print("Pilih menu: ");
            String menu = input.nextLine();

            try {
                pilihan = Integer.parseInt(menu);
            } catch (NumberFormatException e) {
                System.out.println("Pilihan harus berupa angka!");
                continue;
            }

            switch (pilihan) {

                case 1:

                    System.out.print(
                        "Masukkan ekspresi Infix: "
                    );

                    String ekspresi = input.nextLine().trim();

                    if (ekspresi.isEmpty()) {
                        System.out.println(
                            "Ekspresi tidak boleh kosong!"
                        );
                    } else {
                        antrean.enqueue(ekspresi);
                    }

                    break;

                case 2:

                    antrean.display();

                    System.out.println(
                        "Jumlah antrean: " + antrean.getSize()
                    );

                    break;

                case 3:

                    if (antrean.isEmpty()) {

                        System.out.println(
                            "Tidak ada ekspresi untuk diproses!"
                        );

                    } else {

                        System.out.println(
                            "\n=== PROSES KONVERSI ==="
                        );

                        while (!antrean.isEmpty()) {

                            String infix = antrean.dequeue();

                            try {

                                String postfix =
                                    InfixToPostfix.convert(infix);

                                System.out.println(
                                    "Infix   : " + infix
                                );

                                System.out.println(
                                    "Postfix : " + postfix
                                );

                                System.out.println("------------------------");

                                riwayat.enqueue(
                                    infix + " -> " + postfix
                                );

                            } catch (IllegalArgumentException e) {

                                System.out.println(
                                    "Ekspresi: " + infix
                                );

                                System.out.println(
                                    "Error: " + e.getMessage()
                                );

                                System.out.println("------------------------");
                            }
                        }

                        System.out.println(
                            "Semua antrean selesai diproses!"
                        );
                    }

                    break;

                case 4:

                    System.out.println(
                        "\n=== RIWAYAT KONVERSI ==="
                    );

                    riwayat.display();

                    break;

                case 5:

                    System.out.println(
                        "Terima kasih telah menggunakan program!"
                    );

                    break;

                default:

                    System.out.println(
                        "Pilihan tidak tersedia!"
                    );
            }

        } while (pilihan != 5);

        input.close();
    }
}
