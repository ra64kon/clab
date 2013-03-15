import java.util.StringTokenizer;

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
public class Command
{
    private Adventure adventure;


    public Command(Adventure adventure)
    {
        this.adventure = adventure;
    }
    
    public String parseCommand(String line)
    {
        String command="";
        String parameter="";
        StringTokenizer st = new StringTokenizer(line, " "); 
        if (st.hasMoreTokens()) 
        {
            command = st.nextToken(); 
            try 
            {
				if (st.hasMoreTokens()) 
				{   
				    parameter = st.nextToken(); 
				    String result = runCommand(command, parameter);
				    if (result.length()>0) return result;
				}
				else
				{
					String result = runCommand(command);
				    if (result.length()>0) return result;
				}
			} 
            catch (NoSuchMethodException e) 
            {
            	return "Command '" + command + "' not found. Type '?' for help.";
			}
        }
        return "Type '?' for help.";
    }
   
    public String runCommand(String commandString) throws NoSuchMethodException
    {
    	if (commandString.equals("?"))
    	{
    		String help = "Type 'take <item>' to take an item.\n"
    			    + "Type 'use <item>' to use an item.\n"
    			    + "Type 'goto <place>' to change your place.\n\n"
    			    + "Simply type 'take','use' or 'goto' to show what to take, to use or where to go.";
    		return help;
    	}
    	if (commandString.equals("take"))
         {
        	 String items = listPlaceItems();
        	 if (items.length()>0)
        	 {
        		 return "I can take: " + items;
        	 }
        	 else
        	 {
        		 return "Nothing to take here.";
        	 }
         }
         if (commandString.equals("use")) return "I can use: " + listItems();
         if (commandString.equals("goto"))
         { 
        	 String pathes = listPathNames();
        	 if (pathes.length()>0)
        	 {
        		 return "I can go to: " + pathes;
        	 }
        	 else
        	 {
        		 return "I can't go to somewhere.";
        	 }
         }
         throw new NoSuchMethodException();
    }
    
    public String runCommand(String commandString, String parameter) throws NoSuchMethodException
    {
         if (commandString.equals("take")) return takeItem(parameter);
         if (commandString.equals("use")) return useItem(parameter);
         if (commandString.equals("goto")) return goTo(parameter); 
         //if (commandString.equals("ask")) goTo(parameter);
         throw new NoSuchMethodException();
    }
    
    private String takeItem(String name)
    {
        Item i = adventure.getCurrentPlace().getItem(name);
        if (i==null) return "Item '" + name + "' not found.";
        if (!i.isAccessible()) return "Item '" + name + "' not accessible.";
        if (!i.isTakable()) return "Item '" + name + "' is not takeable.";
        adventure.getCurrentPlace().removeItem(name);
    	adventure.getInventory().putItem(i);
        return "'" + name + "' taken.";
    }
    
    private String useItem(String name)
    {
        // 1. Check item in Inventar und aktuellem Place ob er direkt benutzt werden kann
        // 2. Check ob item in einer Regel vorkommt und führe Regel aus
        return "use";
    }
    
    private String goTo(String name)
    {
        Path p = adventure.getCurrentPlace().getPath(name);
    	if (p==null)
    	{
    		return "I don't know where '" + name + "' is.";
    	}
    	else
    	{
    		return p.changePlace(adventure);
    	}
    }
    
    private String listItems()
    {
        String result = adventure.getInventory().getItemNames();
        result = result + listPlaceItems();
        return result;
    }
    
    private String listPathNames()
    {
    	return adventure.getCurrentPlace().getPathNames();
    }
    
    private String listPlaceItems()
    {
        return adventure.getCurrentPlace().getItemNames();
    }
}
