package fr.adneom.test.adneomTest;

import java.util.ArrayList;
import java.util.List;

import fr.adneom.test.Exception.TailleParameterNegativeException;
import fr.adneom.test.Exception.TailleParameterNullException;
import fr.adneom.test.Exception.TailleParameterSuperiorListLength;

public class ServicePartition {

	public ServicePartition() {
	}

	public List<List> partition(List<Integer> myList, int length) {

		myList=new ArrayList<>();
		try {
			myList.isEmpty();
		} catch (NullPointerException e) {
			e.getMessage();
		}
		
		
//		if (myList.isEmpty()) {
//			throw new ListNullException("Liste est vide.");
//		}
		if (length == 0) {
			throw new TailleParameterNullException(
					String.format("La taille entrée en parametre :[  %s  ]est égale à zéro.", length));
		}
		if (length < 0) {
			throw new TailleParameterNegativeException(
					String.format("La taille entrée en parametre :[  %s  ]est négative .", length));
		}
		if (length > myList.size()) {
			throw new TailleParameterSuperiorListLength(String
					.format("La taille entrée en parametre :[  %s  ]est superieur à la taille de la liste.", length));
		}

		int myListSize = myList.size();

		int index = 0;

		int firstElementInSubListe = 0;

		int lastElementInSubList;

		List<List> listResult = new ArrayList<>();

		List<Integer> subListe = new ArrayList<Integer>();

		while (index < myListSize) {

			lastElementInSubList = firstElementInSubListe + length;
			if (lastElementInSubList < myListSize) {

				while (firstElementInSubListe < lastElementInSubList) {
					subListe.add(myList.get(index));
					firstElementInSubListe++;
					index++;
				}
				listResult.add(subListe);
				subListe = new ArrayList<>();
			} else {
				lastElementInSubList = myListSize;
				while (firstElementInSubListe < lastElementInSubList) {
					subListe.add(myList.get(index));
					firstElementInSubListe++;
					index++;
				}
				listResult.add(subListe);
			}
		}
		return listResult;
	}

}
