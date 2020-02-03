package context;

import java.util.HashMap;

public class ScenarioContext {
	
	private HashMap<String, Object> context = new HashMap<String, Object>();

	public HashMap<String, Object> getContext() {
		return context;
	}

	public void setContext(HashMap<String, Object> context) {
		this.context = context;
	}
	
}
