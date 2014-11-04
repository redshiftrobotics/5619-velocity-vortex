#pragma config(Sensor, S1,     ,               sensorI2CCustom)
//*!!Code automatically generated by 'ROBOTC' configuration wizard               !!*//

#include "JoystickDriver.c"
#include "../Libraries/I2C.h"
#include "../autonomous/IRfunctions - original.c"

const int threshold = 18;
int joystick1[4];
//float power[2];

void updateJoystick() {
	joystick1[0] = joystick.joy1_x1;
	joystick1[1] = joystick.joy1_x2;
	joystick1[2] = joystick.joy1_y1;
	joystick1[3] = joystick.joy1_y2;
}

float angleX(int x, int y) {
	return atan(x/y);
}

float angleY(int x, int y) {
	return atan(y/x);
}
void doStuff() {
	updateJoystick();
	if(joystick1[0] > threshold)
		I2C_SetMotorSpeed(S1, 2, 2, -joystick1[0]);
	if(joystick1[1] > threshold)
		I2C_SetMotorSpeed(S1, 2, 2, joystick1[1]);
	if(joystick1[2] > threshold) {
		I2C_SetMotorSpeed(S1, 1, 1, joystick1[2]);
		I2C_SetMotorSpeed(S1, 1, 2, joystick1[2]);
	}
	if(joystick1[3] > threshold) {
		I2C_SetMotorSpeed(S1, 1, 1, -joystick1[3]);
		I2C_SetMotorSpeed(S1, 1, 2, -joystick1[3]);
	}
	//else if(joystick[2] > threshold && joystick[0] > threshold) {
	//	I2C_SetMotorSpeed(S1, 1, 1, calcPower(angleX(joystick[0], joystick[2]), 50, power);
	//	I2C_SetMotorSpeed(S1, 1, 2, -joystick[3]);
	//	I2C_SetMotorSpeed(S1, 2, 2, joystick[1]);
	//}




}

task main()
{
	while(true) {
		getJoystickSettings(joystick);
		doStuff();
	}


}
