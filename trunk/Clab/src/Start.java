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
	private static final double version = 0.01;
	
	public static void main(String[] args) throws IOException
    {
        Adventure a = loadAdventure("TestAdventure");
        Command c = new Command(a);
        System.out.println("Clab - command line adventure builder - Version " + version + "\n");
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

    public static void testAdventure(Adventure a)
    {
        Command c = new Command(a);
        c.runCommand("take", "key");
        System.out.println("Testfall key==" + a.getInventory().getItem("key").getName());
    }
    
    
    public static Adventure loadAdventure(String name)
    {
        Adventure a = new Adventure(name);
        Place buero = a.createStartPlace("office");
        buero.createItem("key");
        

        return a;
    }
}