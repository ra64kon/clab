
public abstract class Action 
{
	private String parameter1;
	
	public Action(String parameter1) 
	{
		this.parameter1 = parameter1;
	}
	
	public boolean useItem(String parameter1)
	{
		return this.parameter1.equals(parameter1);
	}
	
	public void runActions()
	{
		actions();
	}
	
	protected abstract void actions();
	
}
