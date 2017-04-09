import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;



public class GeneratorOfIbmTicks extends Thread{
	
	private double  pricesIBM [] ={100, 84.00, 101.00, 90, 155.00, 80.00};
//	private double  pricesIBM [] ={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//	private double  pricesIBM [] ={1, 1, 1, 1, 1, 1, 1, 1, 1, 1};

	
	public void run(){
		// cria Esper instance
		EPServiceProvider stockEventAgent = EPServiceProviderManager.getProvider("StockAgent");
		
		//cria runtime para enviar evento
		EPRuntime runtimeOfSockEventAgent = stockEventAgent.getEPRuntime();
		
		
		// initialize simple StockEvent
		StockEvent event;
		String id = "";
		long timeZero = System.currentTimeMillis();

		// generate events
		for (int i = 0; i < pricesIBM.length; i++) {
			event = new StockEvent(id+i, System.currentTimeMillis() -timeZero, "ibm", pricesIBM[i]);
			System.out.println("... send ibm     " + event);
			runtimeOfSockEventAgent.sendEvent(event);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
