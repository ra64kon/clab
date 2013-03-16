
public abstract class Action 
{
	private String name;
	
	public Action(String name) 
	{
		this.name = name;
	}
	
	public boolean useItem(String parameter1)
	{
		return name.equals(parameter1);
	}
	
	public String runUseActions() throws NotFoundException
	{
		return useActions();
	}
	
	protected abstract String useActions() throws NotFoundException;
	
	public String getName()
	{
		return name;
	}
	
}
