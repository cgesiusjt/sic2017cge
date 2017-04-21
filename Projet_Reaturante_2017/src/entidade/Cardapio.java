package entidade;

import java.io.Serializable;

@SuppressWarnings("serial")
public class Cardapio implements Serializable {

	private Integer idcardapio;
	private String categoria; 
	private String descricao;
	private Double valorUnitario;
	private String disponibilidade;
	private Integer quantidade; 
	
	public Cardapio() {

	}

	public Cardapio(Integer idcardapio, String categoria, String descricao, Double valorUnitario,
			String disponibilidade, Integer quantidade) {
		this.idcardapio = idcardapio;
		this.categoria = categoria;
		this.descricao = descricao;
		this.valorUnitario = valorUnitario;
		this.disponibilidade = disponibilidade;
		this.quantidade = quantidade;
	}

	public Integer getIdcardapio() {
		return idcardapio;
	}

	public void setIdcardapio(Integer idcardapio) {
		this.idcardapio = idcardapio;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValorUnitario() {
		return valorUnitario;
	}

	public void setValorUnitario(Double valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	public String getDisponibilidade() {
		return disponibilidade;
	}

	public void setDisponibilidade(String disponibilidade) {
		this.disponibilidade = disponibilidade;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	public String toString() {
		return "Codigo: " + getIdcardapio() + "\nCategoria:" + getCategoria() 
		+ "\nDescri��o: " + getDescricao() + "\nValor Unitario: " + getValorUnitario() 
		+ "\nDisponibilidade: " + getDisponibilidade() + "Quantidade: " + getQuantidade();
	}

}
