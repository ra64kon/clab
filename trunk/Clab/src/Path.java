
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
public class Path
{
    private String name;
    private Place to;
    private Item mandatoryItem;
    private String missingItemText = "";

    /**
     * Constructor for objects of class Place
     */
    public Path(String name, Place to)
    {
        this.name = name;
        this.to = to;
    }
    
    public void setMandatoryItem(Item mandatoryItem, String missingItemText)
    {
    	this.mandatoryItem = mandatoryItem;
    	this.missingItemText = missingItemText;
    }
    
    public String changePlace(Adventure a)
    {
    	if (mandatoryItem==null || a.getInventory().hasItem(mandatoryItem))
    	{
    		a.setCurrentPlace(to);
    		return "Going to '" + to.getName() + "'";
    	}
    	else
    	{
   			return missingItemText;
    	}
    }
    
    
    public String getName()
    {
        return name;    
    }
}
