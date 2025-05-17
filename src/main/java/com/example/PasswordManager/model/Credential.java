package com.example.PasswordManager.model;

public class Credential {
    private String username;
    private String service;
    private String encryptedPassword;

    //Default Constructor

    public Credential(String username , String service , String encryptedPass) {
        super();
        this.username = username;
        this.service = service;
        this.encryptedPassword = encryptedPass;
    }

    public Credential() {

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

	public void setEncryptedPassword(String encryptedPassword) {
		this.encryptedPassword = encryptedPassword;
	}

	


}