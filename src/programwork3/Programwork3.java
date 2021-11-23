package programwork3;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.OrderStatus;
import entities.Product;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Scanner;

public class Programwork3 {
    public static void main(String[] args) throws ParseException {
        
    Scanner sc = new Scanner(System.in);
    SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");

    
        System.out.println("Enter cliente data:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Birth date (DD/MN/YYYY):");
        Date birthDate = sdf1.parse(sc.next());
        Client c1 = new Client(name, email, birthDate);
        
        
        System.out.println();
        System.out.println("Enter order Data: ");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());
        
        Order order = new Order(new Date(), status, c1);
        
        System.out.print("How many items to this order? ");
        int n = sc.nextInt();
        		for (int i=1; i<=n; i++) {
			System.out.println("Enter #" + i + " item data:");
			System.out.print("Product name: ");
			sc.nextLine();
			String productName = sc.nextLine();
			System.out.print("Product price: ");
			double productPrice = sc.nextDouble();

			Product product = new Product(productName, productPrice);

			System.out.print("Quantity: ");
			int quantity = sc.nextInt();

			OrderItem orderItem = new OrderItem(quantity, productPrice, product); 

			order.addItem(orderItem);
		}
        System.out.println();
        System.out.println("ORDER SUMMARY:");
	System.out.println(order);
		
        sc.close();

} 
}
