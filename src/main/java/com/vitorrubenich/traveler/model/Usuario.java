package com.vitorrubenich.traveler.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class Usuario {

	@Column(name = "data_cadastro", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataCadastro;
	
	@Column(nullable = false)
    private String senha;

	@Override
	public int hashCode() {
		return Objects.hash(dataCadastro, senha);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(senha, other.senha);
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	
}
