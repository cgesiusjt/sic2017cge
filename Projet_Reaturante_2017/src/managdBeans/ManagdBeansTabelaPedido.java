package managdBeans;

import java.util.List;

import entidade.CardapioTO;
import persistence.DAOPedido;

public class ManagdBeansTabelaPedido {
	
	private List<CardapioTO> listaTabelaPedido;

	public List<CardapioTO> getListaTabelaPedido() {
		
		DAOPedido daoPedido = new DAOPedido();
		
		try {
			listaTabelaPedido = daoPedido.allTabelaPedido();
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return listaTabelaPedido;
	}
	
	

}
