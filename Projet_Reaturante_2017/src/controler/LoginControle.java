package controler;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import criptografia.CriptografiaSenha;
import entidade.Usuario;
import persistence.UsuarioDao;


@WebServlet("/LoginControle")
public class LoginControle extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginControle() {
        super();
    }
    
    protected void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	String acao = request.getParameter("acao");
    	
    	if(acao != null) {
    		if(acao.equalsIgnoreCase("autenticar")) {
    			String destino = "login.jsp";
    			
    			try{
    			String login = request.getParameter("login");
    			String senha = CriptografiaSenha.encriptarSenha(request.getParameter("senha"));
    			
    			UsuarioDao usuarioDao = new UsuarioDao();
    			Usuario usuario = usuarioDao.autenticar(login, senha);
    			
    			if(usuario != null) {
    				
    				HttpSession session = request.getSession();
    				session.setAttribute("usuarioLogado", usuario);
    				
    				if(login.equalsIgnoreCase("gerente")) {
    					destino = "gerenciamento.jsp";
    				} 
    			} else {
					throw new Exception("Acesso Negado. Tente novamente");
				}
    			
    			} catch(Exception e) {
    				request.setAttribute("erro", e.getMessage());
    			} finally {
    				request.getRequestDispatcher(destino).forward(request, response);
    			}
    			
    		}
    	}
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		execute(request, response);
	}

}
