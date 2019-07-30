package com.syntezator.syntezator;

import com.jsyn.data.SegmentedEnvelope;
import com.jsyn.midi.MidiSynthesizer;
import com.jsyn.unitgen.SineOscillator;
import com.jsyn.unitgen.UnitOscillator;
import com.jsyn.unitgen.VariableRateMonoReader;
import com.softsynth.math.AudioMath;

import javax.sound.midi.MidiMessage;
import javax.sound.midi.Receiver;

public class MidiInputReceiver implements Receiver {

    private MidiMessage message = null;
    private long timeStamp = 0;
    private UnitOscillator messageoutput = null;
    private MidiSynthesizer midiSynthesizer;
    private PolyphonyController poly;






    public MidiInputReceiver() {    }

    public MidiInputReceiver(byte[] array) {
    }

    public MidiInputReceiver(UnitOscillator messageoutput) {this.messageoutput = messageoutput;}

    public MidiInputReceiver(PolyphonyController poly) {this.poly = poly;}





    public void send(MidiMessage msg, long timeStamp) {
        this.timeStamp = timeStamp;
        this.message = msg;


        byte[] marray = msg.getMessage();
        if (marray.length == 3) {
        poly.messagein((int) marray[0], (double) marray[1], (double) marray[2]);
        }


    }



    public void setenvelope(SegmentedEnvelope envelope){

    }

    public void close() {}
}

