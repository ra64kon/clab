import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

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
public class Start
{
	private static final double version = 0.05;
	
	public static void main(String[] args) throws IOException
    {
		System.out.println("Clab - command line adventure builder - Version " + version + "\n");
		
		try 
		{
			Adventure a = loadAdventure("TestAdventure");
			Command c = new Command(a);
	        System.out.println(a.getName() + "\n");
	        while(true)
	        {
	            System.out.print(a.getCurrentPlace().getName() + ">");
	            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	            String line = br.readLine();
	            if (line.equals("exit")) break;
	            String result = c.parseCommand(line);
	            System.out.println(result);
	            System.out.println();
	        }
		} 
		catch (NotFoundException e) 
		{
			System.out.println("Cannot load Adventure: " + e.getMessage());
		}
        
    }

    
    public static Adventure loadAdventure(String name) throws NotFoundException
    {
        Adventure a = new Adventure(name);
        Scene s1 = new Scene("I'm at the office. It feels, that I should not be here.");
        final Operations o = new Operations(a, s1);
        a.createPlace("office");
        a.setStartPlace("office");
        a.createPlace("home");
        
        a.createItem("key",false, true);
        a.createItem("desk", true, false);
        a.createItem("ticket", true, true);
        o.putItem("key", "office");
        o.putItem("desk", "office");
       
        o.createPath("bus", "office", "home", "ticket", "Where is my ticket?");
        
        Action act = new Action("desk")
        {
        	protected void useActions() throws NotFoundException
        	{
        		o.putItem("ticket", "office");
        	}
        };
        s1.addAction(act);
        
        return a;
    }
}
