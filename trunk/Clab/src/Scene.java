
import java.util.HashMap;

public class Scene 
{
	private String description;
	private HashMap<String,Action> actions = new HashMap<String,Action>();
	
	public Scene(String description) 
	{
		this.description=description;
	}
	
	public void addAction(Action action)
	{
		actions.put(action.getName(),action);
	}
	
	/**
	 * Removes action after use
	 * 
	 * @param name
	 * @throws NotFoundException
	 */
	public String runUseAction(String name) throws NotFoundException
	{
		Action a = actions.get(name);
		if (a==null) throw new NotFoundException("Action '" + name + "' not found.");
		String result = a.runUseActions();
		actions.remove(a.getName());
		return result;
	}

	public boolean hasFinished()
	{
		return actions.isEmpty();
	}


	public String getDescription() 
	{
		return description;
	}


	
	
}
