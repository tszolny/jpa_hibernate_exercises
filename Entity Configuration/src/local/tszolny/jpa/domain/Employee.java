package local.tszolny.jpa.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Pracownicy")
public class Employee {
	@Id
	@GeneratedValue
	private long id;
	@Column(name = "Imie", nullable = false, length = 10)
	private String firstName;
	@Column(name = "Nazwisko", columnDefinition = "VARCHAR(10) NOT NULL")
	private String lastName;
	@Column(name = "Pensja")
	private double salary;
	@Column(name = "Pensja2", precision = 10, scale = 2)
	private BigDecimal salary2;
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public BigDecimal getSalary2() {
		return salary2;
	}
	public void setSalary2(BigDecimal salary2) {
		this.salary2 = salary2;
	}
	public long getId() {
		return id;
	}
	
}
