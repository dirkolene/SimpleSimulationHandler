package StructuredSim_Test.mockUpSim;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import StructuredSim_Test.ExperimentHandling.Environment;
import StructuredSim_Test.ExperimentHandling.Parameters;
import StructuredSim_Test.ExperimentHandling.PlanningThread;

/**
 * Hello world!
 *
 */
public class Simulation 
{
    public static void main( String[] args )
    {
//    	List <Parameters> listOfParam = new ArrayList <Parameters> ();
//    	listOfParam.add(new Parameters("val1", 1));
//    	listOfParam.add(new Parameters("val2", 2));
//    	listOfParam.add(new Parameters("val3", 3));
//    	listOfParam.add(new Parameters("val4", 4));
//    	listOfParam.add(new Parameters("val5", 5));
    	
    	Parameters[] arrayParam = new Parameters[]{new Parameters("val1", 1), new Parameters("val2", 2), new Parameters("val3", 3), new Parameters("val4", 4), new Parameters("val5", 5)};
    	
    	Environment baseEnv = new Environment(0, arrayParam, 1);
    	//Environment baseEnv = new Environment(0, new Parameters("val1", 1), 1);
    	
		BlockingQueue<Environment> queue = new LinkedBlockingQueue<Environment>();
		PlanningThread planning = new PlanningThread(queue, baseEnv, 10);
	
		new Thread(planning).start();
    }
}
