
public class Operations 
{
	private Adventure adventure;
	private Scene scene;

	public Operations(Adventure adventure, Scene scene) 
	{
		this.adventure = adventure;
		this.scene = scene;
	}
	
    public void putItem(String item, String place) throws NotFoundException 
    {
        Place p = adventure.getPlace(place);   
        Item i = adventure.getItem(item);
        p.putItem(i);
    }
    
    public void createPath(String name, String from, String to, String item, String missingItemText) throws NotFoundException 
    {
    	Place fromPlace = adventure.getPlace(from);  
    	Place toPlace = adventure.getPlace(to);  
    	Item i = adventure.getItem(item);
    	fromPlace.createPath(name, toPlace, i, missingItemText);
    }
    
    public void createPath(String name, String from, String to) throws NotFoundException 
    {
    	Place fromPlace = adventure.getPlace(from);  
    	Place toPlace = adventure.getPlace(to);  
        fromPlace.createPath(name, toPlace);
    }
}
