package lab;

import java.io.FileInputStream;
import java.util.Scanner;
import java.io.FileNotFoundException;

public class Q6 {
    public static void main(String[] args) {
        String [][] productArr = new String[7][3];
        String [][] orderArr = new String[5][3];
        
        try {
            Scanner sc = new Scanner(new FileInputStream("lab/lab07/product.txt"));

            for (int i = 0; sc.hasNextLine(); i++){
                String line = sc.nextLine();
                productArr[i] = line.split(",");
            }

            sc = new Scanner(new FileInputStream("lab/lab07/order.txt"));

            for (int i = 0; sc.hasNextLine(); i++){
                String line = sc.nextLine();
                orderArr[i] = line.split(",");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
        
        System.out.printf("%-10s %-20s %-8s %-12s %8s%n", "ProductID", "ProductName", "Quantity", "PricePerUnit", "Total");
        for (int i=0; i < orderArr.length; i++){
            int linkIndex = getLinkIndex(orderArr[i][1], productArr);
            if(linkIndex > 0){
                double pricePerUnit = Double.parseDouble(productArr[linkIndex][2]);
                int quantity = Integer.parseInt(orderArr[i][2]);
                double totalPrice = pricePerUnit * quantity;
                System.out.printf("%-10s %-20s %-8d %-12.2f %8.2f%n", productArr[linkIndex][0], productArr[linkIndex][1], quantity, pricePerUnit, totalPrice);
            }   
        }
    }
    public static int getLinkIndex (String productId, String [][] productArr){
        for (int i = 0; i < productArr.length; i++){
            if (productArr[i][0].equals(productId)){
                return i;
            }
        }
        return -1;
    }
}
