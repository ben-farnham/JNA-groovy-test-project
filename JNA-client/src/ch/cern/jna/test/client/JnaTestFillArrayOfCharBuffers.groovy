package ch.cern.jna.test.client

import com.sun.jna.Pointer
import com.sun.jna.Structure
import com.sun.jna.StringArray

class JnaTestFillArrayOfCharBuffers extends JnaTest 
{
	def info
	
	public static class Info extends Structure
	{		
		public Pointer lines
		public int count
	}
	
	void invokeNativeMethod()
	{
		def arrayOflines = new StringArray((String[])["one", "two", "three"].toArray(new String[0]));
		info = new Info(lines:arrayOflines, count:3)
		
		result = MyMain.theLib.getFunction("fill_array_of_char_buffers").invokeVoid([info].toArray())
	}
	
	String getResultAsString()
	{
		def result = "Returned values:\n"
		def array = info.lines.getStringArray(0)
		array.eachWithIndex {element, i -> result += "\titem index ["+i+"] value ["+element+"]\n"}
		return result
	}
}
