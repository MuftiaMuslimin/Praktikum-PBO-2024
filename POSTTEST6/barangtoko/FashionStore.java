import java.util.ArrayList;

public class FashionStore {
    private ArrayList<Product> productList = new ArrayList<Product>();

    public void addProduct(Product product) {
        productList.add(product);
    }

    public void displayProducts() {
        for (Product item : productList) {
            System.out.println(item.getName());
            System.out.println(item.getPrice());
        }
    }

    public void updateProduct(int index, String newName, double newPrice) {
        if (index < 1 || index > productList.size()) {
            System.out.println("Nomor produk tidak valid.");
            return;
        }
        productList.get(index - 1).setName(newName);
        productList.get(index - 1).setPrice(newPrice);
        System.out.println("Produk berhasil diupdate.");
    }

    public void deleteProduct(int index) {
        if (index < 1 || index > productList.size()) {
            System.out.println("Nomor produk tidak valid.");
            return;
        }
        productList.remove(index - 1);
        System.out.println("Produk berhasil dihapus.");
    }
}
