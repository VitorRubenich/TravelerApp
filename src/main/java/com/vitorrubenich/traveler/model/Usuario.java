package com.vitorrubenich.traveler.model;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;


@Entity
public class Usuario extends Pessoa{

	@Column(name = "data_cadastro", nullable = false)
    @DateTimeFormat(iso = ISO.DATE)
    private LocalDate dataCadastro;
	
	@Column(nullable = false)
    private String senha;

	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "permissao_id_fk", nullable = false)
    private Permissao permissao;

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

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(dataCadastro, permissao, senha);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(dataCadastro, other.dataCadastro) && Objects.equals(permissao, other.permissao)
				&& Objects.equals(senha, other.senha);
	}
	
	
}
