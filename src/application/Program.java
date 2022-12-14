package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        Locale.setDefault(Locale.US);
        Scanner read = new Scanner(System.in);

        System.out.println("Enter client data:");
		System.out.print("Name: ");
		String name = read.nextLine();
		System.out.print("Email: ");
		String email = read.next();
		System.out.print("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(read.next());
		
		Client client = new Client(name,email, birthDate);
		
		System.out.println("\nEnter order data:");
		System.out.print("Status: ");
		OrderStatus status = OrderStatus.valueOf(read.next().toUpperCase());

		System.out.println();
		
		Order order = new Order(new Date(), status, client);
		
		System.out.print("How many items to this order?: ");
		int n = read.nextInt();
		for(int i=0; i<n; i++) {
			
			System.out.println("\n--Enter #"+(i+1)+" item data:--\n");
			
			System.out.print("Product name: ");
			read.nextLine();
			String productName = read.nextLine();
			
			System.out.print("Product price: ");
			double productPrice = read.nextDouble();
			
			System.out.print("Quantity: ");
			int quantity = read.nextInt();
			
			Product product = new Product(productName, productPrice);
			
			OrderItem it = new OrderItem(quantity, productPrice, product);
			
			order.addItem(it);
			
		}
		
		System.out.println("\n"+order);
		
        read.close();
    }
}
