


import com.espertech.esper.client.EPRuntime;
import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;



public class GeneratorOfSunTicks extends Thread{

	private double  pricesSun [] ={33.00, 32.00, 31.00, 35.00, 30.00, 29.00, 33.00, 40.00};

	
	public void run(){
		// cria Esper instance
		EPServiceProvider stockEventAgent = EPServiceProviderManager.getProvider("StockAgent");
		
		//cria runtime para enviar evento
		EPRuntime runtimeOfSockEventAgent = stockEventAgent.getEPRuntime();
		
		
		// inicializa StockEvent
		StockEvent event;
		String id = "";
		long timeZero = System.currentTimeMillis();

		// generate events
		for (int i = 0;i < pricesSun.length; i++) {
			event = new StockEvent(id+i, System.currentTimeMillis() - timeZero, "sun", pricesSun[i]);
			System.out.println("... send sun     " + event);
			runtimeOfSockEventAgent.sendEvent(event);
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}

}
