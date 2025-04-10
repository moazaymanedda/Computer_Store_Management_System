package rs.ac.uns.ftn.db.jdbc.exam.ui_handler;

public class ComplexFunctionalityUIHandler {

	public void handleComplexFunctionalityMenu() {
		String answer;
		do {
			System.out.println("\nOdaberite funkcionalnost:");
			// TODO: update menu
			System.out.println("\n1 -");
			System.out.println("\n2 -");

			System.out.println("\nX - Izlazak iz kompleksnih funkcionalnosti");

			answer = MainUIHandler.sc.nextLine();

			switch (answer) {
			case "1":
				break;
			case "2":
				break;

			}

		} while (!answer.equalsIgnoreCase("X"));
	}

}
