import java.util.HashMap;

/*
Clab - command line adventure builder
Copyright (C) 2013, ra64kon

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.
*/
public class Adventure
{
    private String name;
    private Inventory inventory = new Inventory();
    private Place currentPlace;
    private HashMap<String,Place> places = new HashMap<String,Place>();
    private HashMap<String,Item> items = new HashMap<String,Item>();
   
    /**
     * Constructor for objects of class Place
     */
    public Adventure(String name)
    {
        this.name = name;
    }
    
    public void setStartPlace(String name) throws NotFoundException
    {
        Place p = getPlace(name);
    	currentPlace = p;
    }
    
    public void createPlace(String name)
    {
        Place p = new Place(name);
        places.put(name, p);
    }
    
    public void createItem(String name,boolean isAccessible, boolean isTakable)
    {
        Item i = new Item(name, isAccessible, isTakable);
        items.put(name, i);
    }
    
    public String getName()
    {
        return name;    
    }
    
    public Inventory getInventory()
    {
        return inventory;    
    }
    
    public Place getCurrentPlace()
    {
        return currentPlace;
    }   
    
    public void setCurrentPlace(Place place)
    {
        this.currentPlace = place;
    } 
    
    public Place getPlace(String name) throws NotFoundException
    {
    	Place p = places.get(name);
    	if (p==null) throw new NotFoundException("Place '" + name + "' not found.");
    	else return p;
    }
    
    public Item getItem(String name) throws NotFoundException
    {
    	Item i = items.get(name);
    	if (i==null) throw new NotFoundException("Item '" + name + "' not found.");
    	else return i;
    }
}
