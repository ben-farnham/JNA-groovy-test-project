package ch.cern.jna.test.client

import com.sun.jna.Library 
import com.sun.jna.Native
import com.sun.jna.NativeLibrary;
import com.sun.jna.Platform

class MyMain 
{
	static def theLib;
	
	static void main(def args)
	{
		println "hello, world! It's " + new Date()
		
		theLib = NativeLibrary.getInstance("C:\\Workspace\\JNA-experiments\\SimpleDllForJnaTesting\\Release\\SimpleDllForJnaTesting.dll")
		
		def jnaTest = new JnaTestNoArgsReturnsVoid()
		jnaTest.invokeNativeMethod()
		println jnaTest.getResultAsString()
		
		jnaTest = new JnaTestNoArgsReturnsIntArray()
		jnaTest.invokeNativeMethod()
		println jnaTest.getResultAsString()
		
		jnaTest = new JnaTestIntArgReturnsIntArray(numberOfElements:15)
		jnaTest.invokeNativeMethod()	
		println jnaTest.getResultAsString()
		
		jnaTest = new JnaTestFillACharBuffer()
		jnaTest.invokeNativeMethod()
		println jnaTest.getResultAsString()
		
		theLib.dispose()
	}

}


