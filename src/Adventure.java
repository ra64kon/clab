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

   
    /**
     * Constructor for objects of class Place
     */
    public Adventure(String name)
    {
        this.name = name;
    }
    
    public Place createStartPlace(String name)
    {
        currentPlace = createPlace(name);
        return currentPlace;
    }
    
    public Place createPlace(String name)
    {
        Place p = new Place(name);
        places.put(name, p);
        return p;
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
}
