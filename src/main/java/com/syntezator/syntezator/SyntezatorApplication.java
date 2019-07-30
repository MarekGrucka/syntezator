package com.syntezator.syntezator;


import com.jsyn.Synthesizer;
import com.jsyn.devices.javasound.JavaSoundAudioDevice;
import com.jsyn.unitgen.*;
import javax.sound.midi.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class SyntezatorApplication {

		public static void main(String[] args) {

		JavaSoundAudioDevice device = new JavaSoundAudioDevice();
		device.setSuggestedInputLatency(0.02); // ustawienie opoznienia NIE DZIAŁA

		LineOut lineOut; // wyjście audio

			// Synteza i podpięcie pod wyjście audio- line out
			UnitOscillator oscillator1 = new SquareOscillator();
			oscillator1.noteOff();
			UnitOscillator oscillator2 = new SquareOscillator();
			oscillator2.noteOff();
			UnitOscillator oscillator3 = new SquareOscillator();
			oscillator3.noteOff();
			UnitOscillator oscillator4 = new SquareOscillator();
			oscillator4.noteOff();

			Synthesizer synth = new MGSynth();
			synth.add(oscillator1);
			synth.add(oscillator2);
			synth.add(oscillator3);
			synth.add(oscillator4);
			synth.add(lineOut = new LineOut());
			oscillator1.output.connect(0, lineOut.input, 0);
			oscillator1.output.connect(0, lineOut.input, 1);
			oscillator2.output.connect(0, lineOut.input, 0);
			oscillator2.output.connect(0, lineOut.input, 1);
			oscillator3.output.connect(0, lineOut.input, 0);
			oscillator3.output.connect(0, lineOut.input, 1);
			oscillator4.output.connect(0, lineOut.input, 0);
			oscillator4.output.connect(0, lineOut.input, 1);

			synth.getAudioDeviceManager().setSuggestedOutputLatency(0.02);

			PolyphonyController poly = new PolyphonyController(4);
			poly.setup(oscillator1, oscillator2, oscillator3, oscillator4);

			/*
			//EnvelopeDAHDSR ADSR = new EnvelopeDAHDSR();
			*/
			synth.start();
			lineOut.start();

			//Tworzy listę urządzeń midi wraz z ich indexem.
			MidiDevice.Info[] infos = MidiSystem.getMidiDeviceInfo();
			for(int i=0;i<infos.length;i++)
			{System.out.println(i +infos[i].getName() + " - " + infos[i].getDescription());	}


		// Przypisanie	i otwarcie urządzenia
		int mididev = 0;

		try {Thread.sleep(500);}
		catch (InterruptedException e)
		{
			System.out.println("Error");
		}

		System.out.println("Wybierz z listy numer udrządzenia midi");
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		try {
			mididev = Integer.parseInt(reader.readLine());
			reader.close();
		}
		catch (IOException e){
			System.out.println("Wybierz numer");
		}

		//Receiver (odbiera sygnały z transmitera), w argumencie miejsce wysyłki -> controller polifonii
		try {
			MidiDevice inputDevice = MidiSystem.getMidiDevice(infos[mididev]);
			inputDevice.open();
			Transmitter transmitter;
			transmitter = inputDevice.getTransmitter();
			MidiInputReceiver midireceiver = new MidiInputReceiver(poly);
			transmitter.setReceiver(midireceiver);
		}
		catch (MidiUnavailableException e){
			System.out.println("Midi is unavailable");
		}

	}

}
