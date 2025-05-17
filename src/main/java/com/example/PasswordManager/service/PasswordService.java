package com.example.PasswordManager.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.PasswordManager.model.Credential;
import com.example.PasswordManager.util.CryptUtil;
import com.example.demo.util.CryptoUtil;

@Service
public class PasswordService {
	
	private final Map<String,Credential> credentialStore = new HashMap<>();
	
	public void saveCredential(String username,String service,String password) {
		String encrypted = CryptUtil.encrypt(password);
		Credential cred = new Credential(username,service,encrypted);
		credentialStore.put(username+":"+service,cred);
	}
	
	public String getPassword(String username,String service) {
		Credential cred = credentialStore.get(username+":"+service);
		if(cred != null) {
			return CryptUtil.decrypt(cred.getEncryptedPassword());
		}
		return null;
	}
	
	public List<Credential> getAllCredential() {
		return new ArrayList<>(credentialStore.values());
	}
}

