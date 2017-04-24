package StructuredSim_Test.ExperimentHandling;

import java.util.concurrent.BlockingQueue;

import StructuredSim_Test.mockUpSim.SimpleSimulationHandler;


public class SimulationThread implements Runnable{
	//Variable
	protected BlockingQueue <Environment> queue ;
	protected SimpleSimulationHandler simultationHandler = new SimpleSimulationHandler();
	
	//Constructor
	public SimulationThread(BlockingQueue <Environment> queue){
		this.queue = queue;
	}

	/**
	 * Run this simulation Thread
	 */
	public void run() {
		// TODO Auto-generated method stub
		try {
			ResultThread result = new ResultThread(queue);
			Thread thread = new Thread(result);
			thread.setName("Result Thread");
			thread.start();
			
			while(true){
				Environment env = (Environment) queue.take();
			//	System.out.println("\tID : " + env.getID() + " Value : " + env.getProbability());
			System.out.println("\tID : " + env.getID() + " Value : " + env.setOfParameters[0].value);
			//simultationHandler.startSimultation(env);
			
			
			}

					
		} catch (InterruptedException e) {    
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
