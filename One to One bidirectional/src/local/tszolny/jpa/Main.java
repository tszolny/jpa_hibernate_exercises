package local.tszolny.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import local.tszolny.jpa.domain.Cat;
import local.tszolny.jpa.domain.Owner;

public class Main {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myDatabase");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Owner owner = new Owner();
		Cat cat = new Cat();
		owner.setFirstName("Jan");
		owner.setLastName("Muszyñski");
		owner.setCat(cat);
		cat.setName("Frycek");
		
		
		entityManager.getTransaction().begin();
		entityManager.persist(owner);
		entityManager.persist(cat);
		entityManager.getTransaction().commit();
		
		entityManager.refresh(cat);
		
		entityManager.close();
		entityManagerFactory.close();
	}

}