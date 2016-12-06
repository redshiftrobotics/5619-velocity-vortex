package org.redshiftrobotics.config;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.redshiftrobotics.colorpicker.ColorPicker;
import org.redshiftrobotics.util.TelementryUtil;

import java.text.DecimalFormat;

public class ConfigBase extends OpMode {
    protected Config config;
    Gamepad gp;

    TelementryUtil util = new TelementryUtil(this);

    boolean lastStateNext = false;
    boolean lastStateBack = false;
    boolean lastStateUp = false;
    boolean lastStateDown = false;

    int currentVar = 0;

    @Override
    public void init() {
        gp = gamepad1;
        currentVar = 0;
        util.log("Ready to start configuring? Press the A button!");
        util.log("");
        util.log("Controls:");
        util.log("  A: Next Page");
        util.log("  B: Back Page");
        util.log("  Y: Increment Up");
        util.log("  X: Increment Down");
        util.updateTelemetry();
    }

    @Override
    public void start(){
        showCurrentVariable();
    }

    @Override
    public void stop(){util.writeLine("Done configuring. Please exit this OPMode.");}

    @Override
    public void loop() {

        if(gp.a && !lastStateNext){
            nextPressed();
        }

        if(gp.b && !lastStateBack){
            backPressed();;
        }

        if(gp.y && !lastStateUp){
            incrementUpPressed();
        }

        if(gp.x && !lastStateDown){
            incrementDownPressed();
        }

        lastStateNext = gp.a;
        lastStateBack = gp.b;
        lastStateUp = gp.y;
        lastStateDown = gp.x;
    }

    void nextPressed(){
        int max = config.variables.size();

        if(currentVar >= max - 1){
            util.clearTelemetry();
            util.updateTelemetry();
            currentVar=max;
            util.stopOPMode();
            return;
        }

        currentVar++;
        showCurrentVariable();
    }

    void backPressed(){
        if(currentVar != 0) {
            currentVar--;
        }
        showCurrentVariable();
    }

    void incrementUpPressed(){
        if(currentVar >= config.variables.size()){
            return; //Return so it doesn't crash
        }
        double cur = config.variables.get(currentVar).getValueDouble();
        double inc = config.variables.get(currentVar).increment;
        double max = config.variables.get(currentVar).max;
        double min = config.variables.get(currentVar).min;

        cur = cur + inc;

        if(cur > max){
            cur = max;
        }

        if(cur < min){
            cur = min;
        }

        config.variables.get(currentVar).setValue(cur);
        showCurrentVariable();
    }

    void incrementDownPressed(){
        if(currentVar >= config.variables.size()){
            return; //Return so it doesn't crash
        }

        double cur = config.variables.get(currentVar).getValueDouble();
        double inc = config.variables.get(currentVar).increment;
        double max = config.variables.get(currentVar).max;
        double min = config.variables.get(currentVar).min;

        cur = cur - inc;

        if(cur > max){
            cur = max;
        }

        if(cur < min){
            cur = min;
        }

        config.variables.get(currentVar).setValue(cur);
        showCurrentVariable();
    }

    void showCurrentVariable(){
        if(currentVar >= config.variables.size()){
            return; //Return so it doesn't crash
        }

        util.log("Variable", config.variables.get(currentVar).name);

        //i know this is messy but it makes it a lot nicer when seeing the result on the driver station phone.
        if(config.variables.get(currentVar).type == ConfigType.DOUBLE){
            DecimalFormat df = new DecimalFormat("#.##");
            util.log("Value", df.format(config.variables.get(currentVar).getValueDouble()));

        }else if(config.variables.get(currentVar).type == ConfigType.BOOLEAN){

            util.log("Value", config.variables.get(currentVar).getValueBoolean());

        }else if(config.variables.get(currentVar).type == ConfigType.FLOAT){
            DecimalFormat df = new DecimalFormat("#.##########");
            util.log("Value", df.format(config.variables.get(currentVar).getValueFloat()));

        }else if(config.variables.get(currentVar).type == ConfigType.INT){

            util.log("Value", config.variables.get(currentVar).getValueInt());

        }else if(config.variables.get(currentVar).type == ConfigType.COLORPICKER){

            util.log("Value", ColorPicker.Color.getColor(config.variables.get(currentVar).getValueInt()).getName());

        }else{
            //this shoulden't ever happen
            util.writeLine("Type error occured in config base. (This should never happen)");
        }
        util.updateTelemetry();
    }
}
