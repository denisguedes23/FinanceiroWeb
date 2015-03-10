/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import financeiro.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author rhuansouza
 */
public class ConexaoHibernateMysql {
    
    public static void main(String[] args){
        Session sessao = null;
        try{
            sessao = HibernateUtil.getSessionFactory().openSession();
             System.out.println("Conectou");
        }catch(Exception ex){
             sessao.close();
        }
        
    }
}
