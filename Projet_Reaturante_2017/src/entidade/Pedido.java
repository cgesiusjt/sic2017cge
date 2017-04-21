package entidade;

import java.util.Date;

public class Pedido {

	private Integer idPedido;
	private Date dataEntrada;
	private Date dataSaida;
	private String horaEntrada;
	private String horaSaida;
	private String mesa;
	private Cardapio cardapio;

	public Pedido() {

	}

	public Pedido(Integer idPedido, Date dataEntrada, Date dataSaida, String horaEntrada, String horaSaida, String mesa,
			Cardapio cardapio) {

		this.idPedido = idPedido;
		this.dataEntrada = dataEntrada;
		this.dataSaida = dataSaida;
		this.horaEntrada = horaEntrada;
		this.horaSaida = horaSaida;
		this.mesa = mesa;
		this.cardapio = cardapio;

	}

	public Integer getIdPedido() {
		return idPedido;
	}

	public void setIdPedido(Integer idPedido) {
		this.idPedido = idPedido;
	}

	public Date getDataEntrada() {
		return dataEntrada;
	}

	public void setDataEntrada(Date dataEntrada) {
		this.dataEntrada = dataEntrada;
	}

	public Date getDataSaida() {
		return dataSaida;
	}

	public void setDataSaida(Date dataSaida) {
		this.dataSaida = dataSaida;
	}

	public String getHoraEntrada() {
		return horaEntrada;
	}

	public void setHoraEntrada(String horaEntrada) {
		this.horaEntrada = horaEntrada;
	}

	public String getHoraSaida() {
		return horaSaida;
	}

	public void setHoraSaida(String horaSaida) {
		this.horaSaida = horaSaida;
	}

	public String getMesa() {
		return mesa;
	}

	public void setMesa(String mesa) {
		this.mesa = mesa;
	}

	public Cardapio getCardapio() {
		return cardapio;
	}

	public void setCardapio(Cardapio cardapio) {
		this.cardapio = cardapio;
	}

}
