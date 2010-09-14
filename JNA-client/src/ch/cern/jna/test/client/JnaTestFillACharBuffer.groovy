package ch.cern.jna.test.client

import com.sun.jna.Native;

class JnaTestFillACharBuffer extends JnaTest
{
	byte[] buffer
	final int bufferLength = 100
	
	void invokeNativeMethod()
	{
		buffer = new byte[bufferLength]
		def funcArgs = [buffer, bufferLength]
		result = MyMain.theLib.getFunction("fill_a_char_buffer").invoke(funcArgs.toArray());
	}
	
	String getResultAsString()
	{
		return "buffer content ["+Native.toString(buffer)+"]\n";
	}
}
