package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;

public class FindAndModify {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.getTransaction().begin();
		Employee employee = entityManager.find(Employee.class, 1L);
		System.out.println("Imie: " + employee.getFirstName());
		System.out.println("Nazwisko: " + employee.getLastName());
		System.out.println("Pensja: " + employee.getSalary());

		employee.setSalary(2500.0);
		
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();

}

}
