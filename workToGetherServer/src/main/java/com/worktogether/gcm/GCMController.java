package com.worktogether.gcm;


import java.io.IOException;

import com.google.android.gcm.server.Constants;
import com.google.android.gcm.server.Message;
import com.google.android.gcm.server.Message.Builder;
import com.google.android.gcm.server.Result;
import com.google.android.gcm.server.Sender;
import com.worktogether.entities.Evento;

public class GCMController implements Runnable {
	
	private String idDispositivoGCM;
	private Evento evento;
	
	public GCMController(String idDispositivoGCM, Evento evento){
		this.idDispositivoGCM = idDispositivoGCM;
		this.evento = evento;
	}
	
	@Override
	public void run() {
		try{
			//Cria um objeto Sender usando a chave API do seu projeto
			Sender sender = new Sender("AIzaSyBIre-L6i5efqqPalBaEF2TL5UmWWRj2KA");
			
			Builder builder = new Message.Builder().collapseKey("1").timeToLive(3).delayWhileIdle(true);
			
			//Montagem do convite
			StringBuilder msg = new StringBuilder();
			msg.append("Convite para o evento");
			msg.append(evento);
			
			Message message = builder.addData("convite", msg.toString()).build();
			
			Result result = sender.send(message, idDispositivoGCM, 1);
			
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
