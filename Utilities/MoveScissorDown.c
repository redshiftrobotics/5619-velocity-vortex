#pragma config(Sensor, S1,     ,               sensorI2CCustom)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

#include "../LocalLibraries/ScissorLift.h"

task main()
{
	while(true)
	{
		ScissorLift_MoveDown(10);
		Sleep(10);
	}
}
