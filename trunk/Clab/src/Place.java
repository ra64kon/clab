import java.util.HashMap;
import java.util.Iterator;

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
public class Place
{
    private String name;
    private HashMap<String,Item> items = new HashMap<String,Item>();
    private HashMap<String,Path> pathes = new HashMap<String,Path>();
    
    /**
     * Constructor for objects of class Place
     */
    public Place(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;    
    }
    
    public void addItem(Item i)
    {
        items.put(i.getName(),i);    
    }
    
    public void putItem(Item i)
    {
        items.put(i.getName(),i);
    }
    
    public Item removeItem(String name)
    {
    	return items.remove(name);      
    }
    
    public boolean hasItem(Item item)
    {
    	return items.containsValue(item);
    }
    
    public Item getItem(String name)
    {
        return items.get(name);    
    }
    
    public Path getPath(String name)
    {
        return pathes.get(name);    
    }
    
    public String getItemNames()
    {
        String names="";
        Iterator<String> i = items.keySet().iterator();
        while(i.hasNext())
        {
            names = names + i.next();
            if (i.hasNext()) names = names + ", ";
        }    
        return names;
    }
    
    public String getPathNames()
    {
        String names="";
        Iterator<String> i = pathes.keySet().iterator();
        while(i.hasNext())
        {
            names = names + i.next();
            if (i.hasNext()) names = names + ", ";
        }    
        return names;
    }
        
    public Path createPath(String name, Place to)
    {
        Path p = new Path(name, to);
        pathes.put(name, p);
        return p;
    }
    
}
