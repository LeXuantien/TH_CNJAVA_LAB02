package Lab02_3;

import java.util.List;
import java.util.Scanner;

public class Program {
	private static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		//Nhap thong tin ket noi vao dtb
		System.out.print("Enter server's url: ");//jdbc:mysql://localhost:3306"
		String serverUrl = sc.nextLine();
		System.out.println("Enter User: "); // VD: "root"
		String user = sc.nextLine();
		System.out.println("Enter password: "); // VD: ""
		String password = sc.nextLine();
		
		//Khoi tao productDao dung de thao tac voi db
		ProductDAO productDao = new ProductDAO(serverUrl, user, password);
		
		if(productDao.getConnection() != null) {
			System.out.println("Connect database successfully");
			
			handleUserChoose(productDao);
		} else {
			System.out.println("Connect database faliure!");
			System.out.println("===End Program===");
		}
	}
	private static void handleUserChoose(ProductDAO productDao) {
		boolean existOption = false;
		
		do {
			System.out.println("\n........Options.........");
			System.out.println("1. Read all products");
			System.out.println("2. Read detail of a prodcut by id");
			System.out.println("3. Add a new product");
			System.out.println("4. Update a product");
			System.out.println("5. Delete a product by id.");
			System.out.println("6. Exit");
			System.out.println("\nYour choice: ");
			String choice = sc.nextLine();
			
			switch (choice) {
			case "1":
				handleReadAllProducts(productDao);
				break;
			case "2":
				handleReadProductDetailById(productDao);
				break;
			case "3":
				handleAddNewProduct(productDao);
				break;
			case "4":
				handleUpdateProduct(productDao);
				break;
			case "5":
				handleDeleteProductByid(productDao);
				break;
			case "6":
				existOption = true;
				System.out.println("===End Program===");
			default:
				System.out.println("Your select is not exist, please choose again!!!");
			}
		} while (!existOption);
		
	}
	private static void handleDeleteProductByid(ProductDAO productDao) {
		System.out.println("Enter product's id:");
		int id = sc.nextInt();
		sc.nextLine();
		if(productDao.delete(id)) {
			System.out.println("Delete product successfully");
		} else {
			System.out.println("Product with id=" + id + "does not exist.");
		}
	}
	private static void handleUpdateProduct(ProductDAO productDao) {
		System.out.println("Enter product's id:");
		int id = sc.nextInt();
		sc.nextLine();
		Product product = productDao.read(id);
		if (product != null) {
			System.out.println("Enter product's name:");
			String name = sc.nextLine();
			System.out.println("Enter prodcut's price:");
			Integer price = sc.nextInt();
			sc.nextLine();
			product.setName(name);
			product.setPrice(price);
			if(productDao.update(product)) {
				System.out.println("Update product successfully!");
			} else {
				System.out.println("Update product failture, please try again");
			}
		} else {
			System.out.println("Product with id=" + id + "does not exist.");
		}
		
	}
	private static void handleAddNewProduct(ProductDAO productDao) {
		System.out.println("Enter product's name:");
		String name = sc.nextLine();
		System.out.println("Enter prodcut's price:");
		Integer price = sc.nextInt();
		Product product = new Product();
		product.setName(name);
		product.setPrice(price);
		if(productDao.add(product) != null) {
			System.out.println("Add product sucessfully");
		} else {
			System.out.println("Add product failure, please try again");
		}
	}
	private static void handleReadProductDetailById(ProductDAO productDao) {
		System.out.println("Enter product's id: ");
		Integer id = sc.nextInt();
		sc.nextLine();
		Product product = productDao.read(id);
		if(product != null) {
			System.out.println(product.toString());
		} else {
			System.out.println("Product with id=" + id + "does not exist.");
		}
	}
	private static void handleReadAllProducts(ProductDAO productDao) {
		List<Product> products = productDao.readAll();
		System.out.println("\nProduct List:");
		
		for(Product product: products) {
			System.out.println(product.toString());
		}
	}
}