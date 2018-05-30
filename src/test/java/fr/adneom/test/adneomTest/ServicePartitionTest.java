package fr.adneom.test.adneomTest;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import fr.adneom.test.Exception.TailleParameterNegativeException;
import fr.adneom.test.Exception.TailleParameterNullException;
import fr.adneom.test.Exception.TailleParameterSuperiorListLength;
import junit.framework.TestCase;

/**
 * Unit test for simple App.
 */
public class ServicePartitionTest extends TestCase {

	private ServicePartition servicePartition;

	/*
	 * List NULL
	 */

	@Test

	public void testPartitionWithListNull() {

		List<Integer> myList = new ArrayList<Integer>();

		int length = 2;

		servicePartition = new ServicePartition();

		try {
			myList.size();
		} catch (TailleParameterNullException e) {
			assertThat(e.getMessage(), is("La taille entrée La liste est egale à zero."));
		}

	}
	/*
	 * Length Parameter NULL
	 */

	@Test

	public void testPartitionWithParameterLengthtNull() {

		List<Integer> myList = new ArrayList<Integer>();

		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(5);

		int length = 0;

		servicePartition = new ServicePartition();

		try {
			servicePartition.partition(myList, length);
		} catch (TailleParameterNullException e) {
			assertThat(e.getMessage(),
					is(String.format("La taille entrée en parametre :[  %s  ]est égale à zéro.", length)));
		}
	}

	/*
	 * Parameter Superior List Lenght
	 */

	@Test

	public void testPartitionWithWithParameterSuperiorToLengthl() {

		List<Integer> myList = new ArrayList<Integer>();

		myList.add(1);
		myList.add(2);
		myList.add(3);
		int length = 5;

		servicePartition = new ServicePartition();
		try {
			servicePartition.partition(myList, length);
		} catch (TailleParameterSuperiorListLength e) {
			assertThat(e.getMessage(), is(String
					.format("La taille entrée en parametre :[  %s  ]est superieur à la taille de la liste.", length)));
		}
	}

	/*
	 * Length Parameter NEGATIVE
	 */

	@Test

	public void testPartitionWithLengthZero() {
		java.util.List<Integer> list1 = new ArrayList<Integer>();
		list1.add(1);
		list1.add(2);
		list1.add(3);
		list1.add(4);
		list1.add(5);
		int length = -2;
		servicePartition = new ServicePartition();
		try {
			servicePartition.partition(list1, length);
		} catch (TailleParameterNegativeException e) {
			assertThat(e.getMessage(),
					is(String.format("La taille entrée en parametre :[  %s  ]est négative .", length)));
		}
	}
}
