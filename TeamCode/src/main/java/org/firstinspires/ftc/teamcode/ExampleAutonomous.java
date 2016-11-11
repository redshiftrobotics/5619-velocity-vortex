package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.hardware.I2cDeviceSynch;

@Disabled
@Autonomous(name = "ExampleAutonomous", group = "Autonomous")
public class ExampleAutonomous extends LinearOpMode {

    Robot myRobot;
    I2cDeviceSynch imu;
    DcMotor leftDrive;
    DcMotor rightDrive;

    @Override
    public void runOpMode(){

        // Initialize our hardware
        leftDrive = hardwareMap.dcMotor.get("left_drive");
        rightDrive = hardwareMap.dcMotor.get("right_drive");
        imu = hardwareMap.i2cDeviceSynch.get("imu");

        // Create our driver
        myRobot = new Robot(imu, leftDrive, rightDrive);

        // Set our p, i, and d tuning
        myRobot.data.PID.PTuning = 37f;
        myRobot.data.PID.ITuning = 1f;
        myRobot.data.PID.DTuning = 4f;

        // Lets drive straight ten rotations or 10 seconds.
        myRobot.straight(10f, 10);
		// Now do a 90 degree turn
		myRobot.AngleTurn(90, 5);
    }
}

