package assignment01B;

//
// Assignment - Computer class and Computer Store Class
// © Erica Monteiro Diogo
// Written by: Erica Monteiro Diogo - ID: 2391137
//
// This assignment consists in a class "Computer" containing the following constructors:
// public Computer() - sets serial number;
// public Computer(String brand, String model, double price) - constructor with parameters;
// public Computer(Computer c) - copy constructor.
// 
// Class "Computer" also has the getters and setters, and the following methods:
// public void findNumberOfCreatedComputers() - it gives the number of created computers;
// public String toString() - shows Computer object information;
// public boolean equals(Computer c) - checks if one Computer is equal to another Computer.
//
// In ComputerStore, computers can be added to the Store's Inventory, it is possible to
// check computers' information, change them or add more computers to the inventory.

import java.util.InputMismatchException;
import java.util.Scanner;

public class ComputerStore {
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i, mC = 0, choice = 0, ncomp = 0, addcomp = 0, passtest = 0, pos, info;
		double price;
		String password="password", word, brand, model, ans = null;
		Scanner kb = new Scanner(System.in);
		
		// Welcome message
		System.out.println("Welcome to the Poney Computer Store System!");
		
		// Adding computers to the inventory,
		while (mC < 1) {
			// Exception: if the option doesn't correspond to the expected type.
			try {
				System.out.println("Please, insert the maximum number of computers you can have in inventory.");
				mC = kb.nextInt();
				if (mC < 1) {
					System.out.println("Invalid Input: it should be a positive value.");
				}
			} catch (InputMismatchException ex) {
				System.out.println("Please, insert a valid value.");
				kb.nextLine();
			}
		}
			
		Computer inventory[] = new Computer[mC];

		// Main menu
		
