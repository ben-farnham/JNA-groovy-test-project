package ch.cern.jna.test.client

abstract class JnaTest 
{
	def result;
	
	abstract void invokeNativeMethod();
	abstract String getResultAsString();
}
