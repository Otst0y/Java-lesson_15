package lesson_15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class ZooClub {

	public Map<Person, List<Animal>> map;
	
	public Map<Person, List<Animal>> getMap() {
		return map;
	}


	public void setMap(Map<Person, List<Animal>> map) {
		this.map = map;
	}


	ZooClub(){
		this.map = new HashMap<>();
	}
	
	
	void addPerson(Person person) {
		map.put(person, new ArrayList<>());
	}
	
	void addAnimal(Person person, Animal animal) {
		if(map.containsKey(person)) {
			List<Animal> animals = map.get(person);
			animals.add(animal);
			map.put(person, animals);
		}
	}
	
	void deleteAnimalFromPerson(Person person, Animal animal) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter person's name to delete his animal:");
		String scanName = scan.next();

		Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();

		while (iterator.hasNext()) {
			Map.Entry<Person, List<Animal>> entry = iterator.next();
			Person currentPerson = entry.getKey();
			if (currentPerson.getName().equals(scanName)) {
				List<Animal> animals = entry.getValue();
				animals.remove(animal);
			}

		}
	}
	
	void deletePerson(Person person) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter person's name to delete:");
		String scanName = scan.next();
		for (Person key : map.keySet()) {
			if(key.getName().equals(scanName)) {
				map.remove(key);
			}
		}
	}
	
	void deleteAnimalFromAll(Animal animal) {
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter animal's name to delete from all members:");
		String scanName = scan.next();
		
		Iterator<Map.Entry<Person, List<Animal>>> iterator = map.entrySet().iterator();
		
		while(iterator.hasNext()) {
			Map.Entry<Person, List<Animal>> entry = iterator.next();
			List<Animal> animals = entry.getValue();
			Iterator<Animal> animalIterator = animals.iterator();
			while(animalIterator.hasNext()) {
				Animal currentAnimal = animalIterator.next();
				if(currentAnimal.getName().equals(scanName)) {
					animalIterator.remove();
				}
			}
		}
	
	}
	
	@Override
	public String toString() {
		return "ZooClub [map=" + map + "]";
	}

	
}
