package com.porto.ninjas.ws;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.Language;
import com.twilio.twiml.Redirect;
import com.twilio.twiml.Redirect.Builder;
import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

public class TwilioServlet extends HttpServlet {

	private Say say;
	private Builder redirect;

	@Override
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {

		String caller = (String) request.getParameter("Caller");

		if ((caller.equals("+5511976951713")) || caller.equals("+5511971188451")) {

			say = new Say.Builder("Olá Caio. Identificamos que você é um de nossos corretores.").voice(Say.Voice.ALICE)
					.language(Language.PT_BR).loop(3).build();
			//redirect = new Redirect.Builder("/ninjas");
		} else {
			say = new Say.Builder(
					"Não identificamos seu telefone em nossa base de dados. Essa funcionalidade ainda está em construção. "
					+ "Essa é uma resposta automática, feita por uma aplicação criada para o programa ninjas, e publicada na Amazon WS.")
							.voice(Say.Voice.ALICE).language(Language.PT_BR).build();
		}
		VoiceResponse voiceResponse = new VoiceResponse.Builder().say(say).build();

		response.setContentType("application/xml");
		response.setCharacterEncoding("UTF-8");
		try {
			response.getWriter().print(voiceResponse.toXml());
		} catch (TwiMLException e) {
			e.printStackTrace();
		}
	}
}