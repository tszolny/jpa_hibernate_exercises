package local.tszolny.jpa.domain;

import java.math.BigDecimal;
import java.math.BigInteger;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class PossibleTypes {
	@Id
	@GeneratedValue
	private long id;
	
	private int someInt;
	private short someShort;
	private double someDouble;
	private boolean someBoolean;
	
	private Integer someInteger;
	private BigInteger someBigInteger;
	private BigDecimal someBigDecimal;
	
	private int[] integerArray;
	private double[] doubleArray;
	
	private MyEnum myEnum;
	@Transient
	private int ignoredField;

	public int getSomeInt() {
		return someInt;
	}

	public void setSomeInt(int someInt) {
		this.someInt = someInt;
	}

	public short getSomeShort() {
		return someShort;
	}

	public void setSomeShort(short someShort) {
		this.someShort = someShort;
	}

	public double getSomeDouble() {
		return someDouble;
	}

	public void setSomeDouble(double someDouble) {
		this.someDouble = someDouble;
	}

	public boolean isSomeBoolean() {
		return someBoolean;
	}

	public void setSomeBoolean(boolean someBoolean) {
		this.someBoolean = someBoolean;
	}

	public Integer getSomeInteger() {
		return someInteger;
	}

	public void setSomeInteger(Integer someInteger) {
		this.someInteger = someInteger;
	}

	public BigInteger getSomeBigInteger() {
		return someBigInteger;
	}

	public void setSomeBigInteger(BigInteger someBigInteger) {
		this.someBigInteger = someBigInteger;
	}

	public BigDecimal getSomeBigDecimal() {
		return someBigDecimal;
	}

	public void setSomeBigDecimal(BigDecimal someBigDecimal) {
		this.someBigDecimal = someBigDecimal;
	}

	public int[] getIntegerArray() {
		return integerArray;
	}

	public void setIntegerArray(int[] integerArray) {
		this.integerArray = integerArray;
	}

	public double[] getDoubleArray() {
		return doubleArray;
	}

	public void setDoubleArray(double[] doubleArray) {
		this.doubleArray = doubleArray;
	}

	public MyEnum getMyEnum() {
		return myEnum;
	}

	public void setMyEnum(MyEnum myEnum) {
		this.myEnum = myEnum;
	}

	public long getId() {
		return id;
	}

	public int getIgnoredField() {
		return ignoredField;
	}

	public void setIgnoredField(int ignoredField) {
		this.ignoredField = ignoredField;
	}

}
