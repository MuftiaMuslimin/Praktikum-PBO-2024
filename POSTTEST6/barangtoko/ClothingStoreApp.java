import java.util.Scanner;

public class ClothingStoreApp {
    // Variabel static
    private static int totalItems = 0;

    // Method static
    public static void displayTotalItems() {
        System.out.println("Total Items: " + totalItems);
    }

    public static void main(String[] args) {
        ClothingStore store = new ClothingStore() {
            @Override
            public void updateItem(int index, String newName, double newPrice) {
                if (index < 1 || index > items.size()) {
                    System.out.println("Nomor item tidak valid.");
                    return;
                }
                if (items.get(index - 1) instanceof ClothingItem) {
                    ClothingItem item = (ClothingItem) items.get(index - 1);
                    item.setName(newName);
                    item.setPrice(newPrice);
                    System.out.println("Item berhasil diupdate.");
                } else {
                    System.out.println("Hanya item pakaian yang dapat diupdate.");
                }
            }
        };

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== Toko Pakaian 'FASHION MM' ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tampilkan Item");
            System.out.println("3. Update Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Tampilkan Total Item");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan harga item (Rp): ");
                    double price = scanner.nextDouble();
                    store.addItem(name, price);
                    totalItems++;
                    System.out.println("Item berhasil ditambahkan.");
                    break;
                case 2:
                    store.displayItems();
                    break;
                case 3:
                    System.out.print("Pilih nomor item yang akan diupdate (1-" + store.items.size() + "): ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    System.out.print("Masukkan nama baru: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan harga baru (Rp): ");
                    double newPrice = scanner.nextDouble();
                    store.updateItem(updateIndex, newName, newPrice);
                    break;
                case 4:
                    System.out.print("Pilih nomor item yang akan dihapus (1-" + store.items.size() + "): ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    store.deleteItem(deleteIndex);
                    break;
                case 5:
                    displayTotalItems();
                    break;
                case 6:
                    System.out.println("Terima kasih sudah berkunjung!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 6);

        scanner.close();
    }
}
