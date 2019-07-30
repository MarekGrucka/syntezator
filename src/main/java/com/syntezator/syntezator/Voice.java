package com.syntezator.syntezator;

import com.jsyn.unitgen.UnitOscillator;
import com.softsynth.math.AudioMath;

public class Voice {

    private int control = 0;
    private double midinote = 0;
    private double midivelocity = 0;
    private UnitOscillator osc;
    private boolean isnoteon = false;
    private int voicecount = 1;


    public void midiin (int control, double midinote, double midivelocity) {
        this.control = control;
        this.midinote = midinote;
        this.midivelocity = midivelocity;

    }

    public Voice(){}

    public Voice(int voicecount){
        this.voicecount = voicecount;
    }

    public boolean getnotestatus(){
        return this.isnoteon;
    }

    public double getcontrol() {
        return this.control;

    }

    public double getmidinote() {
        return this.midinote;

    }

    public double getmidivelocity() {
        return this.midivelocity;

    }

    public void setcontrol(int control) {
        this.control = control;

    }

    public void setmidinote(double midinote) {
        this.midinote = midinote;
        System.out.println(this.midinote);

    }

    public void setmidivelocity(double midivelocity) {
        this.midivelocity = midivelocity;

    }

    public void sendmsg (){

            osc.noteOn(AudioMath.pitchToFrequency(this.midinote), (double) this.midivelocity / 127 / voicecount);
            this.isnoteon = true;

    }

    public void noteoff (){
        osc.noteOff();
        this.isnoteon = false;
    }

    public void setosc (UnitOscillator osc){
        this.osc = osc;
    }

    public void setVoicecount (int voicecount){this.voicecount = voicecount;}


}
