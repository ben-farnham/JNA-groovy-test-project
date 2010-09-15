package ch.cern.jna.test.client;

import com.sun.jna.Function;
import com.sun.jna.NativeLibrary;
import com.sun.jna.Pointer;
import com.sun.jna.StringArray;
import com.sun.jna.Structure;

public class JnaTestGetAnythingToWork 
{
	public static class Info extends Structure 
	{
		public Pointer lines;
		public int count;
	}
	
	public void doIt(NativeLibrary theLib)
	{
		Info info = new Info();
		
		StringArray lines = new StringArray(new String[]{"one", "two", "three"});		
		info.lines = lines;
		info.count = 3;
		
		Function function = theLib.getFunction("fill_array_of_char_buffers");
		function.invoke(new Object[]{info});
		
		String[] array = info.lines.getStringArray(0, 3);
		for(int i=0; i<array.length; i++)
		{
			System.out.println("item ["+i+"] value ["+array[i]+"]");
		}
	}
}
