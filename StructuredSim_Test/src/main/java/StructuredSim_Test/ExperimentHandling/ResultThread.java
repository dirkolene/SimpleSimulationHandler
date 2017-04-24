package StructuredSim_Test.ExperimentHandling;

import java.util.concurrent.BlockingQueue;


public class ResultThread implements Runnable{
	protected BlockingQueue<Environment> queue ;
	
	public ResultThread(BlockingQueue <Environment> queue) {
		this.queue = queue;
	}
	

	public void run() {
		// TODO Auto-generated method stub
		System.out.println("\t\tResult Thread");
		
	}

}
