package lesson_15;

import java.util.Scanner;

public class Main {

	static void menu() {
		System.out.println("Enter 1 to add a member to club:");
		System.out.println("Enter 2 to add an animal to member:");
		System.out.println("Enter 3 to delete an animal from a member:");
		System.out.println("Enter 4 to delete a member from club:");
		System.out.println("Enter 5 to delete an animal from all members:");
		System.out.println("Enter 6 to show Zoo:");
		System.out.println("Enter 7 to exit:");
	}
	
	public static void main(String[] args) {
		
		ZooClub zC = new ZooClub();
		
		Person person1 = new Person("Dave", 55);
		Animal animal1 = new Animal("Bone", "Dog");
		
		
		while(true) {
			menu();
			
			Scanner scan = new Scanner(System.in);
			int scanMenu = scan.nextInt();
			switch (scanMenu) {
			case 1:
				zC.addPerson(person1);				
				break;
			case 2:
				zC.addAnimal(person1, animal1);				
				break;
			case 3:
				zC.deleteAnimalFromPerson(person1, animal1);				
				break;
			case 4:
				zC.deletePerson(null);				
				break;
			case 5:
				zC.deleteAnimalFromAll(null);				
				break;
			case 6:
				System.out.println(zC);				
				break;
			case 7:
				System.exit(0);			
				break;

			default:
				break;
			}
		}
		

	}

}
