package persistence;

import java.util.ArrayList;
import java.util.List;

import entidade.Cardapio;
import entidade.CardapioTO;
import entidade.Pedido;
import util.ControlePedido;

public class DAOPedido extends DAO {

	private Pedido p;
	private ControlePedido cp;
	private CardapioTO cardapioTO;

	public void insertPedido(String c, ControlePedido cp, Integer m) throws Exception {

		String query = "insert into pedido(nomegarcom, dataentada, datasaida, horaentrada, horasaida, mesa) "
				+ "values(?, ?, ?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setString(1, c);
		stmt.setString(2, cp.pegarData());
		stmt.setString(3, cp.pegarData());
		stmt.setString(4, cp.pegarHora());
		stmt.setString(5, cp.pegarHora());
		stmt.setInt(6, m);
		stmt.execute();
		stmt.close();

		closeConection();

	}

	public void insertItemPedido(Cardapio c, Integer pedido) throws Exception {

		String query = "insert into itempedido(quantidade, idpedido, idcardapio) values(?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, c.getQuantidade());
		stmt.setInt(2, pedido);
		stmt.setInt(3, c.getIdcardapio());
		stmt.execute();
		stmt.close();

		closeConection();

	}

	public void insertItemPedidoAux(Cardapio c, Integer pedido, Integer mesa) throws Exception {

		String query = "insert into pedidoaux(quantidade, idpedido, idcardapio, mesa) values(?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, c.getQuantidade());
		stmt.setInt(2, pedido);
		stmt.setInt(3, c.getIdcardapio());
		stmt.setInt(4, mesa);
		stmt.execute();
		stmt.close();

		closeConection();

	}
	
	public void insertPedidoTabela(CardapioTO cardapioTO) throws Exception {
		String query = "insert into pedidotabela(idpedidotabela, categoria, descricao, valorunitario, quantidade, disponibilidade)"
				+ "values(?, ?, ?, ?, ?, ?)";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		
		stmt.setInt(1, cardapioTO.getIdCardapio());
		stmt.setString(2, cardapioTO.getCategoria());
		stmt.setString(3, cardapioTO.getDescricao());
		stmt.setDouble(4, cardapioTO.getValorUnitario());
		stmt.setInt(5, cardapioTO.getQuantidade());
		stmt.setString(6, cardapioTO.getDisponibilidade());
		stmt.execute();
		stmt.close();
		
		closeConection();
	}
	
	public void insertPagamentoAux(Cardapio c, Integer pedido, Integer mesa) throws Exception {

		String query = "insert into pagamentoaux(quantidade, idpedido, idcardapio, mesa) values(?, ?, ?, ?)";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setInt(1, c.getQuantidade());
		stmt.setInt(2, pedido);
		stmt.setInt(3, c.getIdcardapio());
		stmt.setInt(4, mesa);
		stmt.execute();
		stmt.close();

		closeConection();

	}
	
	public List<CardapioTO> allTabelaPedido() throws Exception {
		
		String query = "select * from pedidotabela";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		
		List<CardapioTO> lista = new ArrayList<CardapioTO>();
		
		while (rs.next()) {
			
			cardapioTO = new CardapioTO();
			
			cardapioTO.setIdCardapio(rs.getInt("idpedidotabela"));
			cardapioTO.setCategoria(rs.getString("categoria"));
			cardapioTO.setDescricao(rs.getString("descricao"));
			cardapioTO.setValorUnitario(rs.getDouble("valorunitario"));
			cardapioTO.setQuantidade(rs.getInt("quantidade"));
			cardapioTO.setDisponibilidade(rs.getString("disponibilidade"));
			lista.add(cardapioTO);
		}
		
		closeConection();
		return lista;
	}
	
	public void delete(Integer idCardapio) throws Exception {
		String query = "delete from pedidotabela where idpedidotabela = ?";
		
		openConection();
		
		stmt = con.prepareStatement(query);
		stmt.setInt(1, idCardapio);
		stmt.execute();
		stmt.close();
		
		closeConection();
	}
	/*
	public List<Pedido> carregarPedido() throws Exception {

		String query = "select * from pedido order by idpedido";

		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<Pedido>();

		while (rs.next()) {

			p = new Pedido();
			p.setGarcom(new Garcom());
			p.setIdPedido(rs.getInt("idpedido"));
			p.getGarcom().setNomeGarcom(rs.getString("nomegarcom"));
			
			 * p.setDataEntrada(FormatacaoData.converterData(rs.getString(
			 * "dataentrada")));
			 * p.setDataSaida(FormatacaoData.converterData(rs.getString(
			 * "datasaida"))); p.setHoraEntrada(rs.getString("horaentrada"));
			 * p.setHoraSaida(rs.getString("horasaida"));
			 
			p.setMesa(rs.getString("mesa"));
			lista.add(p);

		}
		closeConection();
		return lista;
	}
	

	public List<Pedido> carregarPedidoAux() throws Exception {

		String query = "select * from vw_pedidoAux";

		openConection();
		stmt = con.prepareStatement(query);
		rs = stmt.executeQuery();
		List<Pedido> lista = new ArrayList<Pedido>();

		while (rs.next()) {

			p = new Pedido();
			p.setCardapio(new Cardapio());
			p.setMesa2(new Mesa());

			p.getCardapio().setQuantidade(rs.getInt("quantidade"));
			p.getCardapio().setDescricao(rs.getString("descricao"));
			p.getCardapio().setValorUnitario(rs.getDouble("valor_unit"));
			p.setIdPedido(rs.getInt("idpedido"));
			p.getCardapio().setIdcardapio(rs.getInt("idcardapio"));
			p.getMesa2().setNumeroMesa(rs.getInt("mesa"));
			lista.add(p);

		}
		closeConection();
		return lista;
	}
	
	public void deletePedido(Integer idpedido) throws Exception {

		String query = "delete from pedidoaux where idpedido = ?";
		
		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, idpedido);
		stmt.execute();
		stmt.close();

		closeConection();
	}
	
	public void deletePedidoPagamento(Integer idpedido) throws Exception {

		String query = "delete from pagamentoaux where idpedido = ?";
		
		openConection();

		stmt = con.prepareStatement(query);
		stmt.setInt(1, idpedido);
		stmt.execute();
		stmt.close();

		closeConection();
	}
	
	public void updateDataHoraSaida(Pedido p) throws Exception {

		
		String query = "update pedido set datasaida =?, horasaida =?"
				+ "where mesa =? ";

		openConection();

		stmt = con.prepareStatement(query);

		stmt.setString(1, p.getControlePedido().pegarData());
		stmt.setString(2, p.getControlePedido().pegarHora());
		stmt.setInt(3, p.getIdPedido());
		stmt.execute();
		stmt.close();

		closeConection();

	}
	*/
}
