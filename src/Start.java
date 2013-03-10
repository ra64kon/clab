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
	private static final double version = 0.04;
	
	public static void main(String[] args) throws IOException
    {
        Adventure a = loadAdventure("TestAdventure");
        Command c = new Command(a);
        System.out.println("Clab - command line adventure builder - Version " + version + "\n");
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

    
    public static Adventure loadAdventure(String name)
    {
        Adventure a = new Adventure(name);
        Scene s1 = new Scene("I'm at the office. It feels, that I should not be here.");
        final Place office = a.createStartPlace("office");
        office.putItem(new Item("key",false, true));
        office.putItem(new Item("desk", true, false));
        final Item ticket = new Item("ticket", true, true);
        Place home = a.createPlace("home");
        Path bus = office.createPath("bus", home);
        bus.setMandatoryItem(ticket, "Where is my ticket?");
        Action act = new Action("desk")
        {
        	protected void actions()
        	{
        		office.putItem(ticket);
        	}
        };
        s1.addAction(act);
        
        return a;
    }
}
