package Validation;

import java.util.Map;
import java.util.Scanner;

import Basic_functionality.Order;
import Basic_functionality.Pet;
import Enum.Category;
import Enum.Status;

public class AddInStore {
	static String loggeduser=null	;
	static Scanner sc = new Scanner(System.in);
	private static int oid = 1;

	public static void login() {
		System.out.println("Entered Into login Portal\n");
		System.out.println("Enter the User Name");
		String userr = sc.next();
		System.out.println("Enter the password");
		String pass = sc.next();

		if (userr.equals("Admin") && pass.equals("Admin")) {
			try {
				loggeduser = "Admin";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("You have sucessfully login into Admin pOrtal");
		} else if ((userr.equals("C1") && pass.equals("C1"))) {
			try {
				loggeduser = "C1";
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("You have Sucessfully login into Customer portal");
		} else {
			loggeduser = null;
			System.out.println("Login failed. Invalid loginId or password.");
		}
	}

	public static void addpet(int petId, String name, Category cat, double unitprice, int no_stock,
			Map<Integer, Pet> pets) {
		if (pets.containsKey(petId)) {
			System.out.println("pet is already present u cant add same id");
		} else {
			pets.put(petId, new Pet(petId, name, cat, unitprice, no_stock));
			System.out.println("Pet is added");
		}
	}

	public static void Updatepet(Map<Integer, Pet> pets, int id) {

		if (pets.containsKey(id)) {
			Pet pet = pets.get(id);
			System.out.println("In update");
			System.out.println("Current pet details" + pet);
			System.out.println("Please Enter the name");
			System.out.println("Enter the new name for pet");
			pets.get(id).setName(sc.next());
			System.out.println("Enter the Category");
			String newcat = sc.nextLine();
			if (!newcat.isEmpty()) {
				pets.get(id).setCategory(Category.valueOf(sc.next().toUpperCase()));
			} else {

			}
		}
		System.out.println("unit price");
		double up = sc.nextInt();
		if (!(up == 0)) {
			pets.get(id).setUnitPrice(up);
		}

		System.out.println("Stock price");
		int sp = sc.nextInt();
		if (!(sp == 0)) {
			pets.get(id).setStocks(sp);

		}

	}

	public static void order_pet(Map<Integer, Pet> pets, int id, Map<Integer, Order> orders) {
		if (pets.containsKey(id)) {
			System.out.println("Pet is present enter quantity u want to order");
			System.out.println("have u done login?Please login first");
			
			if (loggeduser.equals("C1") || loggeduser.equals("Admin")) {

				int quantity = sc.nextInt();
				int m = pets.get(id).getStocks();
				if (quantity <= (m)) {
					pets.get(id).setStocks(m - quantity);
					System.out.println("order is placing");
					int order = oid++;
					orders.put(order, new Order(id, quantity));
					System.out.println("******Placed****");
				}
			}
		}

	}

	public static void change_status(Map<Integer, Order> orders, int id) {
		System.out.println("have u done login?Please login first");
		
		Order o = orders.get(id);
		if (orders.containsKey(id)) {
			if (loggeduser.equals("Admin")) {
				System.out.println("What u want to change in progress,completed or what");
				o.setStatus(Status.valueOf(sc.next().toUpperCase()));
				System.out.println("Changed");
			}
		}

	}

}