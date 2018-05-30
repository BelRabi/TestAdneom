package fr.adneom.test.adneomTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.adneom.test.Exception.TailleParameterNegativeException;
import fr.adneom.test.Exception.TailleParameterNullException;

public class Main {

	public static void main(String[] args) {
		List<Integer> myList = new ArrayList<>();

		Scanner clavier = new Scanner(System.in);
		System.out.println("Veuillez entrer la taille de la liste.");
		boolean testException = false;
		int listValue;
		int length = myList.size();
		int subListLength = 0;
		try {
			length = Integer.parseInt(clavier.nextLine());
			if (length < 0) {
				throw new TailleParameterNegativeException("La valeur entrée est négatif");
			} else if (length == 0) {
				throw new TailleParameterNullException("La taille entrée La liste est egale à zero.");
			}
			for (int i = 0; i < length; i++) {
				System.out.println(String.format("Entrez le valeur n° %s : ", i + 1));
				listValue = Integer.parseInt(clavier.nextLine());
				myList.add(listValue);
			}
			System.out.println("Entrez le taille entré en parametre");
			subListLength = Integer.parseInt(clavier.nextLine());

		} catch (NumberFormatException e) {
			System.out.println("La valeur entrée est non valide." + e.getMessage());
			testException = true;
		}

		if (testException == false) {
			ServicePartition servicePartition = new ServicePartition();
			System.out.println("La liste de sous liste avec un taille de sous liste egale à " + subListLength + " est "
					+ servicePartition.partition(myList, subListLength));
		}

	}

}
