package local.tszolny.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Employee;
import local.tszolny.jpa.domain.Phone;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Employee employee = new Employee();
		employee.setFirstName("Adam");
		employee.setLastName("Bonk");
		List<Phone> phones = new ArrayList<>();
		Phone phone1 = new Phone();
		Phone phone2 = new Phone();
		phone1.setType("domowy");
		phone1.setNumber("1234566");
		phone2.setType("s³u¿bowy");
		phone2.setNumber("4351234");
		phones.add(phone1);
		phones.add(phone2);
		employee.setPhones(phones);
		
		entityManager.getTransaction().begin();
		entityManager.persist(employee);
		entityManager.persist(phone1);
		entityManager.persist(phone2);
		entityManager.getTransaction().commit();
		
		entityManager.close();
		entityManagerFactory.close();
	}

}