/* Copyright (c) 2014, 2015 Qualcomm Technologies Inc

All rights reserved.

Redistribution and use in source and binary forms, with or without modification,
are permitted (subject to the limitations in the disclaimer below) provided that
the following conditions are met:

Redistributions of source code must retain the above copyright notice, this list
of conditions and the following disclaimer.

Redistributions in binary form must reproduce the above copyright notice, this
list of conditions and the following disclaimer in the documentation and/or
other materials provided with the distribution.

Neither the name of Qualcomm Technologies Inc nor the names of its contributors
may be used to endorse or promote products derived from this software without
specific prior written permission.

NO EXPRESS OR IMPLIED LICENSES TO ANY PARTY'S PATENT RIGHTS ARE GRANTED BY THIS
LICENSE. THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO,
THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT OWNER OR CONTRIBUTORS BE LIABLE
FOR ANY DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL
DAMAGES (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE. */

package com.qualcomm.ftcrobotcontroller.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.OpModeManager;
import com.qualcomm.robotcore.eventloop.opmode.OpModeRegister;

/**
 * Register Op Modes
 */
public class FtcOpModeRegister implements OpModeRegister {

  /**
   * The Op Mode Manager will call this method when it wants a list of all
   * available op modes. Add your op mode to the list to enable it.
   *
   * @param manager op mode manager
   */
  public void register(OpModeManager manager) {

    /*
     * register your op modes here.
     * The first parameter is the name of the op mode
     * The second parameter is the op mode class property
     *
     * If two or more op modes are registered with the same name, the app will display an error.
     *
     * Uncomment any of the following lines if you want to register an op mode.
     */
    //manager.register("Final Mountain Autonomous", FinalMountainAuto.class);
     /*
	  manager.register("NullOp", NullOp.class)
	  manager.register("K9TeleOp", K9TeleOp.class);
	  manager.register ("PushBotAuto", PushBotAuto.class);
	  manager.register ("PushBotManual", PushBotManual.class)
	  manager.register("AdafruitRGBExample", AdafruitRGBExample.class);
      manager.register("MRRGBExample", MRRGBExample.class);
      manager.register("ColorSensorDriver", ColorSensorDriver.class);
      manager.register("HTRGBExample", HTRGBExample.class);

      manager.register("IrSeekerOp", IrSeekerOp.class);
      manager.register("CompassCalibration", CompassCalibration.class);
      manager.register("I2cAddressChangeExample", LinearI2cAddressChange.class);


      manager.register("NxtTeleOp", NxtTeleOp.class);

      manager.register("LinearK9TeleOp", LinearK9TeleOp.class);
      manager.register("LinearIrExample", LinearIrExample.class);


      manager.register ("PushBotManual1", PushBotManual1.class);
      manager.register ("PushBotAutoSensors", PushBotAutoSensors.class);
      manager.register ("PushBotIrEvent", PushBotIrEvent.class);

      manager.register ("PushBotManualSensors", PushBotManualSensors.class);
      manager.register ("PushBotOdsDetectEvent", PushBotOdsDetectEvent.class);
      manager.register ("PushBotOdsFollowEvent", PushBotOdsFollowEvent.class);
      manager.register ("PushBotTouchEvent", PushBotTouchEvent.class);

      manager.register("PushBotDriveTouch", PushBotDriveTouch.class);
      manager.register("PushBotIrSeek", PushBotIrSeek.class);
      manager.register("PushBotSquare", PushBotSquare.class);

	  //////////////////////////////////////////////////////////////////////////////////////
*/

/*

	                 GOOD OPMODES

      LOW OP MODES

      BLUE TEAM
      RED RAMP

      manager.register("BTeam-RRamp-Close", EAuto_BTeam_RRamp_Close.class);
      manager.register("BTeam-RRamp-Far", EAuto_BTeam_RRamp_Far.class);

      BLUE TEAM
      BLUE RAMP

      manager.register("BTeam-BRamp-Close", EAuto_BTeam_BRamp_Close.class);
      manager.register("BTeam-BRamp-Far", EAuto_BTeam_BRamp_Far.class);


      RED TEAM
      BLUE RAMP


     manager.register("RTeam-BRamp-Close", EAuto_RTeam_BRamp_Close.class);
     manager.register("RTeam-BRamp-Far", EAuto_RTeam_BRamp_Far.class);


      RED TEAM
      RED RAMP

      manager.register("RTeam-RRamp-Close", EAuto_RTeam_RRamp_Close.class);
      manager.register("RTeam-RRamp-Far", EAuto_RTeam_RRamp_Far.class);
*/
    //DRIVE
     // manager.register("Low Drive", ETLow.class);
      manager.register("High Drive", ETHigh.class);
      manager.register("Arm Test", ArmTest.class);
      manager.register("Space Jam", EParty.class);

      manager.register("Blue Team", EAuto_BTeam_RRamp_Close.class);
      manager.register("Red Team", EAuto_RTeam_BRamp_Close.class);


      manager.register("RESET (In case of bugs run)", EResetAll.class);
     /*
      manager.register("[Debug] FRONT LEFT", EFrontLeft.class);
      manager.register("[Debug] FRONT RIGHT", EFrontRight.class);
      manager.register("[Debug] BACK LEFT", EBackLeft.class);
      manager.register("[Debug] BACK RIGHT", EBackRight.class);
     // manager.register("Debug.class", EDebug.class);
    //  manager.register("DebugDrive.class", EDebugDriveTest.class);

*/







  }
}
