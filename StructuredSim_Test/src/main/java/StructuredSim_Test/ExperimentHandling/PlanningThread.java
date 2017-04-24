package StructuredSim_Test.ExperimentHandling;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;



public class PlanningThread implements Runnable{
	
	//Variable
	protected double cuttOffPlanning;
	protected BlockingQueue<Environment> queue ;
	protected Environment currentEnvironment, baseEnvironment;

	//Constructor
	public PlanningThread(BlockingQueue<Environment> queue, Environment baseEnv, double cuttOfPlanning){
		this.queue = queue;
		this.baseEnvironment = baseEnv;
		this.cuttOffPlanning = cuttOfPlanning;
	}

	/**
	 * Creating a new Environment based on a created Environment (Base or currentEnvironment)
	 * @param old : Previous Environment in the BlockingQueue
	 * @return e : The new Environment created
	 */
	public Environment createNextEnvironment (Environment old){
		Environment o;
		int id = old.getID()+1;
		Parameters [] arrayParam = old.setOfParameters;
		arrayParam[0].value +=  5;
		
		o = new Environment(id, arrayParam, 1);
		
//		Environment e;
//		int id = old.getID() + 1;
//		List<Parameters> listParam = new ArrayList<Parameters>();
//		
//		for(int i = 0; i< old.setOfParameters.size(); i++){
//			listParam.add(old.setOfParameters.get(i));
//		}
//		
//		double value = listParam.get(0).getValue() + 5;
//		listParam.get(0).setValue(value);
//		double proba = old.getProbability();
//		e = new Environment(id, listParam, proba);
//		
//		Environment o ;
//		int id = old.getID();
//		Parameters param = old.parameter;
//		param.value += 5;
//		o = new Environment(id+1, param, 1);

		return o;

	}

	/**
	 * Add an Environment to the BlockingQueue. A trace is printed to indicate if the environment has been added.
	 * @param e : Environment to Add
	 */
	public void addEnvToQueue(Environment e){
		boolean wasAdded = false ;

		try{
			wasAdded = queue.add(e);
		}finally{
			if(wasAdded)
			{
				System.out.println("Event : " + e.ID + " is added ! Value : " + e.setOfParameters[0].value);
			}
			else
				System.out.println("Event : " + e.ID + " is not added ! ");
		}


	}

	/**
	 * Run this planning thread
	 */
	public void run() {
		// Create and start next Thread
		SimulationThread simulation = new SimulationThread(queue);
		Thread thread = new Thread(simulation);
		thread.setName("Simulation Thread");
		thread.start();

		if(currentEnvironment == null){
			currentEnvironment = baseEnvironment;
			addEnvToQueue(currentEnvironment);
		}
		
		
		for(int i = 0; i<cuttOffPlanning; i++){
			currentEnvironment = createNextEnvironment(currentEnvironment);
			addEnvToQueue(currentEnvironment);
		}
	}

	



}