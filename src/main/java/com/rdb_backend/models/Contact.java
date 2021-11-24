package com.rdb_backend.models;



import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import com.rdb_backend.enums.ContactEnum;

@Entity
public class Contact {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	
	@Enumerated(EnumType.STRING)
	private ContactEnum talkTo;

	@NotNull(message = "Inserir Nome")
    private String name;
    
    @NotNull(message = "Inserir Email")
    private String email;
    
    @NotNull(message = "Inserir Telefone")
    private String phone;
    
    @NotNull(message = "Inserir Assunto")
    private String subjectMatter;

	@Column(name = "message", columnDefinition = "TEXT NOT NULL") // 21 mil caracteres
	@NotNull(message = "Inserir Mensagem")
    private String message;
    
    @CreatedDate
    @Column(name = "created_date")
    private LocalDateTime createdDate = LocalDateTime.now();

    @LastModifiedDate
    @Column(name = "last_modified_date")
    private LocalDateTime lastModifiedDate = LocalDateTime.now();
	
    
    public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}

    public ContactEnum getTalkTo() {
		return talkTo;
	}
	public void setTalkTo(ContactEnum talkTo) {
		this.talkTo = talkTo;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSubjectMatter() {
		return subjectMatter;
	}
	public void setSubjectMatter(String subjectMatter) {
		this.subjectMatter = subjectMatter;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "Contact [id=" + id + ", talkTo=" + talkTo + ", name=" + name + ", email=" + email + ", phone=" + phone
				+ ", subjectMatter=" + subjectMatter + ", message=" + message + ", createdDate=" + createdDate
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}
	
}
