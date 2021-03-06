package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setFirstName("Damian");
		employee.setLastName("Mielonka");
		employee.setSalary(4000.0);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		System.out.println("ID: " + employee.getId());
		System.out.println("First Name: " + employee.getFirstName());
		System.out.println("Last Name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Tax: " + employee.getTax());
		System.out.println();
		
		entityManager.refresh(employee);
		
		System.out.println("ID: " + employee.getId());
		System.out.println("First Name: " + employee.getFirstName());
		System.out.println("Last Name: " + employee.getLastName());
		System.out.println("Salary: " + employee.getSalary());
		System.out.println("Tax: " + employee.getTax());
		System.out.println();

		entityManager.close();
		entityManagerFactory.close();
	}

}