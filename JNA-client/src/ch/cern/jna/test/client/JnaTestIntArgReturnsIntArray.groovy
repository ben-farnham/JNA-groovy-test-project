package ch.cern.jna.test.client

class JnaTestIntArgReturnsIntArray extends JnaTest 
{
	def numberOfElements = 10
	
	void invokeNativeMethod() 
	{
		def funcArgs = [new Integer(numberOfElements)]
		result = MyMain.theLib.getFunction("int_arg_returns_int_array").invokePointer(funcArgs.toArray())
	}

	String getResultAsString() 
	{
		def intArray = result.getIntArray(0, numberOfElements)

		def resultAsString = ""
		intArray.eachWithIndex {element, i -> (resultAsString += "element ["+i+"] value ["+element+"]\n")}

		return resultAsString;
	}
}
