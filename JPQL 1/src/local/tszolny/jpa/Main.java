package local.tszolny.jpa;

import java.util.Iterator;

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
		
//		Pojedynczy obiekty typu Employee:
//		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.lastName = 'Frycz'", Employee.class);
//		Employee employee = query.getSingleResult();
//		
//		System.out.println("First name: " + employee.getFirstName());
//		System.out.println("Last name: " + employee.getLastName());
//		System.out.println("Salary: " + employee.getSalary());

		
//		Lista obiekt�w typu Employee:
//		TypedQuery<Employee> query = entityManager.createQuery("select e from Employee e where e.salary > 3000 order by salary", Employee.class);
//		List<Employee> employees = query.getResultList();
//		
//		for (Employee e : employees) {
//			System.out.println("First name: " + e.getFirstName());
//			System.out.println("Last name: " + e.getLastName());
//			System.out.println("Salary: " + e.getSalary());
//			System.out.println();
//		}

		//		Lista tablic obiekt�w typu Object (m�j spos�b):
//		Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), salary * 0.2 from Employee e");
//		List resultList = query.getResultList();
//		for (Object o : resultList) {
//			Object[] employee = (Object[]) o;
//			System.out.println(employee[0]);
//			System.out.println(employee[1]);
//			System.out.println();
//		}
		
		//		Lista tablic obiekt�w typu Object (spos�b wyk�adaj�cego):
		Query query = entityManager.createQuery("select concat(e.firstName, ' ', e.lastName), salary * 0.2 from Employee e");
		Iterator<?> iterator = query.getResultList().iterator();
		while (iterator.hasNext()) {
			Object[] item = (Object[]) iterator.next();
			String name = (String) item[0];
			double tax = (double) item[1];
			System.out.println(name + " has to pay " + tax);
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