import java.util.*;
import java.util.List;
import java.util.ArrayList;


//class stocks {
        class Product {
            private int id;
            private String name;
            private int quantity;
            private int cost_price;
            private int mrp;
            private int sale_price;

            public Product(int id , String name, int quantity, int cost_price, int mrp, int sale_price){
            this.id = id;
            this.name = name;
            this.quantity = quantity;
            this.cost_price = cost_price;
            this.mrp = mrp;
            this.sale_price= sale_price;
        }
        
        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public int getQuantity(){
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
        
        public int getCp() {
            return(cost_price); 
        }

        public int getMrp() {
            return mrp;
        }

        public int getSp() {
            return sale_price;
        }
        

    }

    class inventoryMangementSystem {
        private List<Product> products;

        public inventoryMangementSystem() {
            this.products = new ArrayList<>();
        }
    

    public void addProduct(Product product)
    {
        products.add(product);
        System.out.println("Product added :" + product.getName());
    }

    public void displayProducts() {
        System.out.println("Product is in inventory:");
        for (Product product : products)
        {
            System.out.println("ID:" + product.getId() + ", Name: " + product.getName() + ", Quantity: " + product.getQuantity() + ", Cost Price: " + product.getCp() + ", MRP: " + product.getMrp() + ", Sale Price: " + product.getSp()) ;
        }
    }

    public void updateProductQuantity(int productId, int newQuantity) {
        for (Product product : products){
            if (product.getId()==productId) {
                product.setQuantity(newQuantity);

                System.out.println("Quantity is updated for product :" + product.getName());
                return;
            }
        }
        System.out.println("Product not found. ");
        }

    public void sale(int productId, int saleQuantity ){
        for(Product product : products) {
            if(product.getId()==productId) {
                product.setQuantity(product.getQuantity()- saleQuantity);
            System.out.println("The sale quantity has been updated in Actual stock for " +  product.getName());
            }

            System.out.println("Product not found. ");
        }
    }

    

    }





    
    
class stocks{
    public static void main(String[] args) {
        
        inventoryMangementSystem inventorySystem = new inventoryMangementSystem();
        Scanner sc = new Scanner(System.in);
        Product product1 = new Product(1, "SherwaniRed", 10,5000, 20000,15000);
        Product product2 = new Product(2, "Kurti", 5 ,500, 1500, 1000);
        Product product3 = new Product(3,"white_Shirt",20,500,2000,1500);
        inventorySystem.addProduct(product1);

        inventorySystem.addProduct(product2);
        inventorySystem.addProduct(product3);
        inventorySystem.displayProducts();

        System.out.println("Press 1 : If you want to add a product: ");
        System.out.println("Press 2 : If you want to delete a product: ");
        System.out.println("Press 3 : If you want to sale a product: ");
        System.out.println("Press 4 : If you want to update product quantity: ");
        System.out.print("Enter your option :");
        int flag = sc.nextInt();

        if(flag==3){
            System.out.println("Enter the product Code: ");
            int productId = sc.nextInt();
            System.out.println("Enter the sale quantity: ");
            int saleQuantity = sc.nextInt();
            inventorySystem.sale(productId,saleQuantity);
        }
        
        if(flag ==4){
        System.out.println("enterb the Product Id to update quantity:  ");
        
        int productId = sc.nextInt();
        System.out.println("Enter the new Quantity: ");
        int newQuantity = sc.nextInt();

        inventorySystem.updateProductQuantity(productId, newQuantity);
        }
        inventorySystem.displayProducts();

    }
    

}