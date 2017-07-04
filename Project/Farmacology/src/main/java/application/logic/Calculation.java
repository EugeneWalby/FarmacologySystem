package application.logic;

import java.util.ArrayList;

public class Calculation {
	private final double SMALL_DOSE = 0.005;
	private final double STD_DOSE = 0.01;
	public int medCount = 0;

	private ArrayList<Integer> medicineID;
	private ArrayList<Double> quantity;
	
	public Calculation() {
		medicineID = new ArrayList<Integer>();
		quantity = new ArrayList<Double>();
	}

	public void calculate(int diseaseID) {
		if (diseaseID == 1 || diseaseID == 9 || diseaseID == 13 
											|| diseaseID == 16 ) {
			// temperature or itch part
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 1;
		} else if (diseaseID == 2) {
			// headache full
			medicineID.add(5);
			quantity.add(STD_DOSE);
			medicineID.add(4);
			quantity.add(SMALL_DOSE);
			medicineID.add(2);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 4;
		} else if (diseaseID == 3 || diseaseID == 12) {
			// itch or temp full
			medicineID.add(7);
			quantity.add(STD_DOSE);
			medCount = 1;
		} else if (diseaseID == 4 || diseaseID == 14) {
			// weakness part
			medicineID.add(5);
			quantity.add(SMALL_DOSE);
			medicineID.add(6);
			quantity.add(SMALL_DOSE);
			medicineID.add(1);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 4;
		} else if (diseaseID == 5) {
			// nausea full
			medicineID.add(1);
			quantity.add(STD_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 2;
		} else if (diseaseID == 6) {
			// rash part
			medicineID.add(2);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 2;
		} else if (diseaseID == 7 || diseaseID == 15) {
			// dizziness full
			medicineID.add(6);
			quantity.add(SMALL_DOSE);
			medicineID.add(1);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 3;
		} else if (diseaseID == 8) {
			// headache part
			medicineID.add(5);
			quantity.add(SMALL_DOSE);
			medicineID.add(4);
			quantity.add(SMALL_DOSE);
			medicineID.add(2);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 4;
		} else if (diseaseID == 10) {
			// dizziness part
			medicineID.add(2);
			quantity.add(SMALL_DOSE);
			medicineID.add(7);
			quantity.add(SMALL_DOSE);
			medCount = 2;
		}
	}
	
	public ArrayList<Integer> getMedicineID() {
		return medicineID;
	}


	public ArrayList<Double> getQuantity() {
		return quantity;
	}

}
