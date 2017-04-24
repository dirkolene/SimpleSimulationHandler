package StructuredSim_Test.mockUpSim;

import java.io.IOException;

import StructuredSim_Test.ExperimentHandling.Environment;
import util.FileManagement;


public class SimpleSimulationHandler {
	FileManagement fm = new FileManagement();
	public String filePathOrigin = "./data/results.txt";
	public String filePathTransfer = "./data/sim";
	

	public void startSimultation(Environment e){
		System.out.println("\t >> " + e.getSetOfParameters()[0].getValue());
		double result = e.getSetOfParameters()[0].getValue() + 1;
		try{
			fm.saveSimultationResult(Double.toString(result));
			fm.createFolder(filePathTransfer + e.getID());
			fm.moveFile(filePathOrigin, filePathTransfer + e.getID() + "/results.txt");

		}catch (IOException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
	}

}
