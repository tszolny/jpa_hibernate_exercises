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
		employee.setFirstName("Adam");
		employee.setLastName("Kowalski");
		employee.setSalary(2345.3);
		employee.setLocality("Kluczbork");
		employee.setZipCode("34-345");
		employee.setStreet("Dworcowa");
		employee.setStreetNumber(34);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}