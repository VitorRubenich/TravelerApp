package com.vitorrubenich.traveler.model;

import java.util.Arrays;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Viagem extends Entidade {

	@Column(nullable = false, length = 80)
	public String NomeDestino;

	@Column(nullable = false)
	public Double valor;
	
	@Lob
	@Column(name = "imagem")
	private byte[] imagem;
	
	public String getNomeDestino() {
		return NomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		NomeDestino = nomeDestino;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public byte[] getImagem() {
		return imagem;
	}

	public void setImagem(byte[] imagem) {
		this.imagem = imagem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(imagem);
		result = prime * result + Objects.hash(NomeDestino, valor);
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
		Viagem other = (Viagem) obj;
		return Objects.equals(NomeDestino, other.NomeDestino) && Arrays.equals(imagem, other.imagem)
				&& Objects.equals(valor, other.valor);
	}
	
	
}
