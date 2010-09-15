#include <windows.h>
#include <iostream>

using namespace std;

extern "C"
{
	__declspec(dllexport) void __cdecl no_args_returns_void()
	{
		cout << "no_args_void_return called" << endl;
	}

	__declspec(dllexport) int* __cdecl no_args_returns_int_array()
	{
		cout << "no_args_returns_int_array called, returning array of length 2" << endl;

		int* arrInts = (int*)malloc(2*sizeof(int));
		arrInts[0] = 100;
		arrInts[1] = 200;

		return arrInts;
	}

	__declspec(dllexport) int* __cdecl int_arg_returns_int_array(const unsigned int nArrayLength)
	{
		cout << "no_args_returns_int_array called with ["<< nArrayLength <<"], returning array of that length" << endl;

		int* arrInts = (int*)malloc(nArrayLength*sizeof(int));

		for(unsigned int i=0; i<nArrayLength; i++)
		{
			arrInts[i] = i;
		}

		return arrInts;
	}

	__declspec(dllexport) void __cdecl fill_a_char_buffer(char buffer[], const unsigned int nBufferLength)
	{
		cout << "fill_a_char_buffer called, length ["<< nBufferLength<<"], original buffer contents ["<< buffer <<"]" << endl;

		for(unsigned int i=0; i<nBufferLength - 1; i++)
		{
			// 48 = start of 0-9 chars in ascii table
			buffer[i] = i%10 + 48;
		}

		cout << "fill_a_char_buffer completed, buffer content ["<< buffer <<"]" << endl;
	}

	__declspec(dllexport) void __cdecl fill_array_of_char_buffers(char** pLines, const unsigned int nNumberOfLines)
	{
		cout << "fill_array_of_char_buffers called, pLines ["<< pLines<<"] number of lines ["<< nNumberOfLines <<"]" << endl;

		for(unsigned int i=0; i<nNumberOfLines; i++)
		{
			// report original value rcvd via JNA
			cout << "\titem index ["<< i <<"] original value ["<< pLines[i] <<"]" << endl;

			// allocate a new string and point to it via ptr to ptr (to be returned via JNA)
			char* pNewLineContents = (char*)calloc(100000, sizeof(char));
			pLines[i] = pNewLineContents;

			for(unsigned int j = 0; j<100000-1; j++)
			{
				pNewLineContents[j] = char(48+i);
			}			
		}
	}


}