package StructuredSim_Test.ExperimentHandling;

import java.util.List;

public class Environment {

	protected int ID;
	protected Parameters[] setOfParameters ;
	protected Parameters parameter;
	protected double probability;

	/**
	 * 
	 * @param i : ID 
	 * @param setOfParam : List of Paramters of this Environment
	 * @param probability : Probability 
	 */
	public Environment(int i, Parameters[] setOfParam, double probability){
		this.ID = i;
		this.probability = probability;
		this.setOfParameters = setOfParam;
	}
	
	public Environment(int i, Parameters p, double probability){
		this.ID = i;
		this.probability = probability;
		this.parameter = p;
	}
	
	

	public Parameters[] getSetOfParameters() {
		return setOfParameters;
	}

	public void setSetOfParameters(Parameters[] setOfParameters) {
		this.setOfParameters = setOfParameters;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}


	public double getProbability() {
		return probability;
	}

	public void setProbability(double probability) {
		this.probability = probability;
	}



}
