package StructuredSim_Test.ExperimentHandling;

import java.util.List;

public class Parameters {
	String key;
	double value;
	String secondKey;
	List <Parameters> listParameters;
	
	public Parameters(String key, double value){
		this.key = key;
		this.value = value;
	}
	
	public Parameters(String key, List<Parameters> value) {
		this.key = key;
		this.listParameters = value;	
	}
	
	public Parameters(String key, String secondKey, double value){
		this.key = key;
		this.secondKey = secondKey;
		this.value = value;
	}
	
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	public String getSecondKey() {
		return secondKey;
	}

	public void setSecondKey(String secondKey) {
		this.secondKey = secondKey;
	}

	public List<Parameters> getListParameters() {
		return listParameters;
	}

	public void setListParameters(List<Parameters> listParameters) {
		this.listParameters = listParameters;
	}

	@Override
	public String toString(){
		return "key : " + key + " value : " + value;
	}

}
