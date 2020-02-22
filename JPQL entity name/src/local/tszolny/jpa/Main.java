package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import local.tszolny.jpa.domain.Employee;

public class Main {
	private static EntityManagerFactory entityManagerFactory;
	private static EntityManager entityManager;
	
	public static void main(String[] args) {
		entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		entityManager = entityManagerFactory.createEntityManager();
		
		addEmployees();
		
		TypedQuery<Employee> query = entityManager.createQuery("select e from Pracownik e where e.salary > :minSalary", Employee.class);
		query.setParameter("minSalary", 5000.0);

		for (Employee e : query.getResultList()) {
			System.out.println(e.getFirstName());
			System.out.println(e.getLastName());
			System.out.println(e.getSalary());
			System.out.println();
		}
		
		entityManager.close();
		entityManagerFactory.close();
	}
	
	public static void addEmployees() {
		addEmployee("Jan", "Nowak", 3000);
		addEmployee("Anna", "Zawadzka", 3500);
		addEmployee("Janina", "Nowak", 2700);
		addEmployee("Urszula", "Nowak", 4200);
		addEmployee("Zenon", "Kowalski", 5600);
		addEmployee("Lucjan", "Adamczyk", 3900);
		addEmployee("Krzysztof", "Kowalski", 7200);
		addEmployee("Anna", "Frasek", 2700);
		addEmployee("Alicja", "Frycz", 2700);
		addEmployee("Adam", "Kr�l", 5300);
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