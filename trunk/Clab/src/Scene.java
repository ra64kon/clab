
import java.util.LinkedList;


public class Scene 
{
	private String description;
	
	public Scene(String description) 
	{
		this.description=description;
	}

	

	private LinkedList<Action> rules = new LinkedList<Action>();
	
	public void addAction(Action action)
	{
		rules.add(action);
	}

	
	public void init()
	{
		
	}
	
	
	
	public void cleanUp()
	{
		
	}


	public String getDescription() 
	{
		return description;
	}


	
	
}
