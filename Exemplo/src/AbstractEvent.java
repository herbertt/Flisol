public abstract class AbstractEvent {
	protected String eventID;
	protected long time;
	
	public AbstractEvent(String eventID, long time) {
		super();
		this.eventID = eventID;
		this.time = time;
	}
	public void setEventID(String eventID) {
		this.eventID = eventID;
	}
	public String getEventID() {
		return eventID;
	}
	public void setTime(long time) {
		this.time = time;
	}
	public long getTime() {
		return time;
	}
}
