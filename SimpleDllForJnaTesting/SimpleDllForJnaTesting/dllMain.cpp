#include <windows.h>
#include <iostream>

using namespace std;

// dllmain.cpp : Defines the entry point for the DLL application.
BOOL APIENTRY DllMain( HMODULE hModule,
                       DWORD  ul_reason_for_call,
                       LPVOID lpReserved
					 )
{
	cout << "DllMain called, reason for call ";

	switch (ul_reason_for_call)
	{
	case DLL_PROCESS_ATTACH:
		cout << "[DLL_PROCESS_ATTACH]";
		break;
	case DLL_THREAD_ATTACH:
		cout << "[DLL_THREAD_ATTACH]";
		break;
	case DLL_THREAD_DETACH:
		cout << "[DLL_THREAD_DETACH]";
		break;
	case DLL_PROCESS_DETACH:
		cout << "[DLL_PROCESS_DETACH]";
		break;
	default:
		cout << "[!UNKNOWN!]";
		break;
	}

	cout << "." << endl;

	return TRUE;
}

