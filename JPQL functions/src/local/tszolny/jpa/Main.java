package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		addEmployees();
		Query query = entityManager.createQuery("select avg(e.salary), min(e.salary), max(e.salary), sum(e.salary), count(e) from Employee e");
		Object[] result = (Object[]) query.getSingleResult();
		System.out.println("Œrednia: " + result[0]);
		System.out.println("Min: " + result[1]);
		System.out.println("Max: " + result[2]);
		System.out.println("Suma: " + result[3]);
		System.out.println("Pracowników: " + result[4]);
		
		
		query = entityManager.createQuery("select substring(e.firstName,1,2), trim(e.lastName), lower(e.firstName), upper(e.firstName), length(e.firstName) from Employee e where firstName = 'Jan'");
		result = (Object[]) query.getSingleResult();
		System.out.println("Pierwsze 2 litery z imienia: " + result[0]);
		System.out.println("Nazwisko bez spacji: |" + result[1] + '|');
		System.out.println("Nazwisko pisane ma³ymi literami: " + result[2]);
		System.out.println("Nazwisko pisane wielkimi literami:" + result[3]);
		System.out.println("Iloœæ liter w imieniu: " + result[4]);
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void addEmployees() {
		addEmployee("Jan", "   Nowak   ", 3000);
		addEmployee("Anna", "Zawadzka", 3500);
		addEmployee("Janina", "Nowak", 2700);
		addEmployee("Urszula", "Nowak", 4200);
		addEmployee("Zenon", "Kowalski", 5600);
		addEmployee("Lucjan", "Adamczyk", 3900);
		addEmployee("Krzysztof", "Kowalski", 7200);
		addEmployee("Anna", "Frasek", 2700);
		addEmployee("Alicja", "Frycz", 2700);
		addEmployee("Adam", "Król", 5300);
		addEmployee("Grzegorz", "Kubacki", 2900);
	}
	
	public static void addEmployee(String firstName, String lastName, double salary) {
		Employee employee = new Employee();
		employee.setFirstName(firstName);
		employee.setLastName(lastName);
		employee.setSalary(salary);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
	}

}