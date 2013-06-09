package com.worktogether.gcm;


import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.worktogether.constant.ApplicationConstant;

public class GCMController implements Runnable {
	
	private String idDispositivoGCM;
	private Long idEvento;
	private String nomeEvento;
	
	public GCMController(String idDispositivoGCM, Long idEvento, String nomeEvento){
		this.idDispositivoGCM = idDispositivoGCM;
		this.idEvento = idEvento;
		this.nomeEvento = nomeEvento;
	}
	
	public void run() {
		try{
			//Cria um objeto Sender usando a chave API do seu projeto
			Sender sender = new Sender(ApplicationConstant.GOOGLE_API_KEY);
			
			Builder builder = new Message.Builder().collapseKey("worktogether_notification").timeToLive(600).delayWhileIdle(true);
			
			//Montagem do convite
			StringBuilder msg = new StringBuilder();
			msg.append("Convite ");
			msg.append(nomeEvento);
			msg.append(";");
			msg.append(idEvento);
			
			Message message = builder.addData("convite", msg.toString()).build();
			
			Result result = sender.send(message, idDispositivoGCM, ApplicationConstant.TENTATIVAS_ENVIO_MSG_GCM);
			
			//Validacoes
			if (result.getMessageId() != null) {
				
				 String canonicalRegId = result.getCanonicalRegistrationId();
				 
				 if (canonicalRegId != null) {
				   // same device has more than on registration ID: update database
				 }
				 
			} else {
				 String error = result.getErrorCodeName();
				 
				 if (error.equals(Constants.ERROR_NOT_REGISTERED)) {
				   // application has been removed from device - unregister database
				 }
			}
			
			
		}catch(IOException e){ 
			e.printStackTrace();
		}
	}

}
