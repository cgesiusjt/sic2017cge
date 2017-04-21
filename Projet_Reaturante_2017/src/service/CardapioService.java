package service;

import entidade.CardapioTO;
import persistence.CardapioDAO;
import persistence.DAOPedido;

public class CardapioService {

	CardapioDAO cardapioDAO;
	DAOPedido daoPedido;

	public CardapioService() {
		cardapioDAO = new CardapioDAO(); 
	}
	
	public void insertPedidoTabela(CardapioTO cardapioTO) {
		try {
			daoPedido.insertPedidoTabela(cardapioTO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void insert(CardapioTO to) {
		try {
			cardapioDAO.insert(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(CardapioTO to) {
		try {
			cardapioDAO.update(to);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(Integer idCardapio) {
		try {
			cardapioDAO.delete(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void select(Integer idCardapio) {
		try {
			cardapioDAO.consulta(idCardapio);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void selectAll() {
		try {
			cardapioDAO.carregarCardapio();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
