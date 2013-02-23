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
            String result = runCommand(command);
            if (result.length()>0) return result;
            if (st.hasMoreTokens()) 
            {   
                parameter = st.nextToken(); 
                return runCommand(command, parameter);
            }
        }
        return "Command " + command + " not found";
    }
   
    public String runCommand(String commandString)
    {
         if (commandString.equals("list")) return listInventory(); 
         return "";
    }
    
    public String runCommand(String commandString, String parameter)
    {
         if (commandString.equals("take")) return takeItem(parameter);
         if (commandString.equals("use")) return useItem(parameter);
         if (commandString.equals("goto")) return goTo(parameter); 
         if (commandString.equals("list")) return listInventory(); 
         //if (commandString.equals("ask")) goTo(parameter);
         return "Command " + commandString + " not found";
    }
    
    private String takeItem(String name)
    {
        Item i = adventure.getCurrentPlace().removeItem(name);
        if (i==null) return "Item '" + name + "' not found.";
    	adventure.getInventory().addItem(i);
        return "Item '" + name + "' taken.";
    }
    
    private String useItem(String name)
    {
        // 1. Check item in Inventar und aktuellem Place ob er direkt benutzt werden kann
        // 2. Check ob item in einer Regel vorkommt und führe Regel aus
        return "use";
    }
    
    private String goTo(String name)
    {
        return "goto";
    }
    
    private String listInventory()
    {
        String result = adventure.getInventory().getItemNames() + "\n";
        result = result + adventure.getCurrentPlace().getItemNames();
        return result;
    }
}
