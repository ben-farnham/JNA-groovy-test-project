package ch.cern.jna.test.client

import com.sun.jna.StringArray

class JnaTestFillArrayOfCharBuffers extends JnaTest 
{
	def lines
	static final lineCount = 3
	
	void invokeNativeMethod()
	{
		lines = new StringArray(createAndInitialiseStringArray());
		MyMain.theLib.getFunction("fill_array_of_char_buffers").invokeVoid([lines, lineCount].toArray())
	}
	
	String getResultAsString()
	{
		def resultString = "Returned values:\n"
		def array = lines.getStringArray(0)
		array.eachWithIndex {element, i -> resultString += "\titem index ["+i+"] string length ["+element.length()+"]\n"}
		return resultString
	}
	
	private String[] createAndInitialiseStringArray()
	{
		def strings = new String[lineCount]
		for(int i=0; i<lineCount; strings[i++] = new String()){}
		return strings
	}
}