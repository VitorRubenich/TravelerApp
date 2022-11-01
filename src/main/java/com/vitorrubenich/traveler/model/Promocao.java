package com.vitorrubenich.traveler.model;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Promocao extends Viagem{

	@Column(nullable = false, name = "perc_desconto")
	public int percDesconto;
	
	@Column(nullable = false, name = "valor_com_desconto")
	public Double valorComDesconto;

	public int getPercDesconto() {
		return percDesconto;
	}

	public void setPercDesconto(int percDesconto) {
		this.percDesconto = percDesconto;
	}

	public Double getValorComDesconto() {
		return valorComDesconto;
	}

	public void setValorComDesconto(Double valorComDesconto) {
		this.valorComDesconto = valorComDesconto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(percDesconto, valorComDesconto);
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
		Promocao other = (Promocao) obj;
		return percDesconto == other.percDesconto && Objects.equals(valorComDesconto, other.valorComDesconto);
	}

	
	
	public void setValorFinal(int desc) {
		Double valorFinal;
		valorFinal = (this.valor / 100) * (100 - desc);
		setValorComDesconto(valorFinal);
	}
	
}
