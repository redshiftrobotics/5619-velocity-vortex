#pragma config(Sensor, S1,     sonar,          sensorSONAR)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

#include "../Libaries/drivers/lego-ultrasound.h"

int sonarRead = 0;

task main()
{
	clearDebugStream();
	while(true) {
		sonarRead = USreadDist(sonar);
		writeDebugStream("%i,", sonarRead);
	}


}
