interface StoreAction {
    void addItem(String name, double price);
    void displayItems();
    void updateItem(int index, String newName, double newPrice);
    void deleteItem(int index);
    
    static void welcomeMessage() {
        System.out.println("Selamat datang di toko pakaian 'FASHION MM'");
    }
    
    static void thankYouMessage() {
        System.out.println("Terima kasih sudah berkunjung!");
    }
}
