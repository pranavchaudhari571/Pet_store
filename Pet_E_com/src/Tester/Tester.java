package Tester;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import Basic_functionality.*;
import Enum.Category;
import Validation.AddInStore;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			boolean exit = true;
			Map<Integer, Pet> pets = new HashMap<Integer, Pet>();
			Map<Integer, Order> orders = new HashMap<Integer, Order>();
			pets.put(101, new Pet(101, "Bull Dog", Category.DOG, 1000, 50));
			pets.put(102, new Pet(102, "Siamese Cat", Category.CAT, 800, 30));
			pets.put(103, new Pet(103, "Rabbit", Category.RABBIT, 150, 20));
			pets.put(104, new Pet(104, "Goldfish", Category.FISH, 50, 100));

			while (exit) {

				System.out.println("*************************Menu******************");
				System.out.println("You have Entered to the Portal\n1) Login\n" + "2) Add New Pet\n"
						+ "3) Update the Pet details\n" + "4) Display all avaliable Pets \n" + "5) Order a Pet \n"
						+ "6) Check order status by order Id  \n" + "7) Update theOrder satus");

				try {
					switch (sc.nextInt()) {
					case 0:
						exit = false;
						break;
					case 1:

						AddInStore.login();
						System.out.println("Entered into login portal");
						break;
					case 2:
						System.out.println(
								"Enter the \n1} PetId,Pet Name\n,2} category Like (CAT, DOG, RABBIT, FISH)\n,2} price per unit\n,2} Sctock ");
						AddInStore.addpet(sc.nextInt(), sc.next(), Category.valueOf(sc.next().toUpperCase()),
								sc.nextDouble(), sc.nextInt(), pets);

						break;
					case 3:
						System.out.println("Update the pet details");
						System.out.println("Enter the Id for Pet to change for the following");
						int id = sc.nextInt();
						AddInStore.Updatepet(pets, id);

						break;
					case 4:
						System.out.println("Display all pets availabel");
						pets.forEach((Integer, Pet) -> System.out.println(Pet));

						break;
					case 5:
						System.out.println("Ordering pet");
						System.out.println("Enter the petId u want order");
						AddInStore.order_pet(pets, sc.nextInt(), orders);

						break;

					case 6:
						System.out.println("Check order Status  by orderId");
						System.out.println("Enter order id");
						int i = sc.nextInt();
						if (orders.containsKey(i)) {
							System.out.println(orders.get(i));
						}

						break;

					case 7:
						System.out.println("Changing status please enter order id");
						AddInStore.change_status(orders, sc.nextInt());
						break;
					

					default:
						break;
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
					sc.nextLine();

				}

			}
		}

	}
}