package ch.cern.jna.test.client

class JnaTestNoArgsReturnsVoid extends JnaTest
{
	void invokeNativeMethod()
	{
		result = MyMain.theLib.getFunction("no_args_returns_void").invoke();	
	}
	
	String getResultAsString()
	{
		return "no inputs or outputs - no result expected\n";
	}
}
