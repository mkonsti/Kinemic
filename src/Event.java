
public class Event {
		
	private String type;
	private Parameters parameters;

	
	public Event (Parameters parameters, String type){
		this.parameters=parameters;
		this.setType(type);
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public Parameters getParameters() {
		return parameters;
	}


	public void setParameters(Parameters parameters) {
		this.parameters = parameters;
	}
}
