package ch.cern.jna.test.client

import com.sun.jna.Pointer
import com.sun.jna.Structure
import com.sun.jna.StringArray

class JnaTestFillArrayOfCharBuffers extends JnaTest 
{
	def lines
	def lineCount
	
	void invokeNativeMethod()
	{
		lines = new StringArray((String[])["one", "two", "three"].toArray(new String[0]));
		lineCount = 3
		
		result = MyMain.theLib.getFunction("fill_array_of_char_buffers").invokeVoid([lines, lineCount].toArray())
	}
	
	String getResultAsString()
	{
		def result = "Returned values:\n"
		def array = lines.getStringArray(0)
		array.eachWithIndex {element, i -> result += "\titem index ["+i+"] string length ["+element.length()+"]\n"}
		return result
	}
}