		do{
			System.out.println("What would you like to do?");
			System.out.println("1. Enter new computers (password required)");
			System.out.println("2. Change information of a computer (password required)");
			System.out.println("3. Display all computers by a specific brand");
			System.out.println("4. Display all computers under a certain price");
			System.out.println("5. Quit");
			// Exception: if the option doesn't correspond to the expected type.
			try {
				System.out.print("Please, type your choice:");
				choice = kb.nextInt();	
			} catch (InputMismatchException ex){
				System.out.println("Please, insert a valid value.");
				kb.nextLine();
				choice = kb.nextInt();
			}
			// Tests if it is a valid option, between 1 and 5.
			if(choice > 5 || choice < 1) {
				System.out.println("Please, type a valid option(1 to 5).");
			} else {
				// Menu options
				switch (choice) {
					case 1: // Option: New computers
						System.out.println("Please, type your password:");
						word = kb.next();
						if(word.equals(password)) {
							System.out.print("How many computers do you want to add to your inventory?");
							try {
								addcomp = kb.nextInt();
							} catch (InputMismatchException ex){
								System.out.println("Please, insert a valid value.");
								kb.nextLine();
								addcomp = kb.nextInt();
							}
							for(i=0;i<mC;i++) {
								if(inventory[i]==null) {
									ncomp++;
								}
							}
							if(addcomp <= ncomp) {
								System.out.println("Yay! You have enough space for new computers! You can add " + ncomp + " new computers!");
								for(i=0;i<addcomp;i++) {
									System.out.println("Please, insert:");
									System.out.println("Brand:");
									brand = kb.next();
									System.out.println("Model:");
									model = kb.next();
									System.out.println("Price:");
									price = kb.nextDouble();
									inventory[mC-ncomp+i]= new Computer(brand,model,price);
								}
								break;
							} else {
								System.out.println("Sorry... you can add only " + ncomp + " computers to the inventory.");
								for(i=0;i<ncomp;i++) {
									System.out.println("Please, insert: ");
									System.out.println("Brand: ");
									brand = kb.next();
									System.out.println("Model: ");
									model = kb.next();
									System.out.println("Price: ");
									price = kb.nextDouble();
									inventory[mC-ncomp+i]= new Computer(brand,model,price);
								}
							}	
						} else {
							passtest++;
							if(passtest ==3) {
								System.out.println("You wrote your password wrong for the third time!");
								break;
							}
						}
						break;
					case 2:
						System.out.print("Please, type your password:");
						word = kb.next();
						if(word.equals(password)) {
							do {
								System.out.print("Please type the number of the computer you want to update the information: ");
								try {
									pos = kb.nextInt();
								} catch (InputMismatchException ex){
									System.out.println("Please, insert a valid value.");
									kb.nextLine();
									pos = kb.nextInt();
								}					
								if(inventory[pos-1]==null) {
									System.out.print("There is no computer registered. Do you want to add a new computer? Type Y(YES) or N(NO).");
									ans = kb.next();
									if(ans=="Y") {
										System.out.println("Please, insert: ");
										System.out.println("Brand: ");
										brand = kb.next();
										System.out.println("Model: ");
										model = kb.next();
										System.out.println("Price: ");
										price = kb.nextDouble();
										inventory[pos-1]= new Computer(brand,model,price);	
									} else {
										break;
									}
								}
								System.out.println("The computer you want to change information is: ");
								System.out.println("Computer: #" + pos);				
								System.out.println("Brand: " + inventory[pos-1].brand);
								System.out.println("Model: " + inventory[pos-1].model);
								System.out.println("Serial Number: " + inventory[pos-1].SN);
								System.out.println("Price: " + inventory[pos-1].price);
								System.out.println("What information would you like to change?");
								System.out.println("1. Brand");
								System.out.println("2. Model");
								System.out.println("3. Serial Number");
								System.out.println("4. Price");
								System.out.println("5. Quit");
								System.out.print("Please, type your choice:");
								try {
									info = kb.nextInt();
								} catch (InputMismatchException ex){
									System.out.println("Please, insert a valid value.");
									kb.nextLine();
									info = kb.nextInt();
								}	
								if(info == 1) {
									System.out.println("Please, type the new brand: ");
									inventory[pos-1].brand = kb.next();
								} else {
									if(info == 2) {
										System.out.println("Please, type the new model: ");
										inventory[pos-1].model = kb.next();
									} else {
										if(info == 3) {
											System.out.println("Please, type the new serial number: ");
											inventory[pos-1].SN = kb.nextLong();
										} else {
											if(info == 4) {
												System.out.println("Please, type the new price: ");
												inventory[pos-1].price = kb.nextDouble();
											} else {
												if(info == 5) {
													break;
												}
											}
										}
									}
								}
								System.out.println("The information has been updated. Your computer now has the following informations: ");
								System.out.println("Computer: #" + pos);				
								System.out.println("Brand: " + inventory[pos-1].brand);
								System.out.println("Model: " + inventory[pos-1].model);
								System.out.println("Serial Number: " + inventory[pos-1].SN);
								System.out.println("Price: " + inventory[pos-1].price);
								System.out.println("Do you want to change another Computer's information? Type Y(YES) or N(NO).");
								ans = kb.next();
							}while( ans.equals("Y"));
						} else {
							passtest++;
							if(passtest ==3) {
								System.out.println("You wrote your password wrong for the third time!");
								break;
							}
						}
						break;
					case 3:
						ncomp = 0;
						for(i=0;i<mC;i++) {
							if(inventory[i]==null) {
								ncomp++;
							}
						}
						System.out.println("Please, type the brand you want to display the computers: ");
						String br = kb.next();
						for(i=0; i < (mC - ncomp); i++) {
							if ((inventory[i].brand).equals(br)) {
								System.out.println("Computer: #" + (i+1));				
								System.out.println("Brand: " + inventory[i].brand);
								System.out.println("Model: " + inventory[i].model);
								System.out.println("Serial Number: " + inventory[i].SN);
								System.out.println("Price: " + inventory[i].price);
							} else {
								if((inventory[i].brand).equals(null)) {
									System.out.println("There are no computers with this brand.");
								}
							}
						}
						

						break;
					case 4:
						ncomp = 0;
						for(i=0;i<mC;i++) {
							if(inventory[i]==null) {
								ncomp++;
							}
						}
						System.out.println("Please, type the maximum price you want to display the computers: ");
						price = kb.nextLong();
						for(i=0; i < (mC - ncomp); i++) {
							if(inventory[i].price <= price) {
								System.out.println("Computer: #" + (i+1));				
								System.out.println("Brand: " + inventory[i].brand);
								System.out.println("Model: " + inventory[i].model);
								System.out.println("Serial Number: " + inventory[i].SN);
								System.out.println("Price: " + inventory[i].price);
							} 
						}	
						break;
					case 5:
						System.out.println("Thank you for choosing Poney Computer Store System!");		
						break;
					default:
						break;		
				}
			}
		} while (choice < 5 && choice > 0);
	}
}
