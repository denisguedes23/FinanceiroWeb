/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package financeiro.util;

import financeiro.usuario.UsuarioDAO;
import financeiro.usuario.UsuarioDAOHibernate;

/**
 *
 * @author rhuansouza
 */
public class DAOFactory {
    
    public static UsuarioDAO criarUsuarioDAO(){
        UsuarioDAOHibernate usuarioDAO = new UsuarioDAOHibernate();
        usuarioDAO.setSession(HibernateUtil.getSessionFactory().getCurrentSession());
        return usuarioDAO;
        
    }
    
}
