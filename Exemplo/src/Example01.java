//Muster S. 128 

//select symbol, price from StockEvent where symbol='ibm' and price > 100



import com.espertech.esper.client.EPServiceProvider;
import com.espertech.esper.client.EPServiceProviderManager;
import com.espertech.esper.client.EPStatement;

public class Example01 {
	
	public static void main(String[] args) {
		
		//get da instância do motor
		EPServiceProvider stockEventAgent = EPServiceProviderManager.getProvider("StockAgent");
		String stmt = "select symbol, price from StockEvent where symbol='ibm' and price > 100";
		System.out.println("****** " + stmt ); 
		System.out.println();
		
		// regista um statement
		EPStatement esperStmt = stockEventAgent.getEPAdministrator().createEPL(stmt);
		
		// adiciona um assinante
		esperStmt.setSubscriber(new Subscriber_symbol_price());
		
		// start event generation
		new GeneratorOfIbmTicks().start();
		new GeneratorOfSunTicks().start();
		
	}
}
