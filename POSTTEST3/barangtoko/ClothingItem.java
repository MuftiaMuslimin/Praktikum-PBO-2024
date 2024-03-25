import java.util.ArrayList;
import java.util.Scanner;

public class ClothingItem extends Product {
    private static final ArrayList<ClothingItem> clothingItems = new ArrayList<>();

    public ClothingItem(String name, double price) {
        super(name, price);
    }

    public static void addItem(String name, double price) {
        clothingItems.add(new ClothingItem(name, price));
    }

    public static void displayItems() {
        if (clothingItems.isEmpty()) {
            System.out.println("Tidak ada item.");
        } else {
            System.out.println("Daftar Item:");
            int index = 1;
            for (ClothingItem item : clothingItems) {
                System.out.printf("%d. %s%n", index, item.getName());
                System.out.printf(" Harga: Rp%,.2f%n", item.getPrice());
                index++;
            }
        }
    }

    public static void updateItem(int index, String newName, double newPrice) {
        if (index < 1 || index > clothingItems.size()) {
            System.out.println("Nomor item tidak valid.");
            return;
        }
        clothingItems.get(index - 1).setName(newName);
        clothingItems.get(index - 1).setPrice(newPrice);
        System.out.println("Item berhasil diupdate.");
    }

    public static void deleteItem(int index) {
        if (index < 1 || index > clothingItems.size()) {
            System.out.println("Nomor item tidak valid.");
            return;
        }
        clothingItems.remove(index - 1);
        System.out.println("Item berhasil dihapus.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("\n=== Toko Pakaian 'FASHION MM' ===");
            System.out.println("1. Tambah Item");
            System.out.println("2. Tampilkan Item");
            System.out.println("3. Update Item");
            System.out.println("4. Hapus Item");
            System.out.println("5. Keluar");
            System.out.print("Pilih menu (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Masukkan nama item: ");
                    String name = scanner.nextLine();
                    System.out.print("Masukkan harga item (Rp): ");
                    double price = scanner.nextDouble();
                    addItem(name, price);
                    System.out.println("Item berhasil ditambahkan.");
                    break;
                case 2:
                    displayItems();
                    break;
                case 3:
                    System.out.print("Pilih nomor item yang akan diupdate (1-" + clothingItems.size() + "): ");
                    int updateIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    System.out.print("Masukkan nama baru: ");
                    String newName = scanner.nextLine();
                    System.out.print("Masukkan harga baru (Rp): ");
                    double newPrice = scanner.nextDouble();
                    updateItem(updateIndex, newName, newPrice);
                    break;
                case 4:
                    System.out.print("Pilih nomor item yang akan dihapus (1-" + clothingItems.size() + "): ");
                    int deleteIndex = scanner.nextInt();
                    scanner.nextLine(); // consume newline character
                    deleteItem(deleteIndex);
                    break;
                case 5:
                    System.out.println("Terima kasih sudah berkunjung!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid.");
            }
        } while (choice != 5);

        scanner.close();
    }
}