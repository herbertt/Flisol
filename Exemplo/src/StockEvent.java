public class StockEvent extends AbstractEvent {
	String symbol;
	double price;
	
	public StockEvent(String eventID, long time, String symbol, double price) {
		super(eventID, time);
		this.symbol = symbol;
		this.price = price;
	}
	public String getSymbol() {
		return symbol;
	}
	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String toString(){
		return "id:" + eventID + ": " + "  time:" + time + "   symbol:" + symbol + "    price:" + price;
//		return "id:" + eventID + "   symbol:" + symbol + "    price:" + price;
	}

}
