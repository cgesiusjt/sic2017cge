package util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import entidade.Cardapio;
import entidade.Pedido;
import persistence.DAOPedido;

public class ControlePedido {

	private Integer codigo = null;
	private SimpleDateFormat sdf;
	private Calendar cal;
	private Object data;
	private String hora;
	private DAOPedido daoPedido;
	private Pedido pedido;

	public ControlePedido() {

		daoPedido = new DAOPedido();
	}

	public String pegarHora() {

		String hora = "";

		cal = Calendar.getInstance();
		sdf = new SimpleDateFormat("HH:mm:ss");
		hora = sdf.format(cal.getTime());
		return hora;
	}

	public String pegarData() {

		String datap = "";

		cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY:MM:dd");
		data = new Date(System.currentTimeMillis());
		datap = sdf.format(data);

		return datap;
	}
	/*
	public Double valorConta() {

		double total = 0.0;
		try {
			List<Pedido> lista = daoPedido.carregarPedidoAux();

			for (Pedido pedido : lista) {

				total += (pedido.getCardapio().getQuantidade() * pedido.getCardapio().getValorUnitario());
			}

		} catch (Exception e1) {

			e1.printStackTrace();
		}

		return total;
	} */

	public Object getData() {

		return sdf.format(pegarData());
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getHora() {

		return sdf.format(pegarHora());
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

}
