package com.syntezator.syntezator;

import com.jsyn.unitgen.UnitOscillator;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Iterator;

public class PolyphonyController {

    private int voicecount = 1;
    private MidiInputReceiver receiver;
    private int outputcount;
    private ArrayList<UnitOscillator> oscillatorarray;
    private ArrayList<Voice> voicearray;
    private int MaxVoiceCount = 8;
    private int oscindex = 0;




    public void PolyphonyController() {
        voicearray = new ArrayList<>(voicecount);
        for (int i = 0; i < voicecount; i++) {
            Voice voice = new Voice();

        }
    }


    public PolyphonyController(int voicecount) {
        if (voicecount > MaxVoiceCount) {
            System.out.println("Max voice count is 8");
            this.PolyphonyController();
        } else {
            voicearray = new ArrayList<>(voicecount);
            this.voicecount = voicecount;
            for (int i = 0; i < voicecount; i++) {
                voicearray.add(new Voice(voicecount));

            }
        }
    }

    public void setVoicecount(int voicecount) {
        if (voicecount > 8) {
            System.out.println("Max voice count is 8");
            this.PolyphonyController();
        } else {
            ArrayList<Voice> voicearray = new ArrayList<>(voicecount);
            this.voicecount = voicecount;
            for (int i = 0; i < voicecount; i++) {
                voicearray.add(new Voice(voicecount));

            }
        }
    }

    public int getVoicecount (){
        return this.voicecount;
    }


// metoda alokuje wiadomość midi do konkretnego glosu
    public void messagein(int control, double midinote, double midivelocity) {


        this.oscindex = 0;

        if (midivelocity != 0){

            for (; this.oscindex < voicearray.size();){

                if (!voicearray.get(this.oscindex).getnotestatus()) {
                    voicearray.get(this.oscindex).setcontrol(control);
                    voicearray.get(this.oscindex).setmidinote(midinote);
                    voicearray.get(this.oscindex).setmidivelocity(midivelocity);
                    voicearray.get(this.oscindex).sendmsg();
                    this.oscindex = voicearray.size();

                }
                this.oscindex++;
            }
        }

        if (midivelocity == 0){

            for(; this.oscindex < voicearray.size();){

                if (voicearray.get(this.oscindex).getmidinote() == midinote){
                    voicearray.get(this.oscindex).noteoff();
                    this.oscindex = voicearray.size();
                }
                this.oscindex++;

            }

        }

    }



    //alokacja oscylatorów do głosów
    private void osctovoice(){
        int i = 0;
        for (Voice voice : voicearray) {
            voice.setosc(oscillatorarray.get(i));
            i++;
        }

    }

    public void setup(UnitOscillator osc1) {
        if (1 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(8);
            oscillatorarray.add(osc1);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2) {
        if (2 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(8);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3) {
        if (3 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(3);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3, UnitOscillator osc4) {
        if (4 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(4);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            oscillatorarray.add(osc4);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3, UnitOscillator osc4, UnitOscillator osc5) {
        if (5 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(5);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            oscillatorarray.add(osc4);
            oscillatorarray.add(osc5);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3, UnitOscillator osc4, UnitOscillator osc5, UnitOscillator osc6) {
        if (6 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(6);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            oscillatorarray.add(osc4);
            oscillatorarray.add(osc5);
            oscillatorarray.add(osc6);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3, UnitOscillator osc4, UnitOscillator osc5, UnitOscillator osc6, UnitOscillator osc7) {
        if (7 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(7);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            oscillatorarray.add(osc4);
            oscillatorarray.add(osc5);
            oscillatorarray.add(osc6);
            oscillatorarray.add(osc7);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }

    public void setup(UnitOscillator osc1, UnitOscillator osc2, UnitOscillator osc3, UnitOscillator osc4, UnitOscillator osc5, UnitOscillator osc6, UnitOscillator osc7, UnitOscillator osc8) {
        if (8 <= this.voicecount) {
            oscillatorarray = new ArrayList<>(8);
            oscillatorarray.add(osc1);
            oscillatorarray.add(osc2);
            oscillatorarray.add(osc3);
            oscillatorarray.add(osc4);
            oscillatorarray.add(osc5);
            oscillatorarray.add(osc6);
            oscillatorarray.add(osc7);
            oscillatorarray.add(osc8);
            osctovoice();
        }
        else{
            System.out.println("Próba przypisania większej liczby oscylatorów niż jest dostępnych głosów");
        }
    }


}
