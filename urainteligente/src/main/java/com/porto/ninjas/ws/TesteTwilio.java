package com.porto.ninjas.ws;

import com.twilio.twiml.Language;
import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

public class TesteTwilio {

	public static void main(String[] args) {
		Say say = new Say.Builder(
				"Este é apenas um teste. Efetuando a integração do twilio com uma aplicação Java na AWS.!")
						.voice(Say.Voice.ALICE).language(Language.PT_BR).loop(3).build();
		VoiceResponse response = new VoiceResponse.Builder().say(say).build();
		try {
			System.out.println(response.toXml());
		} catch (TwiMLException e) {
			e.printStackTrace();
		}

	}

}
