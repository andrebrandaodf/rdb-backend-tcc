package com.rdb_backend.enums;

public enum ContactEnum {
	ONLY("Quero Doar", "andrebrandaodf@gmail.com"),
	SUGGESTIONS("Sugestões e Críticas", "andrebrandaodf@gmail.com"),
	VOLUNTARY("Seja um Voluntário", "andrebrandaodf@gmail.com");

	private String talkTo;
	private String email;

	ContactEnum(String talkTo, String email) {
		this.talkTo = talkTo;
		this.email = email;
	}

	public String getTalkTo() {
		return talkTo;
	}

	public void setTalkTo(String talkTo) {
		this.talkTo = talkTo;
	}

	public String getEmail() {
		return email;
	}
}

