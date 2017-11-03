package com.porto.ninjas.ws;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.twilio.twiml.Gather;
import com.twilio.twiml.Language;
import com.twilio.twiml.Redirect;
import com.twilio.twiml.Say;
import com.twilio.twiml.TwiMLException;
import com.twilio.twiml.VoiceResponse;

@SuppressWarnings("serial")
@WebServlet("/ninjas")
public class UraServlet extends HttpServlet{
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {

      
        VoiceResponse.Builder builder = new VoiceResponse.Builder();

        String digito = request.getParameter("Digits");
        if (digito != null) {
            switch (digito) {
                case "1":
                    builder.say(new Say.Builder("Será enviado um sms de teste para você").voice(Say.Voice.ALICE)
        					.language(Language.PT_BR).build());
                    break;
                case "2":
                    builder.say(new Say.Builder("Até logo!").voice(Say.Voice.ALICE)
        					.language(Language.PT_BR).build());
                    break;
                default:
                    builder.say(new Say.Builder("Essa opção não existe").voice(Say.Voice.ALICE)
        					.language(Language.PT_BR).build());
                    criarGather(builder);
                    break;
            }
        } else {
        	criarGather(builder);
        }

        response.setContentType("application/xml");
        try {
            response.getWriter().print(builder.build().toXml());
        } catch (TwiMLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void criarGather(VoiceResponse.Builder builder) {
        builder.gather(new Gather.Builder()
                        .numDigits(2)
                        .say(new Say.Builder("Para envio de um SMS de teste, aperte 1. Para encerrar a ligação, aperte 2.").voice(Say.Voice.ALICE)
            					.language(Language.PT_BR).build())
                        .build()
                )
                .redirect(new Redirect.Builder().url("/ninjas").build());
    }
}

	

