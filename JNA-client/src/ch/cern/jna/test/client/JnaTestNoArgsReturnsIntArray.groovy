package ch.cern.jna.test.client

class JnaTestNoArgsReturnsIntArray extends JnaTest 
{
	void invokeNativeMethod()
	{
		result = MyMain.theLib.getFunction("no_args_returns_int_array").invokePointer()
	}
	
	String getResultAsString()
	{
		
		def intArray = result.getIntArray(0, 2)

		def resultAsString = ""
		intArray.eachWithIndex {element, i -> (resultAsString += "element ["+i+"] value ["+element+"]\n")}

		return resultAsString;
	}
}
